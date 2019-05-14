
package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterDiet;
import it.contrader.dao.DietRepository;
import it.contrader.dto.DietDTO;
import it.contrader.model.Diet;

@Service
public class DietService {

	private final DietRepository dietRepository;

	@Autowired
	public DietService(DietRepository dietRepository) {
		this.dietRepository = dietRepository;
	}
	
	
	public List<DietDTO> getListaDietDTO() {
		return ConverterDiet.toListDTO((List<Diet>) dietRepository.findAll());
	}

	public DietDTO getDietDTOById(Integer id) {
		return ConverterDiet.toDTO(dietRepository.findById(id).get());
	}

	/*public PlayerDTO getByUsernameAndPassword(String username, String password) {

		final Player player = playerRepository.findPlayerByUsernameAndPassword(username, password);

		return ConverterUser.toDTO(player);
	}*/

	public boolean insertDiet(DietDTO dietDTO) {		
		return dietRepository.save(ConverterDiet.toEntity(dietDTO)) != null;
	}
	
	//public boolean insertUser(String username, String password) {
	//	return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	//}

	public boolean updateDiet(DietDTO dietDTO) {
		return dietRepository.save(ConverterDiet.toEntity(dietDTO)) != null;
	}
	
	public void deleteDietById(Integer id) {
		dietRepository.deleteById(id);
	}
	
	/*
	public void assignTypeById(Integer id, String type) {
		playerRepository.assignById(id, type);
	}
	*/
	
	/*public List<PlayerDTO> findUserDTOByUsername(String username) {
		
		final List<Player> list = playerRepository.findAllByUsername(username);
		final List<UserDTO> userDTOs = new ArrayList<>();
		list.forEach(i -> playerDTOs.add(ConverterPlayer.toDTO(i)));
		return playerDTOs;
	}*/
}
