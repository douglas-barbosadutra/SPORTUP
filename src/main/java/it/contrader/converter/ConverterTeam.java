
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
			teamDTO.setIdTeam(team.getIdTeam());
			teamDTO.setInfo(team.getInfo());
			
		}
		return teamDTO;
	}

	public static Team toEntity(TeamDTO teamDTO) {
		Team team = null;
		if (teamDTO != null) {
			team = new Team();
			team.setIdTeam(teamDTO.getIdTeam());
			team.setInfo(teamDTO.getInfo());
			
		}
		return team;
	}

	public static List<TeamDTO> toListDTO(List<Team> list) {
		List<TeamDTO> listTeamDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Team team : list) {
				listTeamDTO.add(ConverterTeam.toDTO(team));
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