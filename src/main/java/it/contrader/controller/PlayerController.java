package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dao.PlayerRepository;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.TrainingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.PlayerService;
import it.contrader.services.TrainingService;
import it.contrader.services.UserService;

import java.util.List;


@CrossOrigin
@RestController
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
	
/*
	private void visualPlayer(HttpServletRequest request){
		List<PlayerDTO> allPlayer = this.playerService.getListaPlayerDTO();
		request.setAttribute("allPlayerDTO", allPlayer);
	}
*/
	
	@RequestMapping(value = "/playerManagement", method = RequestMethod.GET)
	public List<PlayerDTO> playerManagement(HttpServletRequest request) {
		
		return this.playerService.getListaPlayerDTO();		
	}
	
	@RequestMapping(value = "/getInfo", method = RequestMethod.POST)
	public PlayerDTO getInfo(@RequestParam(value = "playerId") int idPlayer) {

		PlayerDTO playerDTO = playerService.getPlayerDTOById(idPlayer);
		return playerDTO;
	}

	@RequestMapping(value = "/addInfo", method = RequestMethod.POST)
	public PlayerDTO addInfo(@RequestParam(value = "playerId") int idPlayer,
			@RequestParam(value = "info") String info) {
		PlayerDTO playerDTO = playerService.getPlayerDTOById(idPlayer);
		playerDTO.setInfo(info);
		playerService.insertPlayer(playerDTO);
		//request.setAttribute("id", id);	
		return playerDTO;
	}
	
	@RequestMapping(value = "/getTraining", method = RequestMethod.GET)
	public TrainingDTO getTraining(@RequestParam(value = "playerId") int idPlayer) {

		PlayerDTO playerDTO = playerService.getPlayerDTOById(idPlayer);
		TrainingDTO trainingDTO = trainingService.getTrainingDTOById(playerDTO.getIdTraining());
		return trainingDTO;
	}

/*
	@RequestMapping(value = "/logOut")
	public String logOut() {

		return "index";
	}
*/
	
}
