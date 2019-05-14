package it.contrader.model;

import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.CascadeType;
import javax.validation.constraints.NotNull;
import javax.ws.rs.DefaultValue;

import org.hibernate.annotations.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import org.springframework.lang.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Player {

	@Id
	@Column(name = "idPlayer")
	private Integer idPlayer;

	@Column(name = "ruolo")
	private String ruolo;

	@Column(name = "idTraining", unique = false)
	@DefaultValue(value = "0")
	private int idTraining;

	@Column(name = "idBiomedicalData")
	@DefaultValue(value = "0")
	private int idBiomedicalData;

	@Column(name = "idDiet")
	@DefaultValue(value = "0")
	private int idDiet;

	@Column(name = "idPerformance")
	@DefaultValue(value = "0")
	private int idPerformance;

	@Column(name = "info")
	@DefaultValue(value = "no info")
	private String info;

	@OneToOne
	@MapsId
	@JoinColumn(name = "idPlayer")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;

	@OneToOne
	@MapsId
	@JoinColumn(name = "idBiomedicalData")
	@OnDelete(action = OnDeleteAction.NO_ACTION)
	private BiomedicalData biomedicalData;

	@ManyToOne
	@MapsId
	@JoinColumn(name = "idTraining")
	private Training training;

	@OneToOne
	@MapsId
	@JoinColumn(name = "idPerformance")
	private Performance performance;

	@OneToOne
	@MapsId
	@JoinColumn(name = "idDiet")
	private Diet diet;

	@ManyToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "PlayerTeam", 
			   joinColumns = 
			   		@JoinColumn(name = "playerId", referencedColumnName = "idPlayer", nullable = true), 
			   inverseJoinColumns = 
			   		@JoinColumn(name = "teamId", referencedColumnName = "idTeam", nullable = true))
	private Set<Team> teams;

	public Set<Team> getTeams() {
		return teams;
	}

	public void setTeams(Set<Team> teams) {
		this.teams = teams;
	}

	/*
	 * public void removePlayerFromTeam(Player playerToRemove) {
	 * 
	 * EntityManager em; em.remove(playerToRemove); Team team = new Team(); for
	 * (Player player : team.getPlayers()) { player.teams.remove(team); }
	 * em.merge(team); em.flush();
	 */

	/*
	 * Configuration config = new Configuration(); SessionFactory factory =
	 * config.configure().buildSessionFactory(); Session session =
	 * factory.openSession(); Transaction tx = null;
	 * 
	 * try { tx = session.beginTransaction();
	 * 
	 * player.getTeams().clear(); session.delete(player); session.flush();
	 * 
	 * tx.commit();
	 * 
	 * }catch (Exception e) { if (tx!=null) tx.rollback(); e.printStackTrace(); }
	 * finally { session.close(); }
	 * 
	 * }
	 */
}
