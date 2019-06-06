package it.contrader.usermicroservice.service;

import it.contrader.usermicroservice.service.dto.PerformanceDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Performance.
 */
public interface PerformanceService {

    /**
     * Save a performance.
     *
     * @param performanceDTO the entity to save
     * @return the persisted entity
     */
    PerformanceDTO save(PerformanceDTO performanceDTO);

    /**
     * Get all the performances.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<PerformanceDTO> findAll(Pageable pageable);


    /**
     * Get the "id" performance.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<PerformanceDTO> findOne(Long id);

    /**
     * Delete the "id" performance.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
