package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;

public class RegisterDAO {

    private final String QUERY_REGISTER = "INSERT INTO user (id_user, name, password) VALUES (?, ?, ?)";
    
    public String register (int id, String username, String password) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_REGISTER);
            statement.setInt(1, id);
            statement.setString(2, username);
            statement.setString(3, password);
           
            String userType=null;
            ResultSet rs;
            //if(statement.executeQuery().next()) {
            	statement.execute();
            	//rs.next();
            //}
            
            return userType;
        }
        catch (SQLException e) {
            GestoreEccezioni.getInstance().gestisciEccezione(e);
            return null;
        }
    }
}
