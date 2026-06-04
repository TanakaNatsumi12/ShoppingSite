package jo.co.aforce.beans;

public class UserBean implements java.io.Serializable{
	
	private String memberId;
	private String password;
	private String lastName;
	private String firstName;
	private String address;
	private String mailAddress;
	
	public UserBean() {
	    
	}

	
	public String getMemberId() {
		return memberId;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getMailAddress() {
		return mailAddress;
	}
	
	public void setMemberId(String memberId) {
		this.memberId=memberId;
	}
	
	public void setPassword(String password) {
		this.password=password;
	}
	
	public void setLastName(String lastName) {
		this.lastName=lastName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}
	
	public void setAddress(String address) {
		this.address=address;
	}
	
	public void setMailAddress(String mailAddress) {
		this.mailAddress=mailAddress;
	}
	
	public UserBean(String memberId, String password, String lastName, String firstName,String address, String mailAddress) {
	    this.memberId = memberId;
	    this.password = password;
	    this.lastName = lastName;
	    this.firstName = firstName;
	    this.address = address;
	    this.mailAddress = mailAddress;
	}

	
	
}
