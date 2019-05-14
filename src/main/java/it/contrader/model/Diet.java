package it.contrader.model;

import java.util.List;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.*;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Diet {

	@Id
	@Column(name = "idDiet")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDiet;

	@Column(name = "monday")
	private String monday;

	@Column(name = "tuesday")
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
	
}
