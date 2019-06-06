package it.contrader.usermicroservice.web.rest;

import it.contrader.usermicroservice.UsermicroserviceApp;

import it.contrader.usermicroservice.domain.Performance;
import it.contrader.usermicroservice.repository.PerformanceRepository;
import it.contrader.usermicroservice.service.PerformanceService;
import it.contrader.usermicroservice.service.dto.PerformanceDTO;
import it.contrader.usermicroservice.service.mapper.PerformanceMapper;
import it.contrader.usermicroservice.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;


import static it.contrader.usermicroservice.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the PerformanceResource REST controller.
 *
 * @see PerformanceResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UsermicroserviceApp.class)
public class PerformanceResourceIntTest {

    private static final Integer DEFAULT_MAX_CORSA_MIN = 1;
    private static final Integer UPDATED_MAX_CORSA_MIN = 2;

    private static final Integer DEFAULT_MAX_FLESSIONI = 1;
    private static final Integer UPDATED_MAX_FLESSIONI = 2;

    private static final Integer DEFAULT_MAX_ADDOMINALI = 1;
    private static final Integer UPDATED_MAX_ADDOMINALI = 2;

    @Autowired
    private PerformanceRepository performanceRepository;


    @Autowired
    private PerformanceMapper performanceMapper;
    

    @Autowired
    private PerformanceService performanceService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restPerformanceMockMvc;

