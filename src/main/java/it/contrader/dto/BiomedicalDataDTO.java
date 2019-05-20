package it.contrader.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BiomedicalDataDTO {

	
	
	private Integer idBiomedicalData;

	
	private int hearthbeat;

	
	private int bloodPressure;

	private float height;
	
	private float weight;
	
	
	private float fatMass;
	
	
	private float fatFreeMass;
	
	private int deleted;
	
	
	
}
