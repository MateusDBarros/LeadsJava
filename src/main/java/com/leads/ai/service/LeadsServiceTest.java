package com.leads.ai.service;

import com.leads.ai.model.Leads;
import com.leads.ai.repository.LeadsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class LeadsServiceTest {

    @InjectMocks
    private LeadsServices service;

    @Mock
    private LeadsRepository repository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSavePerson() {
        Leads leads = new Leads();
        leads.setNome("John Doe");
        leads.setEmail("john@example.com");
        leads.setProposta("Quero mais informações");

        when(repository.save(any(Leads.class))).thenReturn(leads);

        Leads saved = service.createLead(leads);
        assertEquals("John Doe", saved.getNome());
    }

    @Test
    void testGetPersonById() {
        Leads leads = new Leads();
        leads.setId(1L);
        leads.setNome("Alice");

        when(repository.findById(1L)).thenReturn(Optional.of(leads));

        Optional<Leads> found = service.FindById(1L);
        assertEquals("Alice", found.get().getNome());
    }
}
