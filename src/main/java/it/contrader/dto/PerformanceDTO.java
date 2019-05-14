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
public class PerformanceDTO {

	private Integer idPerformance;

	private int maxCorsaMin;

	private int maxFlessioni;
	
	private int maxAddominali;	
	
	
}
