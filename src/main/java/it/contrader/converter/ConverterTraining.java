package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TrainingDTO;
import it.contrader.model.Training;

public class ConverterTraining {

	public static TrainingDTO toDTO(Training training) {
		TrainingDTO trainingDTO = null;
		if (training != null) {
			trainingDTO = new TrainingDTO();
			trainingDTO.setTrainingId(training.getTrainingId());
			trainingDTO.setInfo(training.getInfo());
		}
		return trainingDTO;
	}

	public static Training toEntity(TrainingDTO trainingDTO) {
		Training training = null;
		if (trainingDTO != null) {
			training = new Training();
			training.setTrainingId(trainingDTO.getTrainingId());
			training.setInfo(trainingDTO.getInfo());
			training.setPlayerId(trainingDTO.getPlayerId());
		}
		return training;
	}

	public static List<TrainingDTO> toListDTO(List<Training> list) {
		List<TrainingDTO> listTrainingDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Training training : list) {
				listTrainingDTO.add(ConverterTraining.toDTO(training));
			}
		}
		return listTrainingDTO;
	}

	public static List<Training> toListEntity(List<TrainingDTO> listTrainingDTO) {
		List<Training> list = new ArrayList<>();
		if (!listTrainingDTO.isEmpty()) {
			for (TrainingDTO trainingDTO : listTrainingDTO) {
				list.add(ConverterTraining.toEntity(trainingDTO));
			}
		}
		return list;
	}
}
