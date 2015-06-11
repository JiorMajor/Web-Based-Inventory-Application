package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import daos.UserDAO;
import model.UserDTO;

public class UserDAOImpl implements UserDAO {
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
	 * @see dao.mysql.UserDAO#getAllUsers()
	 */
	@Override
	public ArrayList<UserDTO> getAllUsers()
	{
		openConnection();
		String sql = "SELECT * FROM sa40team06.user ";
		ArrayList<UserDTO> userList = null;
		try {
			rSet = statement.executeQuery(sql);
			userList = new ArrayList<UserDTO>();
			while (rSet.next())
			{
				UserDTO userDto = new UserDTO(rSet.getInt(1),rSet.getString(2),rSet.getString(3),rSet.getString(4),rSet.getString(5),rSet.getString(6));
				userList.add(userDto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
		return userList;
	}
	
	/* (non-Javadoc)
	 * @see dao.mysql.UserDAO#getEmailPW(java.lang.String, java.lang.String)
	 */
	@Override
	public UserDTO getEmailPW(String name, String password)
	{
		openConnection();
		UserDTO u = null;
		String sql = "select * from sa40team06.user where UserName =" +name+" && Password ="+password;
		try {
			rSet = statement.executeQuery(sql);
			while (rSet.next()) 
			{
				u = new UserDTO(rSet.getInt(1), rSet.getString(2), rSet.getString(3), rSet.getString(4), rSet.getString(5), rSet.getString(6));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
		return u;
	}
	
	/* (non-Javadoc)
	 * @see dao.mysql.UserDAO#updateUser(model.UserDTO)
	 */
	@Override
	public boolean updateUser(UserDTO user) {
		openConnection();
		String upd = "UPDATE sa40team06.user SET "
				+ "UserName="+user.getUserName()
				+ ", Address="+user.getAddress()
				+ ", PhoneNo="+user.getPhoneNo()
				+ ", Password="+user.getPassword()
				+ ", UserType="+user.getUserType()
				+ " WHERE UserId =" + user.getUserId() + ";";
		try {
			statement.executeUpdate(upd);
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
}


