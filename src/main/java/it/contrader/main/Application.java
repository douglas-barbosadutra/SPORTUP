package it.contrader.main;

import it.contrader.controller.Request;

public class Application {

	static Request request = new Request();
	
    public static void main(String[] args) {
    	MainDispatcher.getInstance().callView("Menu", request);
        
    }

}
