package model;
import java.io.Serializable;
import java.util.Date;

public class OrderTransactionDTO implements Serializable{

	private int orTransId;
	private int partNo;
	private int orderQty;
	private String manuName;
	private Date orderDate;
	private int userId;
	private double orderPrice;
	private String orderStatus;
	
	public OrderTransactionDTO(int orTransId, int partNo, int orderQty,
			String manuName, Date orderDate, int userId, double orderPrice,
			String orderStatus) {
		super();
		this.orTransId = orTransId;
		this.partNo = partNo;
		this.orderQty = orderQty;
		this.manuName = manuName;
		this.orderDate = orderDate;
		this.userId = userId;
		this.orderPrice = orderPrice;
		this.orderStatus = orderStatus;
	}
	public int getOrTransId() {
		return orTransId;
	}
	public int getPartNo() {
		return partNo;
	}
	public int getOrderQty() {
		return orderQty;
	}
	public String getManuName() {
		return manuName;
	}
	public Date getOrderDate() {
		return orderDate;
	}
	public int getUserId() {
		return userId;
	}
	public double getOrderPrice() {
		return orderPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	@Override
	public String toString() {
		return "OrderTransaction [orTransId=" + orTransId + ", partNo="
				+ partNo + ", orderQty=" + orderQty + ", manuName=" + manuName
				+ ", orderDate=" + orderDate + ", userId=" + userId
				+ ", orderPrice=" + orderPrice + ", orderStatus=" + orderStatus
				+ "]";
	}
}
