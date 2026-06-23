package jo.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CartDAO extends DAO{

	 // セッションIDからカートIDを取得
    public Integer findCartIdBySession(Connection conn, String sessionId) throws Exception {
        String sql = "SELECT id FROM carts WHERE session_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, sessionId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) return rs.getInt("id");
        return null;
    }

    // カートを新規作成
    public int createCart(Connection conn, String sessionId) throws Exception {
        String sql = "INSERT INTO carts (session_id) VALUES (?)";
        PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, sessionId);
        stmt.executeUpdate();
        ResultSet keys = stmt.getGeneratedKeys();
        keys.next();
        return keys.getInt(1);
    }

    // カート内に同じ商品があるか確認
    public Integer findCartItemId(Connection conn, int cartId, int productId) throws Exception {
        String sql = "SELECT id FROM cart_items WHERE cart_id = ? AND product_id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, cartId);
        stmt.setInt(2, productId);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) return rs.getInt("id");
        return null;
    }

    // 数量を加算
    public void updateCartItemQuantity(Connection conn, int itemId, int quantity) throws Exception {
        String sql = "UPDATE cart_items SET quantity = quantity + ? WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, quantity);
        stmt.setInt(2, itemId);
        stmt.executeUpdate();
    }

    // 新規商品をカートに追加（unit_price は削除）
    public void insertCartItem(Connection conn, int cartId, int productId, int quantity) throws Exception {
        String sql = "INSERT INTO cart_items (cart_id, product_id, quantity) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, cartId);
        stmt.setInt(2, productId);
        stmt.setInt(3, quantity);
        stmt.executeUpdate();
    }
    
    public List<Map<String, Object>> getCartItems(Connection conn, int cartId) throws Exception {
        String sql = "SELECT ci.id, ci.product_id, p.name, p.price, p.image_url AS image, " +
                     "ci.quantity, p.stock " +   // ← 在庫追加
                     "FROM cart_items ci " +
                     "JOIN products p ON ci.product_id = p.id " +
                     "WHERE ci.cart_id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, cartId);
        ResultSet rs = stmt.executeQuery();

        List<Map<String, Object>> list = new ArrayList<>();

        while (rs.next()) {
            Map<String, Object> item = new HashMap<>();
            item.put("id", rs.getInt("id"));                
            item.put("product_id", rs.getInt("product_id"));
            item.put("name", rs.getString("name"));
            item.put("price", rs.getInt("price"));
            item.put("image", rs.getString("image"));
            item.put("quantity", rs.getInt("quantity"));
            item.put("stock", rs.getInt("stock"));  // ← 在庫を追加
            list.add(item);
        }

        return list;
    }
    
    public void removeItem(Connection conn, int cartId, int productId) throws Exception {

        String sql = "DELETE FROM cart_items WHERE cart_id = ? AND product_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, cartId);
            ps.setInt(2, productId);
            ps.executeUpdate();
        }
    }
    
    public void updateCartItem(Connection conn, int cartId, int productId, int quantity) throws Exception {

        String sql = "UPDATE cart_items SET quantity = ? WHERE cart_id = ? AND product_id = ?";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, quantity);
            ps.setInt(2, cartId);
            ps.setInt(3, productId);
            ps.executeUpdate();
        }
    }


}
