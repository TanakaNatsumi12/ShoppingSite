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

@WebServlet(urlPatterns= {"/userDeleteServlet"})
public class UserDeleteServlet extends HttpServlet{

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserBean loginUser = (UserBean) session.getAttribute("customer");

        if (loginUser == null) {
            response.sendRedirect(request.getContextPath() + "/views/no-login.jsp");
            return;
        }

        String memberId = loginUser.getMemberId();

        UserDAO dao = new UserDAO();
        boolean result = false;

        try {
            result = dao.delete(memberId);
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (result) {
            session.removeAttribute("customer");

            RequestDispatcher rd = request.getRequestDispatcher("/views/user-delete-success.jsp");
            rd.forward(request, response);
        } else {
            request.setAttribute("error", "削除に失敗しました");
            RequestDispatcher rd = request.getRequestDispatcher("/views/user-menu.jsp");
            rd.forward(request, response);
        }
    }
}
