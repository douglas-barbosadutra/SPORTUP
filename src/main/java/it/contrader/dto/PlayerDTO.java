package it.contrader.dto;

import it.contrader.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO{
	
	private int idPlayer;

	private String ruolo;
	
	private int idTraining;

	private int idBiomedicalData;
	
	private int idDiet;
	
	private int idPerformance;
	
	private String info;
		
	/*
	public PlayerDTO(int id, String username, String password, String type) {
		super.setIdUser(id);
		super.setUsername(username);
		super.setPassword(password);
		super.setType(type);
		this.ruolo = "cabbasisara";
		this.idTraining = 1;
		this.idBiomedicalData = 1;
		this.info = "Antonella";
	}
	*/
	
}
