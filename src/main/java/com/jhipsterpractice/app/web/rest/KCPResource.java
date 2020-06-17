package com.jhipsterpractice.app.web.rest;

import com.jhipsterpractice.app.domain.KCP;
import com.jhipsterpractice.app.repository.KCPRepository;
import com.jhipsterpractice.app.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.jhipsterpractice.app.domain.KCP}.
 */
@RestController
@RequestMapping("/api")
@Transactional
public class KCPResource {

    private final Logger log = LoggerFactory.getLogger(KCPResource.class);

    private static final String ENTITY_NAME = "kCP";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final KCPRepository kCPRepository;

    public KCPResource(KCPRepository kCPRepository) {
        this.kCPRepository = kCPRepository;
    }

    /**
     * {@code POST  /kcps} : Create a new kCP.
     *
     * @param kCP the kCP to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new kCP, or with status {@code 400 (Bad Request)} if the kCP has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/kcps")
    public ResponseEntity<KCP> createKCP(@RequestBody KCP kCP) throws URISyntaxException {
        log.debug("REST request to save KCP : {}", kCP);
        if (kCP.getId() != null) {
            throw new BadRequestAlertException("A new kCP cannot already have an ID", ENTITY_NAME, "idexists");
        }
        KCP result = kCPRepository.save(kCP);
        return ResponseEntity.created(new URI("/api/kcps/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, false, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /kcps} : Updates an existing kCP.
     *
     * @param kCP the kCP to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated kCP,
     * or with status {@code 400 (Bad Request)} if the kCP is not valid,
     * or with status {@code 500 (Internal Server Error)} if the kCP couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/kcps")
    public ResponseEntity<KCP> updateKCP(@RequestBody KCP kCP) throws URISyntaxException {
        log.debug("REST request to update KCP : {}", kCP);
        if (kCP.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        KCP result = kCPRepository.save(kCP);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, false, ENTITY_NAME, kCP.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /kcps} : get all the kCPS.
     *
     * @param pageable the pagination information.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of kCPS in body.
     */
    @GetMapping("/kcps")
    public ResponseEntity<List<KCP>> getAllKCPS(Pageable pageable) {
        log.debug("REST request to get a page of KCPS");
        Page<KCP> page = kCPRepository.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /kcps/:id} : get the "id" kCP.
     *
     * @param id the id of the kCP to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the kCP, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/kcps/{id}")
    public ResponseEntity<KCP> getKCP(@PathVariable Long id) {
        log.debug("REST request to get KCP : {}", id);
        Optional<KCP> kCP = kCPRepository.findById(id);
        return ResponseUtil.wrapOrNotFound(kCP);
    }

    /**
     * {@code DELETE  /kcps/:id} : delete the "id" kCP.
     *
     * @param id the id of the kCP to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/kcps/{id}")
    public ResponseEntity<Void> deleteKCP(@PathVariable Long id) {
        log.debug("REST request to delete KCP : {}", id);
        kCPRepository.deleteById(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, false, ENTITY_NAME, id.toString())).build();
    }
}
