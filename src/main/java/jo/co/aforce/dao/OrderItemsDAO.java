package jo.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderItemsDAO {
	
	public void insertOrderItems(Connection conn, int orderId, List<Map<String, Object>> items) throws Exception {

        String sql = "INSERT INTO order_items (order_id, product_id, quantity, price, variation) "
                   + "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {

            for (Map<String, Object> item : items) {
                ps.setInt(1, orderId);
                ps.setInt(2, (int) item.get("product_id"));
                ps.setInt(3, (int) item.get("quantity"));
                ps.setInt(4, (int) item.get("price"));
                ps.setString(5, (String) item.get("variation"));
                ps.addBatch();
            }

            ps.executeBatch();
        }
    }
	
	public List<Map<String, Object>> getOrderItems(Connection conn, int orderId) throws Exception {

	    String sql = "SELECT oi.product_id, oi.quantity, oi.price, oi.variation, " +
	                 "p.name, p.image_url AS image " +
	                 "FROM order_items oi " +
	                 "JOIN products p ON oi.product_id = p.id " +
	                 "WHERE oi.order_id = ?";

	    PreparedStatement ps = conn.prepareStatement(sql);
	    ps.setInt(1, orderId);
	    ResultSet rs = ps.executeQuery();

	    List<Map<String, Object>> list = new ArrayList<>();

	    while (rs.next()) {
	        Map<String, Object> item = new HashMap<>();
	        item.put("product_id", rs.getInt("product_id"));
	        item.put("name", rs.getString("name"));
	        item.put("price", rs.getInt("price"));
	        item.put("quantity", rs.getInt("quantity"));
	        item.put("variation", rs.getString("variation"));
	        item.put("image", rs.getString("image"));
	        list.add(item);
	    }

	    return list;
	}

	
}
