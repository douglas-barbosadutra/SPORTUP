/**
 * Manage a Business Owner view
 */

package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeTrainerView implements View {

    private String choice;

    public void showResults(Request request) {
    	System.out.println("Welcome in SPORTUP "+request.get("nomeUtente").toString());
    }


    public void showOptions() {
        System.out.println("-------MENU-------\n");
        System.out.println("Select what you want to manage:");
        System.out.println("[T]rainings [E]xit");
        this.choice = this.getInput();
    }

    public void submit() {
        if (choice.equalsIgnoreCase("T")) {
        	MainDispatcher.getInstance().callView("Training", null);
        }
        
        if (choice.equalsIgnoreCase("E"))
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        else {
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
