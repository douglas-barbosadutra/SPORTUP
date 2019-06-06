package it.contrader.usermicroservice.service.impl;

import it.contrader.usermicroservice.service.PerformanceService;
import it.contrader.usermicroservice.domain.Performance;
import it.contrader.usermicroservice.repository.PerformanceRepository;
import it.contrader.usermicroservice.service.dto.PerformanceDTO;
import it.contrader.usermicroservice.service.mapper.PerformanceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing Performance.
 */
@Service
@Transactional
public class PerformanceServiceImpl implements PerformanceService {

    private final Logger log = LoggerFactory.getLogger(PerformanceServiceImpl.class);

    private final PerformanceRepository performanceRepository;

    private final PerformanceMapper performanceMapper;

    public PerformanceServiceImpl(PerformanceRepository performanceRepository, PerformanceMapper performanceMapper) {
        this.performanceRepository = performanceRepository;
        this.performanceMapper = performanceMapper;
    }

    /**
     * Save a performance.
     *
     * @param performanceDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public PerformanceDTO save(PerformanceDTO performanceDTO) {
        log.debug("Request to save Performance : {}", performanceDTO);
        Performance performance = performanceMapper.toEntity(performanceDTO);
        performance = performanceRepository.save(performance);
        return performanceMapper.toDto(performance);
    }

    /**
     * Get all the performances.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<PerformanceDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Performances");
        return performanceRepository.findAll(pageable)
            .map(performanceMapper::toDto);
    }


    /**
     * Get one performance by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<PerformanceDTO> findOne(Long id) {
        log.debug("Request to get Performance : {}", id);
        return performanceRepository.findById(id)
            .map(performanceMapper::toDto);
    }

    /**
     * Delete the performance by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Performance : {}", id);
        performanceRepository.deleteById(id);
    }
}
