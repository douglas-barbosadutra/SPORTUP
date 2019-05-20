package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterPerformance;
import it.contrader.dao.PerformanceRepository;
import it.contrader.dto.PerformanceDTO;
import it.contrader.model.Performance;

@Service
public class PerformanceService {

	private final PerformanceRepository performanceRepository;

	@Autowired
	public PerformanceService(PerformanceRepository performanceRepository) {
		this.performanceRepository = performanceRepository;
	}
	
	public List<PerformanceDTO> getListaPerformanceDTO() {
		return ConverterPerformance.toListDTO((List<Performance>) performanceRepository.findAll());
	}

	public PerformanceDTO getPerformanceDTOById(Integer id) {
		return ConverterPerformance.toDTO(performanceRepository.findById(id).get());
	}

	/*public PlayerDTO getByUsernameAndPassword(String username, String password) {

		final Player player = playerRepository.findPlayerByUsernameAndPassword(username, password);

		return ConverterUser.toDTO(player);
	}*/

	public boolean insertPerformance(PerformanceDTO performanceDTO) {		
		return performanceRepository.save(ConverterPerformance.toEntity(performanceDTO)) != null;
	}
	
	//public boolean insertUser(String username, String password) {
	//	return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	//}

	public boolean updatePerformance(PerformanceDTO performanceDTO) {
		return performanceRepository.save(ConverterPerformance.toEntity(performanceDTO)) != null;
	}
	
	public void deletePerformanceById(Integer id) {
		performanceRepository.deleteById(id);
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
