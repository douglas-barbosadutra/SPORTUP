package it.contrader.usermicroservice.service;

import it.contrader.usermicroservice.service.dto.BiomedicalDataDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing BiomedicalData.
 */
public interface BiomedicalDataService {

    /**
     * Save a biomedicalData.
     *
     * @param biomedicalDataDTO the entity to save
     * @return the persisted entity
     */
    BiomedicalDataDTO save(BiomedicalDataDTO biomedicalDataDTO);

    /**
     * Get all the biomedicalData.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<BiomedicalDataDTO> findAll(Pageable pageable);


    /**
     * Get the "id" biomedicalData.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<BiomedicalDataDTO> findOne(Long id);

    /**
     * Delete the "id" biomedicalData.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
