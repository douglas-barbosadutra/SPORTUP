package it.contrader.dto;

import it.contrader.model.Diet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DailyDTO {

	private int idDay;
	
	private String day;

	private String breakfast;

	private String snack;

	private String lunch;

	private String snackAfternoon;

	private String dinner;
	
	private Diet diet;

}
