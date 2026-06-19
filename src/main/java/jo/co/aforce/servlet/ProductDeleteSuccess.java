package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jo.co.aforce.dao.ProductDAO;

@WebServlet("/productDeleteSuccess")
public class ProductDeleteSuccess extends HttpServlet{

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        request.setCharacterEncoding("UTF-8");

	        // JSP から送られてきた商品IDを取得
	        String idStr = request.getParameter("id");
	        System.out.println("【DeleteSuccess】受け取ったID文字列 = '" + idStr + "'");

	        if (idStr == null || idStr.isEmpty()) {
	            request.setAttribute("error", "商品IDが取得できませんでした。");
	            request.getRequestDispatcher("/views/admin-products-delete-error.jsp").forward(request, response);
	            return;
	        }

	        int id = Integer.parseInt(idStr);
	        System.out.println("【DeleteSuccess】パース後のID = " + id);
	        // DAO を使って削除処理
	        ProductDAO dao = new ProductDAO();
	        boolean result = dao.deleteProduct(id);
	        System.out.println("【DeleteSuccess】削除結果 = " + result);
	        if (result) {
	            request.setAttribute("message", "商品を削除しました。");
	            request.getRequestDispatcher("/views/admin-products-delete-success.jsp")
	                   .forward(request, response);
	        } else {
	            request.setAttribute("error", "商品の削除に失敗しました。");
	            request.getRequestDispatcher("/views/admin-products-delete-error.jsp")
	                   .forward(request, response);
	        }
	    }
}
