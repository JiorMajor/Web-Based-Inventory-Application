package model;
import java.io.Serializable;

public class ManufacturerDTO implements Serializable{

	private String manuName;
	private String address;
	private int phoneNo;
	private String contactPerson;
	
	public ManufacturerDTO(String manuName, String address, int phoneNo,
			String contactPerson) {
		super();
		this.manuName = manuName;
		this.address = address;
		this.phoneNo = phoneNo;
		this.contactPerson = contactPerson;
	}
	public String getManuName() {
		return manuName;
	}
	public String getAddress() {
		return address;
	}
	public int getPhoneNo() {
		return phoneNo;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	@Override
	public String toString() {
		return "Manufacturer [manuName=" + manuName + ", address=" + address
				+ ", phoneNo=" + phoneNo + ", contactPerson=" + contactPerson
				+ "]";
	}
}
