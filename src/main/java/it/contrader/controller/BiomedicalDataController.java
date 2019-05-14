
package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.BiomedicalDataDTO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.BiomedicalDataService;
import it.contrader.services.PlayerService;
import it.contrader.services.UserService;

@Controller
@RequestMapping("/BiomedicalData")
public class BiomedicalDataController {

	private final BiomedicalDataService biomedicalDataService;
	private final PlayerService playerService;

	@Autowired
	public BiomedicalDataController(BiomedicalDataService biomedicalDataService, PlayerService playerService) {
		this.biomedicalDataService = biomedicalDataService;
		this.playerService = playerService;
	}

	/*
	@RequestMapping(value = "/view", method = RequestMethod.GET)
	private void visualBiomedicalData(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		List<BiomedicalDataDTO> allBiomedicalData = (List<BiomedicalDataDTO>) this.biomedicalDataService.getBiomedicalDataDTOById(id);
		request.setAttribute("allBiomedicalDataDTO", allBiomedicalData);
	}
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		return "trainerTeam";

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		return "trainerBiomedicalData";

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		BiomedicalDataDTO biomedicalDataDTO = this.biomedicalDataService.getBiomedicalDataDTOById(id);
		biomedicalDataDTO.setBloodPressure(Integer.parseInt(request.getParameter("blood_pressure")));
		biomedicalDataDTO.setHearthbeat(Integer.parseInt(request.getParameter("heartbeat")));
		biomedicalDataDTO.setHeight(Float.parseFloat(request.getParameter("height")));
		biomedicalDataDTO.setWeight(Float.parseFloat(request.getParameter("weight")));
		biomedicalDataDTO.setFatMass(Float.parseFloat(request.getParameter("fat_mass")));
		biomedicalDataDTO.setFatFreeMass(Float.parseFloat(request.getParameter("fat_free_mass")));
		biomedicalDataService.insertBiomedicalData(biomedicalDataDTO);
		request.setAttribute("bDATA", biomedicalDataDTO);
		return "trainerBiomedicalData";
	}
	
	@RequestMapping(value = "/getBiomedical", method = RequestMethod.POST)
	private String visualBiomedicalData(HttpServletRequest request) {

		int id = Integer.parseInt(request.getParameter("id"));

		PlayerDTO playerDTO = playerService.getPlayerDTOById(id);

		request.setAttribute("id", id);
		BiomedicalDataDTO allBiomedicalData = biomedicalDataService
				.getBiomedicalDataDTOById(playerDTO.getIdBiomedicalData());

		request.setAttribute("bloodPressure", allBiomedicalData.getBloodPressure());
		request.setAttribute("deleted", allBiomedicalData.getDeleted());
		request.setAttribute("fatFreeMass", allBiomedicalData.getFatFreeMass());
		request.setAttribute("fatMass", allBiomedicalData.getFatMass());
		request.setAttribute("hearthBeat", allBiomedicalData.getHearthbeat());
		request.setAttribute("height", allBiomedicalData.getHeight());
		request.setAttribute("weight", allBiomedicalData.getWeight());

		return "PlayerBiomedicalData";

	}
	
}
