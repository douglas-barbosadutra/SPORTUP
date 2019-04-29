package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterTeam;
import it.contrader.dao.TeamDAO;
import it.contrader.dto.TeamDTO;
import it.contrader.model.Team;

public class TeamService {

	private TeamDAO teamDAO;

	public TeamService() {
		this.teamDAO = new TeamDAO();
	}

	public List<Team> getAllTeam() {
		return this.teamDAO.getAllTeam();
	}

	public boolean createTeam(TeamDTO teamDTO) {
		return this.teamDAO.createTeam(ConverterTeam.toEntity(teamDTO));
	}
	/*
	public boolean updateTeam(TeamDTO teamDTO) {
		return this.teamDAO.updateTeam(ConverterTeam.toEntity(teamDTO));
	}
	*/
	public boolean deleteTeam(int teamId) {
		return this.teamDAO.deleteTeam(teamId);
	}
	
	public boolean assignTeam(TeamDTO teamDTO) {
		return this.teamDAO.assignTeam(ConverterTeam.toEntity(teamDTO));
	}
	
	
}
