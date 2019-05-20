
package it.contrader.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.CrossOrigin;


import it.contrader.dto.PlayerDTO;
import it.contrader.dto.TrainingDTO;
import it.contrader.dto.UserDTO;
import it.contrader.services.TrainingService;
import it.contrader.services.UserService;

@CrossOrigin
@Controller
@RequestMapping("/Training")
public class TrainingController {

	private final TrainingService trainingService;

	@Autowired
	public TrainingController(TrainingService trainingService) {
		this.trainingService = trainingService;
	}

	@RequestMapping(value = "/view", method = RequestMethod.GET)
	private List<TrainingDTO> visualTraining(HttpServletRequest request){
		List<TrainingDTO> allTraining = this.trainingService.getListaTrainingDTO();
		return allTraining;
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	public TrainingDTO update(@RequestParam(value = "idTraining") int idT,@RequestParam(value = "info") String info) {
		TrainingDTO trainingDTO = this.trainingService.getTrainingDTOById(idT);
		trainingDTO.setInfo(info);
		trainingService.insertTraining(trainingDTO);
		return trainingDTO;
	}
	
	@RequestMapping(value = "/creaTraining", method = RequestMethod.GET)
	public TrainingDTO insertTraining(@RequestParam(value = "info") String info) {
		TrainingDTO trainingObj = new TrainingDTO();
		trainingObj.setInfo(info);
		trainingService.insertTraining(trainingObj);
		return trainingObj;
	}

}