package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.BiomedicalDataDTO;
import it.contrader.dto.DietDTO;
import it.contrader.dto.PerformanceDTO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Daily;
import it.contrader.services.BiomedicalDataService;
import it.contrader.services.DailyService;
import it.contrader.services.DietService;
import it.contrader.services.PerformanceService;
import it.contrader.services.PlayerService;
import it.contrader.services.UserService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private final PlayerService playerService;
	private final BiomedicalDataService biomedicalDataService;
	private final PerformanceService performanceService;
	private final DietService dietService;
	private final DailyService dailyService;
	
	@Autowired
	public UserController(UserService userService, PlayerService playerService, BiomedicalDataService biomedicalDataService, PerformanceService performanceService, DietService dietService, DailyService dailyService) {
		this.userService = userService;
		this.playerService = playerService;
		this.biomedicalDataService = biomedicalDataService;
		this.performanceService = performanceService;
		this.dietService = dietService;
		this.dailyService = dailyService;
	}
		
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public List<UserDTO> userManagement(HttpServletRequest request) {
		return this.userService.getListaUserDTO();		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public void delete(@RequestParam(value = "userId") int id) {
		this.userService.deleteUserById(id);
	}
	
	@RequestMapping(value = "/assignType", method = RequestMethod.GET)
	public void assignType(@RequestParam(value = "userId") int id, @RequestParam(value = "type") String type) {
		UserDTO userObj = this.userService.getUserDTOById(id);
		userObj.setType(type);
		
		if (userObj.getType().equals("trainer")){
			this.userService.updateUser(userObj);
		}else if (userObj.getType().equals("nutritionist")){
				this.userService.updateUser(userObj);
		} else if (userObj.getType().equals("player")) {
			this.userService.updateUser(userObj);
			
			int idUser = userObj.getIdUser();
			
			/** CREA BIO DATA **/
			BiomedicalDataDTO bioDTO = new BiomedicalDataDTO();
			biomedicalDataService.insertBiomedicalData(bioDTO);
			List<BiomedicalDataDTO> listBioDTO = biomedicalDataService.getListaBiomedicalDataDTO();
			int idBio = 0;
			for (int i=0; i<listBioDTO.size(); i++) {
				if(listBioDTO.get(i).getIdBiomedicalData()>idBio) idBio = listBioDTO.get(i).getIdBiomedicalData();
			}
			
			/** CREA DIETA **/			
			DietDTO dietDTO = new DietDTO();
			dietService.insertDiet(dietDTO);
			List<DietDTO> listDietDTO = dietService.getListaDietDTO();
			int idDiet = 0;
			for (int i=0; i<listDietDTO.size(); i++) {
				if(listDietDTO.get(i).getIdDiet()>idDiet) idDiet = listDietDTO.get(i).getIdDiet();
			}
			System.out.println("iddiet " + idDiet);
			Daily daily1 = new Daily("monday", idDiet);
			Daily daily2 = new Daily("tuesday", idDiet);
			Daily daily3 = new Daily("wednesday", idDiet);
			Daily daily4 = new Daily("thursday", idDiet);
			Daily daily5 = new Daily("friday", idDiet);
			Daily daily6 = new Daily("saturday", idDiet);
			Daily daily7 = new Daily("sunday", idDiet);
			dailyService.insertDaily(daily1);
			dailyService.insertDaily(daily2);
			dailyService.insertDaily(daily3);
			dailyService.insertDaily(daily4);
			dailyService.insertDaily(daily5);
			dailyService.insertDaily(daily6);
			dailyService.insertDaily(daily7);
			
			/** CREA PERFORMANCE **/
			PerformanceDTO perfDTO = new PerformanceDTO();
			performanceService.insertPerformance(perfDTO);
			List<PerformanceDTO> listPerfDTO = performanceService.getListaPerformanceDTO();
			int idPerf = 0;
			for (int i=0; i<listPerfDTO.size(); i++) {
				if(listPerfDTO.get(i).getIdPerformance()>idPerf) idPerf = listPerfDTO.get(i).getIdPerformance();
			}
			
			PlayerDTO playerObj = new PlayerDTO();
			playerObj.setIdPlayer(idUser);
			playerObj.setInfo("no info");
			playerObj.setRuolo("pending");
			playerObj.setIdBiomedicalData(idBio);
			playerObj.setIdPerformance(idPerf);
			playerObj.setIdDiet(idDiet);
			playerObj.setIdTraining(1);
			
			playerService.addPlayer(playerObj);
		}
	}
		
	@RequestMapping(value = "/creaUser", method = RequestMethod.GET)
	public UserDTO insertUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
		String type = "pending";
		System.out.println("AAAOOOOOOOOOOOOOOOOOOOO");
		UserDTO userObj = new UserDTO( username, password, type);
		userService.insertUser(userObj);
		return userObj;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public UserDTO loginControl(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String ruolo = userDTO.getType();
		if (!StringUtils.isEmpty(ruolo)) {
			return userDTO;
		}
		return null;
	}
	
	@RequestMapping(value = "/getUser", method = RequestMethod.GET)
	public UserDTO loginControl(@RequestParam(value = "idUser") int id) {
		final UserDTO userDTO = userService.getUserDTOById(id);
		return userDTO;
	}
	
	

}
