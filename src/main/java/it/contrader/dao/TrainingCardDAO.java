
package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Training;
import it.contrader.model.TrainingCard;
import it.contrader.model.User;
import it.contrader.model.Player;

public class TrainingCardDAO {

	private final String QUERY_INSERT_EMPTY = "insert into training_card (id_training, id_training_card) values (?, ?)";
	private final String QUERY_INSERT_FULL = "insert into training_card \n" +
			 					"(id_training, id_training_card, monday, tuesday, wednesday, thursday, friday, saturday, sunday) \n" +
			 					"values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private final String QUERY_UPDATE_FULL = "UPDATE training_card \n" +
											 "set monday=?, tuesday=?, wednesday=?, thursday=?, friday=?, saturday=?, sunday=?, deleted=0 \n" +
											 "where id_training = ? AND id_training_card = ?";
	
	private final String QUERY_GET_LAST_ID = "select max(id_training_card) as id_training_card from training_card where id_training = ?";
	
	private final String QUERY_UPDATE = "UPDATE training_card \n" +
										"set monday=?, tuesday=?, wednesday=?, thursday=?, friday=?, saturday=?, sunday=?\n" +
										"where id_training = ? AND id_training_card = ?";
	
	private final String QUERY_DELETE_TRAINING_CARD = "UPDATE training_card set deleted = 1 where id_training = ? AND id_training_card = ?";
	
	private final String QUERY_CHECK_DELETED = "select id_training_card, deleted from training_card where id_training = ?";
	private final String QUERY_CHECK_DELETED_BY_ID = "select deleted from training_card where id_training = ? AND id_training_card = ?";

	private final String QUERY_VIEW_T_CARDS = "select * from training_card where id_training = ?";
	private final String QUERY_GET_T_CARDS = "select * from training_card where id_training = ? AND id_training_card = ?";
	private final String QUERY_GET_TRAINING_ID = "select id_training from player where id_user = ?";				
	
