
package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.services.PlayerService;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.TrainingDTO;
import it.contrader.services.TeamService;


@Controller
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
	private String visualTeam(HttpServletRequest request){
		List<TeamDTO> allTeam = this.teamService.getListaTeamDTO();
		request.setAttribute("allTeamDTO", allTeam);
		return "trainerTeam";

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(HttpServletRequest request) {
		return "trainerTeam";

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		TeamDTO teamDTO = this.teamService.getTeamDTOById(id);
		teamDTO.setInfo(request.getParameter("info"));
		teamService.insertTeam(teamDTO);
		visualTeam(request);
		return "trainerTeam";

	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.teamService.deleteTeamById(id);
		visualTeam(request);
		return "trainerTeam";

	}
	
	@RequestMapping(value = "/creaTeam", method = RequestMethod.GET)
	public String insertTeam(HttpServletRequest request) {
		//int id = Integer.parseInt(request.getParameter("id"));
		String info = request.getParameter("info");
		

		TeamDTO teamObj = new TeamDTO();
		teamObj.setInfo(info);
		
		teamService.insertTeam(teamObj);

		visualTeam(request);
		return "trainerTeam";
	}
	
	
	@RequestMapping(value = "/assign", method = RequestMethod.GET)
	public String assign(HttpServletRequest request) {
		int idTeam = Integer.parseInt(request.getParameter("idTeam"));
		int idPlayer = Integer.parseInt(request.getParameter("idPlayer"));
		teamService.assignTeam(idTeam, idPlayer);
		return "trainerTeam";
	}
	
}
