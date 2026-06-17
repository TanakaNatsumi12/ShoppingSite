package jo.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jo.co.aforce.beans.TeamBean;
import jo.co.aforce.dao.TeamDAO;

@WebServlet("/productAdd")
public class ProductAdd extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        TeamDAO dao = new TeamDAO();
        List<TeamBean> teams = dao.findAll();

        request.setAttribute("teams", teams);

        RequestDispatcher rd = request.getRequestDispatcher("/views/admin-products-add.jsp");
        rd.forward(request, response);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    doPost(request, response);
	}
}
