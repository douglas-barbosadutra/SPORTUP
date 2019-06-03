package it.contrader.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Daily{
	
	public Daily(String day, int idDiet) {
		this.day = day;
		this.breakfast = "free";
		this.snack = "free";
		this.lunch = "free";
		this.snackAfternoon = "free";
		this.dinner = "free";
		Diet diet = new Diet();
		diet.setIdDiet(idDiet);
		this.setDiet(diet);
	}

	@Id
	@Column(name = "idDay")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDay;
	
	@Column(name = "day")
	private String day;

	@Column(name = "breakfast")
	private String breakfast;

	@Column(name = "snack")
	private String snack;

	@Column(name = "lunch")
	private String lunch;

	@Column(name = "snackAfternoon")
	private String snackAfternoon;

	@Column(name = "dinner")
	private String dinner;

	@ManyToOne	
	@JoinColumn(name = "idDiet")
	private Diet diet;

}
