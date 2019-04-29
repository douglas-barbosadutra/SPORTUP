package it.contrader.controller;

import java.util.List;

import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.model.Team;
import it.contrader.service.UserService;
import it.contrader.model.Player;

public class UserController implements Controller {

	private static String sub_package = "user.";
	private UserService usersService;
	private Request request;

	public UserController() {
		this.usersService = new UserService();
	}

	public List<User> getAllUser() {
		return this.usersService.getAllUser();
	}
	
	public List<Player> getAllPlayerTraining() {
		return this.usersService.getAllPlayerTraining();
	}
	
	public List<Player> getAllPlayerTeam(Team team) {
		return this.usersService.getAllPlayerTeam(team);
	}

	public UserDTO readUser(int userId) {
		return this.usersService.readUser(userId);
	}

	public boolean insertUser(UserDTO usersDTO) {
		return this.usersService.insertUser(usersDTO);
	}

	public boolean updateUser(UserDTO usersDTO) {
		return this.usersService.updateUser(usersDTO);
	}

	public boolean deleteUser(Integer usersId) {
		return this.usersService.deleteUser(usersId);
	}
	
	public boolean setUserRights(Integer usersId, String userType) {
		return this.usersService.setUserRights(usersId, userType);
	}
	
	public boolean addPlayerInfo(int userId, String player_info) {
		return this.usersService.addPlayerInfo(userId, player_info);	
	}
	
	public Player getPlayerInfo(int userId) {
		return this.usersService.getPlayerInfo(userId);	
	}
	
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("User", null);
		} else {
			switch (choice.toUpperCase()) {
			case "S":
				MainDispatcher.getInstance().callView(sub_package + "UserRights", null);
				break;
			case "D":
				MainDispatcher.getInstance().callView(sub_package + "UserDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
