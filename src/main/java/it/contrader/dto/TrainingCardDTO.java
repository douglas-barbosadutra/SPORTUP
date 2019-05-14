package it.contrader.dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import it.contrader.model.Training;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrainingCardDTO {

	private Integer idTrainingCard;

	private String monday;

	private String tuesday;

	private String wednesday;

	private String thursday;

	private String friday;

	private String saturday;

	private String sunday;

	private int deleted;
	
	private Training training;
}
