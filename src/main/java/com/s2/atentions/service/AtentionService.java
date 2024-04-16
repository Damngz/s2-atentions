package com.s2.atentions.service;

import java.util.List;
import java.util.Optional;

import com.s2.atentions.model.Atention;

public interface AtentionService {
  List<Atention> getAllAtentions();
  Optional<Atention> getAtentionById(Long id);
  Atention createAtention(Atention atention);
  Atention updateAtention(Long id, Atention atention);
  void deleteAtention(Long id);
  List<Atention> getAtentionByPatientId(String patientId);
}
