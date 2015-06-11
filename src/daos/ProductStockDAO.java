package daos;

import java.util.ArrayList;

import model.ProductStockDTO;

public interface ProductStockDAO {

	public abstract ArrayList<ProductStockDTO> getAllProductList();
	public abstract ArrayList<ProductStockDTO> getbyCategory(String cat);

}