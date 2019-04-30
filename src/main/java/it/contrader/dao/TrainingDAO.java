package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.Request;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.User;
import it.contrader.model.Training;

public class TrainingDAO {

	private final String QUERY_ALL = "select * from training";
	private final String QUERY_INSERT = "insert into training (info) values (?)";
	private final String QUERY_READ = "select * from training where id_training=?";
	private final String QUERY_RIGHTS = "update user set type = ? where id_user = ?";

	private final String QUERY_UPDATE = "UPDATE training SET info=? WHERE id_training=?";
	private final String QUERY_DELETE = "delete from training where id_training=?";
	private final String QUERY_UPDATE_ID_TRAINING = "update player SET id_training=null where id_training=?";

	private final String QUERY_LAST_ID = "select max(id_training) as id_training from training";
	private final String QUERY_ASSIGNTRAINING = "update player SET id_training=? WHERE id_user=?";
	private final String QUERY_CHECK_ID_TRAINING = "select id_training from training where id_training=?";
	private final String QUERY_GET_PLAYER_TRAINING = "select training.info\n" +
													 "from training\n" +
													 "join player\n" + 
													 "on training.id_training = player.id_training\n" +
													 "where player.id_user = ?\n";


	
	
	public TrainingDAO() {
		
	}
	
	public int getLastID() {
		int lastID=1;
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_LAST_ID);
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
			//int training_id = getLastID() + 1;
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			//preparedStatement.setInt(1, training_id);
			preparedStatement.setString(1, training.getInfo());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public Training readTraining(int trainingId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, trainingId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String info;

			info = resultSet.getString("info");
			
			Training training = new Training(info);
			training.setTrainingId(resultSet.getInt("id_training"));

			return training;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateTraining(Training trainingToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (trainingToUpdate.getTrainingId() == 0)
			return false;

		Training trainingRead = readTraining(trainingToUpdate.getTrainingId());
		if (!trainingRead.equals(trainingToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (trainingToUpdate.getInfo() == null || trainingToUpdate.getInfo().equals("")) {
					trainingToUpdate.setInfo(trainingRead.getInfo());
				}
				
				
	
				
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, trainingToUpdate.getInfo());
				preparedStatement.setInt(2, trainingToUpdate.getTrainingId());

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

	
	public boolean assignTraining(Training trainingToAssign) {
		Connection connection = ConnectionSingleton.getInstance();
			
			try {
				// Check if id is present
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CHECK_ID_TRAINING);
				preparedStatement.setInt(1, trainingToAssign.getTrainingId());
				ResultSet resultSet = preparedStatement.executeQuery();
								
				if (!resultSet.next()) {
					System.out.println("ERROR: Training not present!");
					return false;
				}
				
				// Update the user
				preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_ASSIGNTRAINING);
				preparedStatement.setInt(2, trainingToAssign.getPlayerId());
				preparedStatement.setInt(1, trainingToAssign.getTrainingId());

				int a = preparedStatement.executeUpdate();
				if (a > 0) return true;
				else return false;
				
			} catch (SQLException e) {
				return false;
			}		
	}

	
	
	
	public boolean deleteTraining(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE_ID_TRAINING);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
		
			preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			 n = preparedStatement.executeUpdate();
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
	
	public Request getPlayerTraining(Request request) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_PLAYER_TRAINING);
			preparedStatement.setInt(1, (int)request.get("id"));
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			request.put("info", resultSet.getString("info"));
		} catch (SQLException e) {
		}
		return request;
	}

}
