
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
import it.contrader.dao.TrainingRepository;
import it.contrader.dto.TrainingDTO;
import it.contrader.model.Training;

@Service
public class TrainingService {

	private final TrainingRepository trainingRepository;

	@Autowired
	public TrainingService(TrainingRepository trainingRepository) {
		this.trainingRepository = trainingRepository;
	}

	public List<TrainingDTO> getListaTrainingDTO() {
		return ConverterTraining.toListDTO((List<Training>) trainingRepository.findAll());
	}


	public TrainingDTO getTrainingDTOById(Integer id) {
		return ConverterTraining.toDTO(trainingRepository.findById(id).get());
	}
	

/*
	public UserDTO getByUsernameAndPassword(String username, String password) {

		final User user = userRepository.findUserByUsernameAndPassword(username, password);

		return ConverterUser.toDTO(user);
	}
*/

	public boolean insertTraining(TrainingDTO trainingDTO) {
		return trainingRepository.save(ConverterTraining.toEntity(trainingDTO)) != null;
	}

/*	
	//public boolean insertUser(String username, String password) {
	//	return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	//}

	public boolean updateUser(UserDTO userDTO) {
		return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	}
	
	public void deleteUserById(Integer id) {
		userRepository.deleteById(id);
	}
	
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
