package com.jhipsterpractice.app.web.rest;

import com.jhipsterpractice.app.JhipsterPracticeApp;
import com.jhipsterpractice.app.domain.KCP;
import com.jhipsterpractice.app.repository.KCPRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link KCPResource} REST controller.
 */
@SpringBootTest(classes = JhipsterPracticeApp.class)
@AutoConfigureMockMvc
@WithMockUser
public class KCPResourceIT {

    private static final String DEFAULT_LOGIN = "AAAAAAAAAA";
    private static final String UPDATED_LOGIN = "BBBBBBBBBB";

    private static final String DEFAULT_PASSWORD = "AAAAAAAAAA";
    private static final String UPDATED_PASSWORD = "BBBBBBBBBB";

    private static final String DEFAULT_FIRST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_FIRST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_LAST_NAME = "AAAAAAAAAA";
    private static final String UPDATED_LAST_NAME = "BBBBBBBBBB";

    private static final String DEFAULT_EMAIL = "AAAAAAAAAA";
    private static final String UPDATED_EMAIL = "BBBBBBBBBB";

    private static final Boolean DEFAULT_ACTIVATED = false;
    private static final Boolean UPDATED_ACTIVATED = true;

    private static final String DEFAULT_LANG_KEY = "AAAAAAAAAA";
    private static final String UPDATED_LANG_KEY = "BBBBBBBBBB";

    private static final String DEFAULT_IMAGE_URL = "AAAAAAAAAA";
    private static final String UPDATED_IMAGE_URL = "BBBBBBBBBB";

    private static final String DEFAULT_ACTIVATION_KEY = "AAAAAAAAAA";
    private static final String UPDATED_ACTIVATION_KEY = "BBBBBBBBBB";

    private static final String DEFAULT_RESET_KEY = "AAAAAAAAAA";
    private static final String UPDATED_RESET_KEY = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_RESET_DATE = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_RESET_DATE = LocalDate.now(ZoneId.systemDefault());

    private static final String DEFAULT_DESIGNATION = "AAAAAAAAAA";
    private static final String UPDATED_DESIGNATION = "BBBBBBBBBB";

    private static final String DEFAULT_NID = "AAAAAAAAAA";
    private static final String UPDATED_NID = "BBBBBBBBBB";

    private static final String DEFAULT_COMPANY = "AAAAAAAAAA";
    private static final String UPDATED_COMPANY = "BBBBBBBBBB";

    @Autowired
    private KCPRepository kCPRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private MockMvc restKCPMockMvc;

    private KCP kCP;

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static KCP createEntity(EntityManager em) {
        KCP kCP = new KCP()
//            .login(DEFAULT_LOGIN)
//            .password(DEFAULT_PASSWORD)
//            .firstName(DEFAULT_FIRST_NAME)
//            .lastName(DEFAULT_LAST_NAME)
//            .email(DEFAULT_EMAIL)
//            .activated(DEFAULT_ACTIVATED)
//            .langKey(DEFAULT_LANG_KEY)
//            .imageUrl(DEFAULT_IMAGE_URL)
//            .activationKey(DEFAULT_ACTIVATION_KEY)
//            .resetKey(DEFAULT_RESET_KEY)
//            .resetDate(DEFAULT_RESET_DATE)
            .designation(DEFAULT_DESIGNATION)
            .nid(DEFAULT_NID)
            .company(DEFAULT_COMPANY);
        return kCP;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static KCP createUpdatedEntity(EntityManager em) {
        KCP kCP = new KCP()
//            .login(UPDATED_LOGIN)
//            .password(UPDATED_PASSWORD)
//            .firstName(UPDATED_FIRST_NAME)
//            .lastName(UPDATED_LAST_NAME)
//            .email(UPDATED_EMAIL)
//            .activated(UPDATED_ACTIVATED)
//            .langKey(UPDATED_LANG_KEY)
//            .imageUrl(UPDATED_IMAGE_URL)
//            .activationKey(UPDATED_ACTIVATION_KEY)
//            .resetKey(UPDATED_RESET_KEY)
//            .resetDate(UPDATED_RESET_DATE)
            .designation(UPDATED_DESIGNATION)
            .nid(UPDATED_NID)
            .company(UPDATED_COMPANY);
        return kCP;
    }

    @BeforeEach
    public void initTest() {
        kCP = createEntity(em);
    }

    @Test
    @Transactional
    public void createKCP() throws Exception {
        int databaseSizeBeforeCreate = kCPRepository.findAll().size();
        // Create the KCP
        restKCPMockMvc.perform(post("/api/kcps")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(kCP)))
            .andExpect(status().isCreated());

        // Validate the KCP in the database
        List<KCP> kCPList = kCPRepository.findAll();
        assertThat(kCPList).hasSize(databaseSizeBeforeCreate + 1);
        KCP testKCP = kCPList.get(kCPList.size() - 1);
        assertThat(testKCP.getLogin()).isEqualTo(DEFAULT_LOGIN);
        assertThat(testKCP.getPassword()).isEqualTo(DEFAULT_PASSWORD);
        assertThat(testKCP.getFirstName()).isEqualTo(DEFAULT_FIRST_NAME);
        assertThat(testKCP.getLastName()).isEqualTo(DEFAULT_LAST_NAME);
        assertThat(testKCP.getEmail()).isEqualTo(DEFAULT_EMAIL);
//        assertThat(testKCP.isActivated()).isEqualTo(DEFAULT_ACTIVATED);
        assertThat(testKCP.getLangKey()).isEqualTo(DEFAULT_LANG_KEY);
        assertThat(testKCP.getImageUrl()).isEqualTo(DEFAULT_IMAGE_URL);
        assertThat(testKCP.getActivationKey()).isEqualTo(DEFAULT_ACTIVATION_KEY);
        assertThat(testKCP.getResetKey()).isEqualTo(DEFAULT_RESET_KEY);
        assertThat(testKCP.getResetDate()).isEqualTo(DEFAULT_RESET_DATE);
        assertThat(testKCP.getDesignation()).isEqualTo(DEFAULT_DESIGNATION);
        assertThat(testKCP.getNid()).isEqualTo(DEFAULT_NID);
        assertThat(testKCP.getCompany()).isEqualTo(DEFAULT_COMPANY);
    }

