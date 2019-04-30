package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;

public class RegisterDAO {

    private final String QUERY_REGISTER = "INSERT INTO user (name, password) VALUES (?, ?)";
    
    public String register(String username, String password) {

        Connection connection = ConnectionSingleton.getInstance();
        try {
            PreparedStatement statement = connection.prepareStatement(QUERY_REGISTER);
            statement.setString(1, username);
            statement.setString(2, password);
           
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
