package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.PlayerDTO;
import it.contrader.model.Player;

public class ConverterPlayer {

	public static PlayerDTO toDTO(Player player) {
		PlayerDTO playerDTO = null;
		if (player != null) {
			playerDTO = new PlayerDTO();
			playerDTO.setIdPlayer(player.getIdPlayer());
			playerDTO.setRuolo(player.getRuolo());
			playerDTO.setIdTraining(player.getIdTraining());
			playerDTO.setIdBiomedicalData(player.getIdBiomedicalData());
			playerDTO.setIdDiet(player.getIdDiet());
			playerDTO.setIdPerformance(player.getIdPerformance());
			playerDTO.setInfo(player.getInfo());
		}
		return playerDTO;
	}

	public static Player toEntity(PlayerDTO playerDTO) {
		Player player = null;
		if (playerDTO != null) {
			player = new Player();
			player.setIdPlayer(playerDTO.getIdPlayer());
			player.setRuolo(playerDTO.getRuolo());
			player.setIdTraining(playerDTO.getIdTraining());
			player.setIdBiomedicalData(playerDTO.getIdBiomedicalData());
			player.setIdDiet(playerDTO.getIdDiet());
			player.setIdPerformance(playerDTO.getIdPerformance());
			player.setInfo(playerDTO.getInfo());			
		}
		return player;
	}

	public static List<PlayerDTO> toListDTO(List<Player> list) {
		List<PlayerDTO> listPlayerDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Player player : list) {
				listPlayerDTO.add(ConverterPlayer.toDTO(player));
			}
		}
		return listPlayerDTO;
	}

	public static List<Player> toListEntity(List<PlayerDTO> listPlayerDTO) {
		List<Player> list = new ArrayList<>();
		if (!listPlayerDTO.isEmpty()) {
			for (PlayerDTO playerDTO : listPlayerDTO) {
				list.add(ConverterPlayer.toEntity(playerDTO));
			}
		}
		return list;
	}
}
