
package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.PerformanceDTO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.BiomedicalDataService;
import it.contrader.services.PerformanceService;
import it.contrader.services.PlayerService;
import it.contrader.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Performance")
public class PerformanceController {

	private final PerformanceService performanceService;
	private final PlayerService playerService;

	@Autowired
	public PerformanceController(PerformanceService performanceService, PlayerService playerService) {
		this.performanceService = performanceService;
		this.playerService = playerService;
	}




/*	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		performanceService.deletePerformanceById((int)request.getAttribute("idPerf"));
		return "homeTrainer";

	}
*/

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public PerformanceDTO update(@RequestParam(value = "performanceId") int idPerformance,
			@RequestParam(value = "maxCorsaMin") int maxCorsaMin,
			@RequestParam(value = "maxFlessioni") int maxFlessioni,
			@RequestParam(value = "maxAddominali") int maxAddominali) {
		PerformanceDTO perfDTO = new PerformanceDTO();
		perfDTO.setIdPerformance(idPerformance);
		perfDTO.setMaxCorsaMin(maxCorsaMin);
		perfDTO.setMaxFlessioni(maxFlessioni);
		perfDTO.setMaxAddominali(maxAddominali);
		performanceService.insertPerformance(perfDTO);
		return perfDTO;
	}
	
/*
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String back(HttpServletRequest request) {
		return "homeTrainer";
	}
*/
	
	@RequestMapping(value = "/getPerformance", method = RequestMethod.POST)
	private PerformanceDTO getPerformance(@RequestParam(value = "playerId") int idPlayer) {

		PlayerDTO playerDTO = playerService.getPlayerDTOById(idPlayer);
		PerformanceDTO perfDTO = performanceService.getPerformanceDTOById(playerDTO.getIdPerformance());
		return perfDTO;
	}
	
}
