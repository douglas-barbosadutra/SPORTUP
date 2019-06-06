package it.contrader.usermicroservice.web.rest;

import it.contrader.usermicroservice.UsermicroserviceApp;

import it.contrader.usermicroservice.domain.Player;
import it.contrader.usermicroservice.domain.BiomedicalData;
import it.contrader.usermicroservice.domain.Performance;
import it.contrader.usermicroservice.repository.PlayerRepository;
import it.contrader.usermicroservice.service.PlayerService;
import it.contrader.usermicroservice.service.dto.PlayerDTO;
import it.contrader.usermicroservice.service.mapper.PlayerMapper;
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
 * Test class for the PlayerResource REST controller.
 *
 * @see PlayerResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = UsermicroserviceApp.class)
public class PlayerResourceIntTest {

    private static final Integer DEFAULT_ID_BIOMEDICAL_DATA = 1;
    private static final Integer UPDATED_ID_BIOMEDICAL_DATA = 2;

    private static final Integer DEFAULT_ID_PERFORMANCE = 1;
    private static final Integer UPDATED_ID_PERFORMANCE = 2;

    private static final Integer DEFAULT_ID_USER = 1;
    private static final Integer UPDATED_ID_USER = 2;

    @Autowired
    private PlayerRepository playerRepository;


    @Autowired
    private PlayerMapper playerMapper;
    

    @Autowired
    private PlayerService playerService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restPlayerMockMvc;

    private Player player;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final PlayerResource playerResource = new PlayerResource(playerService);
        this.restPlayerMockMvc = MockMvcBuilders.standaloneSetup(playerResource)
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
    public static Player createEntity(EntityManager em) {
        Player player = new Player()
            .idBiomedicalData(DEFAULT_ID_BIOMEDICAL_DATA)
            .idPerformance(DEFAULT_ID_PERFORMANCE)
            .idUser(DEFAULT_ID_USER);
        // Add required entity
        BiomedicalData biomedicalData = BiomedicalDataResourceIntTest.createEntity(em);
        em.persist(biomedicalData);
        em.flush();
        player.setBiomedicalData(biomedicalData);
        // Add required entity
        Performance performance = PerformanceResourceIntTest.createEntity(em);
        em.persist(performance);
        em.flush();
        player.setPerformance(performance);
        return player;
    }

    @Before
    public void initTest() {
        player = createEntity(em);
    }

    @Test
    @Transactional
    public void createPlayer() throws Exception {
        int databaseSizeBeforeCreate = playerRepository.findAll().size();

        // Create the Player
        PlayerDTO playerDTO = playerMapper.toDto(player);
        restPlayerMockMvc.perform(post("/api/players")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(playerDTO)))
            .andExpect(status().isCreated());

