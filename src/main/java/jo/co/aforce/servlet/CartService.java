package jo.co.aforce.servlet;

import java.sql.Connection;

import jo.co.aforce.dao.CartDAO;
import jo.co.aforce.dao.DAO;

public class CartService{
	
	private CartDAO cartDao = new CartDAO();

    // カートに商品を追加するメイン処理
    public void addToCart(String sessionId, int productId, int quantity) throws Exception {

        try (Connection conn = DAO.getConnection()) {

            // 1. セッションIDに紐づくカートを探す
            Integer cartId = cartDao.findCartIdBySession(conn, sessionId);

            // 2. カートが無ければ新規作成
            if (cartId == null) {
                cartId = cartDao.createCart(conn, sessionId);
            }

            // 3. カート内に同じ商品があるか確認
            Integer itemId = cartDao.findCartItemId(conn, cartId, productId);

            // 4. 既にあるなら数量を加算、無ければ新規追加
            if (itemId != null) {
                cartDao.updateCartItemQuantity(conn, itemId, quantity);
            } else {
                cartDao.insertCartItem(conn, cartId, productId, quantity);
            }
        }
        
    }
    
    public void removeFromCart(String sessionId, int productId) throws Exception {

        try (Connection conn = DAO.getConnection()) {

            CartDAO cartDao = new CartDAO();

            // カートID取得
            Integer cartId = cartDao.findCartIdBySession(conn, sessionId);

            if (cartId != null) {
                cartDao.removeItem(conn, cartId, productId);
            }
        }
    }
	
}
