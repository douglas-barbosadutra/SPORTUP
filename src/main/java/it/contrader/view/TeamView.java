package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.TeamController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Team;

public class TeamView implements View {

	private TeamController teamController;
	private Request request;
	private String choice;
	
	public TeamView() {
		this.teamController = new TeamController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Team Menu -------\n");
		
		System.out.println("ID\tInfo");
		System.out.print("------------------------------------------------------");
		List<Team> teams = teamController.getAllTeam();
		System.out.println();
		teams.forEach(team -> System.out.println(team.toString()));
		System.out.println();
		
		System.out.println("Select operation:");
		System.out.println("[C]reate [A]ssign [D]elete [I]nspect [B]ack [E]xit");
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
		    MainDispatcher.getInstance().callAction("Team", "doControl", this.request);
	}

}
