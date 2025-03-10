package com.leads.ai.service;

import com.leads.ai.model.Leads;
import com.leads.ai.repository.LeadsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeadsServices {

    private final LeadsRepository repository;

    public LeadsServices(LeadsRepository repository) {
        this.repository = repository;
    }

    public Leads createLead(Leads lead) {
        return repository.save(lead);
    }

    public List<Leads> readAll() {
        return repository.findAll();
    }

    public Optional<Leads> FindById(long id) {
        return repository.findById(id);
    }

    public void delete(Long id) {
        if (repository.findById(id).isPresent())
            repository.deleteById(id);
        else throw new IllegalStateException("Id da proposta não encontrado.");
    }
}
