
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

import it.contrader.dto.BiomedicalDataDTO;
import it.contrader.dto.DietDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Diet;
import it.contrader.dto.PlayerDTO;
import it.contrader.services.BiomedicalDataService;
import it.contrader.services.DietService;
import it.contrader.services.UserService;
import it.contrader.services.PlayerService;

@CrossOrigin
@RestController
@RequestMapping("/Diet")
public class DietController {

	private final DietService dietService;
	private final PlayerService playerService;
	private final UserService userService;

	@Autowired
	public DietController(DietService dietService, PlayerService playerService, UserService userService) {
		this.dietService = dietService;
		this.playerService = playerService;
		this.userService = userService;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	private DietDTO visualDiet(@RequestParam(value = "playerId") int idPlayer){
	
		//request.setAttribute("idPlayer", idPlayer);
		PlayerDTO player = playerService.getPlayerDTOById(idPlayer);
		int idDiet = player.getIdDiet();
		DietDTO dietDTO = new DietDTO();
		dietDTO = dietService.getDietDTOById(idDiet);
		return dietDTO;
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public DietDTO insert(@RequestParam(value = "dietId") int idDiet,
			@RequestParam(value = "monday") String monday,
			@RequestParam(value = "tuesday") String tuesday,
			@RequestParam(value = "wednesday") String wednesday,
			@RequestParam(value = "thursday") String thursday,
			@RequestParam(value = "friday") String friday,
			@RequestParam(value = "saturday") String saturday,
			@RequestParam(value = "sunday") String sunday) {
		
		DietDTO dietDTO = dietService.getDietDTOById(idDiet);
		dietDTO.setMonday(monday);
		dietDTO.setTuesday(tuesday);
		dietDTO.setWednesday(wednesday);
		dietDTO.setThursday(thursday);
		dietDTO.setFriday(friday);
		dietDTO.setSaturday(saturday);
		dietDTO.setSunday(sunday);
		dietService.insertDiet(dietDTO);
		//request.setAttribute("userListDTO", userService.getListaUserDTO());
		return dietDTO;
	}
	
/*
	@RequestMapping(value = "/noDiet", method = RequestMethod.GET)
	public String noDiet(HttpServletRequest request) {
		int idDiet = (int) request.getAttribute("idDiet");
		request.setAttribute("idDiet", idDiet);
		DietDTO dietDTO = dietService.getDietDTOById(idDiet);
		
		dietDTO.setMonday("free");
		dietDTO.setMonday("free");
		dietDTO.setMonday("free");
		dietDTO.setMonday("free");
		dietDTO.setMonday("free");
		dietDTO.setMonday("free");
		dietDTO.setMonday("free");
		
		dietService.updateDiet(dietDTO);
		
		return "homeNutritionist";
	}
*/
	
/*	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idDiet = (int) request.getAttribute("idDiet");
		request.setAttribute("idDiet", idDiet);
		dietService.deleteDietById(idDiet);
		
		return "trainerBiomedicalData";

	}
*/

	
}
