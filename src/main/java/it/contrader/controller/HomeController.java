package it.contrader.controller;

import java.sql.SQLException;

import it.contrader.main.MainDispatcher;
import it.contrader.service.LoginService;
import it.contrader.service.RegisterService;

public class HomeController implements Controller {

    private LoginService loginService;
    private RegisterService registerService;
    private Request request;
    
    public HomeController() {
        loginService = new LoginService();
        registerService = new RegisterService();
        request = new Request();
    }

    public void doControl(Request request) {
        if(request.get("mode").equals("login")){
	    	try {
	        	if (request != null) {
		            String nomeUtente = request.get("nomeUtente").toString();
		            String password = request.get("password").toString();
		            this.request = loginService.login(nomeUtente, password);
		            
		            this.request.put("nomeUtente", nomeUtente);
		            this.request.put("password", password);
		            String userType= this.request.get("type").toString();
		            
		            //Change view according userType
		            if(userType==null) {
		            	MainDispatcher.getInstance().callAction("Login", "doControl", this.request);
		            }
		            if (userType.equals("admin"))
		                MainDispatcher.getInstance().callView("HomeAdmin", this.request);
		            
		            if (userType.equals("player"))
		            	MainDispatcher.getInstance().callView("HomePlayer", this.request);
		            
		            if (userType.equals("trainer"))
		            	MainDispatcher.getInstance().callView("HomeTrainer", this.request);
		            
		            if (userType.equalsIgnoreCase("pending")) {
		            	System.out.println("Account under verification!");
		            	MainDispatcher.getInstance().callView("Menu", request);
		            }
		            else {
		            	MainDispatcher.getInstance().callView("Menu", null);
		            }
		    	}
	    	}catch (Exception e){
	    		
	    	}
        
        	
        }
	    if(request.get("mode").equals("register")){
	    	if (request != null) {
	    		String nomeUtente = request.get("username").toString();
	            String password = request.get("password").toString();
	            String userType= registerService.register(nomeUtente, password);
	            MainDispatcher.getInstance().callView("Login", null);
	    	}   
	    }
        
        else {
        	System.out.println("ERROR: User not found!");
        	MainDispatcher.getInstance().callView("Menu", null);
        }

    }
}
