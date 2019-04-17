package it.contrader.controller;

import it.contrader.main.MainDispatcher;

public class RegisterController implements Controller {

    public RegisterController() {
    }

    public void doControl (Request request) {
        MainDispatcher.getInstance().callView("Register", request);
    }
}
