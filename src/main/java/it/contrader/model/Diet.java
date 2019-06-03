package it.contrader.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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

public class Diet {

	@Id
	@Column(name = "idDiet")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDiet;
	
//	@OneToMany(mappedBy="diet")
//	private List<Daily> daily;	

}
