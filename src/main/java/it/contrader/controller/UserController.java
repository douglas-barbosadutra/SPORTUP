package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.PlayerRepository;
import it.contrader.dto.BiomedicalDataDTO;
import it.contrader.dto.DietDTO;
import it.contrader.dto.PerformanceDTO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Player;
import it.contrader.services.BiomedicalDataService;
import it.contrader.services.DietService;
import it.contrader.services.PerformanceService;
import it.contrader.services.PlayerService;
import it.contrader.services.UserService;

import java.util.List;


@Controller
@RequestMapping("/User")
public class UserController {

	private final UserService userService;
	private final PlayerService playerService;
	private final BiomedicalDataService biomedicalDataService;
	private final PerformanceService performanceService;
	private final DietService dietService;
	private HttpSession session;
	
	@Autowired
	public UserController(UserService userService, PlayerService playerService, BiomedicalDataService biomedicalDataService, PerformanceService performanceService, DietService dietService) {
		this.userService = userService;
		this.playerService = playerService;
		this.biomedicalDataService = biomedicalDataService;
		this.performanceService = performanceService;
		this.dietService = dietService;
	}
	

	private void visualUser(HttpServletRequest request){
		List<UserDTO> allUser = this.userService.getListaUserDTO();
		request.setAttribute("allUserDTO", allUser);
	}
	
	@RequestMapping(value = "/userManagement", method = RequestMethod.GET)
	public String userManagement(HttpServletRequest request) {
		visualUser(request);
		return "homeUser";		
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("id", id);
		this.userService.deleteUserById(id);
		visualUser(request);
		return "homeUser";
		
	}
	
	@RequestMapping(value = "/assign", method = RequestMethod.GET)
	public String assign(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type").toString();
		//System.out.println("AAAAAAAAAA "+request.getParameter("id"));
		request.setAttribute("id", id);
		this.userService.assignTypeById(id, type);
		visualUser(request);
		return "homeUser";
		
	}
	
	@RequestMapping(value = "/assignType", method = RequestMethod.GET)
	public String assignType(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		String type = request.getParameter("type").toString();
		
		request.setAttribute("id", id);
		UserDTO userObj = this.userService.getUserDTOById(id);
		userObj.setType(type);
		
		if (userObj.getType().equals("trainer")){
			this.userService.updateUser(userObj);
			visualUser(request);
			return "homeUser";
		}else if (userObj.getType().equals("nutritionist")){
				this.userService.updateUser(userObj);
				visualUser(request);
				return "homeUser";
		} else if (userObj.getType().equals("player")) {
			this.userService.updateUser(userObj);
			
			int idUser = userObj.getIdUser();
			String username = userObj.getUsername();
			String password = userObj.getPassword();
			
			BiomedicalDataDTO bioDTO = new BiomedicalDataDTO();
			biomedicalDataService.insertBiomedicalData(bioDTO);
			List<BiomedicalDataDTO> listBioDTO = biomedicalDataService.getListaBiomedicalDataDTO();
			int idBio = 0;
			for (int i=0; i<listBioDTO.size(); i++) {
				if(listBioDTO.get(i).getIdBiomedicalData()>idBio) idBio = listBioDTO.get(i).getIdBiomedicalData();
			}
			
			
			DietDTO dietDTO = new DietDTO();
			dietService.insertDiet(dietDTO);
			List<DietDTO> listDietDTO = dietService.getListaDietDTO();
			int idDiet = 0;
			for (int i=0; i<listDietDTO.size(); i++) {
				if(listDietDTO.get(i).getIdDiet()>idDiet) idDiet = listDietDTO.get(i).getIdDiet();
			}
			
			
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
		visualUser(request);
	
		return "homeUser";
	}
	
	
	
	/*@RequestMapping(value = "/crea", method = RequestMethod.GET)
	public String insert(HttpServletRequest request) {
		visualUser(request);
		request.setAttribute("option", "insert");
		return "creaUser";
		
	}
	*/
	
	@RequestMapping(value = "/cercaUser", method = RequestMethod.GET)
	public String cercaUser(HttpServletRequest request) {

		final String content = request.getParameter("search");

		List<UserDTO> allUser = this.userService.findUserDTOByUsername(content);
		request.setAttribute("allUserDTO", allUser);

		return "homeUser";

	}
	
	@RequestMapping(value = "/creaUser", method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request) {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		//String type = request.getParameter("type").toString();
		String type = "pending";

		UserDTO userObj = new UserDTO( username, password, type);
		
		userService.insertUser(userObj);

		visualUser(request);
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginControl(HttpServletRequest request) {

		session = request.getSession();
		final String username = request.getParameter("username");
		final String password = request.getParameter("password");
		final UserDTO userDTO = userService.getByUsernameAndPassword(username, password);
		final String ruolo = userDTO.getType();
		if (!StringUtils.isEmpty(ruolo)) {
			session.setAttribute("utenteCollegato", userDTO);
			if (ruolo.equals("admin")) {
				return "home";
			} else if (ruolo.equals("trainer")) {
				return "homeTrainer";
			} else if (ruolo.equals("player")) {
				request.setAttribute("id", userDTO.getIdUser());
				return "homePlayer";
			}else if (ruolo.equals("nutritionist")) {
				request.setAttribute("userListDTO", userService.getListaUserDTO());
				return "homeNutritionist";
			}
		}
		return "index";
	}
	
	/*@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String insert(HttpServletRequest request) {

		session = request.getSession();
		session.setAttribute("utente", null);

		if (request != null) {
			final String username = request.getParameter("username").toString();
			final String password = request.getParameter("password").toString();
			final String type = "pending";
			UserDTO userDTO = new UserDTO();
			userDTO.setUsername(username);
			userDTO.setPassword(password);
			userDTO.setType(type);
			// recuperiamo l'utente
			userService.insertUser(userDTO);
			visualUser(request);

		return "index";
		}
	}
	*/
}
