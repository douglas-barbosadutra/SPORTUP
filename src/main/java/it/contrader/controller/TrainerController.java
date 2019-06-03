package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import it.contrader.dto.BiomedicalDataDTO;
import it.contrader.dto.PerformanceDTO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.TrainingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.UserService;
import it.contrader.services.TrainingService;
import it.contrader.services.BiomedicalDataService;
import it.contrader.services.PerformanceService;
import it.contrader.services.PlayerService;

@CrossOrigin(origins = "*")
@Controller
@RequestMapping("/Trainer")
public class TrainerController {

	private final UserService userService;
	private final TrainingService trainingService;
	private final BiomedicalDataService biomedicalDataService;
	private final PlayerService playerService;
	private final PerformanceService performanceService;

	@Autowired
	public TrainerController(UserService userService, TrainingService trainingService, BiomedicalDataService biomedicalDataService, PlayerService playerService, PerformanceService performanceService) {
		this.userService = userService;
		this.trainingService = trainingService;
		this.biomedicalDataService = biomedicalDataService;
		this.playerService = playerService;
		this.performanceService = performanceService;
	}

	@RequestMapping(value = "/training", method = RequestMethod.GET)
	public List<TrainingDTO> training(HttpServletRequest request) {
		List<TrainingDTO> allTraining = this.trainingService.getListaTrainingDTO();
		return allTraining;

	}
	
	@RequestMapping(value = "/biomedicalData", method = RequestMethod.GET)
	public BiomedicalDataDTO biomedicalData(@RequestParam(value = "idPlayer") int idPlayer) {
		PlayerDTO playerDTO = this.playerService.getPlayerDTOById(idPlayer);
		BiomedicalDataDTO bData = new BiomedicalDataDTO();
		bData = biomedicalDataService.getBiomedicalDataDTOById(playerDTO.getIdBiomedicalData());
		return bData;
	}
	
	@RequestMapping(value = "/performance", method = RequestMethod.GET)
	public PerformanceDTO performance(@RequestParam(value = "idPlayer") int idPlayer) {
		PlayerDTO playerDTO = this.playerService.getPlayerDTOById(idPlayer);
		PerformanceDTO perfDTO = new PerformanceDTO();
		perfDTO = performanceService.getPerformanceDTOById(playerDTO.getIdPerformance());
		return perfDTO;
	}

	/*
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "index";

	}
	*/
	/*
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String indietro(HttpServletRequest request) {
		return "homeTrainer";
	}
	*/
}