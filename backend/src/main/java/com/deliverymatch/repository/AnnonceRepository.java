package com.deliverymatch.repository;
import com.deliverymatch.model.Annonce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

    List<Annonce> findByDestinationFinalContainingIgnoreCaseAndDateDepart(
            String destinationFinal, String dateDepart);

    // Flexible filter
    @Query("SELECT a FROM Annonce a WHERE " +
            "(:pointDepart IS NULL OR a.pointDepart LIKE %:pointDepart%) AND " +
            "(:destinationFinal IS NULL OR a.destinationFinal LIKE %:destinationFinal%) AND " +
            "(:dateDepart IS NULL OR a.dateDepart = :dateDepart) AND " +
            "(:typeMarchandise IS NULL OR a.typeMarchandise LIKE %:typeMarchandise%) AND " +
            "(:capaciteMin IS NULL OR a.capaciteDisponible >= :capaciteMin)")
    List<Annonce> searchAnnonces(String pointDepart,
                                 String destinationFinal,
                                 String dateDepart,
                                 String typeMarchandise,
                                 Integer capaciteMin);

}
