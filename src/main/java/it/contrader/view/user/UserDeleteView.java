package it.contrader.view.user;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.view.View;

public class UserDeleteView implements View {

	private UserController userController;
	private Request request;

	public UserDeleteView() {
		this.userController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		System.out.println("Digita l'ID:");
		String usersId = getInput();

		if (usersId != null && StringUtils.isStrictlyNumeric(usersId)) {
			boolean r = userController.deleteUser(Integer.parseInt(usersId));
			if(!r) System.out.println("ERROR: delete failed!");  
			
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
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
