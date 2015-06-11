package dao.mysql;

import java.sql.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import model.OrderTransactionDTO;
import daos.OrderTransactionDAO;
import java.util.Date;

public class OrderTransactionDAOImpl implements OrderTransactionDAO {

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
	 * @see dao.mysql.OrderTransactionDAO#getAllTransactions()
	 */
	@Override
	public ArrayList<OrderTransactionDTO> getAllTransactions()
	{
		OpenConnection();
		ArrayList<OrderTransactionDTO> result = new ArrayList<OrderTransactionDTO>();
		try {	
			rs = statement.executeQuery("SELECT * FROM sa40team06.ordertransaction");
			while(rs.next())
			{
				Timestamp t = rs.getTimestamp("OrderDate");
				Date d = null;
				if(t != null)
				{
					d = new Date(t.getTime());
				}
				OrderTransactionDTO c = new OrderTransactionDTO(rs.getInt("OrTransactionId"), rs.getInt("PartNo"), rs.getInt("OrderQty"),
						rs.getString("ManufacturerName"), d, rs.getInt("UserId"), rs.getDouble("OrderPrice"), rs.getString("Status"));
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
	 * @see dao.mysql.OrderTransactionDAO#createNewOrder(model.OrderTransactionDTO)
	 */
	@Override
	public Boolean createNewOrder(OrderTransactionDTO b)
	{
		OpenConnection();
		
		try {
			java.sql.Date date = new java.sql.Date(b.getOrderDate().getTime());
			
			statement.executeUpdate("INSERT INTO sa40team06.ordertransaction(OrTransactionId, PartNo, OrderQty, "
					+ "ManufacturerName, OrderDate, UserId, OrderPrice, Status) VALUES(" +
					b.getOrTransId() + 
					", " + b.getPartNo() +
					", " + b.getOrderQty() +
					", \"" + b.getManuName() +
					", " + date +
					"\", " + b.getUserId() + 
					", " + b.getOrderPrice() +
					", \"" + b.getOrderStatus() + "\");");
			
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
			
			CloseConnection();
		}
	}
	
	@Override
	public int getAutoOrTransID()
	{
		int id = 1;
		ArrayList<OrderTransactionDTO> trans = this.getAllTransactions();
		int i = trans.size();
		if(i > 1)
		{
			id = i + 1;
		}
		return id;
	}
	
}
