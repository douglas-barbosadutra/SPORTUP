package it.contrader.view.team;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.TeamController;
import it.contrader.dto.TeamDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class TeamAssignView implements View {

	private TeamController teamController;
	private Request request;

	public TeamAssignView() {
		this.teamController = new TeamController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int id_player, id_team;
		Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("Assign Team:");
		System.out.println("Insert player ID: ");
		id_player = scanner.nextInt();
		System.out.println("Insert team ID");
		id_team=scanner.nextInt();
		if (id_player!=0 && id_team!=0) {
			teamController.assignTeam(new TeamDTO(id_team, id_player));
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
		MainDispatcher.getInstance().callView("Team", null);
	}

}
