package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import jo.co.aforce.beans.UserBean;
import jo.co.aforce.dao.UserDAO;

@WebServlet(urlPatterns= {"/userEditServlet"})
public class UserEditServlet extends HttpServlet{
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String lastName = request.getParameter("lastName");
        String firstName = request.getParameter("firstName");
        String address = request.getParameter("address");
        String mailAddress = request.getParameter("mailAddress");
        
        HttpSession session = request.getSession();
        UserBean loginUser = (UserBean) session.getAttribute("customer");
        
        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/views/no-login.jsp");
            return;
        }

        loginUser.setLastName(lastName);
        loginUser.setFirstName(firstName);
        loginUser.setAddress(address);
        loginUser.setMailAddress(mailAddress);

        UserDAO dao = new UserDAO();
        boolean result = false;

        try {
            result = dao.update(loginUser);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result) {
        	session.setAttribute("customer", loginUser);
            RequestDispatcher rd = request.getRequestDispatcher("/views/user-edit-success.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("error", "更新に失敗しました");
            RequestDispatcher rd = request.getRequestDispatcher("/views/user-edit.jsp");
            rd.forward(request, response);
        }
        

    }

}