    @Test
    @Transactional
    public void createKCPWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = kCPRepository.findAll().size();

        // Create the KCP with an existing ID
        kCP.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restKCPMockMvc.perform(post("/api/kcps")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(kCP)))
            .andExpect(status().isBadRequest());

        // Validate the KCP in the database
        List<KCP> kCPList = kCPRepository.findAll();
        assertThat(kCPList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    @Transactional
    public void getAllKCPS() throws Exception {
        // Initialize the database
        kCPRepository.saveAndFlush(kCP);

        // Get all the kCPList
        restKCPMockMvc.perform(get("/api/kcps?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(kCP.getId().intValue())))
            .andExpect(jsonPath("$.[*].login").value(hasItem(DEFAULT_LOGIN)))
            .andExpect(jsonPath("$.[*].password").value(hasItem(DEFAULT_PASSWORD)))
            .andExpect(jsonPath("$.[*].firstName").value(hasItem(DEFAULT_FIRST_NAME)))
            .andExpect(jsonPath("$.[*].lastName").value(hasItem(DEFAULT_LAST_NAME)))
            .andExpect(jsonPath("$.[*].email").value(hasItem(DEFAULT_EMAIL)))
            .andExpect(jsonPath("$.[*].activated").value(hasItem(DEFAULT_ACTIVATED.booleanValue())))
            .andExpect(jsonPath("$.[*].langKey").value(hasItem(DEFAULT_LANG_KEY)))
            .andExpect(jsonPath("$.[*].imageUrl").value(hasItem(DEFAULT_IMAGE_URL)))
            .andExpect(jsonPath("$.[*].activationKey").value(hasItem(DEFAULT_ACTIVATION_KEY)))
            .andExpect(jsonPath("$.[*].resetKey").value(hasItem(DEFAULT_RESET_KEY)))
            .andExpect(jsonPath("$.[*].resetDate").value(hasItem(DEFAULT_RESET_DATE.toString())))
            .andExpect(jsonPath("$.[*].designation").value(hasItem(DEFAULT_DESIGNATION)))
            .andExpect(jsonPath("$.[*].nid").value(hasItem(DEFAULT_NID)))
            .andExpect(jsonPath("$.[*].company").value(hasItem(DEFAULT_COMPANY)));
    }

    @Test
    @Transactional
    public void getKCP() throws Exception {
        // Initialize the database
        kCPRepository.saveAndFlush(kCP);

        // Get the kCP
        restKCPMockMvc.perform(get("/api/kcps/{id}", kCP.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(kCP.getId().intValue()))
            .andExpect(jsonPath("$.login").value(DEFAULT_LOGIN))
            .andExpect(jsonPath("$.password").value(DEFAULT_PASSWORD))
            .andExpect(jsonPath("$.firstName").value(DEFAULT_FIRST_NAME))
            .andExpect(jsonPath("$.lastName").value(DEFAULT_LAST_NAME))
            .andExpect(jsonPath("$.email").value(DEFAULT_EMAIL))
            .andExpect(jsonPath("$.activated").value(DEFAULT_ACTIVATED.booleanValue()))
            .andExpect(jsonPath("$.langKey").value(DEFAULT_LANG_KEY))
            .andExpect(jsonPath("$.imageUrl").value(DEFAULT_IMAGE_URL))
            .andExpect(jsonPath("$.activationKey").value(DEFAULT_ACTIVATION_KEY))
            .andExpect(jsonPath("$.resetKey").value(DEFAULT_RESET_KEY))
            .andExpect(jsonPath("$.resetDate").value(DEFAULT_RESET_DATE.toString()))
            .andExpect(jsonPath("$.designation").value(DEFAULT_DESIGNATION))
            .andExpect(jsonPath("$.nid").value(DEFAULT_NID))
            .andExpect(jsonPath("$.company").value(DEFAULT_COMPANY));
    }
    @Test
    @Transactional
    public void getNonExistingKCP() throws Exception {
        // Get the kCP
        restKCPMockMvc.perform(get("/api/kcps/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateKCP() throws Exception {
        // Initialize the database
        kCPRepository.saveAndFlush(kCP);

        int databaseSizeBeforeUpdate = kCPRepository.findAll().size();

        // Update the kCP
        KCP updatedKCP = kCPRepository.findById(kCP.getId()).get();
        // Disconnect from session so that the updates on updatedKCP are not directly saved in db
        em.detach(updatedKCP);
        updatedKCP
//            .login(UPDATED_LOGIN)
//            .password(UPDATED_PASSWORD)
//            .firstName(UPDATED_FIRST_NAME)
//            .lastName(UPDATED_LAST_NAME)
//            .email(UPDATED_EMAIL)
//            .activated(UPDATED_ACTIVATED)
//            .langKey(UPDATED_LANG_KEY)
//            .imageUrl(UPDATED_IMAGE_URL)
//            .activationKey(UPDATED_ACTIVATION_KEY)
//            .resetKey(UPDATED_RESET_KEY)
//            .resetDate(UPDATED_RESET_DATE)
            .designation(UPDATED_DESIGNATION)
            .nid(UPDATED_NID)
            .company(UPDATED_COMPANY);

        restKCPMockMvc.perform(put("/api/kcps")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(updatedKCP)))
            .andExpect(status().isOk());

        // Validate the KCP in the database
        List<KCP> kCPList = kCPRepository.findAll();
        assertThat(kCPList).hasSize(databaseSizeBeforeUpdate);
        KCP testKCP = kCPList.get(kCPList.size() - 1);
        assertThat(testKCP.getLogin()).isEqualTo(UPDATED_LOGIN);
        assertThat(testKCP.getPassword()).isEqualTo(UPDATED_PASSWORD);
        assertThat(testKCP.getFirstName()).isEqualTo(UPDATED_FIRST_NAME);
        assertThat(testKCP.getLastName()).isEqualTo(UPDATED_LAST_NAME);
        assertThat(testKCP.getEmail()).isEqualTo(UPDATED_EMAIL);
//        assertThat(testKCP.isActivated()).isEqualTo(UPDATED_ACTIVATED);
        assertThat(testKCP.getLangKey()).isEqualTo(UPDATED_LANG_KEY);
        assertThat(testKCP.getImageUrl()).isEqualTo(UPDATED_IMAGE_URL);
        assertThat(testKCP.getActivationKey()).isEqualTo(UPDATED_ACTIVATION_KEY);
        assertThat(testKCP.getResetKey()).isEqualTo(UPDATED_RESET_KEY);
        assertThat(testKCP.getResetDate()).isEqualTo(UPDATED_RESET_DATE);
        assertThat(testKCP.getDesignation()).isEqualTo(UPDATED_DESIGNATION);
        assertThat(testKCP.getNid()).isEqualTo(UPDATED_NID);
        assertThat(testKCP.getCompany()).isEqualTo(UPDATED_COMPANY);
    }

    @Test
    @Transactional
    public void updateNonExistingKCP() throws Exception {
        int databaseSizeBeforeUpdate = kCPRepository.findAll().size();

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restKCPMockMvc.perform(put("/api/kcps")
            .contentType(MediaType.APPLICATION_JSON)
            .content(TestUtil.convertObjectToJsonBytes(kCP)))
            .andExpect(status().isBadRequest());

        // Validate the KCP in the database
        List<KCP> kCPList = kCPRepository.findAll();
        assertThat(kCPList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    @Transactional
    public void deleteKCP() throws Exception {
        // Initialize the database
        kCPRepository.saveAndFlush(kCP);

        int databaseSizeBeforeDelete = kCPRepository.findAll().size();

        // Delete the kCP
        restKCPMockMvc.perform(delete("/api/kcps/{id}", kCP.getId())
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<KCP> kCPList = kCPRepository.findAll();
        assertThat(kCPList).hasSize(databaseSizeBeforeDelete - 1);
    }
}
