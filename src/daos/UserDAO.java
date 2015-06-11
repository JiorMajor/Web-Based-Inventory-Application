package daos;

import java.util.ArrayList;

import model.UserDTO;

public interface UserDAO {

	public abstract ArrayList<UserDTO> getAllUsers();

	public abstract UserDTO getEmailPW(String name, String password);

	public abstract boolean updateUser(UserDTO user);

}