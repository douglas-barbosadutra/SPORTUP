package it.contrader.dto;

public class BiomedicalDataDTO {
	private int id_b_data;
	private int hearthbeat;
	private int blood_pressure;
	private float height;
	private float weight;
	private float fat_mass;
	private float fat_free_mass;
	private int deleted;

	public BiomedicalDataDTO() {
	}

	public int getId_b_data() {
		return id_b_data;
	}

	public void setId_b_data(int id_b_data) {
		this.id_b_data = id_b_data;
	}

	public int getHearthbeat() {
		return hearthbeat;
	}

	public void setHearthbeat(int hearthbeat) {
		this.hearthbeat = hearthbeat;
	}

	public int getBlood_pressure() {
		return blood_pressure;
	}

	public void setBlood_pressure(int blood_pressure) {
		this.blood_pressure = blood_pressure;
	}

	public float getHeight() {
		return height;
	}

	public void setHeight(float height) {
		this.height = height;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getFat_mass() {
		return fat_mass;
	}

	public void setFat_mass(float fat_mass) {
		this.fat_mass = fat_mass;
	}

	public float getFat_free_mass() {
		return fat_free_mass;
	}

	public void setFat_free_mass(float fat_free_mass) {
		this.fat_free_mass = fat_free_mass;
	}

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}
	
		
}