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
		}
		return dietDTO;
	}

	public static Diet toEntity(DietDTO dietDTO) {
		Diet diet = null;
		if (dietDTO != null) {
			diet = new Diet();
			diet.setIdDiet(dietDTO.getIdDiet());
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
