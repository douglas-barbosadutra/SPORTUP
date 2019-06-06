package it.contrader.usermicroservice.repository;

import it.contrader.usermicroservice.domain.BiomedicalData;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the BiomedicalData entity.
 */
@SuppressWarnings("unused")
@Repository
public interface BiomedicalDataRepository extends JpaRepository<BiomedicalData, Long> {

}
