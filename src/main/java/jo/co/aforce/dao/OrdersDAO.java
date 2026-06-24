package jo.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class OrdersDAO {
	
	public int insertOrder(Connection conn, String memberId, List<Map<String, Object>> items, String paymentMethod)
            throws Exception {

        int total = 0;
        for (Map<String, Object> item : items) {
            total += (int) item.get("price") * (int) item.get("quantity");
        }

        String sql = "INSERT INTO orders (member_id, total_amount, payment_method) VALUES (?, ?, ?)";

        try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, memberId);
            ps.setInt(2, total);
            ps.setString(3, paymentMethod);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) return rs.getInt(1);
        }

        throw new Exception("注文IDの取得に失敗しました");
    }
}
