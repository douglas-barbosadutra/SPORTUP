package it.contrader.view.training;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.controller.TrainingController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.view.View;

public class TrainingDeleteView implements View {

	private UserController userController;
	private TrainingController trainingController;
	private Request request;

	public TrainingDeleteView() {
		this.trainingController = new TrainingController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		System.out.println("Select ID:");
		String trainingId = getInput();

		if (trainingId != null && StringUtils.isStrictlyNumeric(trainingId)) {
			trainingController.deleteTraining(Integer.parseInt(trainingId));
			
		} else {
			System.out.println("Wrong Value!");
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callView("Training", null);
	}

}
