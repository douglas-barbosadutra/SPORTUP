package it.contrader.usermicroservice.service.impl;

import it.contrader.usermicroservice.service.BiomedicalDataService;
import it.contrader.usermicroservice.domain.BiomedicalData;
import it.contrader.usermicroservice.repository.BiomedicalDataRepository;
import it.contrader.usermicroservice.service.dto.BiomedicalDataDTO;
import it.contrader.usermicroservice.service.mapper.BiomedicalDataMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;
/**
 * Service Implementation for managing BiomedicalData.
 */
@Service
@Transactional
public class BiomedicalDataServiceImpl implements BiomedicalDataService {

    private final Logger log = LoggerFactory.getLogger(BiomedicalDataServiceImpl.class);

    private final BiomedicalDataRepository biomedicalDataRepository;

    private final BiomedicalDataMapper biomedicalDataMapper;

    public BiomedicalDataServiceImpl(BiomedicalDataRepository biomedicalDataRepository, BiomedicalDataMapper biomedicalDataMapper) {
        this.biomedicalDataRepository = biomedicalDataRepository;
        this.biomedicalDataMapper = biomedicalDataMapper;
    }

    /**
     * Save a biomedicalData.
     *
     * @param biomedicalDataDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public BiomedicalDataDTO save(BiomedicalDataDTO biomedicalDataDTO) {
        log.debug("Request to save BiomedicalData : {}", biomedicalDataDTO);
        BiomedicalData biomedicalData = biomedicalDataMapper.toEntity(biomedicalDataDTO);
        biomedicalData = biomedicalDataRepository.save(biomedicalData);
        return biomedicalDataMapper.toDto(biomedicalData);
    }

    /**
     * Get all the biomedicalData.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<BiomedicalDataDTO> findAll(Pageable pageable) {
        log.debug("Request to get all BiomedicalData");
        return biomedicalDataRepository.findAll(pageable)
            .map(biomedicalDataMapper::toDto);
    }


    /**
     * Get one biomedicalData by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<BiomedicalDataDTO> findOne(Long id) {
        log.debug("Request to get BiomedicalData : {}", id);
        return biomedicalDataRepository.findById(id)
            .map(biomedicalDataMapper::toDto);
    }

    /**
     * Delete the biomedicalData by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete BiomedicalData : {}", id);
        biomedicalDataRepository.deleteById(id);
    }
}
