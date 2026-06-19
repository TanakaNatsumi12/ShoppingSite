package jo.co.aforce.servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jo.co.aforce.beans.ProductsBean;
import jo.co.aforce.beans.TeamBean;
import jo.co.aforce.dao.PlayerDAO;
import jo.co.aforce.dao.ProductDAO;
import jo.co.aforce.dao.TeamDAO;

@WebServlet("/productEdit")
public class ProductEdit extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        ProductDAO dao = new ProductDAO();
        ProductsBean product = dao.findById(id);
        
        TeamDAO tdao = new TeamDAO();
        List<TeamBean> teams = tdao.findAll(); 
        
        String teamName = tdao.findNameById(product.getTeamId());
        product.setTeamName(teamName);

        
        PlayerDAO pdao = new PlayerDAO();
        String playerName = pdao.findNameById(product.getPlayerId());
        product.setPlayerName(playerName);
        
        request.setAttribute("teams", teams);  
        request.setAttribute("product", product);


        RequestDispatcher rd = request.getRequestDispatcher("/views/admin-products-edit.jsp");
        rd.forward(request, response);
    }
}

