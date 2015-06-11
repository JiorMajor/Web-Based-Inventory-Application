package model;
import java.io.Serializable;

public class CustomerDTO implements Serializable{

	private int customerId;
	private String customerName;
	private String address;
	private int phoneNo;
	
	public CustomerDTO(int customerId, String customerName, String address,
			int phoneNo) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
		this.phoneNo = phoneNo;
	}
	public int getCustomerId() {
		return customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public String getAddress() {
		return address;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName="
				+ customerName + ", address=" + address + ", phoneNo="
				+ phoneNo + "]";
	}
}