    private Performance performance;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final PerformanceResource performanceResource = new PerformanceResource(performanceService);
        this.restPerformanceMockMvc = MockMvcBuilders.standaloneSetup(performanceResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Performance createEntity(EntityManager em) {
        Performance performance = new Performance()
            .maxCorsaMin(DEFAULT_MAX_CORSA_MIN)
            .maxFlessioni(DEFAULT_MAX_FLESSIONI)
            .maxAddominali(DEFAULT_MAX_ADDOMINALI);
        return performance;
    }

    @Before
    public void initTest() {
        performance = createEntity(em);
    }

    @Test
    @Transactional
    public void createPerformance() throws Exception {
        int databaseSizeBeforeCreate = performanceRepository.findAll().size();

        // Create the Performance
        PerformanceDTO performanceDTO = performanceMapper.toDto(performance);
        restPerformanceMockMvc.perform(post("/api/performances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(performanceDTO)))
            .andExpect(status().isCreated());

        // Validate the Performance in the database
        List<Performance> performanceList = performanceRepository.findAll();
        assertThat(performanceList).hasSize(databaseSizeBeforeCreate + 1);
        Performance testPerformance = performanceList.get(performanceList.size() - 1);
        assertThat(testPerformance.getMaxCorsaMin()).isEqualTo(DEFAULT_MAX_CORSA_MIN);
        assertThat(testPerformance.getMaxFlessioni()).isEqualTo(DEFAULT_MAX_FLESSIONI);
        assertThat(testPerformance.getMaxAddominali()).isEqualTo(DEFAULT_MAX_ADDOMINALI);
    }

    @Test
    @Transactional
    public void createPerformanceWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = performanceRepository.findAll().size();

        // Create the Performance with an existing ID
        performance.setId(1L);
        PerformanceDTO performanceDTO = performanceMapper.toDto(performance);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPerformanceMockMvc.perform(post("/api/performances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(performanceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Performance in the database
        List<Performance> performanceList = performanceRepository.findAll();
        assertThat(performanceList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllPerformances() throws Exception {
        // Initialize the database
        performanceRepository.saveAndFlush(performance);

        // Get all the performanceList
        restPerformanceMockMvc.perform(get("/api/performances?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(performance.getId().intValue())))
            .andExpect(jsonPath("$.[*].maxCorsaMin").value(hasItem(DEFAULT_MAX_CORSA_MIN)))
            .andExpect(jsonPath("$.[*].maxFlessioni").value(hasItem(DEFAULT_MAX_FLESSIONI)))
            .andExpect(jsonPath("$.[*].maxAddominali").value(hasItem(DEFAULT_MAX_ADDOMINALI)));
    }
    

    @Test
    @Transactional
    public void getPerformance() throws Exception {
        // Initialize the database
        performanceRepository.saveAndFlush(performance);

        // Get the performance
        restPerformanceMockMvc.perform(get("/api/performances/{id}", performance.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(performance.getId().intValue()))
            .andExpect(jsonPath("$.maxCorsaMin").value(DEFAULT_MAX_CORSA_MIN))
            .andExpect(jsonPath("$.maxFlessioni").value(DEFAULT_MAX_FLESSIONI))
            .andExpect(jsonPath("$.maxAddominali").value(DEFAULT_MAX_ADDOMINALI));
    }
    @Test
    @Transactional
    public void getNonExistingPerformance() throws Exception {
        // Get the performance
        restPerformanceMockMvc.perform(get("/api/performances/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePerformance() throws Exception {
        // Initialize the database
        performanceRepository.saveAndFlush(performance);

        int databaseSizeBeforeUpdate = performanceRepository.findAll().size();

        // Update the performance
        Performance updatedPerformance = performanceRepository.findById(performance.getId()).get();
        // Disconnect from session so that the updates on updatedPerformance are not directly saved in db
        em.detach(updatedPerformance);
        updatedPerformance
            .maxCorsaMin(UPDATED_MAX_CORSA_MIN)
            .maxFlessioni(UPDATED_MAX_FLESSIONI)
            .maxAddominali(UPDATED_MAX_ADDOMINALI);
        PerformanceDTO performanceDTO = performanceMapper.toDto(updatedPerformance);

        restPerformanceMockMvc.perform(put("/api/performances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(performanceDTO)))
            .andExpect(status().isOk());

        // Validate the Performance in the database
        List<Performance> performanceList = performanceRepository.findAll();
        assertThat(performanceList).hasSize(databaseSizeBeforeUpdate);
        Performance testPerformance = performanceList.get(performanceList.size() - 1);
        assertThat(testPerformance.getMaxCorsaMin()).isEqualTo(UPDATED_MAX_CORSA_MIN);
        assertThat(testPerformance.getMaxFlessioni()).isEqualTo(UPDATED_MAX_FLESSIONI);
        assertThat(testPerformance.getMaxAddominali()).isEqualTo(UPDATED_MAX_ADDOMINALI);
    }

    @Test
    @Transactional
    public void updateNonExistingPerformance() throws Exception {
        int databaseSizeBeforeUpdate = performanceRepository.findAll().size();

        // Create the Performance
        PerformanceDTO performanceDTO = performanceMapper.toDto(performance);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restPerformanceMockMvc.perform(put("/api/performances")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(performanceDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Performance in the database
        List<Performance> performanceList = performanceRepository.findAll();
        assertThat(performanceList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePerformance() throws Exception {
        // Initialize the database
        performanceRepository.saveAndFlush(performance);

        int databaseSizeBeforeDelete = performanceRepository.findAll().size();

        // Get the performance
        restPerformanceMockMvc.perform(delete("/api/performances/{id}", performance.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Performance> performanceList = performanceRepository.findAll();
        assertThat(performanceList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Performance.class);
        Performance performance1 = new Performance();
        performance1.setId(1L);
        Performance performance2 = new Performance();
        performance2.setId(performance1.getId());
        assertThat(performance1).isEqualTo(performance2);
        performance2.setId(2L);
        assertThat(performance1).isNotEqualTo(performance2);
        performance1.setId(null);
        assertThat(performance1).isNotEqualTo(performance2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PerformanceDTO.class);
        PerformanceDTO performanceDTO1 = new PerformanceDTO();
        performanceDTO1.setId(1L);
        PerformanceDTO performanceDTO2 = new PerformanceDTO();
        assertThat(performanceDTO1).isNotEqualTo(performanceDTO2);
        performanceDTO2.setId(performanceDTO1.getId());
        assertThat(performanceDTO1).isEqualTo(performanceDTO2);
        performanceDTO2.setId(2L);
        assertThat(performanceDTO1).isNotEqualTo(performanceDTO2);
        performanceDTO1.setId(null);
        assertThat(performanceDTO1).isNotEqualTo(performanceDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(performanceMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(performanceMapper.fromId(null)).isNull();
    }
}
