package jo.co.aforce.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jo.co.aforce.beans.UserBean;
import jo.co.aforce.dao.CartDAO;
import jo.co.aforce.dao.DAO;
import jo.co.aforce.dao.OrderItemsDAO;
import jo.co.aforce.dao.OrdersDAO;
import jo.co.aforce.dao.StockDAO;

@WebServlet("/purchaseSuccess")
public class PurchaseSuccess extends HttpServlet {
	
	
	private CartDAO cartDao = new CartDAO();
    private OrdersDAO ordersDao = new OrdersDAO();
    private OrderItemsDAO orderItemsDao = new OrderItemsDAO();
    private StockDAO stockDao = new StockDAO();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserBean customer = (UserBean) session.getAttribute("customer");

        if (customer == null) {
            response.sendRedirect(request.getContextPath() + "/views/login-in.jsp");
            return;
        }

        String sessionId = session.getId();

        try (Connection conn = DAO.getConnection()) {

            conn.setAutoCommit(false);

            // カート取得
            Integer cartId = cartDao.findCartIdBySession(conn, sessionId);
            if (cartId == null) {
                response.sendRedirect("cartServlet");
                return;
            }

            List<Map<String, Object>> cartItems = cartDao.getCartItems(conn, cartId);
            if (cartItems == null || cartItems.isEmpty()) {
                response.sendRedirect("cartServlet");
                return;
            }

            String paymentMethod = request.getParameter("payment_method");

            // ① 注文作成（orderId 発行）
            int orderId = ordersDao.insertOrder(conn, customer.getMemberId(), cartItems, paymentMethod);

            // ② order_items を INSERT（先に入れる）
            orderItemsDao.insertOrderItems(conn, orderId, cartItems);

            // ③ 在庫更新
            stockDao.updateStock(conn, cartItems);

            // ④ カート削除
            cartDao.clearCart(conn, cartId);

            // ⑤ commit（ここで DB に確定）
            conn.commit();

            // ⑥ order_items を SELECT（commit 後なのでデータが存在する）
            List<Map<String, Object>> orderItems = orderItemsDao.getOrderItems(conn, orderId);

            // ⑦ JSP に渡す
            request.setAttribute("orderItems", orderItems);
            request.setAttribute("orderId", orderId);

            // ⑧ forward（contextPath を付けない）
            request.getRequestDispatcher("/views/purchase-success.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
    	
    	  
}
