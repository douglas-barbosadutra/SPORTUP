package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.controller.TrainingController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.model.Training;

public class TrainingView implements View {

	private TrainingController trainingController;
	private Request request;
	private String choice;
	
	public TrainingView() {
		this.trainingController = new TrainingController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Trainings Menu -------\n");
		
		System.out.println("ID\tType");
		System.out.print("------------------------------------------------------");
		List<Training> trainings = trainingController.getAllTraining();
		System.out.println();
		trainings.forEach(training -> System.out.println(training.toString()));
		System.out.println();
		
		System.out.println("Select operation:");
		System.out.println("[C]reate [U]pdate"
				+ " [D]elete [A]ssign [B]ack [E]xit");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    MainDispatcher.getInstance().callAction("Training", "doControl", this.request);
	}

}
