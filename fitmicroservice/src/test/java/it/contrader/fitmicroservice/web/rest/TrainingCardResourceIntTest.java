package it.contrader.fitmicroservice.web.rest;

import it.contrader.fitmicroservice.FitmicroserviceApp;

import it.contrader.fitmicroservice.domain.TrainingCard;
import it.contrader.fitmicroservice.repository.TrainingCardRepository;
import it.contrader.fitmicroservice.service.TrainingCardService;
import it.contrader.fitmicroservice.service.dto.TrainingCardDTO;
import it.contrader.fitmicroservice.service.mapper.TrainingCardMapper;
import it.contrader.fitmicroservice.web.rest.errors.ExceptionTranslator;

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


import static it.contrader.fitmicroservice.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the TrainingCardResource REST controller.
 *
 * @see TrainingCardResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = FitmicroserviceApp.class)
public class TrainingCardResourceIntTest {

    private static final String DEFAULT_MONDAY = "AAAAAAAAAA";
    private static final String UPDATED_MONDAY = "BBBBBBBBBB";

    private static final String DEFAULT_TUESDAY = "AAAAAAAAAA";
    private static final String UPDATED_TUESDAY = "BBBBBBBBBB";

    private static final String DEFAULT_WEDNESDAY = "AAAAAAAAAA";
    private static final String UPDATED_WEDNESDAY = "BBBBBBBBBB";

    private static final String DEFAULT_THURSDAY = "AAAAAAAAAA";
    private static final String UPDATED_THURSDAY = "BBBBBBBBBB";

    private static final String DEFAULT_FRIDAY = "AAAAAAAAAA";
    private static final String UPDATED_FRIDAY = "BBBBBBBBBB";

    private static final String DEFAULT_SATURDAY = "AAAAAAAAAA";
    private static final String UPDATED_SATURDAY = "BBBBBBBBBB";

    private static final String DEFAULT_SUNDAY = "AAAAAAAAAA";
    private static final String UPDATED_SUNDAY = "BBBBBBBBBB";

    private static final Integer DEFAULT_ID_PLAYER = 1;
    private static final Integer UPDATED_ID_PLAYER = 2;

    @Autowired
    private TrainingCardRepository trainingCardRepository;


    @Autowired
    private TrainingCardMapper trainingCardMapper;
    

    @Autowired
    private TrainingCardService trainingCardService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restTrainingCardMockMvc;

    private TrainingCard trainingCard;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final TrainingCardResource trainingCardResource = new TrainingCardResource(trainingCardService);
        this.restTrainingCardMockMvc = MockMvcBuilders.standaloneSetup(trainingCardResource)
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
    public static TrainingCard createEntity(EntityManager em) {
        TrainingCard trainingCard = new TrainingCard()
            .monday(DEFAULT_MONDAY)
            .tuesday(DEFAULT_TUESDAY)
            .wednesday(DEFAULT_WEDNESDAY)
            .thursday(DEFAULT_THURSDAY)
            .friday(DEFAULT_FRIDAY)
            .saturday(DEFAULT_SATURDAY)
            .sunday(DEFAULT_SUNDAY)
            .idPlayer(DEFAULT_ID_PLAYER);
        return trainingCard;
    }

    @Before
    public void initTest() {
        trainingCard = createEntity(em);
    }

