package jo.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jo.co.aforce.beans.UserBean;

public class UserDAO extends DAO{
	
	public UserBean search(String memberId, String password)
		throws Exception {
		UserBean customer=null;
		
		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement(
				"select * from users where MEMBER_ID=? and PASSWORD=?");
		
		
	st.setString(1, memberId);
	st.setString(2, password);
	ResultSet rs=st.executeQuery();
	
	if(rs.next()) {
	    customer = new UserBean();
	    customer.setMemberId(rs.getString("MEMBER_ID"));
	    customer.setPassword(rs.getString("PASSWORD"));
	    customer.setLastName(rs.getString("LAST_NAME"));
	    customer.setFirstName(rs.getString("FIRST_NAME"));
	    customer.setAddress(rs.getString("ADDRESS"));
	    customer.setMailAddress(rs.getString("MAIL_ADDRESS"));
	    customer.setRole(rs.getString("ROLE")); 
	}
	
	st.close();
	con.close();	
	return customer;
	
	}
	
	public boolean insert(UserBean customer) throws Exception {

	    Connection con = getConnection();

	    PreparedStatement st = con.prepareStatement(
	        "INSERT INTO users (MEMBER_ID, PASSWORD, LAST_NAME, FIRST_NAME, ADDRESS, MAIL_ADDRESS) "
	      + "VALUES (?, ?, ?, ?, ?, ?)");

	    st.setString(1, customer.getMemberId());
	    st.setString(2, customer.getPassword());
	    st.setString(3, customer.getLastName());
	    st.setString(4, customer.getFirstName());
	    st.setString(5, customer.getAddress());
	    st.setString(6, customer.getMailAddress());

	    int result = st.executeUpdate();

	    st.close();
	    con.close();

	    return result == 1;
	}
	
	public boolean exists(String memberId) throws Exception {
	    Connection con = getConnection();

	    PreparedStatement st = con.prepareStatement(
	        "SELECT MEMBER_ID FROM users WHERE MEMBER_ID = ?"
	    );
	    st.setString(1, memberId);

	    ResultSet rs = st.executeQuery();
	    boolean exists = rs.next();  // 1件でもあれば true

	    rs.close();
	    st.close();
	    con.close();

	    return exists;
	}
	
	
	public boolean update(UserBean user) throws Exception {
	    Connection con = getConnection();

	    String sql = "UPDATE users SET LAST_NAME=?, FIRST_NAME=?, ADDRESS=?, MAIL_ADDRESS=? WHERE MEMBER_ID=?";
	    PreparedStatement ps = con.prepareStatement(sql);

	    ps.setString(1, user.getLastName());
	    ps.setString(2, user.getFirstName());
	    ps.setString(3, user.getAddress());
	    ps.setString(4, user.getMailAddress());
	    ps.setString(5, user.getMemberId());

	    int result = ps.executeUpdate();

	    ps.close();
	    con.close();

	    return result > 0;


}
	
	public boolean delete(String memberId) throws Exception {
	    Connection con = getConnection();

	    String sql = "DELETE FROM users WHERE MEMBER_ID=?";
	    PreparedStatement ps = con.prepareStatement(sql);

	    ps.setString(1, memberId);

	    int result = ps.executeUpdate();

	    ps.close();
	    con.close();

	    return result > 0;
	}

	
}
