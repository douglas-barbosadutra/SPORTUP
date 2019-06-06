package it.contrader.fitmicroservice.repository;

import it.contrader.fitmicroservice.domain.TrainingCard;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the TrainingCard entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TrainingCardRepository extends JpaRepository<TrainingCard, Long> {

}
