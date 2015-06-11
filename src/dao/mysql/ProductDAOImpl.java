package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import daos.ProductDAO;
import model.ProductDTO;

public class ProductDAOImpl implements ProductDAO {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet rs;

	public static void OpenConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sa40team06", "root",
					"");
			statement = connection.createStatement();

		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void CloseConnection() {
		try {
			statement.close();
			connection.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.ProductDAO#getAllProducts()
	 */
	@Override
	public ArrayList<ProductDTO> getAllProducts() {
		OpenConnection();
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		try {
			rs = statement.executeQuery("SELECT * FROM sa40team06.product");
			while (rs.next()) {
				ProductDTO c = new ProductDTO(rs.getInt("PartNo"),
						rs.getString("PartName"), rs.getDouble("UnitPrice"),
						rs.getString("Description"), rs.getString("Color"),
						rs.getString("Dimension"), rs.getString("Category"),
						rs.getString("ManufacturerName"),
						rs.getInt("ReorderLvl"), rs.getInt("MinReorderQty"),
						rs.getString("ShelfLocation"));
				result.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.ProductDAO#getOneProduct(int)
	 */
	@Override
	public ProductDTO getOneProduct(int id) {
		OpenConnection();
		ProductDTO c = null;
		try {
			rs = statement
					.executeQuery("SELECT * FROM sa40team06.product where PartNo ="
							+ id);
			while (rs.next()) {
				c = new ProductDTO(rs.getInt("PartNo"),
						rs.getString("PartName"), rs.getDouble("UnitPrice"),
						rs.getString("Description"), rs.getString("Color"),
						rs.getString("Dimension"), rs.getString("Category"),
						rs.getString("ManufacturerName"),
						rs.getInt("ReorderLvl"), rs.getInt("MinReorderQty"),
						rs.getString("ShelfLocation"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		return c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.ProductDAO#getProductByColor(java.lang.String)
	 */
	@Override
	public ProductDTO getProductByColor(String color) {
		OpenConnection();
		ProductDTO c = null;
		try {
			rs = statement
					.executeQuery("SELECT * FROM sa40team06.product where Color ="
							+ color);
			while (rs.next()) {
				c = new ProductDTO(rs.getInt("PartNo"),
						rs.getString("PartName"), rs.getDouble("UnitPrice"),
						rs.getString("Description"), rs.getString("Color"),
						rs.getString("Dimension"), rs.getString("Category"),
						rs.getString("ManufacturerName"),
						rs.getInt("ReorderLvl"), rs.getInt("MinReorderQty"),
						rs.getString("ShelfLocation"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		return c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.ProductDAO#getProductByCategory(java.lang.String)
	 */
	@Override
	public ProductDTO getProductByCategory(String category) {
		OpenConnection();
		ProductDTO c = null;
		try {
			rs = statement
					.executeQuery("SELECT * FROM sa40team06.product where Category ="
							+ category);
			while (rs.next()) {
				c = new ProductDTO(rs.getInt("PartNo"),
						rs.getString("PartName"), rs.getDouble("UnitPrice"),
						rs.getString("Description"), rs.getString("Color"),
						rs.getString("Dimension"), rs.getString("Category"),
						rs.getString("ManufacturerName"),
						rs.getInt("ReorderLvl"), rs.getInt("MinReorderQty"),
						rs.getString("ShelfLocation"));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		return c;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.ProductDAO#getProductsByPartName(java.lang.String)
	 */
	@Override
	public ArrayList<ProductDTO> getProductsByPartName(String name) {
		OpenConnection();
		ArrayList<ProductDTO> result = new ArrayList<ProductDTO>();
		try {
			rs = statement
					.executeQuery("SELECT * FROM sa40team06.product where PartName LIKE '"
							+ name + "%';");
			while (rs.next()) {
				ProductDTO c = new ProductDTO(rs.getInt("PartNo"),
						rs.getString("PartName"), rs.getDouble("UnitPrice"),
						rs.getString("Description"), rs.getString("Color"),
						rs.getString("Dimension"), rs.getString("Category"),
						rs.getString("ManufacturerName"),
						rs.getInt("ReorderLvl"), rs.getInt("MinReorderQty"),
						rs.getString("ShelfLocation"));
				result.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.ProductDAO#createNewProduct(model.ProductDTO)
	 */
	@Override
	public Boolean createNewProduct(ProductDTO b)
	{
		OpenConnection();
		
		try {
			statement.executeUpdate("INSERT INTO product VALUES(" +
					b.getPartNo() + 
					", '" + b.getPartName() +
					"', " + b.getUnitPrice() +
					", '" + b.getDescription() +
					"', '" + b.getColor() +
					"', '" + b.getDimension() +
					"', '" + b.getCategory() +
					"', '" + b.getManuName() +
					"', " + b.getReorderlvl() +
					", " + b.getMinOrderQty() +
					", '" + b.getShelfLocation() + "');");
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//return false;
		}
		finally{
			
			CloseConnection();
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.ProductDAO#updateProduct(model.ProductDTO)
	 */
	@Override
	public Boolean updateProduct(ProductDTO b) {
		OpenConnection();

		try {
			statement
					.executeUpdate("UPDATE sa40team06.product SET PartName = '"
							+ b.getPartName() + "', UnitPrice = "
							+ b.getUnitPrice() + ", Description = '"
							+ b.getDescription() + "', Color = '"
							+ b.getColor() + "', Dimension = '"
							+ b.getDimension() + "', Category = '"
							+ b.getCategory() + "', ManufacturerName = '"
							+ b.getManuName() + "', ReorderLvl = "
							+ b.getReorderlvl() + ", MinReorderQty = "
							+ b.getMinOrderQty() + ", ShelfLocation = '"
							+ b.getShelfLocation() + "' WHERE PartNo = "
							+ b.getPartNo() + ";");

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {

			CloseConnection();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.ProductDAO#deleteProduct(model.ProductDTO)
	 */
	@Override
	public Boolean deleteProduct(ProductDTO b) {
		OpenConnection();

		try {
			statement
					.executeUpdate("DELETE FROM sa40team06.product WHERE PartName ="+"'"+ b.getPartName()+"'" + ";");

			return true;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		} finally {

			CloseConnection();
		}
	}

	@Override
	public int getAutoPartNo() {
		int id = 1;
		ArrayList<ProductDTO> trans = this.getAllProducts();
		int i = trans.size();
		if (i > 1) {
			id = i + 1;
		}
		return id;
	}
	
	public ArrayList<String> getCategoryList(){
		OpenConnection();
		ArrayList<String> catlist = new ArrayList<String>();
		try {
			rs = statement.executeQuery("SELECT DISTINCT Category from sa40team06.product");
			while (rs.next()) {
				String s = rs.getString("Category");
				catlist.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		return catlist;
	}
	
	public ArrayList<String> getManufacturernName(){
		OpenConnection();
		ArrayList<String> manufacturerlist=new ArrayList<String>();
		try {
			rs = statement.executeQuery("SELECT DISTINCT ManufacturerName from sa40team06.product");
			while (rs.next()) {
				String s = rs.getString("ManufacturerName");
				manufacturerlist.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		return manufacturerlist;
		
	}
	
	public ArrayList<String> getShelfLocation(){
		OpenConnection();
		ArrayList<String> shelflocation=new ArrayList<String>();
		try {
			rs = statement.executeQuery("SELECT DISTINCT ShelfLocation from sa40team06.product");
			while (rs.next()) {
				String s = rs.getString("ShelfLocation");
				shelflocation.add(s);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		return shelflocation;
		
	}

}
