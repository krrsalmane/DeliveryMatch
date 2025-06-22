package com.deliverymatch.repository;
import ch.qos.logback.core.status.Status;
import com.deliverymatch.model.Annonce;
import com.deliverymatch.model.Demande;
import com.deliverymatch.model.Expediteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface DemandeRepository  extends JpaRepository<Demande, Long> {


    List<Demande> findByExpediteur(Expediteur expediteur);

    List<Demande> findByAnnonce(Annonce annonce);
}
