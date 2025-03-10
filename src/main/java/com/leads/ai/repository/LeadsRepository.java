package com.leads.ai.repository;

import com.leads.ai.model.Leads;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LeadsRepository extends JpaRepository <Leads, Long> {
    @Override
    Optional<Leads> findById(Long aLong);
}
