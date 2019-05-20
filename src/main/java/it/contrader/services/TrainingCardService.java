
package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterUser;
import it.contrader.dao.UserRepository;
import it.contrader.dto.UserDTO;
import it.contrader.model.User;

import it.contrader.converter.ConverterTraining;
import it.contrader.converter.ConverterTrainingCard;
import it.contrader.dao.TrainingCardRepository;
import it.contrader.dao.TrainingRepository;
import it.contrader.dto.TrainingCardDTO;
import it.contrader.dto.TrainingDTO;
import it.contrader.model.Training;
import it.contrader.model.TrainingCard;

@Service
public class TrainingCardService {

	private final TrainingCardRepository trainingCardRepository;

	@Autowired
	public TrainingCardService(TrainingCardRepository trainingCardRepository) {
		this.trainingCardRepository = trainingCardRepository;
	}

	public List<TrainingCardDTO> getListaTrainingCardDTO() {
		return ConverterTrainingCard.toListDTO((List<TrainingCard>) trainingCardRepository.findAll());
	}
	
	public TrainingCardDTO findTrainingCardDTOByIdTrainingCardAndIdTraining(int idTCard, int idT) {
		return trainingCardRepository.findTrainingCardDTOByIdTrainingCardAndIdTraining(idTCard, idT);
	};


	/*public List<TrainingCardDTO> findAllByidTraining(int id) {
		return ConverterTrainingCard.toListDTO(trainingCardRepository.findAllByidTraining(id));
	}*/

	public TrainingCardDTO getTrainingCardDTOById(Integer id) {
		return ConverterTrainingCard.toDTO(trainingCardRepository.findById(id).get());
	}
	

/*
	public UserDTO getByUsernameAndPassword(String username, String password) {

		final User user = userRepository.findUserByUsernameAndPassword(username, password);

		return ConverterUser.toDTO(user);
	}
*/

	public boolean insertTrainingCard(TrainingCardDTO trainingCardDTO) {
		return trainingCardRepository.save(ConverterTrainingCard.toEntity(trainingCardDTO)) != null;
	}

/*	
	//public boolean insertUser(String username, String password) {
	//	return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	//}

	public boolean updateUser(UserDTO userDTO) {
		return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	}
*/	
	public void deleteTrainingCardById(Integer id) {
		trainingCardRepository.deleteById(id);
	}
/*	
	public List<UserDTO> findUserDTOByUsername(String username) {
		
		final List<User> list = userRepository.findAllByUsername(username);
		final List<UserDTO> userDTOs = new ArrayList<>();
		list.forEach(i -> userDTOs.add(ConverterUser.toDTO(i)));
		return userDTOs;
		
	
	}
	*/
/*
}
*/
}
