package it.contrader.view.team;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.TeamController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Team;
import it.contrader.view.View;

public class TeamDeleteView implements View {

	private TeamController teamController;
	private Request request;

	public TeamDeleteView() {
		this.teamController = new TeamController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		System.out.println("Select ID:");
		String teamId = getInput();

		if (teamId != null && StringUtils.isStrictlyNumeric(teamId)) {
			teamController.deleteTeam(Integer.parseInt(teamId));
			
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
		MainDispatcher.getInstance().callView("Team", null);
	}

}
