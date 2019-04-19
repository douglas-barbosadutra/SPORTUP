package it.contrader.view.training;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.TrainingController;
import it.contrader.dto.TrainingDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class TrainingUpdateView implements View {

	private TrainingController trainingsController;
	private Request request;

	public TrainingUpdateView() {
		this.trainingsController = new TrainingController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int trainingIdToUpdate;
		String info;

		/*
		 * List<User> users; Integer usersId; String password; users =
		 * usersController.getAllUsers();
		 */
		System.out.println("\n----- Seleziona l'allenamento da modificate  -----\n");
		// System.out.println();
		// users.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		TrainingDTO trainingDTO = new TrainingDTO();

		System.out.println("Digita l'Id del training da modificare:");
		try {
			trainingIdToUpdate = Integer.parseInt(getInput());
			if (trainingIdToUpdate != 0) {
				trainingDTO.setTrainingId(trainingIdToUpdate);

				System.out.println("Digita la nuova info");
				info = getInput();
				if (!info.equals(""))
					trainingDTO.setInfo(info);

				trainingsController.updateTraining(trainingDTO);

			}
		} catch (Exception e) {
			System.out.println("Hai inserito un valore errato");
		}

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Training", "doControl", request);
	}

}
