package model;
import java.io.Serializable;

public class VehicleDTO implements Serializable{

	private String vehicleId;
	private int ownerId;
	private String vehicleType;
	private String vehicleModel;
	
	public VehicleDTO(String vehicleId, int ownerId, String vehicleType,
			String vehicleModel) {
		super();
		this.vehicleId = vehicleId;
		this.ownerId = ownerId;
		this.vehicleType = vehicleType;
		this.vehicleModel = vehicleModel;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public int getOwnerId() {
		return ownerId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public String getVehicleModel() {
		return vehicleModel;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicleId=" + vehicleId + ", ownerId=" + ownerId
				+ ", vehicleType=" + vehicleType + ", vehicleModel="
				+ vehicleModel + "]";
	}
}
