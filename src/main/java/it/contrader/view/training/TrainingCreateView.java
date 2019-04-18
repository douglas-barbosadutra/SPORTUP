package it.contrader.view.training;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.TrainingController;
import it.contrader.dto.TrainingDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class TrainingCreateView implements View {

	private TrainingController trainingController;
	private Request request;

	public TrainingCreateView() {
		this.trainingController = new TrainingController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String info;

		System.out.println("Insert training info:");
		info = getInput();
		if (!info.equals("")) {
			trainingController.createTraining(new TrainingDTO(info));
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
