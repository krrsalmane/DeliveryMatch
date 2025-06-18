package com.deliverymatch.controller;


import com.deliverymatch.dto.AnnonceRequest;
import com.deliverymatch.model.Annonce;
import com.deliverymatch.service.AnnonceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}