	public TrainingCardDAO() {
		
	}
	
	
	public boolean createTrainigCardEmpty(TrainingCard training_card) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_LAST_ID);
			preparedStatement.setInt(1, training_card.getId_training());
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			int last_id = rs.getInt("id_training_card");
			
			preparedStatement = connection.prepareStatement(QUERY_INSERT_EMPTY);
			preparedStatement.setInt(1, training_card.getId_training());
			preparedStatement.setInt(2, last_id+1);
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public boolean createTrainigCardFull(TrainingCard trainingCard) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			int id = checkDeletedTrainingCard(trainingCard);
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_LAST_ID);
			preparedStatement.setInt(1, trainingCard.getId_training());
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			
			if(id == 0) {
				preparedStatement = connection.prepareStatement(QUERY_INSERT_FULL);
			
				int last_id = rs.getInt("id_training_card");
				preparedStatement.setInt(2, last_id+1);
				preparedStatement.setInt(1, trainingCard.getId_training());
				preparedStatement.setString(3, trainingCard.getMonday());
				preparedStatement.setString(4, trainingCard.getTuesday());
				preparedStatement.setString(5, trainingCard.getWednesday());
				preparedStatement.setString(6, trainingCard.getThursday());
				preparedStatement.setString(7, trainingCard.getFriday());
				preparedStatement.setString(8, trainingCard.getSaturday());
				preparedStatement.setString(9, trainingCard.getSunday());
			}else {
				preparedStatement = connection.prepareStatement(QUERY_UPDATE_FULL);
				
				preparedStatement.setInt(9, id);
				preparedStatement.setInt(8, trainingCard.getId_training());
				preparedStatement.setString(1, trainingCard.getMonday());
				preparedStatement.setString(2, trainingCard.getTuesday());
				preparedStatement.setString(3, trainingCard.getWednesday());
				preparedStatement.setString(4, trainingCard.getThursday());
				preparedStatement.setString(5, trainingCard.getFriday());
				preparedStatement.setString(6, trainingCard.getSaturday());
				preparedStatement.setString(7, trainingCard.getSunday());
			}
			
			
			preparedStatement.executeUpdate();
			
			return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public int checkDeletedTrainingCard(TrainingCard training_card) {
		int id_training_card = 0;
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CHECK_DELETED);
			preparedStatement.setInt(1, training_card.getId_training());
			ResultSet rs = preparedStatement.executeQuery();
			
			do {
				rs.next();
			}while(rs.getInt("deleted")==0);
			
			id_training_card = rs.getInt("id_training_card");
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			
		}
		return id_training_card;
	}

	public boolean checkDeletedTrainingCardByID(TrainingCard training_card) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CHECK_DELETED_BY_ID);
			preparedStatement.setInt(1, training_card.getId_training());
			preparedStatement.setInt(2, training_card.getId_training_card());
			ResultSet rs = preparedStatement.executeQuery();
			rs.next();
			
			if(rs.getInt("deleted")==1) return true;
			
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			
		}
		return false;
	}
	
	public boolean updateTrainingCard(TrainingCard training_card) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			if(checkDeletedTrainingCardByID(training_card)) return false;
			else {
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
				
				preparedStatement.setInt(8, training_card.getId_training());
				preparedStatement.setInt(9, training_card.getId_training_card());
				preparedStatement.setString(1, training_card.getMonday());
				preparedStatement.setString(2, training_card.getTuesday());
				preparedStatement.setString(3, training_card.getWednesday());
				preparedStatement.setString(4, training_card.getThursday());
				preparedStatement.setString(5, training_card.getFriday());
				preparedStatement.setString(6, training_card.getSaturday());
				preparedStatement.setString(7, training_card.getSunday());
				preparedStatement.executeUpdate();
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
		return true;
	}


	public boolean deleteTrainingCard(TrainingCard training_card) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_TRAINING_CARD);
			preparedStatement.setInt(1, training_card.getId_training());
			preparedStatement.setInt(2, training_card.getId_training_card());
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}
	
	public List<TrainingCard> getAllTrainingCardTrainer(TrainingCard training_card) {
		List<TrainingCard> t_cardList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		TrainingCard t_card = new TrainingCard();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_VIEW_T_CARDS);
			preparedStatement.setInt(1, training_card.getId_training());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if(resultSet.getInt("deleted")==0) {
					t_card = new TrainingCard();
					t_card.setId_training(resultSet.getInt("id_training"));
					t_card.setId_training_card(resultSet.getInt("id_training_card"));
					t_card.setMonday(resultSet.getString("monday"));
					t_card.setTuesday(resultSet.getString("tuesday"));
					t_card.setWednesday(resultSet.getString("wednesday"));
					t_card.setThursday(resultSet.getString("thursday"));
					t_card.setFriday(resultSet.getString("friday"));
					t_card.setSaturday(resultSet.getString("saturday"));
					t_card.setSunday(resultSet.getString("sunday"));
					
					t_cardList.add(t_card);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t_cardList;
	}
	
	public List<TrainingCard> getAllTrainingCardPlayer(Player player) {
		List<TrainingCard> t_cardList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		TrainingCard t_card = new TrainingCard();
		int id_training = 0;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_TRAINING_ID);
			preparedStatement.setInt(1, player.getUserId());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			id_training = resultSet.getInt("id_training");
			
						
			preparedStatement = connection.prepareStatement(QUERY_VIEW_T_CARDS);
			preparedStatement.setInt(1, id_training);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				if(resultSet.getInt("deleted")==0) {
					t_card = new TrainingCard();
					t_card.setId_training(resultSet.getInt("id_training"));
					t_card.setId_training_card(resultSet.getInt("id_training_card"));
					t_card.setMonday(resultSet.getString("monday"));
					t_card.setTuesday(resultSet.getString("tuesday"));
					t_card.setWednesday(resultSet.getString("wednesday"));
					t_card.setThursday(resultSet.getString("thursday"));
					t_card.setFriday(resultSet.getString("friday"));
					t_card.setSaturday(resultSet.getString("saturday"));
					t_card.setSunday(resultSet.getString("sunday"));
					
					t_cardList.add(t_card);
				}
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return t_cardList;
	}
	
	public TrainingCard getTrainingCard(TrainingCard training_card) {
		Connection connection = ConnectionSingleton.getInstance();
		TrainingCard t_card = new TrainingCard();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_T_CARDS);
			preparedStatement.setInt(1, training_card.getId_training());
			preparedStatement.setInt(2, training_card.getId_training_card());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			resultSet.next();
			if(resultSet.getInt("deleted")==0) {
				t_card = new TrainingCard();
				t_card.setId_training(resultSet.getInt("id_training"));
				t_card.setId_training_card(resultSet.getInt("id_training_card"));
				t_card.setMonday(resultSet.getString("monday"));
				t_card.setTuesday(resultSet.getString("tuesday"));
				t_card.setWednesday(resultSet.getString("wednesday"));
				t_card.setThursday(resultSet.getString("thursday"));
				t_card.setFriday(resultSet.getString("friday"));
				t_card.setSaturday(resultSet.getString("saturday"));
				t_card.setSunday(resultSet.getString("sunday"));
				t_card.setDeleted(resultSet.getInt("deleted"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t_card;
	}

}

