
package it.contrader.controller;

import java.util.List;

import it.contrader.dto.TrainingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.model.Training;
import it.contrader.service.UserService;
import it.contrader.service.TrainingService;


public class TrainingController implements Controller {

	private static String sub_package = "training.";
	private UserService usersService;
	private TrainingService trainingService;
	private Request request;

	public TrainingController() {
		this.trainingService = new TrainingService();
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
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "TrainingModify", null);
				break;
			case "D":
				MainDispatcher.getInstance().callView(sub_package + "TrainingDelete", null);
				break;
			case "A":
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
