package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/userAddConfirmServlet"})
public class UserAddConfirmServlet extends HttpServlet{
	
	public void doPost(
			HttpServletRequest request, HttpServletResponse response
		)throws ServletException, IOException{
	
	String memberId = request.getParameter("memberId");
	String password = request.getParameter("password");
	String lastName = request.getParameter("lastName");
	String firstName = request.getParameter("firstName");
	String address = request.getParameter("address");
	String mailAddress = request.getParameter("mailAddress");

	
	HttpSession session = request.getSession();
	session.setAttribute("memberId", memberId);
    session.setAttribute("password", password);
    session.setAttribute("lastName", lastName);
    session.setAttribute("firstName", firstName);
    session.setAttribute("address", address);
    session.setAttribute("mailAddress", mailAddress);

	
	RequestDispatcher rd = request.getRequestDispatcher("/views/user-add-confirm.jsp");
	rd.forward(request, response);


	}
}