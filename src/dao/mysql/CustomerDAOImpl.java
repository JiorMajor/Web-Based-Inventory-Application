package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import daos.CustomerDAO;
import model.CustomerDTO;

public class CustomerDAOImpl implements CustomerDAO {
	
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
	 * @see dao.mysql.CustomerDAO#getAllCustomers()
	 */
	@Override
	public ArrayList<CustomerDTO> getAllCustomers()
	{
		OpenConnection();
		ArrayList<CustomerDTO> result = new ArrayList<CustomerDTO>();
		try {
			rs = statement.executeQuery("SELECT * FROM sa40team06.customer");
			while(rs.next())
			{
				CustomerDTO c = new CustomerDTO(rs.getInt("CustomerID"), rs.getString("CustomerName"),
						rs.getString("Address"), rs.getInt("PhoneNo"));
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
	 * @see dao.mysql.CustomerDAO#getOneCustomer(int)
	 */
	@Override
	public CustomerDTO getOneCustomer(int id)
	{
		OpenConnection();
		CustomerDTO c = null;
		try {
			rs = statement.executeQuery("SELECT * FROM sa40team06.customer where CustomerID =" + id);
			while(rs.next())
			{
				c = new CustomerDTO(rs.getInt("CustomerID"), rs.getString("CustomerName"),
						rs.getString("Address"), rs.getInt("PhoneNo"));
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
