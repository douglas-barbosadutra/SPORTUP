package it.contrader.model;

import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BiomedicalData {

	@Id
	@Column(name = "idBiomedicalData")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idBiomedicalData;

	@Column(name = "hearthbeat")
	private int hearthbeat;

	@Column(name = "bloodPressure")
	private int bloodPressure;
	
	@Column(name = "height")
	private float height;
	
	@Column(name = "weight")
	private float weight;
	
	@Column(name = "fatMass")
	private float fatMass;
	
	@Column(name = "fatFreeMass")
	private float fatFreeMass;
	
	@Column(name = "deleted")
	private int deleted;
	

}
