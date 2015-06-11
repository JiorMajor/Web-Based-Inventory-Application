package daos;

import java.util.ArrayList;

import model.OrderTransactionDTO;

public interface OrderTransactionDAO {

	public abstract ArrayList<OrderTransactionDTO> getAllTransactions();

	public abstract Boolean createNewOrder(OrderTransactionDTO b);
	
	public abstract int getAutoOrTransID();

}