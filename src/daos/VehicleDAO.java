package daos;

import java.util.ArrayList;

import model.VehicleDTO;

public interface VehicleDAO {

	public abstract ArrayList<VehicleDTO> getAllVehicles();

	public abstract VehicleDTO getOneVehicle(String id);

}