package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterUser;
import it.contrader.utils.Request;
import it.contrader.converter.ConverterTraining;
import it.contrader.dao.TrainingDAO;
import it.contrader.dto.TrainingDTO;
import it.contrader.dao.UserDAO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Training;

public class TrainingService {

	private TrainingDAO trainingDAO;
	private UserDAO userDAO;

	public TrainingService() {
		this.trainingDAO = new TrainingDAO();
	}

	public List<Training> getAllTraining() {
		return this.trainingDAO.getAllTraining();
	}

	public boolean createTraining(TrainingDTO trainingDTO) {
		return this.trainingDAO.createTraining(ConverterTraining.toEntity(trainingDTO));
	}
	
	public UserDTO readUser(int userId) {
		return ConverterUser.toDTO(this.userDAO.readUser(userId));
	}
	
	public boolean updateUser(UserDTO userDTO) {
		return this.userDAO.updateUser(ConverterUser.toEntity(userDTO));
	}
	
	public boolean updateTraining(TrainingDTO trainingDTO) {
		return this.trainingDAO.updateTraining(ConverterTraining.toEntity(trainingDTO));
	}
	public boolean deleteTraining(int trainingId) {
		return this.trainingDAO.deleteTraining(trainingId);
	}
	
	public boolean setUserRights(int userId, String userType) {
		return this.userDAO.setUserRights(userId, userType);
	}
		
	public boolean assignTraining(TrainingDTO trainingDTO) {
		return this.trainingDAO.assignTraining(ConverterTraining.toEntity(trainingDTO));
	}
	
	public Request getPlayerTraining(Request request) {
		return this.trainingDAO.getPlayerTraining(request);
	}
	
}
