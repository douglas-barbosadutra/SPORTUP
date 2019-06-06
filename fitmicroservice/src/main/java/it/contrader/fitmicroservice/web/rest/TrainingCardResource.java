package it.contrader.fitmicroservice.web.rest;

import com.codahale.metrics.annotation.Timed;
import it.contrader.fitmicroservice.service.TrainingCardService;
import it.contrader.fitmicroservice.web.rest.errors.BadRequestAlertException;
import it.contrader.fitmicroservice.web.rest.util.HeaderUtil;
import it.contrader.fitmicroservice.web.rest.util.PaginationUtil;
import it.contrader.fitmicroservice.service.dto.TrainingCardDTO;
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
 * REST controller for managing TrainingCard.
 */
@RestController
@RequestMapping("/api")
public class TrainingCardResource {

    private final Logger log = LoggerFactory.getLogger(TrainingCardResource.class);

    private static final String ENTITY_NAME = "trainingCard";

    private final TrainingCardService trainingCardService;

    public TrainingCardResource(TrainingCardService trainingCardService) {
        this.trainingCardService = trainingCardService;
    }

    /**
     * POST  /training-cards : Create a new trainingCard.
     *
     * @param trainingCardDTO the trainingCardDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new trainingCardDTO, or with status 400 (Bad Request) if the trainingCard has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/training-cards")
    @Timed
    public ResponseEntity<TrainingCardDTO> createTrainingCard(@Valid @RequestBody TrainingCardDTO trainingCardDTO) throws URISyntaxException {
        log.debug("REST request to save TrainingCard : {}", trainingCardDTO);
        if (trainingCardDTO.getId() != null) {
            throw new BadRequestAlertException("A new trainingCard cannot already have an ID", ENTITY_NAME, "idexists");
        }
        TrainingCardDTO result = trainingCardService.save(trainingCardDTO);
        return ResponseEntity.created(new URI("/api/training-cards/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /training-cards : Updates an existing trainingCard.
     *
     * @param trainingCardDTO the trainingCardDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated trainingCardDTO,
     * or with status 400 (Bad Request) if the trainingCardDTO is not valid,
     * or with status 500 (Internal Server Error) if the trainingCardDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/training-cards")
    @Timed
    public ResponseEntity<TrainingCardDTO> updateTrainingCard(@Valid @RequestBody TrainingCardDTO trainingCardDTO) throws URISyntaxException {
        log.debug("REST request to update TrainingCard : {}", trainingCardDTO);
        if (trainingCardDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        TrainingCardDTO result = trainingCardService.save(trainingCardDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, trainingCardDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /training-cards : get all the trainingCards.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of trainingCards in body
     */
    @GetMapping("/training-cards")
    @Timed
    public ResponseEntity<List<TrainingCardDTO>> getAllTrainingCards(Pageable pageable) {
        log.debug("REST request to get a page of TrainingCards");
        Page<TrainingCardDTO> page = trainingCardService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/training-cards");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /training-cards/:id : get the "id" trainingCard.
     *
     * @param id the id of the trainingCardDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the trainingCardDTO, or with status 404 (Not Found)
     */
    @GetMapping("/training-cards/{id}")
    @Timed
    public ResponseEntity<TrainingCardDTO> getTrainingCard(@PathVariable Long id) {
        log.debug("REST request to get TrainingCard : {}", id);
        Optional<TrainingCardDTO> trainingCardDTO = trainingCardService.findOne(id);
        return ResponseUtil.wrapOrNotFound(trainingCardDTO);
    }

    /**
     * DELETE  /training-cards/:id : delete the "id" trainingCard.
     *
     * @param id the id of the trainingCardDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/training-cards/{id}")
    @Timed
    public ResponseEntity<Void> deleteTrainingCard(@PathVariable Long id) {
        log.debug("REST request to delete TrainingCard : {}", id);
        trainingCardService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
