package it.contrader.fitmicroservice.service.impl;

import it.contrader.fitmicroservice.service.DietService;
import it.contrader.fitmicroservice.domain.Diet;
import it.contrader.fitmicroservice.repository.DietRepository;
import it.contrader.fitmicroservice.service.dto.DietDTO;
import it.contrader.fitmicroservice.service.mapper.DietMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Diet.
 */
@Service
@Transactional
public class DietServiceImpl implements DietService {

    private final Logger log = LoggerFactory.getLogger(DietServiceImpl.class);

    private final DietRepository dietRepository;

    private final DietMapper dietMapper;

    public DietServiceImpl(DietRepository dietRepository, DietMapper dietMapper) {
        this.dietRepository = dietRepository;
        this.dietMapper = dietMapper;
    }

    /**
     * Save a diet.
     *
     * @param dietDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public DietDTO save(DietDTO dietDTO) {
        log.debug("Request to save Diet : {}", dietDTO);
        Diet diet = dietMapper.toEntity(dietDTO);
        diet = dietRepository.save(diet);
        return dietMapper.toDto(diet);
    }

    /**
     * Get all the diets.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DietDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Diets");
        return dietRepository.findAll(pageable)
            .map(dietMapper::toDto);
    }


    /**
     * Get one diet by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<DietDTO> findOne(Long id) {
        log.debug("Request to get Diet : {}", id);
        return dietRepository.findById(id)
            .map(dietMapper::toDto);
    }

    /**
     * Delete the diet by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Diet : {}", id);
        dietRepository.deleteById(id);
    }
}
