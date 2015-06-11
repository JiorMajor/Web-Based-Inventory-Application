package model;
import java.io.Serializable;

public class ProductDTO implements Serializable{

	private int partNo;
	private String partName;
	private double unitPrice;
	private String description;
	private String color;
	private String dimension;
	private String category;
	private String manuName;
	private int reorderlvl;
	private int minOrderQty;
	private String shelfLocation;
	
	public ProductDTO(int partNo, String partName, double unitPrice,
			String description, String color, String dimension,
			String category, String manuName, int reorderlvl, int minOrderQty,
			String shelfLocation) {
		super();
		this.partNo = partNo;
		this.partName = partName;
		this.unitPrice = unitPrice;
		this.description = description;
		this.color = color;
		this.dimension = dimension;
		this.category = category;
		this.manuName = manuName;
		this.reorderlvl = reorderlvl;
		this.minOrderQty = minOrderQty;
		this.shelfLocation = shelfLocation;
	}
	public String getPartName() {
		return partName;
	}
	public void setPartName(String partName) {
		this.partName = partName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPartNo() {
		return partNo;
	}
	public double getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getManuName() {
		return manuName;
	}
	public void setManuName(String manuName) {
		this.manuName = manuName;
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
	public String getShelfLocation() {
		return shelfLocation;
	}
	public void setShelfLocation(String shelfLocation) {
		this.shelfLocation = shelfLocation;
	}
	@Override
	public String toString() {
		return "ProductDTO [partNo=" + partNo + ", partName=" + partName
				+ ", unitPrice=" + unitPrice + ", description=" + description
				+ ", color=" + color + ", dimension=" + dimension
				+ ", category=" + category + ", manuName=" + manuName
				+ ", reorderlvl=" + reorderlvl + ", minOrderQty=" + minOrderQty
				+ ", shelfLocation=" + shelfLocation + "]";
	}
}
