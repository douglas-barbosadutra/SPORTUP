
package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.PerformanceDTO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.BiomedicalDataService;
import it.contrader.services.PerformanceService;
import it.contrader.services.PlayerService;
import it.contrader.services.UserService;

@Controller
@RequestMapping("/Performance")
public class PerformanceController {

	private final PerformanceService performanceService;
	private final PlayerService playerService;

	@Autowired
	public PerformanceController(PerformanceService performanceService, PlayerService playerService) {
		this.performanceService = performanceService;
		this.playerService = playerService;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	private void visualBiomedicalData(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		PerformanceDTO perfDTO = (PerformanceDTO) this.performanceService.getPerformanceDTOById(id);
		request.setAttribute("perfDTO", perfDTO);
	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		return "trainerTeam";

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		performanceService.deletePerformanceById((int)request.getAttribute("idPerf"));
		return "homeTrainer";

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		PerformanceDTO perfDTO = new PerformanceDTO();
		perfDTO.setIdPerformance(Integer.parseInt(request.getParameter("idPerf")));
		perfDTO.setMaxCorsaMin(Integer.parseInt(request.getParameter("maxCorsaMin")));
		perfDTO.setMaxFlessioni(Integer.parseInt(request.getParameter("maxFlessioni")));
		perfDTO.setMaxAddominali(Integer.parseInt(request.getParameter("maxAddominali")));
		performanceService.insertPerformance(perfDTO);
		return "homeTrainer";
	}
	
	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String back(HttpServletRequest request) {
		return "homeTrainer";

	}
	
	@RequestMapping(value = "/getPerformance", method = RequestMethod.POST)
	private String getPerformance(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));

		PlayerDTO playerDTO = playerService.getPlayerDTOById(id);
		PerformanceDTO perfDTO = performanceService.getPerformanceDTOById(playerDTO.getIdPerformance());

		request.setAttribute("abdominal", perfDTO.getMaxAddominali());
		request.setAttribute("run", perfDTO.getMaxCorsaMin());
		request.setAttribute("pushups", perfDTO.getMaxFlessioni());

		return "performance";
	}
	
}
