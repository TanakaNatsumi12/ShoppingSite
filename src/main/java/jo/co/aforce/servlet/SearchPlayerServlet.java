package jo.co.aforce.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jo.co.aforce.beans.PlayerBean;
import jo.co.aforce.dao.PlayerDAO;

@WebServlet("/searchPlayer")
public class SearchPlayerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        PlayerDAO dao = new PlayerDAO();
        List<PlayerBean> players = dao.searchByName(keyword);

        // JSON で返す
        response.setContentType("application/json; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.print("[");

        for (int i = 0; i < players.size(); i++) {
            PlayerBean p = players.get(i);

            out.print("{");
            out.print("\"id\":" + p.getId() + ",");
            out.print("\"name\":\"" + p.getName() + "\"");
            out.print("}");

            if (i < players.size() - 1) out.print(",");
        }

        out.print("]");
    }
}
