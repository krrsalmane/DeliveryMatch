package com.deliverymatch.repository;
import com.deliverymatch.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AnnonceRepository extends JpaRepository<Annonce, Long> {
}
