package it.contrader.fitmicroservice.service;

import it.contrader.fitmicroservice.service.dto.DietDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing Diet.
 */
public interface DietService {

    /**
     * Save a diet.
     *
     * @param dietDTO the entity to save
     * @return the persisted entity
     */
    DietDTO save(DietDTO dietDTO);

    /**
     * Get all the diets.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<DietDTO> findAll(Pageable pageable);


    /**
     * Get the "id" diet.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<DietDTO> findOne(Long id);

    /**
     * Delete the "id" diet.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
