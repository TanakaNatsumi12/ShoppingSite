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

@WebServlet("/productSerach")
public class ProductSearch extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
		
		request.setCharacterEncoding("UTF-8");

        String keyword = request.getParameter("keyword");

        ProductDAO dao = new ProductDAO();
        List<ProductsBean> products;
          

        if (keyword != null && !keyword.isEmpty()) {
            products = dao.searchProducts(keyword);
        } else {
            products = dao.findAll();
        }

       
        request.setAttribute("products", products);
        request.getRequestDispatcher("/views/user-serach-result.jsp").forward(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    doPost(request, response);
	}
	
}
