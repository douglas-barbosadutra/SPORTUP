package it.contrader.usermicroservice.web.rest;

import it.contrader.usermicroservice.UsermicroserviceApp;

import it.contrader.usermicroservice.domain.BiomedicalData;
import it.contrader.usermicroservice.repository.BiomedicalDataRepository;
import it.contrader.usermicroservice.service.BiomedicalDataService;
import it.contrader.usermicroservice.service.dto.BiomedicalDataDTO;
import it.contrader.usermicroservice.service.mapper.BiomedicalDataMapper;
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
 * Test class for the BiomedicalDataResource REST controller.
 *
 * @see BiomedicalDataResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UsermicroserviceApp.class)
public class BiomedicalDataResourceIntTest {

    private static final Integer DEFAULT_HEARTHBEAT = 1;
    private static final Integer UPDATED_HEARTHBEAT = 2;

    private static final Integer DEFAULT_BLOOD_PRESSURE = 1;
    private static final Integer UPDATED_BLOOD_PRESSURE = 2;

    private static final Integer DEFAULT_HEIGHT = 1;
    private static final Integer UPDATED_HEIGHT = 2;

    private static final Integer DEFAULT_WEIGHT = 1;
    private static final Integer UPDATED_WEIGHT = 2;

    private static final Integer DEFAULT_FAT_MASS = 1;
    private static final Integer UPDATED_FAT_MASS = 2;

    private static final Integer DEFAULT_FAT_FREE_MASS = 1;
    private static final Integer UPDATED_FAT_FREE_MASS = 2;

    @Autowired
    private BiomedicalDataRepository biomedicalDataRepository;


    @Autowired
    private BiomedicalDataMapper biomedicalDataMapper;
    

    @Autowired
    private BiomedicalDataService biomedicalDataService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restBiomedicalDataMockMvc;

    private BiomedicalData biomedicalData;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final BiomedicalDataResource biomedicalDataResource = new BiomedicalDataResource(biomedicalDataService);
        this.restBiomedicalDataMockMvc = MockMvcBuilders.standaloneSetup(biomedicalDataResource)
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
    public static BiomedicalData createEntity(EntityManager em) {
        BiomedicalData biomedicalData = new BiomedicalData()
            .hearthbeat(DEFAULT_HEARTHBEAT)
            .bloodPressure(DEFAULT_BLOOD_PRESSURE)
            .height(DEFAULT_HEIGHT)
            .weight(DEFAULT_WEIGHT)
            .fatMass(DEFAULT_FAT_MASS)
            .fatFreeMass(DEFAULT_FAT_FREE_MASS);
        return biomedicalData;
    }

    @Before
    public void initTest() {
        biomedicalData = createEntity(em);
    }

    @Test
    @Transactional
    public void createBiomedicalData() throws Exception {
        int databaseSizeBeforeCreate = biomedicalDataRepository.findAll().size();

        // Create the BiomedicalData
        BiomedicalDataDTO biomedicalDataDTO = biomedicalDataMapper.toDto(biomedicalData);
        restBiomedicalDataMockMvc.perform(post("/api/biomedical-data")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(biomedicalDataDTO)))
            .andExpect(status().isCreated());