    @Test
    @Transactional
    public void createTrainingCard() throws Exception {
        int databaseSizeBeforeCreate = trainingCardRepository.findAll().size();

        // Create the TrainingCard
        TrainingCardDTO trainingCardDTO = trainingCardMapper.toDto(trainingCard);
        restTrainingCardMockMvc.perform(post("/api/training-cards")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trainingCardDTO)))
            .andExpect(status().isCreated());

        // Validate the TrainingCard in the database
        List<TrainingCard> trainingCardList = trainingCardRepository.findAll();
        assertThat(trainingCardList).hasSize(databaseSizeBeforeCreate + 1);
        TrainingCard testTrainingCard = trainingCardList.get(trainingCardList.size() - 1);
        assertThat(testTrainingCard.getMonday()).isEqualTo(DEFAULT_MONDAY);
        assertThat(testTrainingCard.getTuesday()).isEqualTo(DEFAULT_TUESDAY);
        assertThat(testTrainingCard.getWednesday()).isEqualTo(DEFAULT_WEDNESDAY);
        assertThat(testTrainingCard.getThursday()).isEqualTo(DEFAULT_THURSDAY);
        assertThat(testTrainingCard.getFriday()).isEqualTo(DEFAULT_FRIDAY);
        assertThat(testTrainingCard.getSaturday()).isEqualTo(DEFAULT_SATURDAY);
        assertThat(testTrainingCard.getSunday()).isEqualTo(DEFAULT_SUNDAY);
        assertThat(testTrainingCard.getIdPlayer()).isEqualTo(DEFAULT_ID_PLAYER);
    }

    @Test
    @Transactional
    public void createTrainingCardWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = trainingCardRepository.findAll().size();

        // Create the TrainingCard with an existing ID
        trainingCard.setId(1L);
        TrainingCardDTO trainingCardDTO = trainingCardMapper.toDto(trainingCard);

        // An entity with an existing ID cannot be created, so this API call must fail
        restTrainingCardMockMvc.perform(post("/api/training-cards")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trainingCardDTO)))
            .andExpect(status().isBadRequest());

        // Validate the TrainingCard in the database
        List<TrainingCard> trainingCardList = trainingCardRepository.findAll();
        assertThat(trainingCardList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkIdPlayerIsRequired() throws Exception {
        int databaseSizeBeforeTest = trainingCardRepository.findAll().size();
        // set the field null
        trainingCard.setIdPlayer(null);

        // Create the TrainingCard, which fails.
        TrainingCardDTO trainingCardDTO = trainingCardMapper.toDto(trainingCard);

        restTrainingCardMockMvc.perform(post("/api/training-cards")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trainingCardDTO)))
            .andExpect(status().isBadRequest());

        List<TrainingCard> trainingCardList = trainingCardRepository.findAll();
        assertThat(trainingCardList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllTrainingCards() throws Exception {
        // Initialize the database
        trainingCardRepository.saveAndFlush(trainingCard);

        // Get all the trainingCardList
        restTrainingCardMockMvc.perform(get("/api/training-cards?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(trainingCard.getId().intValue())))
            .andExpect(jsonPath("$.[*].monday").value(hasItem(DEFAULT_MONDAY.toString())))
            .andExpect(jsonPath("$.[*].tuesday").value(hasItem(DEFAULT_TUESDAY.toString())))
            .andExpect(jsonPath("$.[*].wednesday").value(hasItem(DEFAULT_WEDNESDAY.toString())))
            .andExpect(jsonPath("$.[*].thursday").value(hasItem(DEFAULT_THURSDAY.toString())))
            .andExpect(jsonPath("$.[*].friday").value(hasItem(DEFAULT_FRIDAY.toString())))
            .andExpect(jsonPath("$.[*].saturday").value(hasItem(DEFAULT_SATURDAY.toString())))
            .andExpect(jsonPath("$.[*].sunday").value(hasItem(DEFAULT_SUNDAY.toString())))
            .andExpect(jsonPath("$.[*].idPlayer").value(hasItem(DEFAULT_ID_PLAYER)));
    }
    

    @Test
    @Transactional
    public void getTrainingCard() throws Exception {
        // Initialize the database
        trainingCardRepository.saveAndFlush(trainingCard);

        // Get the trainingCard
        restTrainingCardMockMvc.perform(get("/api/training-cards/{id}", trainingCard.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(trainingCard.getId().intValue()))
            .andExpect(jsonPath("$.monday").value(DEFAULT_MONDAY.toString()))
            .andExpect(jsonPath("$.tuesday").value(DEFAULT_TUESDAY.toString()))
            .andExpect(jsonPath("$.wednesday").value(DEFAULT_WEDNESDAY.toString()))
            .andExpect(jsonPath("$.thursday").value(DEFAULT_THURSDAY.toString()))
            .andExpect(jsonPath("$.friday").value(DEFAULT_FRIDAY.toString()))
            .andExpect(jsonPath("$.saturday").value(DEFAULT_SATURDAY.toString()))
            .andExpect(jsonPath("$.sunday").value(DEFAULT_SUNDAY.toString()))
            .andExpect(jsonPath("$.idPlayer").value(DEFAULT_ID_PLAYER));
    }
    @Test
    @Transactional
    public void getNonExistingTrainingCard() throws Exception {
        // Get the trainingCard
        restTrainingCardMockMvc.perform(get("/api/training-cards/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateTrainingCard() throws Exception {
        // Initialize the database
        trainingCardRepository.saveAndFlush(trainingCard);

        int databaseSizeBeforeUpdate = trainingCardRepository.findAll().size();

        // Update the trainingCard
        TrainingCard updatedTrainingCard = trainingCardRepository.findById(trainingCard.getId()).get();
        // Disconnect from session so that the updates on updatedTrainingCard are not directly saved in db
        em.detach(updatedTrainingCard);
        updatedTrainingCard
            .monday(UPDATED_MONDAY)
            .tuesday(UPDATED_TUESDAY)
            .wednesday(UPDATED_WEDNESDAY)
            .thursday(UPDATED_THURSDAY)
            .friday(UPDATED_FRIDAY)
            .saturday(UPDATED_SATURDAY)
            .sunday(UPDATED_SUNDAY)
            .idPlayer(UPDATED_ID_PLAYER);
        TrainingCardDTO trainingCardDTO = trainingCardMapper.toDto(updatedTrainingCard);

        restTrainingCardMockMvc.perform(put("/api/training-cards")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trainingCardDTO)))
            .andExpect(status().isOk());

        // Validate the TrainingCard in the database
        List<TrainingCard> trainingCardList = trainingCardRepository.findAll();
        assertThat(trainingCardList).hasSize(databaseSizeBeforeUpdate);
        TrainingCard testTrainingCard = trainingCardList.get(trainingCardList.size() - 1);
        assertThat(testTrainingCard.getMonday()).isEqualTo(UPDATED_MONDAY);
        assertThat(testTrainingCard.getTuesday()).isEqualTo(UPDATED_TUESDAY);
        assertThat(testTrainingCard.getWednesday()).isEqualTo(UPDATED_WEDNESDAY);
        assertThat(testTrainingCard.getThursday()).isEqualTo(UPDATED_THURSDAY);
        assertThat(testTrainingCard.getFriday()).isEqualTo(UPDATED_FRIDAY);
        assertThat(testTrainingCard.getSaturday()).isEqualTo(UPDATED_SATURDAY);
        assertThat(testTrainingCard.getSunday()).isEqualTo(UPDATED_SUNDAY);
        assertThat(testTrainingCard.getIdPlayer()).isEqualTo(UPDATED_ID_PLAYER);
    }

    @Test
    @Transactional
    public void updateNonExistingTrainingCard() throws Exception {
        int databaseSizeBeforeUpdate = trainingCardRepository.findAll().size();

        // Create the TrainingCard
        TrainingCardDTO trainingCardDTO = trainingCardMapper.toDto(trainingCard);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restTrainingCardMockMvc.perform(put("/api/training-cards")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(trainingCardDTO)))
            .andExpect(status().isBadRequest());

        // Validate the TrainingCard in the database
        List<TrainingCard> trainingCardList = trainingCardRepository.findAll();
        assertThat(trainingCardList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteTrainingCard() throws Exception {
        // Initialize the database
        trainingCardRepository.saveAndFlush(trainingCard);

        int databaseSizeBeforeDelete = trainingCardRepository.findAll().size();

        // Get the trainingCard
        restTrainingCardMockMvc.perform(delete("/api/training-cards/{id}", trainingCard.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<TrainingCard> trainingCardList = trainingCardRepository.findAll();
        assertThat(trainingCardList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(TrainingCard.class);
        TrainingCard trainingCard1 = new TrainingCard();
        trainingCard1.setId(1L);
        TrainingCard trainingCard2 = new TrainingCard();
        trainingCard2.setId(trainingCard1.getId());
        assertThat(trainingCard1).isEqualTo(trainingCard2);
        trainingCard2.setId(2L);
        assertThat(trainingCard1).isNotEqualTo(trainingCard2);
        trainingCard1.setId(null);
        assertThat(trainingCard1).isNotEqualTo(trainingCard2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(TrainingCardDTO.class);
        TrainingCardDTO trainingCardDTO1 = new TrainingCardDTO();
        trainingCardDTO1.setId(1L);
        TrainingCardDTO trainingCardDTO2 = new TrainingCardDTO();
        assertThat(trainingCardDTO1).isNotEqualTo(trainingCardDTO2);
        trainingCardDTO2.setId(trainingCardDTO1.getId());
        assertThat(trainingCardDTO1).isEqualTo(trainingCardDTO2);
        trainingCardDTO2.setId(2L);
        assertThat(trainingCardDTO1).isNotEqualTo(trainingCardDTO2);
        trainingCardDTO1.setId(null);
        assertThat(trainingCardDTO1).isNotEqualTo(trainingCardDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(trainingCardMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(trainingCardMapper.fromId(null)).isNull();
    }
}
