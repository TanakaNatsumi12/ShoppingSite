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
}


