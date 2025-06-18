package com.deliverymatch.repository;
import ch.qos.logback.core.status.Status;
import com.deliverymatch.model.Demande;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.LocalDate;
import java.util.List;

public interface DemandeRepository  extends JpaRepository<Demande, Long> {


}