        // Validate the Player in the database
        List<Player> playerList = playerRepository.findAll();
        assertThat(playerList).hasSize(databaseSizeBeforeCreate + 1);
        Player testPlayer = playerList.get(playerList.size() - 1);
        assertThat(testPlayer.getIdBiomedicalData()).isEqualTo(DEFAULT_ID_BIOMEDICAL_DATA);
        assertThat(testPlayer.getIdPerformance()).isEqualTo(DEFAULT_ID_PERFORMANCE);
        assertThat(testPlayer.getIdUser()).isEqualTo(DEFAULT_ID_USER);
    }

    @Test
    @Transactional
    public void createPlayerWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = playerRepository.findAll().size();

        // Create the Player with an existing ID
        player.setId(1L);
        PlayerDTO playerDTO = playerMapper.toDto(player);

        // An entity with an existing ID cannot be created, so this API call must fail
        restPlayerMockMvc.perform(post("/api/players")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(playerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Player in the database
        List<Player> playerList = playerRepository.findAll();
        assertThat(playerList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkIdBiomedicalDataIsRequired() throws Exception {
        int databaseSizeBeforeTest = playerRepository.findAll().size();
        // set the field null
        player.setIdBiomedicalData(null);

        // Create the Player, which fails.
        PlayerDTO playerDTO = playerMapper.toDto(player);

        restPlayerMockMvc.perform(post("/api/players")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(playerDTO)))
            .andExpect(status().isBadRequest());

        List<Player> playerList = playerRepository.findAll();
        assertThat(playerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkIdPerformanceIsRequired() throws Exception {
        int databaseSizeBeforeTest = playerRepository.findAll().size();
        // set the field null
        player.setIdPerformance(null);

        // Create the Player, which fails.
        PlayerDTO playerDTO = playerMapper.toDto(player);

        restPlayerMockMvc.perform(post("/api/players")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(playerDTO)))
            .andExpect(status().isBadRequest());

        List<Player> playerList = playerRepository.findAll();
        assertThat(playerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkIdUserIsRequired() throws Exception {
        int databaseSizeBeforeTest = playerRepository.findAll().size();
        // set the field null
        player.setIdUser(null);

        // Create the Player, which fails.
        PlayerDTO playerDTO = playerMapper.toDto(player);

        restPlayerMockMvc.perform(post("/api/players")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(playerDTO)))
            .andExpect(status().isBadRequest());

        List<Player> playerList = playerRepository.findAll();
        assertThat(playerList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllPlayers() throws Exception {
        // Initialize the database
        playerRepository.saveAndFlush(player);

        // Get all the playerList
        restPlayerMockMvc.perform(get("/api/players?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(player.getId().intValue())))
            .andExpect(jsonPath("$.[*].idBiomedicalData").value(hasItem(DEFAULT_ID_BIOMEDICAL_DATA)))
            .andExpect(jsonPath("$.[*].idPerformance").value(hasItem(DEFAULT_ID_PERFORMANCE)))
            .andExpect(jsonPath("$.[*].idUser").value(hasItem(DEFAULT_ID_USER)));
    }
    

    @Test
    @Transactional
    public void getPlayer() throws Exception {
        // Initialize the database
        playerRepository.saveAndFlush(player);

        // Get the player
        restPlayerMockMvc.perform(get("/api/players/{id}", player.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(player.getId().intValue()))
            .andExpect(jsonPath("$.idBiomedicalData").value(DEFAULT_ID_BIOMEDICAL_DATA))
            .andExpect(jsonPath("$.idPerformance").value(DEFAULT_ID_PERFORMANCE))
            .andExpect(jsonPath("$.idUser").value(DEFAULT_ID_USER));
    }
    @Test
    @Transactional
    public void getNonExistingPlayer() throws Exception {
        // Get the player
        restPlayerMockMvc.perform(get("/api/players/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updatePlayer() throws Exception {
        // Initialize the database
        playerRepository.saveAndFlush(player);

        int databaseSizeBeforeUpdate = playerRepository.findAll().size();

        // Update the player
        Player updatedPlayer = playerRepository.findById(player.getId()).get();
        // Disconnect from session so that the updates on updatedPlayer are not directly saved in db
        em.detach(updatedPlayer);
        updatedPlayer
            .idBiomedicalData(UPDATED_ID_BIOMEDICAL_DATA)
            .idPerformance(UPDATED_ID_PERFORMANCE)
            .idUser(UPDATED_ID_USER);
        PlayerDTO playerDTO = playerMapper.toDto(updatedPlayer);

        restPlayerMockMvc.perform(put("/api/players")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(playerDTO)))
            .andExpect(status().isOk());

        // Validate the Player in the database
        List<Player> playerList = playerRepository.findAll();
        assertThat(playerList).hasSize(databaseSizeBeforeUpdate);
        Player testPlayer = playerList.get(playerList.size() - 1);
        assertThat(testPlayer.getIdBiomedicalData()).isEqualTo(UPDATED_ID_BIOMEDICAL_DATA);
        assertThat(testPlayer.getIdPerformance()).isEqualTo(UPDATED_ID_PERFORMANCE);
        assertThat(testPlayer.getIdUser()).isEqualTo(UPDATED_ID_USER);
    }

    @Test
    @Transactional
    public void updateNonExistingPlayer() throws Exception {
        int databaseSizeBeforeUpdate = playerRepository.findAll().size();

        // Create the Player
        PlayerDTO playerDTO = playerMapper.toDto(player);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException 
        restPlayerMockMvc.perform(put("/api/players")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(playerDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Player in the database
        List<Player> playerList = playerRepository.findAll();
        assertThat(playerList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deletePlayer() throws Exception {
        // Initialize the database
        playerRepository.saveAndFlush(player);

        int databaseSizeBeforeDelete = playerRepository.findAll().size();

        // Get the player
        restPlayerMockMvc.perform(delete("/api/players/{id}", player.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Player> playerList = playerRepository.findAll();
        assertThat(playerList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Player.class);
        Player player1 = new Player();
        player1.setId(1L);
        Player player2 = new Player();
        player2.setId(player1.getId());
        assertThat(player1).isEqualTo(player2);
        player2.setId(2L);
        assertThat(player1).isNotEqualTo(player2);
        player1.setId(null);
        assertThat(player1).isNotEqualTo(player2);
    }

    @Test
    @Transactional
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(PlayerDTO.class);
        PlayerDTO playerDTO1 = new PlayerDTO();
        playerDTO1.setId(1L);
        PlayerDTO playerDTO2 = new PlayerDTO();
        assertThat(playerDTO1).isNotEqualTo(playerDTO2);
        playerDTO2.setId(playerDTO1.getId());
        assertThat(playerDTO1).isEqualTo(playerDTO2);
        playerDTO2.setId(2L);
        assertThat(playerDTO1).isNotEqualTo(playerDTO2);
        playerDTO1.setId(null);
        assertThat(playerDTO1).isNotEqualTo(playerDTO2);
    }

    @Test
    @Transactional
    public void testEntityFromId() {
        assertThat(playerMapper.fromId(42L).getId()).isEqualTo(42);
        assertThat(playerMapper.fromId(null)).isNull();
    }
}
