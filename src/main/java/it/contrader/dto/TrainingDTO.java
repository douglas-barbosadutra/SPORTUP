package it.contrader.dto;

public class TrainingDTO {
	private String info;
	private int id_player;
	private int id_training;

	public TrainingDTO(String info) {
		this.info = info;
	}
	public TrainingDTO(int id_player, int id_training) {
		this.id_player = id_player;
		this.id_training = id_training;
	}
	
	public TrainingDTO() {} 
	
	public int getTrainingId() {
		return id_training;
	}

	public void setTrainingId(int trainingId) {
		this.id_training = trainingId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
	public int getPlayerId() {
		return id_player;
	}

}
