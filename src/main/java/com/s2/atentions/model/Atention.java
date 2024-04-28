package com.s2.atentions.model;

import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="atention")
public class Atention extends RepresentationModel<Atention> {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @NotBlank(message = "Debe ingresar una fecha")
  @Column(name = "attention_date")
  private String date;

  @NotBlank(message = "Debe ingresar el nombre del paciente")
  @Column(name = "patient")
  private String patient;

  @NotBlank(message = "Debe ingresar el RUT del paciente")
  @Column(name = "patient_id")
  private String patientId;

  @NotBlank(message = "Debe ingresar el nombre del médico")
  @Column(name = "doctor")
  private String doctor;

  @NotBlank(message = "Debe ingresar un diagnóstico")
  @Column(name = "diagnosis")
  private String diagnosis;

  @NotBlank(message = "Debe ingresar un tratamiento")
  @Column(name = "treatment")
  private String treatment;

  @NotBlank(message = "Debe ingresar observaciones")
  @Column(name = "observations")
  private String observations;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public String getPatient() {
    return patient;
  }

  public void setPatient(String patient) {
    this.patient = patient;
  }

  public String getPatientId() {
    return patientId;
  }

  public void setPatientId(String patientId) {
    this.patientId = patientId;
  }

  public String getDoctor() {
    return doctor;
  }

  public void setDoctor(String doctor) {
    this.doctor = doctor;
  }

  public String getDiagnosis() {
    return diagnosis;
  }

  public void setDiagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
  }

  public String getTreatment() {
    return treatment;
  }

  public void setTreatment(String treatment) {
    this.treatment = treatment;
  }

  public String getObservations() {
    return observations;
  }

  public void setObservations(String observations) {
    this.observations = observations;
  }
}