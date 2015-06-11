package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import daos.ProductStockDAO;
import model.ProductStockDTO;

public class ProductStockDAOImpl implements ProductStockDAO {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet rs;

	public static void OpenConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sa40team06", "root", "");
			statement = connection.createStatement();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static void CloseConnection() {
		try {
			statement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dao.mysql.ProductStockDAO#getAllProductList()
	 */
	@Override
	public ArrayList<ProductStockDTO> getAllProductList() {
		OpenConnection();
		ArrayList<ProductStockDTO> result = new ArrayList<ProductStockDTO>();
		try {
			rs = statement
					.executeQuery("SELECT p.PartNo, p.PartName, p.UnitPrice, p.Category, p.ReorderLvl, p.MinReorderQty, p.Dimension, p.Color, p.ShelfLocation, pi.TotalQty, pi.DamagedQty, pi.AvailableQty FROM sa40team06.product p , sa40team06.product_inventory pi WHERE p.PartNo = pi.PartNo");
			while (rs.next()) {
				ProductStockDTO ps = new ProductStockDTO(rs.getInt("PartNo"),
						rs.getString("PartName"), rs.getDouble("UnitPrice"),
						rs.getString("Category"), rs.getInt("ReorderLvl"),
						rs.getInt("MinReorderQty"), rs.getString("Dimension"),rs.getString("Color"),
						rs.getString("ShelfLocation"), rs.getInt("TotalQty"),
						rs.getInt("DamagedQty"), rs.getInt("AvailableQty"));
				result.add(ps);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//CloseConnection();
		}
		return result;
	}
	
	public ArrayList<ProductStockDTO> getbyCategory(String cat){
		OpenConnection();
		ArrayList<ProductStockDTO> result = new ArrayList<ProductStockDTO>();
		try {
			rs = statement
					.executeQuery("SELECT p.PartNo, p.PartName, p.UnitPrice, p.Category, p.ReorderLvl, p.MinReorderQty, p.Dimension, p.Color, p.ShelfLocation, pi.TotalQty, pi.DamagedQty, pi.AvailableQty FROM sa40team06.product p , sa40team06.product_inventory pi WHERE p.PartNo = pi.PartNo AND p.Category="+"'"+cat+"';");
			while (rs.next()) {
				ProductStockDTO ps = new ProductStockDTO(rs.getInt("PartNo"),
						rs.getString("PartName"), rs.getDouble("UnitPrice"),
						rs.getString("Category"), rs.getInt("ReorderLvl"),
						rs.getInt("MinReorderQty"), rs.getString("Dimension"),rs.getString("Color"),
						rs.getString("ShelfLocation"), rs.getInt("TotalQty"),
						rs.getInt("DamagedQty"), rs.getInt("AvailableQty"));
				result.add(ps);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			CloseConnection();
		}
		return result;
	}
}