        // Validate the BiomedicalData in the database
        List<BiomedicalData> biomedicalDataList = biomedicalDataRepository.findAll();
        assertThat(biomedicalDataList).hasSize(databaseSizeBeforeCreate + 1);
        BiomedicalData testBiomedicalData = biomedicalDataList.get(biomedicalDataList.size() - 1);
        assertThat(testBiomedicalData.getHearthbeat()).isEqualTo(DEFAULT_HEARTHBEAT);
        assertThat(testBiomedicalData.getBloodPressure()).isEqualTo(DEFAULT_BLOOD_PRESSURE);
        assertThat(testBiomedicalData.getHeight()).isEqualTo(DEFAULT_HEIGHT);
        assertThat(testBiomedicalData.getWeight()).isEqualTo(DEFAULT_WEIGHT);
        assertThat(testBiomedicalData.getFatMass()).isEqualTo(DEFAULT_FAT_MASS);
        assertThat(testBiomedicalData.getFatFreeMass()).isEqualTo(DEFAULT_FAT_FREE_MASS);
    }

    @Test
    @Transactional
    public void createBiomedicalDataWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = biomedicalDataRepository.findAll().size();

        // Create the BiomedicalData with an existing ID
        biomedicalData.setId(1L);
        BiomedicalDataDTO biomedicalDataDTO = biomedicalDataMapper.toDto(biomedicalData);

        // An entity with an existing ID cannot be created, so this API call must fail
        restBiomedicalDataMockMvc.perform(post("/api/biomedical-data")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(biomedicalDataDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BiomedicalData in the database
        List<BiomedicalData> biomedicalDataList = biomedicalDataRepository.findAll();
        assertThat(biomedicalDataList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void getAllBiomedicalData() throws Exception {
        // Initialize the database
        biomedicalDataRepository.saveAndFlush(biomedicalData);

        // Get all the biomedicalDataList
        restBiomedicalDataMockMvc.perform(get("/api/biomedical-data?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(biomedicalData.getId().intValue())))
            .andExpect(jsonPath("$.[*].hearthbeat").value(hasItem(DEFAULT_HEARTHBEAT)))
            .andExpect(jsonPath("$.[*].bloodPressure").value(hasItem(DEFAULT_BLOOD_PRESSURE)))
            .andExpect(jsonPath("$.[*].height").value(hasItem(DEFAULT_HEIGHT)))
            .andExpect(jsonPath("$.[*].weight").value(hasItem(DEFAULT_WEIGHT)))
            .andExpect(jsonPath("$.[*].fatMass").value(hasItem(DEFAULT_FAT_MASS)))
            .andExpect(jsonPath("$.[*].fatFreeMass").value(hasItem(DEFAULT_FAT_FREE_MASS)));
    }
    

    @Test
    @Transactional
    public void getBiomedicalData() throws Exception {
        // Initialize the database
        biomedicalDataRepository.saveAndFlush(biomedicalData);

        // Get the biomedicalData
        restBiomedicalDataMockMvc.perform(get("/api/biomedical-data/{id}", biomedicalData.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(biomedicalData.getId().intValue()))
            .andExpect(jsonPath("$.hearthbeat").value(DEFAULT_HEARTHBEAT))
            .andExpect(jsonPath("$.bloodPressure").value(DEFAULT_BLOOD_PRESSURE))
            .andExpect(jsonPath("$.height").value(DEFAULT_HEIGHT))
            .andExpect(jsonPath("$.weight").value(DEFAULT_WEIGHT))
            .andExpect(jsonPath("$.fatMass").value(DEFAULT_FAT_MASS))
            .andExpect(jsonPath("$.fatFreeMass").value(DEFAULT_FAT_FREE_MASS));
    }
    @Test
    @Transactional
    public void getNonExistingBiomedicalData() throws Exception {
        // Get the biomedicalData
        restBiomedicalDataMockMvc.perform(get("/api/biomedical-data/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateBiomedicalData() throws Exception {
        // Initialize the database
        biomedicalDataRepository.saveAndFlush(biomedicalData);

        int databaseSizeBeforeUpdate = biomedicalDataRepository.findAll().size();

        // Update the biomedicalData
        BiomedicalData updatedBiomedicalData = biomedicalDataRepository.findById(biomedicalData.getId()).get();
        // Disconnect from session so that the updates on updatedBiomedicalData are not directly saved in db
        em.detach(updatedBiomedicalData);
        updatedBiomedicalData
            .hearthbeat(UPDATED_HEARTHBEAT)
            .bloodPressure(UPDATED_BLOOD_PRESSURE)
            .height(UPDATED_HEIGHT)
            .weight(UPDATED_WEIGHT)
            .fatMass(UPDATED_FAT_MASS)
            .fatFreeMass(UPDATED_FAT_FREE_MASS);
        BiomedicalDataDTO biomedicalDataDTO = biomedicalDataMapper.toDto(updatedBiomedicalData);

        restBiomedicalDataMockMvc.perform(put("/api/biomedical-data")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(biomedicalDataDTO)))
            .andExpect(status().isOk());

        // Validate the BiomedicalData in the database
        List<BiomedicalData> biomedicalDataList = biomedicalDataRepository.findAll();
        assertThat(biomedicalDataList).hasSize(databaseSizeBeforeUpdate);
        BiomedicalData testBiomedicalData = biomedicalDataList.get(biomedicalDataList.size() - 1);
        assertThat(testBiomedicalData.getHearthbeat()).isEqualTo(UPDATED_HEARTHBEAT);
        assertThat(testBiomedicalData.getBloodPressure()).isEqualTo(UPDATED_BLOOD_PRESSURE);
        assertThat(testBiomedicalData.getHeight()).isEqualTo(UPDATED_HEIGHT);
        assertThat(testBiomedicalData.getWeight()).isEqualTo(UPDATED_WEIGHT);
        assertThat(testBiomedicalData.getFatMass()).isEqualTo(UPDATED_FAT_MASS);
        assertThat(testBiomedicalData.getFatFreeMass()).isEqualTo(UPDATED_FAT_FREE_MASS);
    }

    @Test
    @Transactional
    public void updateNonExistingBiomedicalData() throws Exception {
        int databaseSizeBeforeUpdate = biomedicalDataRepository.findAll().size();

        // Create the BiomedicalData
        BiomedicalDataDTO biomedicalDataDTO = biomedicalDataMapper.toDto(biomedicalData);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restBiomedicalDataMockMvc.perform(put("/api/biomedical-data")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(biomedicalDataDTO)))
            .andExpect(status().isBadRequest());

        // Validate the BiomedicalData in the database
        List<BiomedicalData> biomedicalDataList = biomedicalDataRepository.findAll();
        assertThat(biomedicalDataList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteBiomedicalData() throws Exception {
        // Initialize the database
        biomedicalDataRepository.saveAndFlush(biomedicalData);

        int databaseSizeBeforeDelete = biomedicalDataRepository.findAll().size();

        // Get the biomedicalData
        restBiomedicalDataMockMvc.perform(delete("/api/biomedical-data/{id}", biomedicalData.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<BiomedicalData> biomedicalDataList = biomedicalDataRepository.findAll();
        assertThat(biomedicalDataList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(BiomedicalData.class);
        BiomedicalData biomedicalData1 = new BiomedicalData();
        biomedicalData1.setId(1L);
        BiomedicalData biomedicalData2 = new BiomedicalData();
        biomedicalData2.setId(biomedicalData1.getId());
        assertThat(biomedicalData1).isEqualTo(biomedicalData2);
        biomedicalData2.setId(2L);
        assertThat(biomedicalData1).isNotEqualTo(biomedicalData2);
        biomedicalData1.setId(null);
        assertThat(biomedicalData1).isNotEqualTo(biomedicalData2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(BiomedicalDataDTO.class);
        BiomedicalDataDTO biomedicalDataDTO1 = new BiomedicalDataDTO();
        biomedicalDataDTO1.setId(1L);
        BiomedicalDataDTO biomedicalDataDTO2 = new BiomedicalDataDTO();
        assertThat(biomedicalDataDTO1).isNotEqualTo(biomedicalDataDTO2);
        biomedicalDataDTO2.setId(biomedicalDataDTO1.getId());
        assertThat(biomedicalDataDTO1).isEqualTo(biomedicalDataDTO2);
        biomedicalDataDTO2.setId(2L);
        assertThat(biomedicalDataDTO1).isNotEqualTo(biomedicalDataDTO2);
        biomedicalDataDTO1.setId(null);
        assertThat(biomedicalDataDTO1).isNotEqualTo(biomedicalDataDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(biomedicalDataMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(biomedicalDataMapper.fromId(null)).isNull();
    }
}
