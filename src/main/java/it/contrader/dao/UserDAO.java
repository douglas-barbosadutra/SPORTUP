package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.User;
import it.contrader.model.Player;
import it.contrader.model.Team;

public class UserDAO {

	private final String QUERY_ALL = "select * from user";
	private final String QUERY_INSERT = "insert into user (name, type) values (?,?)";
	private final String QUERY_INSERT_PLAYER = "insert into player (id_user) values (?)";
	private final String QUERY_READ = "select * from user where id_user=?";
	private final String QUERY_RIGHTS = "update user set type = ? where id_user = ?";

	private final String QUERY_UPDATE = "UPDATE user SET name=?, type=? WHERE id_user=?";
	private final String QUERY_DELETE = "delete from user where id_user=?";
	private final String QUERY_DELETE_CHECK = "select (type) from user where id_user = ?";
	private final String QUERY_ADD_PLAYER_INFO = "UPDATE player SET info=? WHERE id_user=?";
	
	private final String QUERY_CREATE_B_DATA = "insert into biomedical_data () values ()";
	private final String QUERY_GET_LAST_B_DATA = "select max(id_biomedical_data) as id_biomedical_data from biomedical_data";
	private final String QUERY_INSERT_B_DATA_PLAYER = "update player set id_biomedical_data = ? where id_user = ?";

	private final String QUERY_ALL_PLAYER_TRAINING = "select user.id_user, user.name, player.role, player.id_training, training.info as 'training type', player.info as 'player info' \n" + 
													 "from user \n" + 
													 "join player\n" + 
													 "on user.id_user = player.id_user\n" + 
													 "left join training\n" + 
													 "on player.id_training = training.id_training;";
	
	private final String QUERY_ALL_PLAYER_TEAM = "select user.id_user, user.name, player.role\n" +
												 "from user\n" +
												 "join player\n" + 
												 "on user.id_user = player.id_user\n" +
												 "left join playerteam\n" + 
												 "on player.id_user = playerteam.id_user\n" +
												 "where playerteam.id_team = ?\n";
	
	private final String QUERY_GET_PLAYER_INFO = "select user.name, user.password, player.role, training.info as 'training type', player.info as 'player info' \n" + 
												 "from user \n" + 
												 "join player\n" + 
												 "on user.id_user = player.id_user\n" + 
												 "left join training\n" + 
												 "on player.id_training = training.id_training\n" +
												 "where user.id_user = ?";
	
	public UserDAO() {

	}

	public List<User> getAllUser() {
		List<User> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			User user;
			while (resultSet.next()) {
				int userId = resultSet.getInt("id_user");
				String username = resultSet.getString("name");
				String usertype = resultSet.getString("type");
				user = new User(username, usertype);
				user.setUserId(userId);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public List<Player> getAllPlayerTraining() {
		List<Player> playerList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL_PLAYER_TRAINING);
			Player player;
			while (resultSet.next()) {
				int userId = resultSet.getInt("id_user");
				String username = resultSet.getString("name");
				String role = resultSet.getString("role");
				int trainingId = resultSet.getInt("id_training");
				String trainingInfo = resultSet.getString("training type");
				String playerInfo = resultSet.getString("player info");
				
				player = new Player();
				
				player.setUserId(userId);
				player.setUsername(username);
				player.setPlayerRole(role);
				player.setTrainingId(trainingId);
				player.setTrainingInfo(trainingInfo);
				player.setPlayerInfo(playerInfo);
				playerList.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerList;
	}
	
	public List<Player> getAllPlayerTeam(Team team) {
		List<Player> playerList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ALL_PLAYER_TEAM);
			preparedStatement.setInt(1, team.getTeamId());
			ResultSet resultSet = preparedStatement.executeQuery();
			Player player;
			while (resultSet.next()) {
				int userId = resultSet.getInt("id_user");
				String username = resultSet.getString("name");
				String role = resultSet.getString("role");
								
				player = new Player();
				
				player.setUserId(userId);
				player.setUsername(username);
				player.setPlayerRole(role);
				playerList.add(player);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return playerList;
	}
	
	public boolean insertUser(User user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(3, user.getUsertype());
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
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE_CHECK);
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String type = resultSet.getString("type").toString();
			System.out.println(type);
			if(type.equals("admin")) return false;
			
			preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public boolean setUserRights(int userId, String userType) {
		
		String type;
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (userId == 0)
			return false;
		try {
			// Check user type
			if (userType.equals("P")) {
				type = "player";
				insertPlayer(userId);
				createPlayerBdata(userId);
			}
			else if (userType.equals("T")) type = "trainer";
			else return false;
		
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
	
	public boolean insertPlayer(int userId) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_PLAYER);
			preparedStatement.setInt(1, userId);
			boolean n = preparedStatement.execute();
			if (n)
				
				return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public int createPlayerBdata(int user_id) {
		Connection connection = ConnectionSingleton.getInstance();
		
		int id_Bdata = 0;
		
		try {
			
			Statement statement = connection.createStatement();
			statement.executeUpdate(QUERY_CREATE_B_DATA);
			
			ResultSet rs = statement.executeQuery(QUERY_GET_LAST_B_DATA);
			rs.next();
			id_Bdata = rs.getInt("id_biomedical_data");
			
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT_B_DATA_PLAYER);
			preparedStatement.setInt(1, id_Bdata);
			preparedStatement.setInt(2, user_id);	
			preparedStatement.execute();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return id_Bdata;

	}
	
	public boolean addPlayerInfo(int player_id, String player_info) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_ADD_PLAYER_INFO);
			preparedStatement.setString(1, player_info);
			preparedStatement.setInt(2, player_id);
			boolean n = preparedStatement.execute();
			if (n)				
				return true;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
	
	public Player getPlayerInfo(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		Player player = new Player();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_GET_PLAYER_INFO);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			player.setUsername(resultSet.getString("name"));
			player.setPassword(resultSet.getString("password"));
			player.setPlayerRole(resultSet.getString("role"));
			player.setTrainingInfo(resultSet.getString("training type"));
			player.setPlayerInfo(resultSet.getString("player info"));
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return player; 
	}

}
