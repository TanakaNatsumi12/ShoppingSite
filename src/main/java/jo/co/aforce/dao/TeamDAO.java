package jo.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jo.co.aforce.beans.TeamBean;

public class TeamDAO extends DAO{
	
	 public List<TeamBean> findAll() {
	        List<TeamBean> list = new ArrayList<>();

	        try {
	            Connection con = getConnection();

	            String sql = "SELECT id, name, conference FROM teams ORDER BY id";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                TeamBean t = new TeamBean();
	                t.setId(rs.getInt("id"));
	                t.setName(rs.getString("name"));
	                t.setConference(rs.getString("conference"));
	                list.add(t);
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
