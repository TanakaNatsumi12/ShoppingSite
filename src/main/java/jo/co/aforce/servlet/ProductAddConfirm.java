package jo.co.aforce.servlet;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/productAddConfirm")
@MultipartConfig(
	    fileSizeThreshold = 1024 * 1024,
	    maxFileSize = 1024 * 1024 * 5,      // 5MB
	    maxRequestSize = 1024 * 1024 * 10   // 10MB
	)
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
		        Part part = request.getPart("image");
		        String fileName = part.getSubmittedFileName();
		        
		        
		        String uploadPath = getServletContext().getRealPath("/img/confirm");
		        File uploadDir = new File(uploadPath);
		        if (!uploadDir.exists()) uploadDir.mkdirs();

		        String filePath = uploadPath + File.separator + fileName;
		        part.write(filePath);


		        
		       

		        request.setAttribute("name", name);
		        request.setAttribute("description", description);
		        request.setAttribute("price", price);
		        request.setAttribute("stock", stock);
		        request.setAttribute("team_id", teamId);
		        request.setAttribute("player_id", playerId);
		        request.setAttribute("team_name", teamName);
		        request.setAttribute("player_name", playerName);
		        request.setAttribute("imagePath", "img/confirm/" + fileName);
		       
		        RequestDispatcher rd = request.getRequestDispatcher("/views/admin-products-add-confirm.jsp");
		        rd.forward(request, response);
		    }

		    protected void doGet(HttpServletRequest request, HttpServletResponse response)
		            throws ServletException, IOException {
		        doPost(request, response);
		    }
		
}
