package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserAddServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String memberId = request.getParameter("memberId");
        String password = request.getParameter("password");
        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String mailAddress = request.getParameter("mailAddress");

      
    }
}
