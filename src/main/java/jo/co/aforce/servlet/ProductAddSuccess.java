package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jo.co.aforce.beans.ProductsBean;
import jo.co.aforce.dao.ProductDAO;

@WebServlet("/productAddSuccess")
public class ProductAddSuccess extends HttpServlet{

	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        request.setCharacterEncoding("UTF-8");

	        ProductsBean product = new ProductsBean();
	        product.setName(request.getParameter("name"));
	        product.setDescription(request.getParameter("description"));
	        product.setPrice(Integer.parseInt(request.getParameter("price")));
	        product.setStock(Integer.parseInt(request.getParameter("stock")));
	        product.setTeamId(Integer.parseInt(request.getParameter("team_id")));
	        product.setPlayerId(Integer.parseInt(request.getParameter("player_id")));
	        product.setImageUrl(request.getParameter("image_url"));

	        ProductDAO dao = new ProductDAO();
	        int result = dao.insertProduct(product);

	        if (result > 0) {
	            response.sendRedirect(request.getContextPath() + "/views/admin-products-add-success.jsp");
	        } else {
	            response.sendRedirect(request.getContextPath() + "/views/error.jsp");
	        }
	    }
}
