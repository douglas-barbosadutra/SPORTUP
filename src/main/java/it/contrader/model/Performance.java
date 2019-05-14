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
public class Performance {

	@Id
	@Column(name = "idPerformance")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPerformance;

	@Column(name = "maxCorsaMin")
	private int maxCorsaMin;

	@Column(name = "maxFlessioni")
	private int maxFlessioni;
	
	@Column(name = "maxAddominali")
	private int maxAddominali;

}
