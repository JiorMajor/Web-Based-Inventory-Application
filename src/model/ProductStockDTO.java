package model;

public class ProductStockDTO {

	private int partNo;
	private String partName;
	private double unitPrice;
	private String category;
	private int reorderlvl;
	private int minOrderQty;
	private String dimension;
	private String color;
	private String shelfLocation;
	private int totalQty;
	private int damagedQty;
	private int availableQty;
	
	
	public ProductStockDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ProductStockDTO(int partNo, String partName, double unitPrice,
			String category, int reorderlvl, int minOrderQty,
			String dimension, String color,
			String shelfLocation, int totalQty, int damagedQty, int availableQty) {
		this.partNo = partNo;
		this.partName = partName;
		this.unitPrice = unitPrice;
		this.category = category;
		this.reorderlvl = reorderlvl;
		this.minOrderQty = minOrderQty;
		this.dimension = dimension;
		this.color = color;
		this.shelfLocation = shelfLocation;
		this.totalQty = totalQty;
		this.damagedQty = damagedQty;
		this.availableQty = availableQty;
	}


	public int getPartNo() {
		return partNo;
	}


	public void setPartNo(int partNo) {
		this.partNo = partNo;
	}


	public String getPartName() {
		return partName;
	}


	public void setPartName(String partName) {
		this.partName = partName;
	}


	public double getUnitPrice() {
		return unitPrice;
	}


	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public int getReorderlvl() {
		return reorderlvl;
	}


	public void setReorderlvl(int reorderlvl) {
		this.reorderlvl = reorderlvl;
	}


	public int getMinOrderQty() {
		return minOrderQty;
	}


	public void setMinOrderQty(int minOrderQty) {
		this.minOrderQty = minOrderQty;
	}

	public String getDimension() {
		return dimension;
	}


	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	
	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		this.color = color;
	}
	
	public String getShelfLocation() {
		return shelfLocation;
	}


	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
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


	@Override
	public String toString() {
		return "productstockDTO [partNo=" + partNo + ", partName=" + partName
				+ ", unitPrice=" + unitPrice + ", category=" + category
				+ ", reorderlvl=" + reorderlvl + ", minOrderQty=" + minOrderQty
				+", dimension=" + dimension + ", color=" + color
				+ ", shelfLocation=" + shelfLocation + ", totalQty=" + totalQty
				+ ", damagedQty=" + damagedQty + ", availableQty="
				+ availableQty + "]";
	}
	
	
}
