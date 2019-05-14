package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterUser;
import it.contrader.converter.ConverterPlayer;
import it.contrader.dao.PlayerRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Player;
import it.contrader.model.User;

@Service
public class PlayerService {

	private final PlayerRepository playerRepository;

	@Autowired
	public PlayerService(PlayerRepository playerRepository) {
		this.playerRepository = playerRepository;
	}
	
	public List<PlayerDTO> getListaPlayerDTO() {
		return ConverterPlayer.toListDTO((List<Player>) playerRepository.findAll());
	}

	public PlayerDTO getPlayerDTOById(Integer id) {
		return ConverterPlayer.toDTO(playerRepository.findPlayerByidPlayer(id));
	}

	/*public PlayerDTO getByUsernameAndPassword(String username, String password) {

		final Player player = playerRepository.findPlayerByUsernameAndPassword(username, password);

		return ConverterUser.toDTO(player);
	}*/

	public boolean insertPlayer(PlayerDTO playerDTO) {		
		return playerRepository.save(ConverterPlayer.toEntity(playerDTO)) != null;
	}
	
	//public boolean insertUser(String username, String password) {
	//	return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	//}

	public boolean updatePlayer(PlayerDTO playerDTO) {
		return playerRepository.save(ConverterPlayer.toEntity(playerDTO)) != null;
	}
	
	public void deletePlayerById(Integer id) {
		playerRepository.deleteById(id);
	}
	
	public void addPlayer(PlayerDTO playerDTO) {
		playerRepository.addPlayer(playerDTO.getIdPlayer(), playerDTO.getIdBiomedicalData(), playerDTO.getIdDiet(), playerDTO.getIdPerformance(),playerDTO.getIdTraining(), playerDTO.getInfo(), playerDTO.getRuolo());
	}
	
	/*public void assignTypeById(Integer id, String type) {
		playerRepository.assignById(id, type);
	}*/
	
	/*public List<PlayerDTO> findUserDTOByUsername(String username) {
		
		final List<Player> list = playerRepository.findAllByUsername(username);
		final List<UserDTO> userDTOs = new ArrayList<>();
		list.forEach(i -> playerDTOs.add(ConverterPlayer.toDTO(i)));
		return playerDTOs;
	}*/
}
