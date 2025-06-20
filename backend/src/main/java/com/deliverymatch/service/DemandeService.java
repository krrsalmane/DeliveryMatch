package com.deliverymatch.service;
import com.deliverymatch.dto.ColisDTO;
import com.deliverymatch.dto.DemandeDTO;
import com.deliverymatch.model.*;
import com.deliverymatch.repository.AnnonceRepository;
import com.deliverymatch.repository.DemandeRepository;
import com.deliverymatch.repository.ExpediteurRepository;
import com.deliverymatch.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;


@Service
@RequiredArgsConstructor
public class DemandeService {

    private final DemandeRepository demandeRepository;

    private final UserRepository expediteurRepository;
    private final AnnonceRepository annonceRepository;

    // Create a new demande (transport request)
    public DemandeDTO creerDemande(DemandeDTO dto) {
        // Fetch Expediteur and Annonce based on the provided IDs in the DTO
        User expediteur = expediteurRepository.findByIdAndRole(dto.expediteurId(), Role.EXPEDIEUR)
                .orElseThrow(() -> new RuntimeException("Expediteur not found"));

        Annonce annonce = annonceRepository.findById(dto.annonceId())
                .orElseThrow(() -> new RuntimeException("Annonce not found"));

        // Create the DemandeTransport entity

        Demande demande = new Demande();
        demande.setDate(dto.date());
        demande.setStatus(DemandeStatus.valueOf(dto.status()));
        demande.setAnnonce(annonce);
        demande.setExpediteur((Expediteur) expediteur);


        List<Colis> colisList = dto.colis().stream().map( c -> {

            Colis colis = new Colis();
            colis.setPoids(c.poids());
            colis.setTypeColis(c.typeColis());
            colis.setLargeur(c.largeur());
            colis.setLongueur(c.longueur());

            return colis;

        }).toList();
        demande.setColis(colisList);


        // Save the Demande and return the corresponding DTO
        Demande savedDemande = demandeRepository.save(demande);

        return new DemandeDTO(
                savedDemande.getId(),
                savedDemande.getDate(),
                savedDemande.getStatus().toString(),
                savedDemande.getExpediteur().getId(),
                savedDemande.getAnnonce().getId(),
                dto.colis()
        );
    }

    // Get all demandes by Expediteur (sender)
    public List<DemandeDTO> afficherDemandesByExpediteur(Long expediteurId) {
        User expediteur = expediteurRepository.findByIdAndRole(expediteurId, Role.EXPEDIEUR)
                .orElseThrow(() -> new RuntimeException("Expediteur not found"));

        List<Demande> demandes = demandeRepository.findByExpediteur((Expediteur) expediteur);

        return demandes.stream().map(demande -> new DemandeDTO(
                demande.getId(),
                demande.getDate(),
                demande.getStatus().toString(),
                expediteur.getId(),
                demande.getAnnonce().getId(),
                demande.getColis().stream().map(colis -> new ColisDTO(
                        colis.getPoids(),
                        colis.getLongueur(),
                        colis.getLargeur(),
                        colis.getTypeColis()


                )).toList()

        )).toList();

    }

    // Get all demandes by Annonce (related to a trip/driver)
    public List<DemandeDTO> afficherDemandesParAnnonce(Long annonceId) {
        Annonce annonce = annonceRepository.findById(annonceId)
                .orElseThrow(() -> new RuntimeException("Annonce not found"));

        List<Demande> demandes = demandeRepository.findByAnnonce(annonce);

        return demandes.stream().map(demande -> new DemandeDTO(
                demande.getId(),
                demande.getDate(),
                demande.getStatus().toString(),
                demande.getExpediteur().getId(),
                annonce.getId(),
                demande.getColis().stream().map(colis -> new ColisDTO(
                        colis.getPoids(),
                        colis.getLongueur(),
                        colis.getLargeur(),
                        colis.getTypeColis()

                )).collect(toList())
        )).collect(toList());
    }
}







