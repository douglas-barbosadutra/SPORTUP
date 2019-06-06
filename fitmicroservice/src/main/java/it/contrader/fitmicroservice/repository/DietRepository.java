package it.contrader.fitmicroservice.repository;

import it.contrader.fitmicroservice.domain.Diet;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Diet entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DietRepository extends JpaRepository<Diet, Long> {

}
