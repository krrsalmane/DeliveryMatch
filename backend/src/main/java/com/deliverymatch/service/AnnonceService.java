package com.deliverymatch.service;
import com.deliverymatch.dto.AnnonceRequest;
import com.deliverymatch.model.Annonce;
import com.deliverymatch.model.Conducteur;
import com.deliverymatch.model.Expediteur;
import com.deliverymatch.repository.AnnonceRepository;
import com.deliverymatch.repository.ConducteurRepository;
import com.deliverymatch.repository.ExpediteurRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnnonceService {

    private final AnnonceRepository annonceRepository;
    private final ConducteurRepository conducteurRepository;


    public Annonce publierAnnonce(AnnonceRequest request) {
        // This is how you should use Optional with findById:
        Optional<Conducteur> optionalConducteur = conducteurRepository.findById(request.getConducteurId());

        // If no conducteur is found, throw an exception
        Conducteur conducteur = optionalConducteur.orElseThrow(() ->
                new RuntimeException("Conducteur not found with ID: " + request.getConducteurId())
        );

        // Create the annonce and set its fields
        Annonce annonce = new Annonce();
        annonce.setPointDepart(request.getPointDepart());
        annonce.setDestinationFinal(request.getDestinationFinal());
        annonce.setDateDepart(request.getDateDepart());
        annonce.setCapaciteDisponible(request.getCapaciteDisponible());
        annonce.setTypeMarchandise(request.getTypeMarchandise());
        annonce.setConducteur(conducteur);

        // Save the annonce to the repository
        return annonceRepository.save(annonce);
    }


    public List<Annonce> getAll() {
        return annonceRepository.findAll();
    }

    // READ BY ID
    public Annonce getById(Long id) {
        return annonceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Annonce not found"));
    }

    public Annonce updateAnnonce(Long id, AnnonceRequest request) {
        Annonce annonce = getById(id); // reuse existing method
        annonce.setPointDepart(request.getPointDepart());
        annonce.setDestinationFinal(request.getDestinationFinal());
        annonce.setDateDepart(request.getDateDepart());
        annonce.setCapaciteDisponible(request.getCapaciteDisponible());
        annonce.setTypeMarchandise(request.getTypeMarchandise());
        return annonceRepository.save(annonce);
    }

    public void deleteAnnonce(Long id) {
        Annonce annonce = getById(id);
        annonceRepository.delete(annonce);
    }
}
