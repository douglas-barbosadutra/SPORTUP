package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.User;
import it.contrader.model.Training;

public class TrainingDAO {

	private final String QUERY_ALL = "select * from training";
	private final String QUERY_INSERT = "insert into training (id_training, info) values (?,?)";
	private final String QUERY_READ = "select * from user where id_user=?";
	private final String QUERY_RIGHTS = "update user set type = ? where id_user = ?";

	private final String QUERY_UPDATE = "UPDATE user SET name=?, type=? WHERE id_user=?";
	private final String QUERY_DELETE = "delete from user where id_user=?";
	private final String QUERY_LAST_ID = "select max(id_training) as id_training from training";
	
	
	
	public TrainingDAO() {
		
	}
	
	public int getLastID() {
		int lastID=1;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_LAST_ID);
			System.out.println("adsf");
			resultSet.next();
			lastID = resultSet.getInt("id_training");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lastID;
	}

	public List<Training> getAllTraining() {
		List<Training> trainingList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Training training;
			while (resultSet.next()) {
				int trainingId = resultSet.getInt("id_training");
				String info = resultSet.getString("info");
				training = new Training(info);
				training.setTrainingId(trainingId);
				trainingList.add(training);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return trainingList;
	}

	public boolean createTraining(Training training) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int training_id = getLastID() + 1;
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setInt(1, training_id);
			preparedStatement.setString(2, training.getInfo());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public User readUser(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String username, password, usertype;

			username = resultSet.getString("name");
			usertype = resultSet.getString("type");
			User user = new User(username, usertype);
			user.setUserId(resultSet.getInt("id_user"));

			return user;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateUser(User userToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (userToUpdate.getUserId() == 0)
			return false;

		User userRead = readUser(userToUpdate.getUserId());
		if (!userRead.equals(userToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
					userToUpdate.setUsername(userRead.getUsername());
				}
				
				
				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
					userToUpdate.setUsertype(userRead.getUsertype());
				}
				
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, userToUpdate.getUsername());
				preparedStatement.setString(3, userToUpdate.getUsertype());
				preparedStatement.setInt(4, userToUpdate.getUserId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;
		
	}

	public boolean deleteUser(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
	
	public boolean setUserRights(int userId, String userType) {
		
		String type;
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (userId == 0)
			return false;
		
		// Check user type
		if (userType.equals("P")) type = "player";
		else if (userType.equals("T")) type = "trainer";
		else return false;
		
		System.out.println(userId + userType);
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_RIGHTS);
			preparedStatement.setInt(2, userId);
			preparedStatement.setString(1, type);
			boolean n = preparedStatement.execute();
			if (n)
				return true;
		} catch (SQLException e) {
		}
		return false;
		
	}

}
