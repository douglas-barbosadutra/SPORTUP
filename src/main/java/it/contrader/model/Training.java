package it.contrader.model;

import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Training {

	@Id
	@Column(name = "idTraining")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTraining;

	@Column(name = "info")
	@NotNull
	private String info;
	
	@OneToMany(mappedBy="training")
	private List<TrainingCard> trainingCard;	
	
	
	
	/*****************************************************************************************
	 * 
	 * 							TESTARE ON DELETE TRAINING SET NULL
	 * 
	 ****************************************************************************************/
	/*
	@PreRemove
	private void preRemove(Player player) {
    	player.setIdTraining(0);
    }
	*/
}
