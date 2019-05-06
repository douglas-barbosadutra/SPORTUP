package it.contrader.model;

public class TrainingCard {
	private int id_training;
	private int id_training_card;
	private String monday, tuesday, wednesday, thursday, friday, saturday, sunday;
	private int deleted;

	public TrainingCard() {
	}

	public TrainingCard(int id_training, int id_training_card) {
		this.id_training = id_training;
		this.id_training_card = id_training_card;
		this.deleted = 0;
	}

	public int getId_training() {
		return id_training;
	}

	public void setId_training(int id_training) {
		this.id_training = id_training;
	}

	public int getId_training_card() {
		return id_training_card;
	}

	public void setId_training_card(int id_training_card) {
		this.id_training_card = id_training_card;
	}

	public String getSaturday() {
		return saturday;
	}

	public void setSaturday(String saturday) {
		this.saturday = saturday;
	}

	public String getMonday() {
		return monday;
	}

	public void setMonday(String monday) {
		this.monday = monday;
	}

	public String getWednesday() {
		return wednesday;
	}

	public void setWednesday(String wednesday) {
		this.wednesday = wednesday;
	}

	public String getTuesday() {
		return tuesday;
	}

	public void setTuesday(String tuesday) {
		this.tuesday = tuesday;
	}

	public String getFriday() {
		return friday;
	}

	public void setFriday(String friday) {
		this.friday = friday;
	}

	public String getSunday() {
		return sunday;
	}

	public void setSunday(String sunday) {
		this.sunday = sunday;
	}

	public String getThursday() {
		return thursday;
	}

	public void setThursday(String thursday) {
		this.thursday = thursday;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
	

	
}
