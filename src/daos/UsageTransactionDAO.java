package daos;

import java.util.ArrayList;

import model.UsageTransactionDTO;

public interface UsageTransactionDAO {

	public abstract ArrayList<UsageTransactionDTO> getAllTransaction();

	public abstract boolean insertTransaction(UsageTransactionDTO Tr);
	
	public int getAutoTranId();

}