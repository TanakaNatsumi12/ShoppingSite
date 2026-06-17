package jo.co.aforce.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jo.co.aforce.beans.ProductsBean;

public class ProductDAO extends DAO {

	public List<ProductsBean> findAll() {
		List<ProductsBean> list = new ArrayList<>();

	    try {
	        Connection con = getConnection();

	        String sql = "SELECT * FROM products";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	        	ProductsBean p = new ProductsBean(
	        		rs.getInt("id"),
	                rs.getString("name"),
	                rs.getString("description"),
	                rs.getInt("price"),
	                rs.getInt("stock"),
	                rs.getInt("team_id"),
	                rs.getInt("player_id"),
	                rs.getString("image_url")
	             );
	             list.add(p);
	         }

	         rs.close();
	         ps.close();
	         con.close();

	     } catch (Exception e) {
	         e.printStackTrace();
	     }

	     return list;
	 }
	
	
	public int insertProduct(ProductsBean product) {
        int result = 0;

        try {
            Connection con = getConnection();

            String sql = "INSERT INTO products "
                       + "(name, description, price, stock, team_id, player_id, image_url) "
                       + "VALUES (?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, product.getName());
            ps.setString(2, product.getDescription());
            ps.setInt(3, product.getPrice());
            ps.setInt(4, product.getStock());
            ps.setInt(5, product.getTeamId());
            ps.setInt(6, product.getPlayerId());
            ps.setString(7, product.getImageUrl());

            result = ps.executeUpdate();

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}


