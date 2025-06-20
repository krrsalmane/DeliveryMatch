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

@Service
@RequiredArgsConstructor
public class AnnonceService {

    private final AnnonceRepository annonceRepository;
    private final ConducteurRepository conducteurRepository;
    public Annonce publierAnnonce(AnnonceRequest request) {
        try {
            Conducteur conducteur=conducteurRepository.findById(request.getConducteurId());
            Annonce annonce = new Annonce();
            annonce.setPointDepart(request.getPointDepart());
            annonce.setDestinationFinal(request.getDestinationFinal());
            annonce.setDateDepart(request.getDateDepart());
            annonce.setCapaciteDisponible(request.getCapaciteDisponible());
            annonce.setTypeMarchandise(request.getTypeMarchandise());
            annonce.setConducteur(conducteur);
            return annonceRepository.save(annonce);
        } catch (Exception e) {
            throw new RuntimeException("conducteur not found");
        }
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
