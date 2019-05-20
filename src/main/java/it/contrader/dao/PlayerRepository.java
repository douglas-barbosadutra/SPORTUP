package it.contrader.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.contrader.model.Player;
import it.contrader.model.User;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

	//public User findUserByUsernameAndPassword(String username,String password);
	//public List<Player> findAllByUsername(String username);
	
	
	public Player  findPlayerByidPlayer(int idPlayer);
	
	@Modifying(clearAutomatically = true)
	@org.springframework.transaction.annotation.Transactional
	@Query(value = "INSERT INTO player (id_player, id_biomedical_data, id_diet, id_performance, id_training, info, ruolo) VALUES (:idPlayer,:idBiomedicalData,:idDiet,:idPerformance,:idTraining,:info,:ruolo)", nativeQuery = true)
	public void addPlayer(@Param("idPlayer") int id,@Param("idBiomedicalData") int idBiomedicalData,@Param("idDiet") int idDiet,@Param("idPerformance") int idPerformance,@Param("idTraining") int idTraining, @Param("info") String info, @Param("ruolo") String ruolo);
}
