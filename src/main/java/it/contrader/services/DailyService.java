package it.contrader.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterDaily;
import it.contrader.dto.DailyDTO;
import it.contrader.model.Daily;
import it.contrader.model.Diet;
import it.contrader.dao.DailyRepository;

@Service
public class DailyService {

	private final DailyRepository dailyRepository;

	@Autowired
	public DailyService(DailyRepository dailyRepository) {
		this.dailyRepository = dailyRepository;
	}

	public boolean insertDaily(Daily daily) {
		dailyRepository.save(daily);
		return true;
	}
	
	public List<DailyDTO> findAllByDiet(Diet diet){
		return ConverterDaily.toListDTO(dailyRepository.findAllByDiet(diet));
	}
	
	public boolean updateDay(Daily daily) {
		dailyRepository.updateDay(daily.getBreakfast(), daily.getSnack(), daily.getLunch(), daily.getSnackAfternoon(), daily.getDinner(), daily.getIdDay());
		return true;
	}

}
