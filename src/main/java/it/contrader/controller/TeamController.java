
package it.contrader.controller;

import java.util.List;

import it.contrader.dto.TrainingDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.model.Player;
import it.contrader.model.Training;
import it.contrader.model.Team;
import it.contrader.service.UserService;
import it.contrader.service.TrainingService;
import it.contrader.service.TeamService;



public class TeamController implements Controller {

	private static String sub_package = "team.";
	private UserService usersService;
	private TrainingService trainingService;
	private TeamService teamService;
	private Request request;
	private UserController userController;

	public TeamController() {
		this.trainingService = new TrainingService();
		this.teamService = new TeamService();
		this.userController = new UserController();
	}

	public List<Team> getAllTeam() {
		return this.teamService.getAllTeam();
	}

	public UserDTO readUser(int userId) {
		return this.usersService.readUser(userId);
	}

	public boolean createTeam(TeamDTO teamDTO) {
		return this.teamService.createTeam(teamDTO);
	}

	public boolean updateUser(UserDTO usersDTO) {
		return this.usersService.updateUser(usersDTO);
	}

	public boolean deleteTeam(Integer teamId) {
		return this.teamService.deleteTeam(teamId);
	}
	
	public boolean updateTraining(TrainingDTO trainingsDTO) {
		return this.trainingService.updateTraining(trainingsDTO);
	}
	
	public boolean assignTeam(TeamDTO teamDTO) {
		return this.teamService.assignTeam(teamDTO);
	}
	
	
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		List<Player> players;
		
		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Team", null);
		} else {
			switch (choice.toUpperCase()) {
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "TeamCreate", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "TeamInspect", null);
				break;
			case "D":
				MainDispatcher.getInstance().callView(sub_package + "TeamDelete", null);
				break;
			case "A":
				System.out.println("ID\tUsername\tRole\tID Training\tTraining Type\tInfo");
				System.out.print("----------------------------------------------------------------------");
				players = userController.getAllPlayerTraining();
				System.out.println();
				players.forEach(player -> System.out.println(player.toStringTraining()));
				System.out.println();
				MainDispatcher.getInstance().callView(sub_package + "TeamAssign", null);
				break;
			case "B":
				request.put("nomeUtente", "trainer");
				MainDispatcher.getInstance().callView("HomeTrainer", request);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Team", null);
				break;
			}
		}
	}

}
