package it.contrader.model;

public class Training {
	private int trainingId;
	private String info;

	public Training() {
	}

	public Training(String info) {
		this.info = info;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	@Override
	public String toString() {
		return this.getTrainingId() + "\t" + this.getInfo();
	}

	public boolean equals(Training trainingCompare) {
		if (!this.getInfo().equals(trainingCompare.getInfo())) {
			return false;
		}
		return true;

	}

}
