package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class MenuView implements View {

	private String choice;

	public void showResults(Request request) {
		
	}

	public void showOptions() {
		System.out.println("-------MENU-------\n");
        System.out.println("Seleziona scelta:");
        System.out.println("[L]ogin [S]ign Up");
        this.choice = this.getInput();
	}

	public void submit() {
        if (choice.equalsIgnoreCase("L") || choice.equalsIgnoreCase("l")) {
        	MainDispatcher.getInstance().callAction("Login", "doControl", null);
        }
        
        if (choice.equalsIgnoreCase("S") || choice.equalsIgnoreCase("s"))
            MainDispatcher.getInstance().callAction("Register", "doControl", null);
        else {
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callView("Menu", request);
        }
    }

	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	protected void send() {
	}

}
