package it.contrader.model;

public class Player {
	private int userId;
	private String username;
	private String role;
	private int trainingId;
	private String trainingInfo;
	private String playerInfo;
	private int teamId;
	private String password;
	

	public Player() {
	}
	
	public Player(int userID) {
		this.userId=userID;
	}

	public Player(String username, String role) {
		this.username = username;
		this.role = role;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public String getPlayerRole() {
		return role;
	}

	public void setPlayerRole(String role) {
		this.role = role;
	}

	public int getTrainingId() {
		return trainingId;
	}

	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}

	public String getTrainingInfo() {
		return trainingInfo;
	}

	public void setTrainingInfo(String trainingInfo) {
		this.trainingInfo = trainingInfo;
	}

	public String getPlayerInfo() {
		return playerInfo;
	}

	public void setPlayerInfo(String playerInfo) {
		this.playerInfo = playerInfo;
	}
	
	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String toStringTraining() {
		return this.getUserId() + "\t" + this.getUsername() + "\t\t" + this.getPlayerRole() + 
				"\t" + this.getTrainingId() + "\t\t" + this.getTrainingInfo() + "\t\t" + this.getPlayerInfo();
	}
	
	public String toStringTeam() {
		return this.getUserId() + "\t" + this.getUsername() + "\t\t" + this.getPlayerRole();
	}
	
	public String toStringInfo() {
		return this.getUsername() + "\t\t" + this.getPassword() + "\t\t" + this.getPlayerRole() + 
				 	"\t" + this.getTrainingInfo() + "\t" + this.getPlayerInfo();
	}

	public boolean equals(Player playerCompare) {
		if (!this.getUsername().equals(playerCompare.getUsername())) {
			return false;
		}

		if (this.getUserId()!=playerCompare.getUserId()) {
			return false;
		}

		return true;

	}

}


