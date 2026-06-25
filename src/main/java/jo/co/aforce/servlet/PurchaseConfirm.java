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

@WebServlet("/purchaseConfirm")
public class PurchaseConfirm extends HttpServlet{
	
	private CartDAO cartDao = new CartDAO();

    public void doPost(
            HttpServletRequest request, HttpServletResponse response
    ) throws ServletException, IOException {

        HttpSession session = request.getSession();

        // ▼ ログインチェック
        UserBean customer = (UserBean) session.getAttribute("customer");
        if (customer == null) {
            request.setAttribute("errorMessage", "ログインが必要です");
            request.getRequestDispatcher("/views/login-in.jsp").forward(request, response);
            return;
        }

        String sessionId = session.getId();

        try (Connection conn = DAO.getConnection()) {

            // ▼ DB からカートを取得（CartServlet と同じ）
            Integer cartId = cartDao.findCartIdBySession(conn, sessionId);

            List<Map<String, Object>> cartItems = null;

            if (cartId != null) {
                cartItems = cartDao.getCartItems(conn, cartId);
            }

            // ▼ カートが空なら cart に戻す
            if (cartItems == null || cartItems.isEmpty()) {
                response.sendRedirect(request.getContextPath() + "/cartServlet");
                return;
            }

            // ▼ JSP に渡す
            request.setAttribute("cart", cartItems);
            
            request.setAttribute("customerName", customer.getLastName() + " " + customer.getFirstName());
            request.setAttribute("customerAddress", customer.getAddress());
            

            request.getRequestDispatcher("/views/purchase-confirm.jsp")
                   .forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
