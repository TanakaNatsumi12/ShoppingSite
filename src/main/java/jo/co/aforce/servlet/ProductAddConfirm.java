package jo.co.aforce.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/productAddConfirm")
public class ProductAddConfirm extends HttpServlet{
	
	public void doPost(
			HttpServletRequest request, HttpServletResponse response
		)throws ServletException, IOException{
		

		        String name = request.getParameter("name");
		        String description = request.getParameter("description");
		        String price = request.getParameter("price");
		        String stock = request.getParameter("stock");
		        String teamId = request.getParameter("team_id");
		        String playerId = request.getParameter("player_id");
		        String teamName = request.getParameter("team_name");
		        String playerName = request.getParameter("player_name");
		        
		       

		        request.setAttribute("name", name);
		        request.setAttribute("description", description);
		        request.setAttribute("price", price);
		        request.setAttribute("stock", stock);
		        request.setAttribute("team_id", teamId);
		        request.setAttribute("player_id", playerId);
		        request.setAttribute("team_name", teamName);
		        request.setAttribute("player_name", playerName);
		      
		       
		        RequestDispatcher rd = request.getRequestDispatcher("/views/admin-products-add-confirm.jsp");
		        rd.forward(request, response);
		    }

		    protected void doGet(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
		        doPost(request, response);
		    }
		
}
