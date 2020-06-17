package com.jhipsterpractice.app.repository;

import com.jhipsterpractice.app.domain.KCP;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the KCP entity.
 */
@SuppressWarnings("unused")
@Repository
public interface KCPRepository extends JpaRepository<KCP, Long> {
}
