
package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.BiomedicalDataDTO;
import it.contrader.dto.DietDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Diet;
import it.contrader.dto.PlayerDTO;
import it.contrader.services.BiomedicalDataService;
import it.contrader.services.DietService;
import it.contrader.services.UserService;
import it.contrader.services.PlayerService;

@Controller
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
	private String visualDiet(HttpServletRequest request){
		int idPlayer = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("idPlayer", idPlayer);
		PlayerDTO player = playerService.getPlayerDTOById(idPlayer);
		int idDiet = player.getIdDiet();
		request.setAttribute("idDiet", idDiet);
		DietDTO dietDTO = new DietDTO();
		dietDTO = dietService.getDietDTOById(idDiet);
		request.setAttribute("dietDTO", dietDTO);
		return "dietView";
	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		int idDiet = Integer.parseInt(request.getParameter("idDiet"));
		request.setAttribute("idDiet", idDiet);
		DietDTO dietDTO = dietService.getDietDTOById(idDiet);
		
		dietDTO.setMonday(request.getParameter("monday").toString());
		dietDTO.setTuesday(request.getParameter("tuesday").toString());
		dietDTO.setWednesday(request.getParameter("wednesday").toString());
		dietDTO.setThursday(request.getParameter("thursday").toString());
		dietDTO.setFriday(request.getParameter("friday").toString());
		dietDTO.setSaturday(request.getParameter("saturday").toString());
		dietDTO.setSunday(request.getParameter("sunday").toString());
		
		dietService.insertDiet(dietDTO);
		request.setAttribute("userListDTO", userService.getListaUserDTO());
		return "homeNutritionist";
	}
	
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
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int idDiet = (int) request.getAttribute("idDiet");
		request.setAttribute("idDiet", idDiet);
		dietService.deleteDietById(idDiet);
		
		return "trainerBiomedicalData";

	}

	@RequestMapping(value = "/back", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		return "homeNutritionist";
	}
	
}
