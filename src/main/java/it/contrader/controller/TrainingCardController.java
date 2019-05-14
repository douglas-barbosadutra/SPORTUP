
package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.contrader.converter.ConverterTraining;
import it.contrader.converter.ConverterTrainingCard;
import it.contrader.dto.BiomedicalDataDTO;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.TrainingCardDTO;
import it.contrader.dto.TrainingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Training;
import it.contrader.model.TrainingCard;
import it.contrader.services.BiomedicalDataService;
import it.contrader.services.TrainingCardService;
import it.contrader.services.TrainingService;
import it.contrader.services.UserService;

@Controller
@RequestMapping("/TrainingCard")
public class TrainingCardController {

	private final TrainingCardService trainingCardService;
	private final TrainingService trainingService;

	@Autowired
	public TrainingCardController(TrainingCardService trainingCardService, TrainingService trainingService) {
		this.trainingCardService = trainingCardService;
		this.trainingService = trainingService;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	private String visualTrainingCard(HttpServletRequest request){
		int id = Integer.parseInt(request.getParameter("id"));
		TrainingDTO t = trainingService.getTrainingDTOById(id);
		
		request.setAttribute("tr", t);
		List<TrainingCardDTO> allTrainingCard =  (List<TrainingCardDTO>) this.trainingCardService.getListaTrainingCardDTO();
		request.setAttribute("allTrainingCardDTO", allTrainingCard);
		return "trainerTrainingCard";

	}

	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert(HttpServletRequest request) {
		

	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		return "trainerTrainingCard";

	}

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public String update(HttpServletRequest request) {
		int idTCard = Integer.parseInt(request.getParameter("id"));
		int idT = Integer.parseInt(request.getParameter("idTraining"));
		TrainingCard trainingCard = this.trainingCardService.findTrainingCardDTOByIdTrainingCardAndIdTraining(idTCard, idT);
		trainingCard.setMonday(request.getParameter("monday"));
		trainingCard.setTuesday(request.getParameter("thuesday"));
		trainingCard.setWednesday(request.getParameter("wednesday"));
		trainingCard.setFriday(request.getParameter("friday"));
		trainingCard.setThursday(request.getParameter("thursday"));
		trainingCard.setSaturday(request.getParameter("saturday"));
		trainingCard.setSunday(request.getParameter("sunday"));
		
		trainingCardService.insertTrainingCard(ConverterTrainingCard.toDTO(trainingCard));
		visualTrainingCard(request);
		return "trainerTrainingCardUpdate";
	}
	
}
