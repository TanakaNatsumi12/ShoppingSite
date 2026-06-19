package jo.co.aforce.servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jo.co.aforce.beans.ProductsBean;
import jo.co.aforce.dao.ProductDAO;

@WebServlet("/productAddSuccess")
public class ProductAddSuccess extends HttpServlet{

	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        request.setCharacterEncoding("UTF-8");
	        
	     // ① 確認画面からファイル名を受け取る
	        String fileName = request.getParameter("image_file");
	        

	        // ② 仮保存 → 本番へコピー
	        String tempPath = getServletContext().getRealPath("/img/confirm/" + fileName);
	        String realPath = getServletContext().getRealPath("/img/registration/" + fileName);

	        Files.copy(Paths.get(tempPath), Paths.get(realPath), StandardCopyOption.REPLACE_EXISTING);

	        // ③ DB に保存する URL
	       String imageUrl = "/img/registration/" + fileName;

	        ProductsBean product = new ProductsBean();
	        product.setName(request.getParameter("name"));
	        product.setDescription(request.getParameter("description"));
	        product.setPrice(Integer.parseInt(request.getParameter("price")));
	        product.setStock(Integer.parseInt(request.getParameter("stock")));
	        product.setTeamId(Integer.parseInt(request.getParameter("team_id")));
	        product.setPlayerId(Integer.parseInt(request.getParameter("player_id")));
	        product.setImageUrl(imageUrl);  

	        

	        ProductDAO dao = new ProductDAO();
	        int result = dao.insertProduct(product);


	        if (result > 0) {
	            response.sendRedirect(request.getContextPath() + "/views/admin-products-add-success.jsp");
	        } else {
	            response.sendRedirect(request.getContextPath() + "/views/error.jsp");
	        }
	    }
}
