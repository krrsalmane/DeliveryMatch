package com.deliverymatch.repository;

import com.deliverymatch.model.Conducteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ConducteurRepository extends JpaRepository<Conducteur, Integer> {
    Conducteur findById(Long id);
}
