package com.deliverymatch.service;


import com.deliverymatch.dto.AnnonceRequest;
import com.deliverymatch.model.Annonce;
import com.deliverymatch.repository.AnnonceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
