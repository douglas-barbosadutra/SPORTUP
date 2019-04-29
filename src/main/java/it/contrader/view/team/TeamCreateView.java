package it.contrader.view.team;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.TeamController;
import it.contrader.dto.TeamDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class TeamCreateView implements View {

	private TeamController teamController;
	private Request request;

	public TeamCreateView() {
		this.teamController = new TeamController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String info;

		System.out.println("Insert team info:");
		info = getInput();
		if (!info.equals("")) {
			teamController.createTeam(new TeamDTO(info));
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
		MainDispatcher.getInstance().callAction("Team", "doControl", request);
	}

}
