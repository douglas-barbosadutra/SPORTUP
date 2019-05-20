
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

import it.contrader.services.PlayerService;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.TrainingDTO;
import it.contrader.services.TeamService;


@CrossOrigin
@RestController
@RequestMapping("/Team")
public class TeamController {

	private final TeamService teamService;
	private final PlayerService playerService;

	@Autowired
	public TeamController(TeamService teamService, PlayerService playerService) {
		this.teamService = teamService;
		this.playerService = playerService;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	private List<TeamDTO> visualTeam(HttpServletRequest request){
		
		return this.teamService.getListaTeamDTO();

	}

/*
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(HttpServletRequest request) {
		return "trainerTeam";

	}
*/
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public TeamDTO update(@RequestParam(value = "teamId") int idTeam,
			@RequestParam(value = "info") String info) {
		
		TeamDTO teamDTO = this.teamService.getTeamDTOById(idTeam);
		teamDTO.setInfo(info);
		teamService.insertTeam(teamDTO);
		return teamDTO;

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam(value = "teamId") int idTeam) {

		this.teamService.deleteTeamById(idTeam);
	}
	
	@RequestMapping(value = "/creaTeam", method = RequestMethod.GET)
	public TeamDTO insertTeam(@RequestParam(value = "info") String info) {		

		TeamDTO teamDTO = new TeamDTO();
		teamDTO.setInfo(info);
		teamService.insertTeam(teamDTO);
		return teamDTO;
	}
	
	
	@RequestMapping(value = "/assign", method = RequestMethod.GET)
	public void assign(@RequestParam(value = "idTeam") int idTeam,
			@RequestParam(value = "idPlayer") int idPlayer) {
		
		teamService.assignTeam(idTeam, idPlayer);
	}
	
}
