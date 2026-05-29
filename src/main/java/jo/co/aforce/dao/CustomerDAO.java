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

}
