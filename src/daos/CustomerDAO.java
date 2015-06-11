package daos;

import java.util.ArrayList;

import model.CustomerDTO;

public interface CustomerDAO {

	public abstract ArrayList<CustomerDTO> getAllCustomers();

	public abstract CustomerDTO getOneCustomer(int id);

}