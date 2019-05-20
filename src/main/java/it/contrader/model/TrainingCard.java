package it.contrader.model;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;

import org.hibernate.annotations.*;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class TrainingCard {

	@Id
	@Column(name = "idTrainingCard")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTrainingCard;

	@Column(name = "monday")
	@NotNull
	private String monday;

	@Column(name = "tuesday")
	@NotNull
	private String tuesday;

	@Column(name = "wednesday")
	private String wednesday;

	@Column(name = "thursday")
	private String thursday;

	@Column(name = "friday")
	private String friday;

	@Column(name = "saturday")
	private String saturday;

	@Column(name = "sunday")
	private String sunday;

	@Column(name = "deleted")
	private int deleted;
	
	@ManyToOne	
	@JoinColumn(name = "idTraining")
	private Training training;

}
