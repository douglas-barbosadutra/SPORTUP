package it.contrader.model;

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
public class Player {

	@Id
	@Column(name = "idPlayer")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPlayer;

	@Column(name = "ruolo")
	@NotNull
	private String ruolo;

	@Column(name = "idTraining")
	@NotNull
	private int idTraining;

	@Column(name = "idBiomedicalData")
	@NotNull
	private int idBiomedicalData;
	
	@NotNull
	@Column(name = "info")
	private String info;
	
	//bi-directional many-to-one association to User
	@OneToOne
	@MapsId
	@JoinColumn(name="idPlayer")
	private User user;
	

	



}
