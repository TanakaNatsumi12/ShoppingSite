package jo.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jo.co.aforce.beans.Customer;

public class CustomerDAO extends DAO{
	
	public Customer search(String memberId, String password)
		throws Exception {
		Customer customer=null;
		
		Connection con=getConnection();
		
		PreparedStatement st;
		st=con.prepareStatement(
				"select * from users where MEMBER_ID=? and PASSWORD=?");
		
		
	st.setString(1, memberId);
	st.setString(2, password);
	ResultSet rs=st.executeQuery();
	
	if(rs.next()) {
	    customer = new Customer();
	    customer.setMemberId(rs.getString("MEMBER_ID"));
	    customer.setPassword(rs.getString("PASSWORD"));
	    customer.setLastName(rs.getString("LAST_NAME"));
	}
	
	st.close();
	con.close();	
	return customer;
	
	}
	
	public int insert(Customer customer) throws Exception {

	    Connection con = getConnection();

	    PreparedStatement st = con.prepareStatement(
	        "INSERT INTO users (MEMBER_ID, PASSWORD, LAST_NAME, FIRST_NAME, MAIL_ADDRESS) "
	      + "VALUES (?, ?, ?, ?, ?)");

	    st.setString(1, customer.getMemberId());
	    st.setString(2, customer.getPassword());
	    st.setString(3, customer.getLastName());
	    st.setString(4, customer.getFirstName());
	    st.setString(5, customer.getMailAddress());

	    int result = st.executeUpdate();

	    st.close();
	    con.close();

	    return result;
	}

}
