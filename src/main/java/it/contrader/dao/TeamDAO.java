package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.User;
import it.contrader.model.Training;
import it.contrader.model.Team;

public class TeamDAO {

	private final String QUERY_ALL = "select * from team";
	private final String QUERY_INSERT = "insert into team (info) values (?)";
	private final String QUERY_READ = "select * from training where id_training=?";
	private final String QUERY_RIGHTS = "update user set type = ? where id_user = ?";

	private final String QUERY_UPDATE = "UPDATE training SET info=? WHERE id_training=?";
	private final String QUERY_DELETE = "delete from team where id_team=?";
	private final String QUERY_UPDATE_ID_TRAINING = "update player SET id_training=null where id_training=?";

	private final String QUERY_LAST_ID = "select max(id_training) as id_training from training";
	private final String QUERY_ASSIGN_TEAM = "insert into playerteam values (?,?)";
	private final String QUERY_CHECK_ID_TEAM = "select id_team from team where id_team=?";
	private final String QUERY_CHECK_ID_PLAYER = "select id_user from player where id_user=?";

	
	
	public TeamDAO() {
		
	}
	
	
	public List<Team> getAllTeam() {
		List<Team> teamList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			Team team;
			while (resultSet.next()) {
				int teamId = resultSet.getInt("id_team");
				String info = resultSet.getString("info");
				team = new Team(info);
				team.setTeamId(teamId);
				teamList.add(team);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return teamList;
	}

	public boolean createTeam(Team team) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, team.getInfo());
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

	
	public boolean assignTeam(Team teamToAssign) {
		Connection connection = ConnectionSingleton.getInstance();
			
			try {
				// Check if team id is present
				PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CHECK_ID_TEAM);
				preparedStatement.setInt(1, teamToAssign.getTeamId());
				ResultSet resultSet = preparedStatement.executeQuery();
								
				if (!resultSet.next()) {
					System.out.println("ERROR: Team not present!");
					return false;
				}
				
				// Check if player id is present
				preparedStatement = connection.prepareStatement(QUERY_CHECK_ID_PLAYER);
				preparedStatement.setInt(1, teamToAssign.getPlayerId());
				ResultSet resultSetP = preparedStatement.executeQuery();
								
				if (!resultSetP.next()) {
					System.out.println("ERROR: Player not present!");
					return false;
				}
				
				// Assign player to a team
				preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_ASSIGN_TEAM);
				preparedStatement.setInt(1, teamToAssign.getPlayerId());
				preparedStatement.setInt(2, teamToAssign.getTeamId());

				int a = preparedStatement.executeUpdate();
				if (a > 0) return true;
				else return false;
				
			} catch (SQLException e) {
				System.out.println(e.getMessage());
				return false;
			}		
	}

	
	
	
	public boolean deleteTeam(Integer id) {
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
