package it.contrader.dto;

public class TeamDTO {
	private String info;
	private int id_team;
	private int id_player;

	public TeamDTO(String info) {
		this.info = info;
	}
	
	public TeamDTO(int id_team, String info) {
		this.id_team = id_team;
		this.info = info;
	}
	
	public TeamDTO(int id_team, int id_player) {
		this.id_team = id_team;
		this.id_player = id_player;
	}
	
	public TeamDTO() {} 
	
	public int getTeamId() {
		return id_team;
	}

	public void setTeamId(int teamId) {
		this.id_team = teamId;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public int getId_player() {
		return id_player;
	}

	public void setId_player(int id_player) {
		this.id_player = id_player;
	}
	
}