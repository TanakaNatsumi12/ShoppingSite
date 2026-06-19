package jo.co.aforce.beans;

public class ProductsBean {
	
	private int id;
    private String name;
    private String description;
    private int price;
    private int stock;
    private int teamId;
    private int playerId;
    private String imageUrl;
    private String playerName;
    private String teamName;
    
    // ★ 引数なしコンストラクタ（JavaBeans必須）
    public ProductsBean() {
    }

    // ★ 全フィールドをセットするコンストラクタ（DAOで便利）
    public ProductsBean(int id, String name, String description, int price, int stock,
                   int teamId, int playerId, String imageUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.teamId = teamId;
        this.playerId = playerId;
        this.imageUrl = imageUrl;
    }
    
    public ProductsBean(int id, String name, String description, int price, int stock,
            String imageUrl) {
 this.id = id;
 this.name = name;
 this.description = description;
 this.price = price;
 this.stock = stock;
 
 this.imageUrl = imageUrl;
}

    // ★ 新規追加用（idなし）コンストラクタ
    public ProductsBean(String name, String description, int price, int stock,
                   int teamId, int playerId, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.teamId = teamId;
        this.playerId = playerId;
        this.imageUrl = imageUrl;
    }

    // ===== Getter / Setter =====

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getTeamId() {
        return teamId;
    }
    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    
    

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    
    

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

}
