package it.contrader.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.contrader.dto.TrainingCardDTO;
import it.contrader.model.Player;
import it.contrader.model.Training;
import it.contrader.model.TrainingCard;
import it.contrader.model.User;

import java.util.List;

import javax.transaction.Transactional;

@Repository
public interface TrainingCardRepository extends CrudRepository<TrainingCard, Integer> {
	
	//@Modifying(clearAutomatically = true)
	//@org.springframework.transaction.annotation.Transactional
	@Query(value = "select * from training_card where id_training=:idT and id_training_card=:idTCard", nativeQuery = true)
	public TrainingCard findTrainingCardDTOByIdTrainingCardAndIdTraining(@Param("idTCard") int idTCard,@Param("idT") int idT);
	//public List<TrainingCard> findAllByidTraining(int id);
	
	
	
	//public User  findUserByUsernameAndPassword(String username,String password);
	
	//@Modifying(clearAutomatically = true)
	//@org.springframework.transaction.annotation.Transactional
	//@Query(value = "update User u set u.type=:TYPE where u.id_user=:ID", nativeQuery = true)
	//public void assignById(@Param("ID") int id,@Param("TYPE") String type);
}