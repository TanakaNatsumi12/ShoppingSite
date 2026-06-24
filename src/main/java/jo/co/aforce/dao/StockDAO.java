package jo.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Map;

public class StockDAO {
	
	
	 public void updateStock(Connection conn, List<Map<String, Object>> items) throws Exception {

	        String sql = "UPDATE products SET stock = stock - ? WHERE id = ?";

	        try (PreparedStatement ps = conn.prepareStatement(sql)) {

	            for (Map<String, Object> item : items) {
	                ps.setInt(1, (int) item.get("quantity"));
	                ps.setInt(2, (int) item.get("product_id"));
	                ps.addBatch();
	            }

	            ps.executeBatch();
	        }
	    }
}
