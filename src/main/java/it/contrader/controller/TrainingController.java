
package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.dto.PlayerDTO;
import it.contrader.dto.TrainingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.TrainingService;
import it.contrader.services.UserService;

@Controller
@RequestMapping("/Training")
public class TrainingController {

	private final TrainingService trainingService;

	@Autowired
	public TrainingController(TrainingService trainingService) {
		this.trainingService = trainingService;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	private void visualTraining(HttpServletRequest request){
		List<TrainingDTO> allTraining = this.trainingService.getListaTrainingDTO();
		request.setAttribute("allTrainingDTO", allTraining);

	}

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String create(HttpServletRequest request) {
		return "trainerTeam";

	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		int id = Integer.parseInt(request.getParameter("id"));
		TrainingDTO trainingDTO = this.trainingService.getTrainingDTOById(id);
		trainingDTO.setInfo(request.getParameter("info"));
		trainingService.insertTraining(trainingDTO);
		visualTraining(request);
		return "trainerTraining";
		

	}
	
	@RequestMapping(value = "/creaTraining", method = RequestMethod.GET)
	public String insertTraining(HttpServletRequest request) {
		//int id = Integer.parseInt(request.getParameter("id"));
		String info = request.getParameter("info");
		

		TrainingDTO trainingObj = new TrainingDTO();
		trainingObj.setInfo(info);
		
		trainingService.insertTraining(trainingObj);

		visualTraining(request);
		return "trainerTraining";
	}

}