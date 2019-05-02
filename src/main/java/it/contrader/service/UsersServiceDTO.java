package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.converter.ConverterUser;
import it.contrader.dao.LoginDAO;
import it.contrader.dao.RegisterDAO;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.utils.Request;

/**
 * Classe che si occupa di interfacciarsi con la persistenza e recuperare
 * attraverso i metodi del Data Access Object le tuple desiderate, Le converte
 * in un oggetto DTO e le restituisce al controller opportuno
 */
public class UsersServiceDTO {

	private final UserDAO usersDAO;
	private final LoginDAO loginDAO;
	private final RegisterDAO registerDAO;

	public UsersServiceDTO() {
		this.usersDAO = new UserDAO();
		this.loginDAO = new LoginDAO();
		this.registerDAO = new RegisterDAO();
	}

	/**
	 * Come vediamo la lista recuperata è di tipo Esempio ma noi la convertiamo in EsempioDTO
	 * Invito chi fa i converter a fare un metodo per convertire direttamente la lista senza farli uno ad uno perchè è sporco e poco efficiente
	 */
	public List<UserDTO> getAllUsers() {

		List<User> list = usersDAO.getAllUser();
		List<UserDTO> listDTO = new ArrayList<>();

		for (User users : list) {
			listDTO.add(ConverterUser.toDTO(users));
		}

		return listDTO;
	}
	
	public Request login (String username, String password) {
		return this.loginDAO.login(username, password);
	}
	
	public String register (String username, String password) {
		return this.registerDAO.register(username, password);
	}
	
	public boolean delete (int id_user) {
		return this.usersDAO.deleteUser(id_user);
	}
	
	public List<User> getAllUser() {
		return this.usersDAO.getAllUser();
	}
	
	public boolean setUserRights(int userId, String userType) {
		return this.usersDAO.setUserRights(userId, userType);
	}
	
	/*public UserDTO getUserByUsernameAndPasword(String username, String password) {
		return ConverterUser.toDTO(usersDAO.login(username, password));
	}

	public boolean updateUsers (UsersDTO usersDTO) {
		return this.usersDAO.updateUsers(UsersConverter.toEntity(usersDTO));
		
}
	
	public boolean deleteUsers (UsersDTO usersDTO) {
		return this.usersDAO.deleteUsers(UsersConverter.toEntity(usersDTO));
		
}
	
	public boolean insertUsers (UsersDTO usersDTO) {
		return this.usersDAO.insertUsers(UsersConverter.toEntity(usersDTO));
	
}
	*/
	
	
	
}