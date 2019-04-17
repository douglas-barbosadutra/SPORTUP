package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class RegisterView implements View {

	private int id_user;
	private String nomeUtente;
	private String password;

	Scanner scanner = new Scanner(System.in);
	
	public void showResults(Request request) {
		
	}

	public void showOptions() {
		System.out.println("----- .:REGISTER:. ----");
		System.out.println("Nome utente:");
		nomeUtente = getInput();
		System.out.println("Password:");
		password = getInput();
		System.out.println("ID:");
		id_user = scanner.nextInt();
	}

	public void submit() {
		Request request = new Request();
		request.put("id", id_user);
		request.put("username", nomeUtente);
		request.put("password", password);
		request.put("mode", "register");
		MainDispatcher.getInstance().callAction("Home", "doControl", request);
	}

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	protected void send() {
	}

}
