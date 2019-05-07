package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private Integer idUser;

	private String username;
	
	private String password;

	private String type;
	
	public UserDTO(String username, String password, String usertype) {
		this.username = username;
		this.type = usertype;
		this.password = password;
	}
	
	public UserDTO(String username, String password) {
		this.username = username;
		this.password = password;
		this.type = "pending";
	}
	
	
	
}
