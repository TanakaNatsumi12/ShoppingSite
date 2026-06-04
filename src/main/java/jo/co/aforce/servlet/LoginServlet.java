package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jo.co.aforce.beans.UserBean;
import jo.co.aforce.dao.UserDAO;

@WebServlet(urlPatterns= {"/loginServlet"})
public class LoginServlet extends HttpServlet{
	public void doPost (
			HttpServletRequest request, HttpServletResponse response
		)throws ServletException, IOException{
		String memberId = request.getParameter("memberId");
		String password = request.getParameter("password");

		
		UserDAO dao=new UserDAO();
		UserBean customer = null;
		
		try {
			customer = dao.search(memberId, password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		if(customer == null) {
			request.getRequestDispatcher("views/login-error.jsp").forward(request, response);
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("customer", customer);
			
			System.out.println("SESSION AFTER SET = " + session.getAttribute("customer"));
			
			 request.getRequestDispatcher("views/user-menu.jsp").forward(request, response);
		}

		
	}
}
