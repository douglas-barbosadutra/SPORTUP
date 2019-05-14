package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String training(HttpServletRequest request) {
		List<TrainingDTO> allTraining = this.trainingService.getListaTrainingDTO();
		request.setAttribute("allTrainingDTO", allTraining);
		return "trainerTraining";

	}
/*
	@RequestMapping(value = "/team", method = RequestMethod.GET)
	public String team(HttpServletRequest request) {
		List<TeamDTO> allTeam = this.teamService.getListaTeamDTO();
		request.setAttribute("allTeamDTO", allTeam);
		return "trainerTeam";

	}
*/
	
	@RequestMapping(value = "/biomedicalData", method = RequestMethod.GET)
	public String biomedicalData(HttpServletRequest request) {
		//System.out.println(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		PlayerDTO playerDTO = this.playerService.getPlayerDTOById(id);
		BiomedicalDataDTO bData = new BiomedicalDataDTO();
		bData =biomedicalDataService.getBiomedicalDataDTOById(playerDTO.getIdBiomedicalData());
		request.setAttribute("bDATA", bData);
		return "trainerBiomedicalData";

	}
	
	@RequestMapping(value = "/performance", method = RequestMethod.GET)
	public String performance(HttpServletRequest request) {
		//System.out.println(request.getParameter("id"));
		int id = Integer.parseInt(request.getParameter("id"));
		PlayerDTO playerDTO = this.playerService.getPlayerDTOById(id);
		PerformanceDTO perfDTO = new PerformanceDTO();
		perfDTO = performanceService.getPerformanceDTOById(playerDTO.getIdPerformance());
		request.setAttribute("perfDTO", perfDTO);
		return "trainerPerformance";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		return "index";

	}
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String indietro(HttpServletRequest request) {
		return "homeTrainer";

	}
}