/**
 * Manage a Business Owner view
 */

package it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.TrainingController;
import it.contrader.controller.UserController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Player;

public class HomePlayerView implements View {

    private String choice, player_info;
    private Request request, r;
    private TrainingController trainingController;
    private UserController userController;
    private Player player;
    Scanner scanner;
    
    
    public void showResults(Request request) {
    	scanner = new Scanner(System.in);
    	this.request = new Request();
    	System.out.println("Welcome in SPORTUP "+request.get("nomeUtente").toString());
    	this.trainingController = new TrainingController();
    	this.userController = new UserController();
    	this.request.put("nomeUtente", request.get("nomeUtente"));
    	this.request.put("id", request.get("id"));
    }


    public void showOptions() {
        System.out.println("-------MENU-------\n");
        System.out.println("Select what you want to inspect:");
        System.out.println("[T]raining [I]nfo [A]dd Info [E]xit");
        this.choice = this.getInput();
    }

    public void submit() {
        if (choice.equalsIgnoreCase("T")) {
        	r = new Request();
        	r = trainingController.getPlayerTraining(request);
	        System.out.println("Training Details");
			System.out.println("-----------------------------");
			if (r.get("info")==null)
					System.out.println("No Training Assigned");
			else {
	        System.out.println(r.get("info").toString());
	    	r.put("nomeUtente", this.request.get("nomeUtente").toString());
	        r.put("id", (int) this.request.get("id"));
			}
			MainDispatcher.getInstance().callView("HomePlayer", this.request);
        }
        if (choice.equalsIgnoreCase("I")) { 
	    	System.out.println("Username\tPassword\tRole\tTraining Type\tInfo");
			System.out.print("----------------------------------------------------------------------");
			player = userController.getPlayerInfo((int) this.request.get("id"));
			System.out.println();
			System.out.println(player.toStringInfo());
			System.out.println();
			MainDispatcher.getInstance().callView("HomePlayer", this.request);
	    }
        if (choice.equalsIgnoreCase("A")) {
        	System.out.println("Write the info you want to add:");
        	player_info = scanner.nextLine();
        	userController.addPlayerInfo((int) this.request.get("id"), player_info);
        	MainDispatcher.getInstance().callView("HomePlayer", this.request);
	    }
        if (choice.equalsIgnoreCase("E")) {
        	MainDispatcher.getInstance().callView("Menu", null);
        }
        else {
        	MainDispatcher.getInstance().callView("HomePlayer", this.request);

        }
        MainDispatcher.getInstance().callView("HomePlayer", this.request);
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}