package com.s2.atentions.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.s2.atentions.model.Atention;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AtentionRepositoryTest {
  @Autowired
  private AtentionRepository atentionRepository;

  @Test
  public void saveAtentionTest() {
    Atention atention = new Atention();
    atention.setDate("11-04-2024");
    atention.setPatient("Gabriel");
    atention.setPatientId("123");
    atention.setDoctor("Doctor 1");
    atention.setDiagnosis("Diagnosis test");
    atention.setTreatment("No treatment");
    atention.setObservations("No observations");

    Atention result = atentionRepository.save(atention);
  
    assertNotNull(result.getId());
    assertEquals("11-04-2024", result.getDate());
  }
}
