
package it.contrader.controller;

import java.util.List;

import it.contrader.dto.TrainingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.model.Player;
import it.contrader.model.Training;
import it.contrader.service.UserService;
import it.contrader.service.TrainingService;


public class TrainingController implements Controller {

	private static String sub_package = "training.";
	private UserService usersService;
	private TrainingService trainingService;
	private Request request;
	private UserController userController;

	public TrainingController() {
		this.trainingService = new TrainingService();
		this.userController = new UserController();
	}

	public List<Training> getAllTraining() {
		return this.trainingService.getAllTraining();
	}

	public UserDTO readUser(int userId) {
		return this.usersService.readUser(userId);
	}

	public boolean createTraining(TrainingDTO trainingsDTO) {
		return this.trainingService.createTraining(trainingsDTO);
	}

	public boolean updateUser(UserDTO usersDTO) {
		return this.usersService.updateUser(usersDTO);
	}

	public boolean deleteTraining(Integer trainingId) {
		return this.trainingService.deleteTraining(trainingId);
	}
	
	public boolean setUserRights(Integer usersId, String userType) {
		return this.usersService.setUserRights(usersId, userType);
	}

	public boolean updateTraining(TrainingDTO trainingsDTO) {
		return this.trainingService.updateTraining(trainingsDTO);
	}
	
	public boolean assignTraining(TrainingDTO trainingsDTO) {
		return this.trainingService.assignTraining(trainingsDTO);
	}
	
	public Request getPlayerTraining(Request request) {
		return this.trainingService.getPlayerTraining(request);
	}
	
	
	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		
		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Training", null);
		} else {
			switch (choice.toUpperCase()) {
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "TrainingCreate", null);
				break;
			case "U":
				MainDispatcher.getInstance().callView(sub_package + "TrainingUpdate", null);
				break;
			case "D":
				MainDispatcher.getInstance().callView(sub_package + "TrainingDelete", null);
				break;
			case "A":
				System.out.println("ID\tUsername\tRole\tID Training\tTraining Type\tInfo");
				System.out.print("----------------------------------------------------------------------");
				List<Player> players = userController.getAllPlayerTraining();
				System.out.println();
				players.forEach(player -> System.out.println(player.toStringTraining()));
				System.out.println();
				MainDispatcher.getInstance().callView(sub_package + "TrainingAssign", null);
				break;
			case "B":
				request.put("nomeUtente", "trainer");
				MainDispatcher.getInstance().callView("HomeTrainer", request);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Trainer", null);
				break;
			}
		}
	}

}
