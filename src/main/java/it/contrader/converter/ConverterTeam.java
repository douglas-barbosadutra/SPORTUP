package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.TeamDTO;
import it.contrader.model.Team;

public class ConverterTeam {

	public static TeamDTO toDTO(Team team) {
		TeamDTO teamDTO = null;
		if (team != null) {
			teamDTO = new TeamDTO();
			teamDTO.setTeamId(team.getTeamId());
			teamDTO.setInfo(team.getInfo());
			teamDTO.setId_player(team.getPlayerId());
		}
		return teamDTO;
	}

	public static Team toEntity(TeamDTO teamDTO) {
		Team team = null;
		if (teamDTO != null) {
			team = new Team();
			team.setTeamId(teamDTO.getTeamId());
			team.setInfo(teamDTO.getInfo());
			team.setPlayerId(teamDTO.getId_player());
		}
		return team;
	}

	public static List<TeamDTO> toListDTO(List<Team> list) {
		List<TeamDTO> listTeamDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Team training : list) {
				listTeamDTO.add(ConverterTeam.toDTO(training));
			}
		}
		return listTeamDTO;
	}

	public static List<Team> toListEntity(List<TeamDTO> listTeamDTO) {
		List<Team> list = new ArrayList<>();
		if (!listTeamDTO.isEmpty()) {
			for (TeamDTO teamDTO : listTeamDTO) {
				list.add(ConverterTeam.toEntity(teamDTO));
			}
		}
		return list;
	}
}
