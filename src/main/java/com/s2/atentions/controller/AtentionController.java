package com.s2.atentions.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.s2.atentions.model.Atention;
import com.s2.atentions.service.AtentionService;

@RestController
@RequestMapping("/atentions")
public class AtentionController {
  private static final Logger log = LoggerFactory.getLogger(AtentionController.class);

  @Autowired
  private AtentionService atentionService;

  @GetMapping
  public CollectionModel<EntityModel<Atention>> getAllAtentions() {
    List<Atention> atentions = atentionService.getAllAtentions();

    List<EntityModel<Atention>> atentionResources = atentions.stream()
      .map(atention -> EntityModel.of(
        atention,
        WebMvcLinkBuilder.linkTo(
          WebMvcLinkBuilder.methodOn(this.getClass()).getAtentionById(atention.getId())
        ).withSelfRel())).collect(Collectors.toList());

    WebMvcLinkBuilder linkTo = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllAtentions());
    CollectionModel<EntityModel<Atention>> resources = CollectionModel.of(atentionResources, linkTo.withRel("atentions"));

    return resources;
  }

  @GetMapping("/{id}")
  public EntityModel<Atention> getAtentionById(@PathVariable Long id) {
    Optional<Atention> atention = atentionService.getAtentionById(id);

    if (atention.isPresent()) {
      return EntityModel.of(atention.get(),
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAtentionById(id)).withSelfRel(),
        WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllAtentions()).withRel("all-atentions"));
    } else {
      throw new AtentionNotFoundException("Atention not found with id: " + id);
    }
  }

  @PostMapping
  public EntityModel<Atention> createAtention(@Validated @RequestBody Atention atention) {
    Atention createdAtention = atentionService.createAtention(atention);

    return EntityModel.of(createdAtention,
      WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAtentionById(createdAtention.getId())).withSelfRel(),
      WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllAtentions()).withRel("all-atentions"));
  }

  @PutMapping("/{id}")
  public EntityModel<Atention> updateAtention(@PathVariable Long id, @RequestBody Atention atention) {
    Atention updatedAtention = atentionService.updateAtention(id, atention);

    return EntityModel.of(updatedAtention,
      WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAtentionById(id)).withSelfRel(),
      WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).getAllAtentions()).withRel("all-atentions"));
  }

  @DeleteMapping("/{id}")
  public void deleteAtention(@PathVariable Long id) {
    atentionService.deleteAtention(id);
  }

  @GetMapping("/patient/{patientId}")
  public List<Atention> getAtentionByPatient(@PathVariable String patientId) {
    return atentionService.getAtentionByPatientId(patientId);
  }
}
