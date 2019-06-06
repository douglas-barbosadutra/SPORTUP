package it.contrader.fitmicroservice.service;

import it.contrader.fitmicroservice.service.dto.TrainingCardDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing TrainingCard.
 */
public interface TrainingCardService {

    /**
     * Save a trainingCard.
     *
     * @param trainingCardDTO the entity to save
     * @return the persisted entity
     */
    TrainingCardDTO save(TrainingCardDTO trainingCardDTO);

    /**
     * Get all the trainingCards.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<TrainingCardDTO> findAll(Pageable pageable);


    /**
     * Get the "id" trainingCard.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<TrainingCardDTO> findOne(Long id);

    /**
     * Delete the "id" trainingCard.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
