
package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;

import it.contrader.dto.TrainingCardDTO;
import it.contrader.services.TrainingCardService;
import it.contrader.services.TrainingService;

@CrossOrigin
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
	private List<TrainingCardDTO> visualTrainingCard(@RequestParam(value = "idTraining") int idTraining){
		List<TrainingCardDTO> allTrainingCard =  (List<TrainingCardDTO>) this.trainingCardService.getListaTrainingCardDTO();
		for (int i=0; i<allTrainingCard.size(); i++) {
			if(allTrainingCard.get(i).getTraining().getIdTraining()!=idTraining)
				allTrainingCard.remove(i);
		}
		return allTrainingCard;
	}

	/*
	@RequestMapping(value = "/insert", method = RequestMethod.GET)
	public void insert(HttpServletRequest request) {
	}
	*/
	/*
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(HttpServletRequest request) {
		return "trainerTrainingCard";
	}
	*/

	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public TrainingCardDTO update(@RequestParam(value = "idTraining") int idT,
		@RequestParam(value = "idTrainingCard") int idTCard,
		@RequestParam(value = "monday") String monday,
		@RequestParam(value = "tuesday") String tuesday,
		@RequestParam(value = "wednesday") String wednesday,
		@RequestParam(value = "thursday") String thursday,
		@RequestParam(value = "friday") String friday,
		@RequestParam(value = "saturday") String saturday,
		@RequestParam(value = "sunday") String sunday) {
		TrainingCardDTO trainingCardDTO = this.trainingCardService.findTrainingCardDTOByIdTrainingCardAndIdTraining(idTCard, idT);
		trainingCardDTO.setMonday(monday);
		trainingCardDTO.setTuesday(tuesday);
		trainingCardDTO.setWednesday(wednesday);
		trainingCardDTO.setFriday(friday);
		trainingCardDTO.setThursday(thursday);
		trainingCardDTO.setSaturday(saturday);
		trainingCardDTO.setSunday(sunday);
		
		trainingCardService.insertTrainingCard(trainingCardDTO);
		return trainingCardDTO;
	}
	
}
