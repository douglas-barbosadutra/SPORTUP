package it.contrader.usermicroservice.repository;

import it.contrader.usermicroservice.domain.Performance;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Performance entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PerformanceRepository extends JpaRepository<Performance, Long> {

}
