package it.contrader.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.contrader.model.Player;
import it.contrader.model.Team;
import it.contrader.model.Training;
import it.contrader.model.User;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface TeamRepository extends CrudRepository<Team, Integer> {

	//public User findUserByUsernameAndPassword(String username,String password);
	//public List<Player> findAllByUsername(String username);
	
	
	//public User  findUserByUsernameAndPassword(String username,String password);
	
	@Modifying(clearAutomatically = true)
	@org.springframework.transaction.annotation.Transactional
	@Query(value = "insert into player_team values (:idTeam, :idPlayer)", nativeQuery = true)
	public void assignTeam(@Param("idTeam") int idTeam,@Param("idPlayer") int idPlayer);
}
