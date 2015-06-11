package dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import daos.ProductInventoryDAO;
import model.ProductInventoryDTO;

public class ProductInventoryDAOImpl implements ProductInventoryDAO {
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
	 * @see dao.mysql.ProductInventoryDAO#getAllProductInventory()
	 */
	@Override
	public ArrayList<ProductInventoryDTO> getAllProductInventory()
	{
		openConnection();
		String sql = "SELECT * FROM sa40team06.product_inventory ";
		ArrayList<ProductInventoryDTO> PList = null;
		try {
			rSet = statement.executeQuery(sql);
		    PList = new ArrayList<ProductInventoryDTO>();
			while (rSet.next())
			{
				ProductInventoryDTO custDto = new ProductInventoryDTO(rSet.getInt(1), rSet.getInt(2), rSet.getInt(3), rSet.getInt(4));
				PList.add(custDto);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
		return PList;
	}
	
	/* (non-Javadoc)
	 * @see dao.mysql.ProductInventoryDAO#insertProduct(model.ProductInventoryDTO)
	 */
	@Override
	public boolean insertProduct(ProductInventoryDTO product)
	{
		openConnection();
		String sql = "INSERT INTO sa40team06.product_inventory (PartNo, TotalQty, DamagedQty, AvailableQty) VALUES ("+
				product.getPartNo()+
				", "+product.getTotalQty()
				+", "+product.getDamagedQty()
				+", "+product.getAvailableQty()
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
	
	/* (non-Javadoc)
	 * @see dao.mysql.ProductInventoryDAO#deleteProduct(model.ProductInventoryDTO)
	 */
	@Override
	public boolean deleteProduct(ProductInventoryDTO product) {
		openConnection();
		String del = "DELETE FROM sa40team06.product_inventory WHERE PartNo="+product.getPartNo()+";";
		try {
			statement.execute(del);
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
	
	/* (non-Javadoc)
	 * @see dao.mysql.ProductInventoryDAO#updateStudent(model.ProductInventoryDTO)
	 */
	@Override
	public boolean updateInventory(ProductInventoryDTO product) {
		openConnection();
		String upd = "UPDATE sa40team06.product_inventory SET "
				+ "TotalQty="+product.getTotalQty()
				+ ", DamagedQty="+product.getDamagedQty()
				+ ", AvailableQty="+product.getAvailableQty()
				+ " WHERE PartNo="+product.getPartNo()+";";
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
	
	public boolean updateInventoryProduct(int partNo, int total, int damaged, int available){
		openConnection();
		String update = "UPDATE sa40team06.product_inventory SET TotalQty="+total+", DamagedQty="+damaged+", AvailableQty="+available+
				" WHERE PartNo="+partNo+";";
		try{
			statement.executeUpdate(update);
		}
		catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		finally{
			closeConnection();
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see dao.mysql.ProductInventoryDAO#getOneStatement(int)
	 */
	@Override
	public ProductInventoryDTO getOneProduct (int partNo)
	{
		openConnection();
		String sql = "SELECT * FROM sa40team06.product_inventory WHERE PartNo ="+partNo;
		ProductInventoryDTO p = null;
		try {
			rSet = statement.executeQuery(sql);
			while (rSet.next()) {
				p= new ProductInventoryDTO(rSet.getInt(1), rSet.getInt(2), rSet.getInt(3), rSet.getInt(4));	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			closeConnection();
		}
		return p;
	}	
}
