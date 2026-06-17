package jo.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jo.co.aforce.beans.PlayerBean;

public class PlayerDAO extends DAO{

	public List<PlayerBean> searchByName(String keyword) {
        List<PlayerBean> list = new ArrayList<>();

        try {
            Connection con = getConnection();

            String sql = "SELECT * FROM players WHERE name LIKE ? ORDER BY name";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyword + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                PlayerBean p = new PlayerBean();
                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setTeamId(rs.getInt("team_id"));
                p.setNationality(rs.getString("nationality"));
                p.setStatus(rs.getString("status"));
                p.setPosition(rs.getString("position"));
                p.setCreatedAt(rs.getTimestamp("created_at").toLocalDateTime());
                p.setUpdatedAt(rs.getTimestamp("updated_at").toLocalDateTime());

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
