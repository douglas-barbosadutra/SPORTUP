package it.contrader.fitmicroservice.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.fitmicroservice.service.DietService;
import it.contrader.fitmicroservice.web.rest.errors.BadRequestAlertException;
import it.contrader.fitmicroservice.web.rest.util.HeaderUtil;
import it.contrader.fitmicroservice.web.rest.util.PaginationUtil;
import it.contrader.fitmicroservice.service.dto.DietDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Diet.
 */
@RestController
@RequestMapping("/api")
public class DietResource {

    private final Logger log = LoggerFactory.getLogger(DietResource.class);

    private static final String ENTITY_NAME = "diet";

    private final DietService dietService;

    public DietResource(DietService dietService) {
        this.dietService = dietService;
    }

    /**
     * POST  /diets : Create a new diet.
     *
     * @param dietDTO the dietDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new dietDTO, or with status 400 (Bad Request) if the diet has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/diets")
    @Timed
    public ResponseEntity<DietDTO> createDiet(@Valid @RequestBody DietDTO dietDTO) throws URISyntaxException {
        log.debug("REST request to save Diet : {}", dietDTO);
        if (dietDTO.getId() != null) {
            throw new BadRequestAlertException("A new diet cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DietDTO result = dietService.save(dietDTO);
        return ResponseEntity.created(new URI("/api/diets/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /diets : Updates an existing diet.
     *
     * @param dietDTO the dietDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated dietDTO,
     * or with status 400 (Bad Request) if the dietDTO is not valid,
     * or with status 500 (Internal Server Error) if the dietDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/diets")
    @Timed
    public ResponseEntity<DietDTO> updateDiet(@Valid @RequestBody DietDTO dietDTO) throws URISyntaxException {
        log.debug("REST request to update Diet : {}", dietDTO);
        if (dietDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        DietDTO result = dietService.save(dietDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, dietDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /diets : get all the diets.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of diets in body
     */
    @GetMapping("/diets")
    @Timed
    public ResponseEntity<List<DietDTO>> getAllDiets(Pageable pageable) {
        log.debug("REST request to get a page of Diets");
        Page<DietDTO> page = dietService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/diets");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /diets/:id : get the "id" diet.
     *
     * @param id the id of the dietDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the dietDTO, or with status 404 (Not Found)
     */
    @GetMapping("/diets/{id}")
    @Timed
    public ResponseEntity<DietDTO> getDiet(@PathVariable Long id) {
        log.debug("REST request to get Diet : {}", id);
        Optional<DietDTO> dietDTO = dietService.findOne(id);
        return ResponseUtil.wrapOrNotFound(dietDTO);
    }

    /**
     * DELETE  /diets/:id : delete the "id" diet.
     *
     * @param id the id of the dietDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/diets/{id}")
    @Timed
    public ResponseEntity<Void> deleteDiet(@PathVariable Long id) {
        log.debug("REST request to delete Diet : {}", id);
        dietService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
