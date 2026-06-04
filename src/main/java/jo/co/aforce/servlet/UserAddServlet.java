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

@WebServlet(urlPatterns= {"/userAddServlet"})
public class UserAddServlet extends HttpServlet{

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        String memberId = (String) session.getAttribute("memberId");
        String password = (String) session.getAttribute("password");
        String lastName = (String) session.getAttribute("lastName");
        String firstName = (String) session.getAttribute("firstName");
        String address = (String) session.getAttribute("address");
        String mailAddress = (String) session.getAttribute("mailAddress");

        // 万が一セッションが切れていた場合
        if (memberId == null || password == null) {
            request.setAttribute("error", "セッションが切れました。もう一度入力してください。");
            RequestDispatcher rd = request.getRequestDispatcher("/views/user-add.jsp");
            rd.forward(request, response);
            return;
        }


        UserBean user = new UserBean(memberId, password, lastName, firstName, address, mailAddress);

        UserDAO dao = new UserDAO();
        

     boolean exists = false;
     try {
         exists = dao.exists(memberId);
     } catch (Exception e) {
         e.printStackTrace();
     }

     if (exists) {
         request.setAttribute("error", "入力されたユーザーIDは既に登録済みです");
         RequestDispatcher rd = request.getRequestDispatcher("/views/user-add.jsp");
         rd.forward(request, response);
         return;
     }

        
        boolean result = false;
		try {
			result = dao.insert(user);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
			
		session.removeAttribute("memberId");
        session.removeAttribute("password");
        session.removeAttribute("lastName");
        session.removeAttribute("firstName");
        session.removeAttribute("address");
        session.removeAttribute("mailAddress");

        if (result) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/user-success.jsp");
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("/views/user-add.jsp");
            rd.forward(request, response);
        }
        

    }
}

