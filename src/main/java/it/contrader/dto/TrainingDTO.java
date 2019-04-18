package it.contrader.dto;

public class TrainingDTO {
	private int trainingId;
	private String info;

	public TrainingDTO(String info) {
		this.info = info;
	}
	
	public TrainingDTO() {} 
	
	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
