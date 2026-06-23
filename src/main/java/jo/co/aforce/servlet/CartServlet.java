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

import jo.co.aforce.dao.CartDAO;
import jo.co.aforce.dao.DAO;

@WebServlet("/cartServlet")
public class CartServlet extends HttpServlet{
	
	private CartDAO cartDao = new CartDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String sessionId = session.getId();

        try (Connection conn = DAO.getConnection()) {

            // カートID取得
            Integer cartId = cartDao.findCartIdBySession(conn, sessionId);

            List<Map<String, Object>> cartItems = null;

            if (cartId != null) {
                // cart.jsp が期待している形式のデータを取得
                cartItems = cartDao.getCartItems(conn, cartId);
            }

            // JSP に渡す
            request.setAttribute("cart", cartItems);

            // 表示
            request.getRequestDispatcher("/views/cart.jsp").forward(request, response);

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
