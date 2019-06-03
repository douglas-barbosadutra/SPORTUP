package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.DailyDTO;
import it.contrader.model.Daily;

public class ConverterDaily {

	public static DailyDTO toDTO(Daily daily) {
		DailyDTO dailyDTO = null;
		if (daily != null) {
			dailyDTO = new DailyDTO();
			dailyDTO.setIdDay(daily.getIdDay());
			dailyDTO.setDay(daily.getDay());
			dailyDTO.setBreakfast(daily.getBreakfast());
			dailyDTO.setSnack(daily.getSnack());
			dailyDTO.setLunch(daily.getLunch());
			dailyDTO.setSnackAfternoon(daily.getSnackAfternoon());
			dailyDTO.setDinner(daily.getDinner());
			dailyDTO.setDiet(daily.getDiet());
		}

		return dailyDTO;
	}

	public static Daily toEntity(DailyDTO dailyDTO) {
		Daily daily = null;
		if (dailyDTO != null) {
			daily = new Daily();
			daily.setIdDay(dailyDTO.getIdDay());
			daily.setDay(dailyDTO.getDay());
			daily.setBreakfast(dailyDTO.getBreakfast());
			daily.setSnack(dailyDTO.getSnack());
			daily.setLunch(dailyDTO.getLunch());
			daily.setSnackAfternoon(dailyDTO.getSnackAfternoon());
			daily.setDinner(dailyDTO.getDinner());
			daily.setDiet(dailyDTO.getDiet());
		}
		return daily;
	}

	public static List<DailyDTO> toListDTO(List<Daily> list) {
		List<DailyDTO> listDailyDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Daily daily : list) {
				listDailyDTO.add(ConverterDaily.toDTO(daily));
			}
		}
		return listDailyDTO;
	}

	public static List<Daily> toListEntity(List<DailyDTO> listDailyDTO) {
		List<Daily> list = new ArrayList<>();
		if (!listDailyDTO.isEmpty()) {
			for (DailyDTO dailyDTO : listDailyDTO) {
				list.add(ConverterDaily.toEntity(dailyDTO));
			}
		}
		return list;
	}
}
