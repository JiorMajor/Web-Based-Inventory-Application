package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.ManufacturerDTO;
import daos.ManufacturerDAO;

public class ManufacturerDAOImpl implements ManufacturerDAO {

	private static Connection connection;
	private static Statement statement;
	private static ResultSet rs;
	
	public static void OpenConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/sa40team06", "root", "");
			statement = connection.createStatement();
			
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void CloseConnection()
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
	 * @see dao.mysql.ManufacturerDAO#getAllManufacturers()
	 */
	@Override
	public ArrayList<ManufacturerDTO> getAllManufacturers()
	{
		OpenConnection();
		ArrayList<ManufacturerDTO> result = new ArrayList<ManufacturerDTO>();
		try {
			rs = statement.executeQuery("SELECT * FROM sa40team06.manufacturer");
			while(rs.next())
			{
				ManufacturerDTO c = new ManufacturerDTO(rs.getString("ManufacturerName"), rs.getString("Address"),
						rs.getInt("PhoneNo"), rs.getString("ContactPerson"));
				result.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CloseConnection();
		}
		return result;
	}
	
	/* (non-Javadoc)
	 * @see dao.mysql.ManufacturerDAO#getOneManufacturer(java.lang.String)
	 */
	@Override
	public ManufacturerDTO getOneManufacturer(String name)
	{
		OpenConnection();
		ManufacturerDTO c = null;
		try {
			rs = statement.executeQuery("SELECT * FROM sa40team06.manufacturer where ManufacturerName =" + name);
			while(rs.next())
			{
				c = new ManufacturerDTO(rs.getString("ManufacturerName"), rs.getString("Address"),
						rs.getInt("PhoneNo"), rs.getString("ContactPerson"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			CloseConnection();
		}
		return c;
	}
}
