package jo.co.aforce.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jo.co.aforce.beans.ProductsBean;

public class ProductDAO extends DAO {

	public List<ProductsBean> findAll(String orderBy) {
	    List<ProductsBean> list = new ArrayList<>();

	    try {
	        Connection con = getConnection();

	        String sql = "SELECT * FROM products ORDER BY " + orderBy;
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
	
	public ProductsBean findById(int id) {
	    ProductsBean product = null;

	    try {
	        Connection con = getConnection();

	        String sql = "SELECT * FROM products WHERE id = ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, id);

	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            product = new ProductsBean(
	                rs.getInt("id"),
	                rs.getString("name"),
	                rs.getString("description"),
	                rs.getInt("price"),
	                rs.getInt("stock"),
	                rs.getInt("team_id"),
	                rs.getInt("player_id"),
	                rs.getString("image_url")
	            );
	        }

	        rs.close();
	        ps.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return product;
	}
	
	public int update(ProductsBean product) {
	    int result = 0;

	    try {
	        Connection con = getConnection();

	        String sql = "UPDATE products SET "
	                + "name=?, description=?, price=?, stock=?, "
	                + "team_id=?, player_id=?, image_url=? "
	                + "WHERE id=?";

	        PreparedStatement ps = con.prepareStatement(sql);

	        ps.setString(1, product.getName());
	        ps.setString(2, product.getDescription());
	        ps.setInt(3, product.getPrice());
	        ps.setInt(4, product.getStock());
	        ps.setInt(5, product.getTeamId());
	        ps.setInt(6, product.getPlayerId());
	        ps.setString(7, product.getImageUrl());
	        ps.setInt(8, product.getId());

	        result = ps.executeUpdate();

	        ps.close();
	        con.close();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return result;
	}

	public boolean deleteProduct(int id) {
	    String sql = "DELETE FROM products WHERE id = ?";

	    try (Connection con = getConnection();
	         PreparedStatement pstmt = con.prepareStatement(sql)) {

	        pstmt.setInt(1, id);

	        int result = pstmt.executeUpdate();
	        return result == 1;

	    } catch (Exception e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	public List<ProductsBean> searchProducts(String keyword, String orderBy) {
	    List<ProductsBean> list = new ArrayList<>();

	    try {
	        Connection con = getConnection();

	        String sql = "SELECT * FROM products WHERE name LIKE ? OR description LIKE ? ORDER BY " + orderBy;
	        PreparedStatement ps = con.prepareStatement(sql);

	        String like = "%" + keyword + "%";
	        ps.setString(1, like);
	        ps.setString(2, like);

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


	public List<ProductsBean> findLatest(int limit) {
	    List<ProductsBean> list = new ArrayList<>();

	    try {
	        Connection con = getConnection();
	        String sql = "SELECT * FROM products ORDER BY id DESC LIMIT ?";
	        PreparedStatement ps = con.prepareStatement(sql);
	        ps.setInt(1, limit);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            ProductsBean p = new ProductsBean();
	            p.setId(rs.getInt("id"));
	            p.setName(rs.getString("name"));
	            p.setPrice(rs.getInt("price"));
	            p.setImageUrl(rs.getString("image_url"));
	            list.add(p);
	        }

	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    return list;
	}
	
}


