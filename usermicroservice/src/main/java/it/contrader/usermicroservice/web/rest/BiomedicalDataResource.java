package it.contrader.usermicroservice.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.usermicroservice.service.BiomedicalDataService;
import it.contrader.usermicroservice.web.rest.errors.BadRequestAlertException;
import it.contrader.usermicroservice.web.rest.util.HeaderUtil;
import it.contrader.usermicroservice.web.rest.util.PaginationUtil;
import it.contrader.usermicroservice.service.dto.BiomedicalDataDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing BiomedicalData.
 */
@RestController
@RequestMapping("/api")
public class BiomedicalDataResource {

    private final Logger log = LoggerFactory.getLogger(BiomedicalDataResource.class);

    private static final String ENTITY_NAME = "biomedicalData";

    private final BiomedicalDataService biomedicalDataService;

    public BiomedicalDataResource(BiomedicalDataService biomedicalDataService) {
        this.biomedicalDataService = biomedicalDataService;
    }

    /**
     * POST  /biomedical-data : Create a new biomedicalData.
     *
     * @param biomedicalDataDTO the biomedicalDataDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new biomedicalDataDTO, or with status 400 (Bad Request) if the biomedicalData has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/biomedical-data")
    @Timed
    public ResponseEntity<BiomedicalDataDTO> createBiomedicalData(@RequestBody BiomedicalDataDTO biomedicalDataDTO) throws URISyntaxException {
        log.debug("REST request to save BiomedicalData : {}", biomedicalDataDTO);
        if (biomedicalDataDTO.getId() != null) {
            throw new BadRequestAlertException("A new biomedicalData cannot already have an ID", ENTITY_NAME, "idexists");
        }
        BiomedicalDataDTO result = biomedicalDataService.save(biomedicalDataDTO);
        return ResponseEntity.created(new URI("/api/biomedical-data/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /biomedical-data : Updates an existing biomedicalData.
     *
     * @param biomedicalDataDTO the biomedicalDataDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated biomedicalDataDTO,
     * or with status 400 (Bad Request) if the biomedicalDataDTO is not valid,
     * or with status 500 (Internal Server Error) if the biomedicalDataDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/biomedical-data")
    @Timed
    public ResponseEntity<BiomedicalDataDTO> updateBiomedicalData(@RequestBody BiomedicalDataDTO biomedicalDataDTO) throws URISyntaxException {
        log.debug("REST request to update BiomedicalData : {}", biomedicalDataDTO);
        if (biomedicalDataDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        BiomedicalDataDTO result = biomedicalDataService.save(biomedicalDataDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, biomedicalDataDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /biomedical-data : get all the biomedicalData.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of biomedicalData in body
     */
    @GetMapping("/biomedical-data")
    @Timed
    public ResponseEntity<List<BiomedicalDataDTO>> getAllBiomedicalData(Pageable pageable) {
        log.debug("REST request to get a page of BiomedicalData");
        Page<BiomedicalDataDTO> page = biomedicalDataService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/biomedical-data");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /biomedical-data/:id : get the "id" biomedicalData.
     *
     * @param id the id of the biomedicalDataDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the biomedicalDataDTO, or with status 404 (Not Found)
     */
    @GetMapping("/biomedical-data/{id}")
    @Timed
    public ResponseEntity<BiomedicalDataDTO> getBiomedicalData(@PathVariable Long id) {
        log.debug("REST request to get BiomedicalData : {}", id);
        Optional<BiomedicalDataDTO> biomedicalDataDTO = biomedicalDataService.findOne(id);
        return ResponseUtil.wrapOrNotFound(biomedicalDataDTO);
    }

    /**
     * DELETE  /biomedical-data/:id : delete the "id" biomedicalData.
     *
     * @param id the id of the biomedicalDataDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/biomedical-data/{id}")
    @Timed
    public ResponseEntity<Void> deleteBiomedicalData(@PathVariable Long id) {
        log.debug("REST request to delete BiomedicalData : {}", id);
        biomedicalDataService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
