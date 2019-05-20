
package it.contrader.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.*;
import org.springframework.lang.Nullable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Team {

	
	@Id
	@Column(name = "idTeam")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTeam;

	@Column(name = "info")
	@NotNull
	private String info;

	@ManyToMany(targetEntity=Player.class, mappedBy="teams")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Player> players;
	public Set<Player> getPlayers(){ return players; }
	public void setPlayers(Set<Player> players) { this.players = players; }
	
	
}
