package it.contrader.controller;

import it.contrader.main.MainDispatcher;
import it.contrader.service.LoginService;
import it.contrader.service.RegisterService;

public class HomeController implements Controller {

    private LoginService loginService;
    private RegisterService registerService;
    
    public HomeController() {
        loginService = new LoginService();
        registerService = new RegisterService();
    }

    public void doControl(Request request) {
        if(request.get("mode").equals("login")){
	    	if (request != null) {
	            String nomeUtente = request.get("nomeUtente").toString();
	            String password = request.get("password").toString();
	            
	            //Change view according userType
	            String userType= loginService.login(nomeUtente, password);
	            if(userType==null)
	                MainDispatcher.getInstance().callAction("Login", "doControl", request);
	            
	            if (userType.equals("admin"))
	                MainDispatcher.getInstance().callView("HomeAdmin", request);
	            
	            if (userType.equals("player"))
	            	MainDispatcher.getInstance().callView("HomePlayer", request);
	            
	            if (userType.equals("trainer"))
	            	MainDispatcher.getInstance().callView("HomeTrainer", request);
	            
	            if (userType.equals("pending"))
	            	MainDispatcher.getInstance().callView("HomePending", request);
	    	}
    	}
	    if(request.get("mode").equals("register")){
	    	if (request != null) {
	    		String nomeUtente = request.get("username").toString();
	            String password = request.get("password").toString();
	            int id_user = (int) request.get("id");
	            
	            String userType= registerService.register(id_user, nomeUtente, password);
	    	}   
	    }
        
        else MainDispatcher.getInstance().callView("Login", null);

    }
}
