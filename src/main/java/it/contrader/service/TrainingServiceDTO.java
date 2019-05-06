package it.contrader.service;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dao.TrainingCardDAO;
import it.contrader.dao.TrainingDAO;
import it.contrader.model.Player;
import it.contrader.model.Training;
import it.contrader.model.TrainingCard;


public class TrainingServiceDTO {

	private final TrainingDAO trainingDAO;
	private final TrainingCardDAO trainingCardDAO;


	public TrainingServiceDTO() {
		this.trainingDAO = new TrainingDAO();
		this.trainingCardDAO = new TrainingCardDAO();
	
	}
	
	public boolean createTraining(Training training) {
		return this.trainingDAO.createTraining(training);
	}
	
	public List<Training> getAllTraining() {
		return this.trainingDAO.getAllTraining();
	}
	
	public boolean createTrainigCardFull(TrainingCard trainingCard) {
		return this.trainingCardDAO.createTrainigCardFull(trainingCard);
	}
	
	public List<TrainingCard> getAllTrainingCardTrainer(TrainingCard training_card) {
		return this.trainingCardDAO.getAllTrainingCardTrainer(training_card);
	}

	public boolean deleteTrainingCard(TrainingCard training_card) {
		return this.trainingCardDAO.deleteTrainingCard(training_card);
	}
	
	public TrainingCard getTrainingCard(TrainingCard training_card) {
		return this.trainingCardDAO.getTrainingCard(training_card);
	}
	
	public boolean updateTrainingCard(TrainingCard training_card) {
		return this.trainingCardDAO.updateTrainingCard(training_card);
	}

	public boolean updateTraining(Training trainingToUpdate) {
		return this.trainingDAO.updateTraining(trainingToUpdate);
	}

	public boolean deleteTraining(Integer id) {
		return this.trainingDAO.deleteTraining(id);
	}
	
	public boolean assignTraining(Training trainingToAssign) {
		return this.trainingDAO.assignTraining(trainingToAssign);
	}
	
	public List<TrainingCard> getAllTrainingCardPlayer(Player player) {
		return this.trainingCardDAO.getAllTrainingCardPlayer(player);
	}	
	
}
