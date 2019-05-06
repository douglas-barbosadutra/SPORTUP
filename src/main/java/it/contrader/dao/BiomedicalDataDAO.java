package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Training;
import it.contrader.model.BiomedicalData;
import it.contrader.model.Player;
import it.contrader.model.Team;

public class BiomedicalDataDAO {

	private final String QUERY_INSERT = "insert into biomedical_data "
										+ "(hearthbeat, blood_pressure, height, weight, fat_mass, fat_free_mass) "
										+ "values (?,?,?,?,?,?)";
	
	private final String QUERY_READ = "select * from training where id_training=?";
	private final String QUERY_RIGHTS = "update user set type = ? where id_user = ?";

	private final String QUERY_UPDATE = "UPDATE biomedical_data \n" +
										"join player \n" +
										"on biomedical_data.id_biomedical_data = player.id_biomedical_data \n" +
										"set biomedical_data.heartbeat = ?, biomedical_data.blood_pressure = ?, \n" +
										"biomedical_data.height = ?, biomedical_data.weight = ?, biomedical_data.fat_mass = ?, biomedical_data.fat_free_mass = ? \n" +
										"where player.id_user = ?";
	
	private final String QUERY_DELETE = "UPDATE biomedical_data \n" +
										"join player \n" +
										"on biomedical_data.id_biomedical_data = player.id_biomedical_data \n" +
										"set biomedical_data.deleted = 1 \n" +
										"where player.id_user = ?";
	
	private final String QUERY_ASSIGN_TEAM = "insert into playerteam values (?,?)";
	private final String QUERY_CHECK_ID_TEAM = "select id_team from team where id_team=?";
	private final String QUERY_CHECK_ID_PLAYER = "select id_user from player where id_user=?";

	private final String QUERY_VIEW_B_DATA_PLAYER = "select biomedical_data.heartbeat, biomedical_data.blood_pressure, biomedical_data.height, biomedical_data.weight, biomedical_data.fat_mass, biomedical_data.fat_free_mass, biomedical_data.deleted \n" + 
													 "from biomedical_data \n" + 
													 "join player\n" + 
													 "on biomedical_data.id_biomedical_data = player.id_biomedical_data\n" + 
													 "where player.id_user = ?";
	
	private final String QUERY_UPDATE_NOT_DELETED = "UPDATE biomedical_data \n" +
										       "join player \n" +
											   "on biomedical_data.id_biomedical_data = player.id_biomedical_data \n" +
											   "set biomedical_data.deleted = 0 \n" +
											   "where player.id_user = ?";
										
	public BiomedicalDataDAO() {
		
	}
	
	
	public boolean createBiomedicalData(BiomedicalData b_data) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			//preparedStatement.setString(1, team.getInfo());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public BiomedicalData getPlayerBData(Player player) {
		Connection connection = ConnectionSingleton.getInstance();
		BiomedicalData b_data = new BiomedicalData();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_VIEW_B_DATA_PLAYER);
			preparedStatement.setInt(1, player.getUserId());
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			
			if(resultSet.getInt("deleted") == 0) {
				b_data.setBlood_pressure(resultSet.getInt("blood_pressure"));
				b_data.setFat_free_mass(resultSet.getFloat("fat_free_mass"));
				b_data.setFat_mass(resultSet.getFloat("fat_mass"));
				b_data.setHearthbeat(resultSet.getInt("heartbeat"));
				b_data.setHeight(resultSet.getFloat("height"));
				b_data.setWeight(resultSet.getFloat("weight"));
			}
			else {
				b_data.setBlood_pressure(0);
				b_data.setFat_free_mass(0);
				b_data.setFat_mass(0);
				b_data.setHearthbeat(0);
				b_data.setHeight(0);
				b_data.setWeight(0);
			}
			
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
		
		return b_data;

	}

	
	public boolean updatePlayerBData(Player player, BiomedicalData b_data) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1, b_data.getHearthbeat());
			preparedStatement.setInt(2, b_data.getBlood_pressure());
			preparedStatement.setFloat(3, b_data.getHeight());
			preparedStatement.setFloat(4, b_data.getWeight());
			preparedStatement.setFloat(5, b_data.getFat_mass());
			preparedStatement.setFloat(6, b_data.getFat_free_mass());
			preparedStatement.setInt(7, player.getUserId());

			int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

		} catch (SQLException e) {
				return false;
		}

	}

	public boolean insertPlayerBData(Player player, BiomedicalData b_data) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_UPDATE);
			preparedStatement.setInt(1, b_data.getHearthbeat());
			preparedStatement.setInt(2, b_data.getBlood_pressure());
			preparedStatement.setFloat(3, b_data.getHeight());
			preparedStatement.setFloat(4, b_data.getWeight());
			preparedStatement.setFloat(5, b_data.getFat_mass());
			preparedStatement.setFloat(6, b_data.getFat_free_mass());
			preparedStatement.setInt(7, player.getUserId());

			preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(QUERY_UPDATE_NOT_DELETED);
			preparedStatement.setInt(1, player.getUserId());
			preparedStatement.executeUpdate();
			
			return true;
			
				
			
		} catch (SQLException e) {
				return false;
		}

	}
		
	
	
	
	public boolean deleteBiomedicalData(Player player) {
		Connection connection = ConnectionSingleton.getInstance();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, player.getUserId());
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;
		} catch (SQLException e) {
		}
		return false;
	}

}

