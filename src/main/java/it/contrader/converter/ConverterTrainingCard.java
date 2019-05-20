package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TrainingCardDTO;
import it.contrader.model.TrainingCard;

public class ConverterTrainingCard {

	public static TrainingCardDTO toDTO(TrainingCard trainingCard) {
		TrainingCardDTO trainingCardDTO = null;
		if (trainingCard != null) {
			trainingCardDTO = new TrainingCardDTO();
			trainingCardDTO.setIdTrainingCard(trainingCard.getIdTrainingCard());
			trainingCardDTO.setMonday(trainingCard.getMonday());
			trainingCardDTO.setTuesday(trainingCard.getTuesday());
			trainingCardDTO.setWednesday(trainingCard.getWednesday());
			trainingCardDTO.setThursday(trainingCard.getThursday());
			trainingCardDTO.setFriday(trainingCard.getFriday());
			trainingCardDTO.setSaturday(trainingCard.getSaturday());
			trainingCardDTO.setSunday(trainingCard.getSunday());
			trainingCardDTO.setTraining(trainingCard.getTraining());
			trainingCardDTO.setDeleted(trainingCard.getDeleted());
		}
		return trainingCardDTO;
	}

	public static TrainingCard toEntity(TrainingCardDTO trainingCardDTO) {
		TrainingCard trainingCard = null;
		if (trainingCardDTO != null) {
			trainingCard = new TrainingCard();
			trainingCard.setIdTrainingCard(trainingCardDTO.getIdTrainingCard());
			trainingCard.setMonday(trainingCardDTO.getMonday());
			trainingCard.setTuesday(trainingCardDTO.getTuesday());
			trainingCard.setWednesday(trainingCardDTO.getWednesday());
			trainingCard.setThursday(trainingCardDTO.getThursday());
			trainingCard.setFriday(trainingCardDTO.getFriday());
			trainingCard.setSaturday(trainingCardDTO.getSaturday());
			trainingCard.setSunday(trainingCardDTO.getSunday());
			trainingCard.setTraining(trainingCardDTO.getTraining());
			trainingCard.setDeleted(trainingCardDTO.getDeleted());
		}
		return trainingCard;
	}

	public static List<TrainingCardDTO> toListDTO(List<TrainingCard> list) {
		List<TrainingCardDTO> listTrainingCardDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (TrainingCard trainingCard : list) {
				listTrainingCardDTO.add(ConverterTrainingCard.toDTO(trainingCard));
			}
		}
		return listTrainingCardDTO;
	}

	public static List<TrainingCard> toListEntity(List<TrainingCardDTO> listTrainingCardDTO) {
		List<TrainingCard> list = new ArrayList<>();
		if (!listTrainingCardDTO.isEmpty()) {
			for (TrainingCardDTO trainingCardDTO : listTrainingCardDTO) {
				list.add(ConverterTrainingCard.toEntity(trainingCardDTO));
			}
		}
		return list;
	}
}
