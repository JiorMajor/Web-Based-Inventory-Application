package model;
import java.io.Serializable;

public class ProductInventoryDTO implements Serializable{

	private int partNo;
	private int totalQty;
	private int damagedQty;
	private int availableQty;
	
	public ProductInventoryDTO(int partNo, int totalQty, int damagedQty,
			int availableQty) {
		super();
		this.partNo = partNo;
		this.totalQty = totalQty;
		this.damagedQty = damagedQty;
		this.availableQty = availableQty;
	}
	public int getPartNo() {
		return partNo;
	}
	public int getTotalQty() {
		return totalQty;
	}
	public void setTotalQty(int totalQty) {
		this.totalQty = totalQty;
	}
	public int getDamagedQty() {
		return damagedQty;
	}
	public void setDamagedQty(int damagedQty) {
		this.damagedQty = damagedQty;
	}
	public int getAvailableQty() {
		return availableQty;
	}
	public void setAvailableQty(int availableQty) {
		this.availableQty = availableQty;
	}
	
	
	public ProductInventoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ProductInventory [partNo=" + partNo + ", totalQty=" + totalQty
				+ ", damagedQty=" + damagedQty + ", availableQty="
				+ availableQty + "]";
	}
	
	
}
