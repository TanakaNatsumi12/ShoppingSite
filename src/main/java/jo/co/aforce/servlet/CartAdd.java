package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/cartAdd")
public class CartAdd extends HttpServlet{

	private CartService cartService = new CartService();

    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        
        int productId = Integer.parseInt(request.getParameter("productId"));

        
        int quantity = 1;

        // 3. セッションIDを取得（未ログインでもカートを持てる）
        HttpSession session = request.getSession();
        String sessionId = session.getId();

        try {
            // 4. CartService に処理を丸投げ
            cartService.addToCart(sessionId, productId, quantity);

            // 5. カートページへリダイレクト
            response.sendRedirect(request.getContextPath() + "/cartServlet");

        } catch (Exception e) {
            throw new ServletException(e);
        }
    
    }
}
