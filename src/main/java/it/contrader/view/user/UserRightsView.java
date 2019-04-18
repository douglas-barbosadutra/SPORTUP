package it.contrader.view.user;

import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.view.View;

public class UserRightsView implements View {

	private UserController userController;
	private Request request;

	public UserRightsView() {
		this.userController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		System.out.println("Insert ID:");
		String usersId = getInput();
		System.out.println("Select user type");
		System.out.println("[P]layer [T]rainer");
		String userType = getInput();
		if (usersId != null && StringUtils.isStrictlyNumeric(usersId)) {
			userController.setUserRights(Integer.parseInt(usersId), userType);
			
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

