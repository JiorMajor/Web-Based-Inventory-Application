package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import daos.UsageTransactionDAO;
import model.UsageTransactionDTO;

public class UsageTransactionDAOImpl implements UsageTransactionDAO {
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
	 * @see dao.mysql.UsageTransactionDAO#getAllTransaction()
	 */
	@Override
	public ArrayList<UsageTransactionDTO> getAllTransaction()
	{
		openConnection();
		String sql = "SELECT * FROM sa40team06.usagetransaction";
		ArrayList<UsageTransactionDTO> TrList = null;
		try {
			rSet = statement.executeQuery(sql);
			TrList = new ArrayList<UsageTransactionDTO>();
			while (rSet.next())
			{
				Timestamp t = rSet.getTimestamp("OrderDate");
				Date d = null;
				if(t != null)
				{
					d = new Date(t.getTime());
				}
				UsageTransactionDTO UTr = new UsageTransactionDTO(rSet.getInt("UsTransactionId"), rSet.getInt("UserId"), rSet.getInt("CustomerId"), rSet.getString("VehicleId"),rSet.getInt("PartNo"),rSet.getInt("QtyUsed"), d);
				TrList.add(UTr);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		return TrList;
	}
	
	/* (non-Javadoc)
	 * @see dao.mysql.UsageTransactionDAO#insertTransaction(model.UsageTransactionDTO)
	 */
	@Override
	public boolean insertTransaction(UsageTransactionDTO Tr)
	{
		openConnection();
		java.sql.Date date = new java.sql.Date(Tr.getUsageDate().getTime());
		String sql = "INSERT INTO sa40team06.usagetransaction (UsTransactionId, UserId, CustomerId, VehicleId, PartNo, QtyUsed, UsageDate) VALUES ("+
				Tr.getUsageTransId()+
				", "+Tr.getUserId()
				+", "+Tr.getCustomerId()
				+", "+Tr.getVehicleId()
				+", "+Tr.getPartNo()
				+", "+Tr.getQtyused()
				+", "+ date
				+" );";

		try {
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		finally{
			closeConnection();
		}
		return true;
	}
	
	@Override
	public int getAutoTranId()
	{
		int id = 1;
		ArrayList<UsageTransactionDTO> trans = this.getAllTransaction();
		int i = trans.size();
		if(i > 1)
		{
			id = i + 1;
		}
		return id;
	}

}
