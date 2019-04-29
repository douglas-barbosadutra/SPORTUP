package it.contrader.view.team;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Team;
import it.contrader.model.Player;
import it.contrader.view.View;

public class TeamInspectView implements View {

	private UserController userController;
	private Request request;

	public TeamInspectView() {
		this.userController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		System.out.println("Select ID of the team you want to inspect:");
		String teamId = getInput();
		
		if (teamId != null && StringUtils.isStrictlyNumeric(teamId)) {
			Team team = new Team();
			team.setTeamId(Integer.parseInt(teamId));
					
			System.out.println("ID\tUsername\tRole");
			System.out.print("---------------------------------------------------");
			List<Player> players = userController.getAllPlayerTeam(team);
			System.out.println();
			players.forEach(player -> System.out.println(player.toStringTeam()));
			System.out.println();
			
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