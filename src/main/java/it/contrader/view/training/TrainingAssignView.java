package it.contrader.view.training;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.TrainingController;
import it.contrader.dto.TrainingDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class TrainingAssignView implements View {

	private TrainingController trainingsController;
	private Request request;

	public TrainingAssignView() {
		this.trainingsController = new TrainingController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int id_player, id_training;
		Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("Assegna training:");
		System.out.println("Digita l'id player: ");
		id_player = scanner.nextInt();
		System.out.println("Digita l'id_training");
		id_training=scanner.nextInt();
		if (id_player!=0 && id_training!=0) {
			trainingsController.assignTraining(new TrainingDTO(id_player, id_training));
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
