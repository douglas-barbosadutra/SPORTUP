/**
 * Manage a Business Owner view
 */

package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;

public class HomeAdminView implements View {

    private String choice;
    Request request;

    public void showResults(Request request) {
    	System.out.println("Welcome in SPORTUP "+request.get("nomeUtente").toString());
    }


    public void showOptions() {
        System.out.println("-------MENU-------\n");
        System.out.println("Select what you want to manage:");
        System.out.println("[U]sers [E]xit");
        this.choice = this.getInput();
    }

    public void submit() {
        if (choice.equalsIgnoreCase("U")) {
        	MainDispatcher.getInstance().callView("User", null);
        }
        
        if (choice.equalsIgnoreCase("E")) {
        	request = new Request();
        	MainDispatcher.getInstance().callView("Menu", request);
        }
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
