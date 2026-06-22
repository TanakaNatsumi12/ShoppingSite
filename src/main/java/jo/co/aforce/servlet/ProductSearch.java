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
        
        
        String order = request.getParameter("order");

        String orderBy = "name ASC"; // デフォルト

        if ("name_asc".equals(order)) {
            orderBy = "name ASC";
        } else if ("name_desc".equals(order)) {
            orderBy = "name DESC";
        } else if ("price_asc".equals(order)) {
            orderBy = "price ASC";
        } else if ("price_desc".equals(order)) {
            orderBy = "price DESC";
        }

        ProductDAO dao = new ProductDAO();
        List<ProductsBean> products;
          

        if (keyword != null && !keyword.isEmpty()) {
            products = dao.searchProducts(keyword, orderBy);
        } else {
            products = dao.findAll(orderBy);
        }

       
        request.setAttribute("products", products);
        request.getRequestDispatcher("/views/user-serach-result.jsp").forward(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    doPost(request, response);
	}
	
}
