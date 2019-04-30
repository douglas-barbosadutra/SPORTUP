package it.contrader.service;

import it.contrader.dao.RegisterDAO;

public class RegisterService {

    private RegisterDAO registerDAO;

    public RegisterService() {
        this.registerDAO = new RegisterDAO();
    }

    public String register (String username, String password) {
        return this.registerDAO.register(username, password);
    }
}
