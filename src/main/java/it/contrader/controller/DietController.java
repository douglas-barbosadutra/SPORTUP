package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.converter.ConverterDaily;
import it.contrader.dto.DailyDTO;
import it.contrader.dto.DietDTO;
import it.contrader.dto.PlayerDTO;
import it.contrader.model.Daily;
import it.contrader.model.Diet;
import it.contrader.services.DailyService;
import it.contrader.services.DietService;
import it.contrader.services.PlayerService;
import it.contrader.services.UserService;

@CrossOrigin(origins= "*")
@RestController
@RequestMapping("/Diet") 
public class DietController {

	private final DietService dietService;
	private final PlayerService playerService;
	private final DailyService dailyService;

	@Autowired
	public DietController(DietService dietService, PlayerService playerService, DailyService dailyService) {
		this.dietService = dietService;
		this.playerService = playerService;
		this.dailyService = dailyService;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	private List<DailyDTO> visualDiet(@RequestParam(value = "playerId") int idPlayer) {
		PlayerDTO playerDTO = playerService.getPlayerDTOById(idPlayer);
		int idDiet = playerDTO.getIdDiet();
		Diet diet = new Diet();
		diet.setIdDiet(idDiet);
		List<DailyDTO> listDaily = dailyService.findAllByDiet(diet);
		return listDaily;	
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public boolean updateDay(@RequestParam(value = "idDay") int idDay,@RequestParam(value = "breakfast") String breakfast, 
			@RequestParam(value = "snack") String snack, @RequestParam(value = "lunch") String lunch, 
			@RequestParam(value = "snackAfternoon") String snackAfternoon, @RequestParam(value = "dinner") String dinner) {

		DailyDTO dailyDTO = new DailyDTO();
		System.out.println("yaaaaa " + breakfast);
		dailyDTO.setIdDay(idDay);
		dailyDTO.setBreakfast(breakfast);
		dailyDTO.setSnack(snack);
		dailyDTO.setLunch(lunch);
		dailyDTO.setSnackAfternoon(snackAfternoon);
		dailyDTO.setDinner(dinner);
		
		return dailyService.updateDay(ConverterDaily.toEntity(dailyDTO));
		
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam(value = "dietId") int idDiet) {
		dietService.deleteDietById(idDiet);
	}

}
