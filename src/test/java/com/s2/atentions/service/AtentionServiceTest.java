package com.s2.atentions.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.s2.atentions.model.Atention;
import com.s2.atentions.repository.AtentionRepository;

@ExtendWith(MockitoExtension.class)
public class AtentionServiceTest {
  @InjectMocks
  private AtentionServiceImpl atentionService;

  @Mock
  private AtentionRepository atentionRepositoryMock;

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

    when(atentionRepositoryMock.save(any())).thenReturn(atention);

    Atention result = atentionService.createAtention(atention);
    
    assertEquals("Diagnosis test", result.getDiagnosis());
  }
}
