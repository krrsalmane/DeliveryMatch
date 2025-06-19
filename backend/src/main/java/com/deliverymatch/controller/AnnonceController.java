package com.deliverymatch.controller;
import com.deliverymatch.dto.AnnonceRequest;
import com.deliverymatch.model.Annonce;
import com.deliverymatch.repository.AnnonceRepository;
import com.deliverymatch.service.AnnonceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/annonces")
@RequiredArgsConstructor
public class AnnonceController {

    private final AnnonceService annonceService;

    @PostMapping("/publier")
    public ResponseEntity<Annonce> publierAnnonce(@RequestBody AnnonceRequest request) {
        Annonce annonce = annonceService.publierAnnonce(request);
        return ResponseEntity.ok(annonce);
    }

    @GetMapping
    public ResponseEntity<List<Annonce>> getAllAnnonces() {
        return ResponseEntity.ok(annonceService.getAll());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Annonce> getAnnonceById(@PathVariable Long id) {
        return ResponseEntity.ok(annonceService.getById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Annonce> updateAnnonce(@PathVariable Long id,
                                                 @RequestBody AnnonceRequest request) {
        return ResponseEntity.ok(annonceService.updateAnnonce(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAnnonce(@PathVariable Long id) {
        annonceService.deleteAnnonce(id);
        return ResponseEntity.noContent().build();
    }


    private final AnnonceRepository annonceRepository;

    @GetMapping("/search")
    public List<Annonce> searchAnnonces(
            @RequestParam(required = false) String pointDepart,
            @RequestParam(required = false) String destinationFinal,
            @RequestParam(required = false) String dateDepart,
            @RequestParam(required = false) String typeMarchandise,
            @RequestParam(required = false) Integer capaciteMin
    ) {
        return annonceRepository.searchAnnonces(
                pointDepart, destinationFinal, dateDepart, typeMarchandise, capaciteMin
        );
    }

}

