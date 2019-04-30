package it.contrader.model;

public class Team {
	private int teamId;
	private String info;
	private int playerId;

	public Team() {
	}

	public Team(String info) {
		this.info = info;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getInfo() {
		return info;
	}
	
	@Override
	public String toString() {
		return this.getTeamId() + "\t" + this.getInfo();
	}

	public boolean equals(Team teamCompare) {
		if (!this.getInfo().equals(teamCompare.getInfo())) {
			return false;
		}
		return true;

	}

}
