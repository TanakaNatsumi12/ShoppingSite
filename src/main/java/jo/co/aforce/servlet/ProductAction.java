package jo.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jo.co.aforce.beans.ProductsBean;
import jo.co.aforce.dao.ProductDAO;

@WebServlet("/productAction")
public class ProductAction extends HttpServlet{
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        ProductDAO dao = new ProductDAO();
	        int limit = 9;  // ← 表示したい件数（例：10件）
	        List<ProductsBean> products = dao.findLatest(limit);

	        request.setAttribute("products", products);

	        request.getRequestDispatcher("views/user-products-menu.jsp")
	               .forward(request, response);
	    }
     
	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
		        throws ServletException, IOException {
		    doPost(request, response);
		}
	
}