package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jo.co.aforce.beans.ProductsBean;
import jo.co.aforce.dao.ProductDAO;

@WebServlet("/productDetail")
public class ProductDetail extends HttpServlet{
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

		 int id = Integer.parseInt(request.getParameter("id"));

		 ProductDAO dao = new ProductDAO();
	     ProductsBean product = dao.findById(id);
        
        
        request.setAttribute("product", product);

	        request.getRequestDispatcher("/views/product-page.jsp")
	               .forward(request, response);
	    }
}
