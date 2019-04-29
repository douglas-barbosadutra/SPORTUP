package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterUser;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;
import it.contrader.model.Player;
import it.contrader.model.Team;

public class UserService {

	private UserDAO userDAO;

	public UserService() {
		this.userDAO = new UserDAO();
	}

	public List<User> getAllUser() {
		return this.userDAO.getAllUser();
	}
	
	public List<Player> getAllPlayerTraining() {
		return this.userDAO.getAllPlayerTraining();
	}
	
	public List<Player> getAllPlayerTeam(Team team) {
		return this.userDAO.getAllPlayerTeam(team);
	}

	public boolean insertUser(UserDTO userDTO) {
		return this.userDAO.insertUser(ConverterUser.toEntity(userDTO));
	}
	
	public UserDTO readUser(int userId) {
		return ConverterUser.toDTO(this.userDAO.readUser(userId));
	}
	
	public boolean updateUser(UserDTO userDTO) {
		return this.userDAO.updateUser(ConverterUser.toEntity(userDTO));
	}
	
	public boolean deleteUser(int userId) {
		return this.userDAO.deleteUser(userId);
	}
	
	public boolean setUserRights(int userId, String userType) {
		return this.userDAO.setUserRights(userId, userType);
	}
	
	public boolean addPlayerInfo(int userId, String player_info) {
		return this.userDAO.addPlayerInfo(userId, player_info);	
	}
	
	public Player getPlayerInfo(int userId) {
		return this.userDAO.getPlayerInfo(userId);	
	}
	
}
