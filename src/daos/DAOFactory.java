package daos;

import dao.mysql.CustomerDAOImpl;
import dao.mysql.ManufacturerDAOImpl;
import dao.mysql.OrderTransactionDAOImpl;
import dao.mysql.ProductDAOImpl;
import dao.mysql.ProductInventoryDAOImpl;
import dao.mysql.ProductStockDAOImpl;
import dao.mysql.UsageTransactionDAOImpl;
import dao.mysql.UserDAOImpl;
import dao.mysql.VehicleDAOImpl;

public class DAOFactory {

	public static CustomerDAO getCustomerDAO()
	{
		CustomerDAO dao = new CustomerDAOImpl();
		return dao;
	}
	
	public static ManufacturerDAO getManufacturerDAO()
	{
		ManufacturerDAO dao = new ManufacturerDAOImpl();
		return dao;
	}
	
	public static OrderTransactionDAO getOrderTransactionDAO()
	{
		OrderTransactionDAO dao = new OrderTransactionDAOImpl();
		return dao;
	}
	
	public static ProductDAO getProductDAO()
	{
		ProductDAO dao = new ProductDAOImpl();
		return dao;
	}
	
	public static ProductInventoryDAO getProductInventoryDAO()
	{
		ProductInventoryDAO dao = new ProductInventoryDAOImpl();
		return dao;
	}
	
	public static UsageTransactionDAO getUsageTransactionDAO()
	{
		UsageTransactionDAO dao = new UsageTransactionDAOImpl();
		return dao;
	}
	
	public static UserDAO getUserDAO()
	{
		UserDAO dao = new UserDAOImpl();
		return dao;
	}
	
	public static VehicleDAO getVehicleDAO()
	{
		VehicleDAO dao = new VehicleDAOImpl();
		return dao;
	}
	
	public static ProductStockDAO getProductStockDAO(){
		ProductStockDAO  dao= new ProductStockDAOImpl();
		return dao;
	}
	
}
