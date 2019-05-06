package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TrainingCardDTO;
import it.contrader.model.TrainingCard;

public class ConverterTrainingCard {

	public static TrainingCardDTO toDTO(TrainingCard t_card) {
		TrainingCardDTO t_cardDTO = null;
		if (t_card != null) {
			t_cardDTO = new TrainingCardDTO();
			t_cardDTO.setId_training(t_card.getId_training_card());
			t_cardDTO.setId_training_card(t_card.getId_training_card());
			t_cardDTO.setMonday(t_card.getMonday());
			t_cardDTO.setTuesday(t_card.getTuesday());
			t_cardDTO.setWednesday(t_card.getWednesday());
			t_cardDTO.setThursday(t_card.getThursday());
			t_cardDTO.setFriday(t_card.getFriday());
			t_cardDTO.setSaturday(t_card.getSaturday());
			t_cardDTO.setSunday(t_card.getSunday());
			t_cardDTO.setDeleted(t_card.getDeleted());
		}
		return t_cardDTO;
	}

	public static TrainingCard toEntity(TrainingCardDTO t_cardDTO) {
		TrainingCard t_card = null;
		if (t_cardDTO != null) {
			t_card = new TrainingCard();
			t_card.setId_training(t_cardDTO.getId_training_card());
			t_card.setId_training_card(t_cardDTO.getId_training_card());
			t_card.setMonday(t_cardDTO.getMonday());
			t_card.setTuesday(t_cardDTO.getTuesday());
			t_card.setWednesday(t_cardDTO.getWednesday());
			t_card.setThursday(t_cardDTO.getThursday());
			t_card.setFriday(t_cardDTO.getFriday());
			t_card.setSaturday(t_cardDTO.getSaturday());
			t_card.setSunday(t_cardDTO.getSunday());
			t_card.setDeleted(t_cardDTO.getDeleted());
		}
		return t_card;
	}

	public static List<TrainingCardDTO> toListDTO(List<TrainingCard> list) {
		List<TrainingCardDTO> listT_cardDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (TrainingCard t_card : list) {
				listT_cardDTO.add(ConverterTrainingCard.toDTO(t_card));
			}
		}
		return listT_cardDTO;
	}

	public static List<TrainingCard> toList(List<TrainingCardDTO> listDTO) {
		List<TrainingCard> listT_card = new ArrayList<>();
		if (!listDTO.isEmpty()) {
			for (TrainingCardDTO t_cardDTO : listDTO) {
				listT_card.add(ConverterTrainingCard.toEntity(t_cardDTO));
			}
		}
		return listT_card;
	}
}
