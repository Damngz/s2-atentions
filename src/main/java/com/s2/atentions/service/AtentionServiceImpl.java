package com.s2.atentions.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.s2.atentions.model.Atention;
import com.s2.atentions.repository.AtentionRepository;

@Service
public class AtentionServiceImpl implements AtentionService {
  @Autowired
  private AtentionRepository atentionRepository;

  @Override
  public List<Atention> getAllAtentions() {
    return atentionRepository.findAll();
  }

  @Override
  public Optional<Atention> getAtentionById(Long id) {
    return atentionRepository.findById(id);
  }

  @Override
  public Atention createAtention(Atention atention) {
    return atentionRepository.save(atention);
  }

  @Override
  public Atention updateAtention(Long id, Atention atention) {
    if (atentionRepository.existsById(id)) {
      atention.setId(id);
      return atentionRepository.save(atention);
    }

    return null;
  }

  @Override
  public void deleteAtention(Long id) {
    atentionRepository.deleteById(id);
  }

  @Override
  public List<Atention> getAtentionByPatientId(String patientId) {
    return atentionRepository.findByPatientId(patientId);
  }
}
