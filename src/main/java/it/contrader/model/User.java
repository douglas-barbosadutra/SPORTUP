package it.contrader.model;

import java.util.List;

import javax.persistence.*;

import javax.validation.constraints.NotNull;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@Column(name = "id_user")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_user;

	@Column(name = "username")
	@NotNull
	private String username;

	@Column(name = "password")
	@NotNull
	private String password;

	
	@Column(name = "type")
	private String type;
	
	
	
	
	
	
	public int getIdUser() {
		return this.id_user;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	public String getType() {
		return this.type;
	}
	
	public void setIdUser(int userId) {
		this.id_user = userId;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setType(String type) {
		this.type = type;
	}

	

}
