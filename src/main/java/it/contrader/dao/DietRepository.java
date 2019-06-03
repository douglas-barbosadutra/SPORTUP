package it.contrader.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.contrader.model.Daily;
import it.contrader.model.Diet;

@Repository
public interface DietRepository extends CrudRepository<Diet, Integer> {

	public Diet findDietByIdDiet(Integer idDiet);

//	public void save(Daily entity);

	
}
