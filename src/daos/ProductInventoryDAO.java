package daos;

import java.util.ArrayList;

import model.ProductInventoryDTO;

public interface ProductInventoryDAO {

	public abstract ArrayList<ProductInventoryDTO> getAllProductInventory();

	public abstract boolean insertProduct(ProductInventoryDTO product);

	public abstract boolean deleteProduct(ProductInventoryDTO product);

	public abstract boolean updateInventory(ProductInventoryDTO product);

	public abstract ProductInventoryDTO getOneProduct(int partNo);
	
	public abstract boolean updateInventoryProduct(int partNo, int total, int damaged, int available);

}