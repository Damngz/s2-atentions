package com.s2.atentions.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s2.atentions.model.Atention;

public interface AtentionRepository extends JpaRepository <Atention, Long> {
  List<Atention> findByPatientId(String patientId);
}
