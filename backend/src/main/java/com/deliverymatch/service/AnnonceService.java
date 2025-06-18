package com.deliverymatch.service;


import com.deliverymatch.dto.AnnonceRequest;
import com.deliverymatch.model.Annonce;
import com.deliverymatch.repository.AnnonceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnonceService {

    private final AnnonceRepository annonceRepository;

    public Annonce publierAnnonce(AnnonceRequest request) {
        Annonce annonce = new Annonce();
        annonce.setPointDepart(request.getPointDepart());
        annonce.setDestinationFinal(request.getDestinationFinal());
        annonce.setDateDepart(request.getDateDepart());
        annonce.setCapaciteDisponible(request.getCapaciteDisponible());
        annonce.setTypeMarchandise(request.getTypeMarchandise());

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
}
