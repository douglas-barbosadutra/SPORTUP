package it.contrader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.contrader.dto.DailyDTO;
import it.contrader.model.Daily;
import it.contrader.model.Diet;

public interface DailyRepository extends CrudRepository<Daily, Integer> {
	
	public List<Daily> findAllByDiet(Diet diet);
	
	@Modifying(clearAutomatically = true)
	@org.springframework.transaction.annotation.Transactional
	@Query(value = "update Daily d set d.breakfast=:breakfast, d.snack=:snack, d.lunch=:lunch, d.snack_afternoon=:snackAfternoon, d.dinner=:dinner where d.id_day=:idDay", nativeQuery = true)
	public void updateDay(@Param("breakfast") String breakfast,@Param("snack") String snack,@Param("lunch") String lunch,@Param("snackAfternoon") String snackAfternoon,@Param("dinner") String dinner,@Param("idDay") int idDay);

}
