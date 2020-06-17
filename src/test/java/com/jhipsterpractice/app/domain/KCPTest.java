package com.jhipsterpractice.app.domain;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import com.jhipsterpractice.app.web.rest.TestUtil;

public class KCPTest {

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(KCP.class);
        KCP kCP1 = new KCP();
        kCP1.setId(1L);
        KCP kCP2 = new KCP();
        kCP2.setId(kCP1.getId());
        assertThat(kCP1).isEqualTo(kCP2);
        kCP2.setId(2L);
        assertThat(kCP1).isNotEqualTo(kCP2);
        kCP1.setId(null);
        assertThat(kCP1).isNotEqualTo(kCP2);
    }
}
