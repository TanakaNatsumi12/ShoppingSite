package jo.co.aforce.servlet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import jo.co.aforce.beans.ProductsBean;
import jo.co.aforce.dao.ProductDAO;

@WebServlet("/productsEditUpdate")
@MultipartConfig
public class ProductsEditUpdate extends HttpServlet{
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

		 request.setCharacterEncoding("UTF-8");
		 
	        // ---------- 1. フォームから値を取得 ----------
	        int id = Integer.parseInt(request.getParameter("id"));
	        String name = request.getParameter("name");
	        String description = request.getParameter("description");
	        int price = Integer.parseInt(request.getParameter("price"));
	        int stock = Integer.parseInt(request.getParameter("stock"));
	        int teamId = Integer.parseInt(request.getParameter("team_id"));
	        int playerId = Integer.parseInt(request.getParameter("player_id"));

	        // ---------- 2. 画像アップロード処理 ----------
	        Part part = request.getPart("image");
	        String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();

	        String imageUrl;

	        if (fileName != null && !fileName.isEmpty()) {
	            // 新しい画像がアップロードされた場合
	            String uploadPath = getServletContext().getRealPath("/img/registration");
	            File uploadDir = new File(uploadPath);
	            if (!uploadDir.exists()) uploadDir.mkdir();

	            part.write(uploadPath + "/" + fileName);

	            imageUrl = "/img/registration/" + fileName;

	        } else {
	            // 画像未選択 → 元の画像を維持
	            imageUrl = request.getParameter("current_image");
	            
	            if (!imageUrl.startsWith("/")) {
	                imageUrl = "/" + imageUrl;
	        }
	            
	            if (!imageUrl.startsWith("/img/registration/")) {
	                String oldFileName = imageUrl.substring(imageUrl.lastIndexOf("/") + 1);
	                imageUrl = "/img/registration/" + oldFileName;
	            }
	        }

	        // ---------- 3. Bean に詰める ----------
	        ProductsBean product = new ProductsBean(
	                id,
	                name,
	                description,
	                price,
	                stock,
	                teamId,
	                playerId,
	                imageUrl
	        );

	        // ---------- 4. DAO で更新 ----------
	        ProductDAO dao = new ProductDAO();
	        dao.update(product);

	        // ---------- 5. 一覧へリダイレクト ----------
	        response.sendRedirect(request.getContextPath() + "/views/admin-products-edit-success.jsp");
	    }
}
