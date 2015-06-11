package model;
import java.io.Serializable;

public class UserDTO implements Serializable{

	private int userId;
	private	String userName;
	private String address;
	private String phoneNo;
	private String password;
	private String userType;
	
	public UserDTO(int userId, String userName, String address,
			String phoneNo, String password, String userType) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.password = password;
		this.userType = userType;
	}
	public int getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public String getAddress() {
		return address;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public String getPassword() {
		return password;
	}
	public String getUserType() {
		return userType;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName
				+ ", address=" + address + ", phoneNo=" + phoneNo
				+ ", password=" + password + ", userType=" + userType + "]";
	}
	
}
