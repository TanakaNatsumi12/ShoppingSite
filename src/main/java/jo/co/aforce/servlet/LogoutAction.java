package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jo.co.aforce.tool.Action;


public class LogoutAction extends Action{
	public String execute(
			HttpServletRequest request, HttpServletResponse response
		)throws ServletException, IOException{
		
		
		HttpSession session=request.getSession();
		
		if(session.getAttribute("customer")!=null) {
			session.removeAttribute("customer");
			return "views/logout-out.jsp"; 
		}
		
		return "views/logout-error.jsp";
	}

}
