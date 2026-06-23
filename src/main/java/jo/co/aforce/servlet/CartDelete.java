package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cartDelete")
public class CartDelete extends HttpServlet{
	
	private CartService cartService = new CartService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        int productId = Integer.parseInt(request.getParameter("id"));

        HttpSession session = request.getSession();
        String sessionId = session.getId();

        try {
            cartService.removeFromCart(sessionId, productId);

            response.sendRedirect(request.getContextPath() + "/cartServlet");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
