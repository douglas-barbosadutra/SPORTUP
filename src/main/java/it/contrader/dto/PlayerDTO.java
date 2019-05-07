package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerDTO {

	private Integer idPlayer;

	private String ruolo;
	
	private int idTraining;

	private int idBiomedicalData;
	
	private String info;
	
	
}
