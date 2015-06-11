package daos;

import java.util.ArrayList;

import model.ManufacturerDTO;

public interface ManufacturerDAO {

	public abstract ArrayList<ManufacturerDTO> getAllManufacturers();

	public abstract ManufacturerDTO getOneManufacturer(String name);

}