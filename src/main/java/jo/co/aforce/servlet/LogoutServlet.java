package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


public class LogoutServlet extends HttpServlet{
	public void doPost(
			HttpServletRequest request, HttpServletResponse response
		)throws ServletException, IOException{
		
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("customer")!=null) {
			session.removeAttribute("customer");
			request.getRequestDispatcher("views/logout-out.jsp").forward(request, response); 
		}
		
		request.getRequestDispatcher("views/login-error.jsp").forward(request, response);
	}

}
