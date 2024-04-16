package com.s2.atentions.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2.atentions.model.Atention;
import com.s2.atentions.model.Response;
import com.s2.atentions.service.AtentionService;

@RestController
@RequestMapping("/atentions")
public class AtentionController {
  private static final Logger log = LoggerFactory.getLogger(AtentionController.class);

  @Autowired
  private AtentionService atentionService;

  @GetMapping
  public List<Atention> getAllAtentions() {
    return atentionService.getAllAtentions();
  }

  @GetMapping("/{id}")
  public Optional<Atention> getAtentionById(@PathVariable Long id) {
    return atentionService.getAtentionById(id);
  }

  @PostMapping
  public Response createAtention(@RequestBody Atention atention) {
    Atention createdAtention = atentionService.createAtention(atention);

    if (createdAtention == null) {
      log.error("No se pudo crear la atención", atention);
      return new Response(500, "No se pudo crear la atención");
    }

    return new Response(200, "Atención creada con éxito");
  }

  @PutMapping("/{id}")
  public Response updateAtention(@PathVariable Long id, @RequestBody Atention atention) {
    try {
      atentionService.updateAtention(id, atention);
      return new Response(200, "Atención actualizada con éxito");
    } catch (Exception e) {
      log.error("No se pudo actualizar la atención", e);
      return new Response(500, "No se pudo actualizar la atención.");
    }
  }

  @DeleteMapping("/{id}")
  public Response deleteAtention(@PathVariable Long id) {
    try {
      atentionService.deleteAtention(id);
      return new Response(200, "Atención eliminada con éxito");
    } catch (Exception e) {
      log.error("No se pudo eliminar la atención", e);
      return new Response(500, "No se pudo eliminar la atención.");
    }
  }

  @GetMapping("/patient/{patientId}")
  public List<Atention> getAtentionByPatient(@PathVariable String patientId) {
    return atentionService.getAtentionByPatientId(patientId);
  }
}
