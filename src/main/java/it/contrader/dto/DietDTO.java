package it.contrader.dto;

import it.contrader.model.Daily;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DietDTO {

	private Integer idDiet;

	private Daily daily;

}
