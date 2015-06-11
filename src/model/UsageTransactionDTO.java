package model;
import java.io.Serializable;
import java.util.Date;

public class UsageTransactionDTO implements Serializable{

	private int usageTransId;
	private int userId;
	private int customerId;
	private String vehicleId;
	private int partNo;
	private int Qtyused;
	private Date usageDate;

	public UsageTransactionDTO(int usageTransId, int userId, int customerId,
			String vehicleId, int partNo, int qtyused, Date usageDate) {
		super();
		this.usageTransId = usageTransId;
		this.userId = userId;
		this.customerId = customerId;
		this.vehicleId = vehicleId;
		this.partNo = partNo;
		Qtyused = qtyused;
		this.usageDate = usageDate;
	}

	public int getUsageTransId() {
		return usageTransId;
	}

	public int getPartNo() {
		return partNo;
	}

	public int getQtyused() {
		return Qtyused;
	}

	public int getCustomerId() {
		return customerId;
	}

	public Date getUsageDate() {
		return usageDate;
	}

	public String getVehicleId() {
		return vehicleId;
	}

	public int getUserId() {
		return userId;
	}

	@Override
	public String toString() {
		return "UsageTransactionDTO [usageTransId=" + usageTransId
				+ ", userId=" + userId + ", customerId=" + customerId
				+ ", vehicleId=" + vehicleId + ", partNo=" + partNo
				+ ", Qtyused=" + Qtyused + ", usageDate=" + usageDate + "]";
	}
}
