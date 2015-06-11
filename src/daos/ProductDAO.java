package daos;

import java.util.ArrayList;

import model.ProductDTO;

public interface ProductDAO {

	public abstract ArrayList<ProductDTO> getAllProducts();

	public abstract ProductDTO getOneProduct(int id);

	public abstract ProductDTO getProductByColor(String color);

	public abstract ProductDTO getProductByCategory(String category);

	public abstract ArrayList<ProductDTO> getProductsByPartName(String name);

	public abstract Boolean createNewProduct(ProductDTO b);

	public abstract Boolean updateProduct(ProductDTO b);

	public abstract Boolean deleteProduct(ProductDTO b);

	public abstract int getAutoPartNo();
	
	public abstract ArrayList<String> getCategoryList();
	
	public abstract ArrayList<String> getManufacturernName();
	
	public abstract ArrayList<String> getShelfLocation();

}