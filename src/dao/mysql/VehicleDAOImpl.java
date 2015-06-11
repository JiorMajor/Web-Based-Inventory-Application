package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import daos.VehicleDAO;
import model.VehicleDTO;

public class VehicleDAOImpl implements VehicleDAO {
	private static Connection connection;
	private static Statement statement;
	private static ResultSet rSet;
	
	public static void openConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/sa40team06","root","");
			statement = connection.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void closeConnection()
	{
		try {
			statement.close();
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/* (non-Javadoc)
	 * @see dao.mysql.VehicleDAO#getAllVehicles()
	 */
	@Override
	public ArrayList<VehicleDTO> getAllVehicles()
	{
		openConnection();
		String sql = "SELECT * FROM sa40team06.vehicle ";
		ArrayList<VehicleDTO> VehicleList = null;
		try {
			rSet = statement.executeQuery(sql);
			VehicleList = new ArrayList<VehicleDTO>();
			while (rSet.next())
			{
				VehicleDTO vehicleDto = new VehicleDTO(rSet.getString(1), rSet.getInt(2), rSet.getString(3),rSet.getString(4));
				VehicleList.add(vehicleDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
		return VehicleList;
	}
	
	/* (non-Javadoc)
	 * @see dao.mysql.VehicleDAO#getOneVehicle(java.lang.String)
	 */
	@Override
	public VehicleDTO getOneVehicle(String id)
	{
		openConnection();
		String sql = "SELECT * FROM sa40team06.vehicle WHERE VehicleID = " + id + ";";
		VehicleDTO vehicleDto  = null;
		try {
			rSet = statement.executeQuery(sql);
			while (rSet.next())
			{
				vehicleDto = new VehicleDTO(rSet.getString(1), rSet.getInt(2), rSet.getString(3),rSet.getString(4));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
		return vehicleDto;
	}

}




