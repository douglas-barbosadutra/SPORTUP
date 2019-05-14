package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DietDTO;
import it.contrader.model.Diet;

public class ConverterDiet {

	public static DietDTO toDTO(Diet diet) {
		DietDTO dietDTO = null;
		if (diet != null) {
			dietDTO = new DietDTO();
			dietDTO.setIdDiet(diet.getIdDiet());
			dietDTO.setMonday(diet.getMonday());
			dietDTO.setTuesday(diet.getTuesday());
			dietDTO.setWednesday(diet.getWednesday());
			dietDTO.setThursday(diet.getThursday());
			dietDTO.setFriday(diet.getFriday());
			dietDTO.setSaturday(diet.getSaturday());
			dietDTO.setSunday(diet.getSunday());
			//dietDTO.setIdDietC(trainingCard.getIdDietC());
			
		}
		return dietDTO;
	}

	public static Diet toEntity(DietDTO dietDTO) {
		Diet diet = null;
		if (dietDTO != null) {
			diet = new Diet();
			diet.setIdDiet(dietDTO.getIdDiet());
			diet.setMonday(dietDTO.getMonday());
			diet.setTuesday(dietDTO.getTuesday());
			diet.setWednesday(dietDTO.getWednesday());
			diet.setThursday(dietDTO.getThursday());
			diet.setFriday(dietDTO.getFriday());
			diet.setSaturday(dietDTO.getSaturday());
			diet.setSunday(dietDTO.getSunday());
			//diet.setIdDietC(dietDTO.getIdDietC());
			
		}
		return diet;
	}

	public static List<DietDTO> toListDTO(List<Diet> list) {
		List<DietDTO> listDietDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Diet diet : list) {
				listDietDTO.add(ConverterDiet.toDTO(diet));
			}
		}
		return listDietDTO;
	}

	public static List<Diet> toListEntity(List<DietDTO> listDietDTO) {
		List<Diet> list = new ArrayList<>();
		if (!listDietDTO.isEmpty()) {
			for (DietDTO dietDTO : listDietDTO) {
				list.add(ConverterDiet.toEntity(dietDTO));
			}
		}
		return list;
	}
}
