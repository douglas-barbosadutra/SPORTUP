package it.contrader.fitmicroservice.service.impl;

import it.contrader.fitmicroservice.service.TrainingCardService;
import it.contrader.fitmicroservice.domain.TrainingCard;
import it.contrader.fitmicroservice.repository.TrainingCardRepository;
import it.contrader.fitmicroservice.service.dto.TrainingCardDTO;
import it.contrader.fitmicroservice.service.mapper.TrainingCardMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing TrainingCard.
 */
@Service
@Transactional
public class TrainingCardServiceImpl implements TrainingCardService {

    private final Logger log = LoggerFactory.getLogger(TrainingCardServiceImpl.class);

    private final TrainingCardRepository trainingCardRepository;

    private final TrainingCardMapper trainingCardMapper;

    public TrainingCardServiceImpl(TrainingCardRepository trainingCardRepository, TrainingCardMapper trainingCardMapper) {
        this.trainingCardRepository = trainingCardRepository;
        this.trainingCardMapper = trainingCardMapper;
    }

    /**
     * Save a trainingCard.
     *
     * @param trainingCardDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public TrainingCardDTO save(TrainingCardDTO trainingCardDTO) {
        log.debug("Request to save TrainingCard : {}", trainingCardDTO);
        TrainingCard trainingCard = trainingCardMapper.toEntity(trainingCardDTO);
        trainingCard = trainingCardRepository.save(trainingCard);
        return trainingCardMapper.toDto(trainingCard);
    }

    /**
     * Get all the trainingCards.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<TrainingCardDTO> findAll(Pageable pageable) {
        log.debug("Request to get all TrainingCards");
        return trainingCardRepository.findAll(pageable)
            .map(trainingCardMapper::toDto);
    }


    /**
     * Get one trainingCard by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<TrainingCardDTO> findOne(Long id) {
        log.debug("Request to get TrainingCard : {}", id);
        return trainingCardRepository.findById(id)
            .map(trainingCardMapper::toDto);
    }

    /**
     * Delete the trainingCard by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete TrainingCard : {}", id);
        trainingCardRepository.deleteById(id);
    }
}
