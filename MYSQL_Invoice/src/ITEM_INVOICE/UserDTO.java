package ITEM_INVOICE;

import java.io.Serializable;

public class UserDTO implements Cloneable,Serializable {
	private int userid;
	private String username;
	private String password;
	
	private static UserDTO userDTO;
	synchronized public static UserDTO getUserDTO() {
		if(userDTO==null) {
			userDTO=new UserDTO();
		}
		return userDTO.getCloneUserDTO();		
	}
	
	private UserDTO getCloneUserDTO() {
		try {
			return (UserDTO)super.clone();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((invoiceid == null) ? 0 : invoiceid.hashCode());
//		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + Float.floatToIntBits(userid);
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDTO other = (UserDTO) obj;
		if (!(userid == other.userid))
			return false;
		if(!(username.equals(other.username)))
			return false;
		if(!(password.equals(other.password)))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UserDTO [User ID =" + userid + ",Username =" + username +"]";
	}
	
	public int getUserid() {
		return userid;
	}
	
	public void setUserid(int userid) {
		this.userid = userid;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
