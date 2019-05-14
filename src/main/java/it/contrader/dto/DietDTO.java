package it.contrader.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietDTO {

	
	private Integer idDiet;

	private String monday;
	
	private String tuesday;

	private String wednesday;
	
	private String thursday;
	
	private String friday;
	
	private String saturday;
		
	private String sunday;
	
}
