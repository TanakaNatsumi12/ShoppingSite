package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/userAddConfirmServlet"})
public class UserAddConfirmServlet extends HttpServlet{
	
	public void doPost(
			HttpServletRequest request, HttpServletResponse response
		)throws ServletException, IOException{
		
	
	
	
	String memberId = request.getParameter("memberId");
	String password = request.getParameter("password");
	String lastName = request.getParameter("lastName");
	String firstName = request.getParameter("firstName");
	String mailAddress = request.getParameter("mailAddress");

	
	request.setAttribute("memberId", memberId);
	request.setAttribute("password", password);
	request.setAttribute("lastName", lastName);
	request.setAttribute("firstName", firstName);
	request.setAttribute("mailAddress", mailAddress);

	
	RequestDispatcher rd = request.getRequestDispatcher("/views/user-add-confirm.jsp");
	rd.forward(request, response);


	}
}