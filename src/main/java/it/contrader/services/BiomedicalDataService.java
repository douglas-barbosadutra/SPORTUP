package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterUser;
import it.contrader.converter.ConverterBiomedicalData;
import it.contrader.converter.ConverterPlayer;
import it.contrader.dao.BiomedicalDataRepository;
import it.contrader.dao.PlayerRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.BiomedicalDataDTO;
import it.contrader.dto.PlayerDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.BiomedicalData;
import it.contrader.model.Player;
import it.contrader.model.User;

@Service
public class BiomedicalDataService {

	private final BiomedicalDataRepository biomedicalDataRepository;

	@Autowired
	public BiomedicalDataService(BiomedicalDataRepository biomedicalDataRepository) {
		this.biomedicalDataRepository = biomedicalDataRepository;
	}
	
	

	public List<BiomedicalDataDTO> getListaBiomedicalDataDTO() {
		return ConverterBiomedicalData.toListDTO((List<BiomedicalData>) biomedicalDataRepository.findAll());
	}

	public BiomedicalDataDTO getBiomedicalDataDTOById(Integer id) {
		return ConverterBiomedicalData.toDTO(biomedicalDataRepository.findById(id).get());
	}

	/*public PlayerDTO getByUsernameAndPassword(String username, String password) {

		final Player player = playerRepository.findPlayerByUsernameAndPassword(username, password);

		return ConverterUser.toDTO(player);
	}*/

	public boolean insertBiomedicalData(BiomedicalDataDTO biomedicalDataDTO) {		
		return biomedicalDataRepository.save(ConverterBiomedicalData.toEntity(biomedicalDataDTO)) != null;
	}
	
	//public boolean insertUser(String username, String password) {
	//	return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	//}

	public boolean updateBiomedicalData(BiomedicalDataDTO biomedicalDataDTO) {
		return biomedicalDataRepository.save(ConverterBiomedicalData.toEntity(biomedicalDataDTO)) != null;
	}
	
	public void deleteBiomedicalDataById(Integer id) {
		biomedicalDataRepository.deleteById(id);
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
