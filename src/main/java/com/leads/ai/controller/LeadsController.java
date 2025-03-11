package com.leads.ai.controller;

import com.leads.ai.model.Leads;
import com.leads.ai.service.LeadsServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LeadsController {

    private final LeadsServices services;

    public LeadsController(LeadsServices services) {
        this.services = services;
    }

    @PostMapping
    public ResponseEntity<String> createLead(Leads lead) {
        services.createLead(lead);
        return ResponseEntity.status(HttpStatus.CREATED).body("Proposta enviada com sucesso");
    }

    @GetMapping
    public ResponseEntity<List<Leads>> readAll() {
        return ResponseEntity.status(HttpStatus.OK).body(services.readAll());
    }

    @GetMapping("/api/{id}")
    public ResponseEntity<Optional<Leads>> findById(@PathVariable long id) {
        return ResponseEntity.status(HttpStatus.OK).body(services.FindById(id));
    }

    @DeleteMapping("/api/{id}")
    public ResponseEntity<String> delete(@PathVariable long id) {
        services.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Proposta deletada com sucesso!");
    }
}
