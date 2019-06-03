
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
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.BiomedicalDataService;
import it.contrader.services.PlayerService;
import it.contrader.services.UserService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/BiomedicalData")
public class BiomedicalDataController {

	private final BiomedicalDataService biomedicalDataService;
	private final PlayerService playerService;

	@Autowired
	public BiomedicalDataController(BiomedicalDataService biomedicalDataService, PlayerService playerService) {
		this.biomedicalDataService = biomedicalDataService;
		this.playerService = playerService;
	}
	
	

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public BiomedicalDataDTO update(@RequestParam(value = "biomedicalDataId") int id,
			@RequestParam(value = "bloodPressure") int bloodPressure,
			@RequestParam(value = "heartbeat") int heartbeat,
			@RequestParam(value = "height") float height,
			@RequestParam(value = "weight") float weight,
			@RequestParam(value = "fatMass") float fatMass,
			@RequestParam(value = "fatFreeMass") float fatFreeMass){
		BiomedicalDataDTO biomedicalDataDTO = this.biomedicalDataService.getBiomedicalDataDTOById(id);
		biomedicalDataDTO.setBloodPressure(bloodPressure);
		biomedicalDataDTO.setHearthbeat(heartbeat);
		biomedicalDataDTO.setHeight(height);
		biomedicalDataDTO.setWeight(weight);
		biomedicalDataDTO.setFatMass(fatMass);
		biomedicalDataDTO.setFatFreeMass(fatFreeMass);
		biomedicalDataService.insertBiomedicalData(biomedicalDataDTO);
		return biomedicalDataDTO;
	}
	
	@RequestMapping(value = "/getBiomedical", method = RequestMethod.POST)
	private BiomedicalDataDTO visualBiomedicalData(@RequestParam(value = "playerId") int id) {

		PlayerDTO playerDTO = playerService.getPlayerDTOById(id);
		//request.setAttribute("id", id);
		BiomedicalDataDTO allBiomedicalData = biomedicalDataService
				.getBiomedicalDataDTOById(playerDTO.getIdBiomedicalData());
		return allBiomedicalData;

	}
	
}
