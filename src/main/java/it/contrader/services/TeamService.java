
package it.contrader.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ConverterTeam;
import it.contrader.converter.ConverterUser;
import it.contrader.dao.TeamRepository;
import it.contrader.dao.UserRepository;
import it.contrader.dto.TeamDTO;
import it.contrader.dto.UserDTO;
import it.contrader.model.Team;
import it.contrader.model.User;

@Service
public class TeamService {

	private final TeamRepository teamRepository;

	@Autowired
	public TeamService(TeamRepository teamRepository) {
		this.teamRepository = teamRepository;
	}

	public List<TeamDTO> getListaTeamDTO() {
		return ConverterTeam.toListDTO((List<Team>) teamRepository.findAll());
	}

	public TeamDTO getTeamDTOById(Integer id) {
		return ConverterTeam.toDTO(teamRepository.findById(id).get());
	}
	
	public void assignTeam (int idTeam, int idPlayer) {
		teamRepository.assignTeam(idTeam, idPlayer);
	}
/*
	public UserDTO getByUsernameAndPassword(String username, String password) {

		final User user = userRepository.findUserByUsernameAndPassword(username, password);

		return ConverterUser.toDTO(user);
	}
*/
	public boolean insertTeam(TeamDTO teamDTO) {
		return teamRepository.save(ConverterTeam.toEntity(teamDTO)) != null;
	}
/*	
	//public boolean insertUser(String username, String password) {
	//	return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	//}

	public boolean updateUser(UserDTO userDTO) {
		return userRepository.save(ConverterUser.toEntity(userDTO)) != null;
	}
*/	
	
	public void deleteTeamById(Integer id) {
		teamRepository.deleteById(id);
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