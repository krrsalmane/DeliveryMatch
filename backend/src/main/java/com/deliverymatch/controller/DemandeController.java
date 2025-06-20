package com.deliverymatch.controller;
import com.deliverymatch.dto.DemandeDTO;
import com.deliverymatch.model.Demande;
import com.deliverymatch.service.DemandeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/demandes")
@RequiredArgsConstructor
public class DemandeController {

    private final DemandeService demandeService;


    // Create a new demande (transport request)
    @PostMapping("/create")
    public ResponseEntity<DemandeDTO> createDemande(@RequestBody DemandeDTO dto) {
        return ResponseEntity.ok(demandeService.creerDemande(dto));
    }

    // Get all demandes by expediteur (sender)
    @GetMapping("/expediteur/{id}")
    public ResponseEntity<List<DemandeDTO>> getDemandesByExpediteur(@PathVariable Long id) {
        return ResponseEntity.ok(demandeService.afficherDemandesByExpediteur(id));
    }

    @PostMapping("/creer")
    public ResponseEntity<DemandeDTO> creerDemande(@RequestBody DemandeDTO dto) {
        DemandeDTO created = demandeService.creerDemande(dto);
        return ResponseEntity.ok(created);
    }


    // Get all demandes by annonce (related to a trip/driver)
    @GetMapping("/annonce/{id}")
    public ResponseEntity<List<DemandeDTO>> getDemandesByAnnonce(@PathVariable Long id) {
        return ResponseEntity.ok(demandeService.afficherDemandesParAnnonce(id));
    }
}



