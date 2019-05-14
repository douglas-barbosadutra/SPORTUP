package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dao.PlayerRepository;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.TrainingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.PlayerService;
import it.contrader.services.TrainingService;
import it.contrader.services.UserService;

import java.util.List;


@Controller
@RequestMapping("/Player")
public class PlayerController {

	private final TrainingService trainingService;
	private final PlayerService playerService;
	private HttpSession session;

	@Autowired
	public PlayerController(PlayerService playerService, TrainingService trainingService) {
		this.trainingService = trainingService;
		this.playerService = playerService;
	}
	

	private void visualPlayer(HttpServletRequest request){
		List<PlayerDTO> allPlayer = this.playerService.getListaPlayerDTO();
		request.setAttribute("allPlayerDTO", allPlayer);
	}
	
	@RequestMapping(value = "/playerManagement", method = RequestMethod.GET)
	public String playerManagement(HttpServletRequest request) {
		visualPlayer(request);
		return "homePlayer";		
	}
	
	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	public String getInfo(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));

		PlayerDTO playerDTO = playerService.getPlayerDTOById(id);

		request.setAttribute("type", playerDTO.getRuolo());

		request.setAttribute("idTraining", playerDTO.getIdTraining());

		request.setAttribute("info", playerDTO.getInfo());
		
		request.setAttribute("idBio", playerDTO.getIdBiomedicalData());
	

		return "homeInfoPlayer";
	}

	@RequestMapping(value = "/addInfo", method = RequestMethod.POST)
	public String addInfo(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));

		String info = request.getParameter("info");

		PlayerDTO playerDTO = playerService.getPlayerDTOById(id);

		playerDTO.setInfo(info);

		playerService.insertPlayer(playerDTO);
		request.setAttribute("id", id);
		
		return "homePlayer";

	}
	
	@RequestMapping(value = "/getTraining", method = RequestMethod.POST)
	public String getTraining(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));

		PlayerDTO playerDTO = playerService.getPlayerDTOById(id);

		TrainingDTO trainingDTO = trainingService.getTrainingDTOById(playerDTO.getIdTraining());

		request.setAttribute("info", trainingDTO.getInfo());

		request.setAttribute("id", trainingDTO.getIdTraining());

		return "infoTraining";

	}

	@RequestMapping(value = "/logOut")
	public String logOut() {

		return "index";
	}
	
}
