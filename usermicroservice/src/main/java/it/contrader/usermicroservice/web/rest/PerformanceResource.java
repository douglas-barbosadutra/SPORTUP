package it.contrader.usermicroservice.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.usermicroservice.service.PerformanceService;
import it.contrader.usermicroservice.web.rest.errors.BadRequestAlertException;
import it.contrader.usermicroservice.web.rest.util.HeaderUtil;
import it.contrader.usermicroservice.web.rest.util.PaginationUtil;
import it.contrader.usermicroservice.service.dto.PerformanceDTO;
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
 * REST controller for managing Performance.
 */
@RestController
@RequestMapping("/api")
public class PerformanceResource {

    private final Logger log = LoggerFactory.getLogger(PerformanceResource.class);

    private static final String ENTITY_NAME = "performance";

    private final PerformanceService performanceService;

    public PerformanceResource(PerformanceService performanceService) {
        this.performanceService = performanceService;
    }

    /**
     * POST  /performances : Create a new performance.
     *
     * @param performanceDTO the performanceDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new performanceDTO, or with status 400 (Bad Request) if the performance has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/performances")
    @Timed
    public ResponseEntity<PerformanceDTO> createPerformance(@RequestBody PerformanceDTO performanceDTO) throws URISyntaxException {
        log.debug("REST request to save Performance : {}", performanceDTO);
        if (performanceDTO.getId() != null) {
            throw new BadRequestAlertException("A new performance cannot already have an ID", ENTITY_NAME, "idexists");
        }
        PerformanceDTO result = performanceService.save(performanceDTO);
        return ResponseEntity.created(new URI("/api/performances/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /performances : Updates an existing performance.
     *
     * @param performanceDTO the performanceDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated performanceDTO,
     * or with status 400 (Bad Request) if the performanceDTO is not valid,
     * or with status 500 (Internal Server Error) if the performanceDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/performances")
    @Timed
    public ResponseEntity<PerformanceDTO> updatePerformance(@RequestBody PerformanceDTO performanceDTO) throws URISyntaxException {
        log.debug("REST request to update Performance : {}", performanceDTO);
        if (performanceDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        PerformanceDTO result = performanceService.save(performanceDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, performanceDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /performances : get all the performances.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of performances in body
     */
    @GetMapping("/performances")
    @Timed
    public ResponseEntity<List<PerformanceDTO>> getAllPerformances(Pageable pageable) {
        log.debug("REST request to get a page of Performances");
        Page<PerformanceDTO> page = performanceService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/performances");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /performances/:id : get the "id" performance.
     *
     * @param id the id of the performanceDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the performanceDTO, or with status 404 (Not Found)
     */
    @GetMapping("/performances/{id}")
    @Timed
    public ResponseEntity<PerformanceDTO> getPerformance(@PathVariable Long id) {
        log.debug("REST request to get Performance : {}", id);
        Optional<PerformanceDTO> performanceDTO = performanceService.findOne(id);
        return ResponseUtil.wrapOrNotFound(performanceDTO);
    }

    /**
     * DELETE  /performances/:id : delete the "id" performance.
     *
     * @param id the id of the performanceDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/performances/{id}")
    @Timed
    public ResponseEntity<Void> deletePerformance(@PathVariable Long id) {
        log.debug("REST request to delete Performance : {}", id);
        performanceService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
