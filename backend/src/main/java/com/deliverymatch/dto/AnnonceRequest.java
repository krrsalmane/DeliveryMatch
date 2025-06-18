package com.deliverymatch.dto;

import lombok.Data;

@Data
public class AnnonceRequest {
    private String pointDepart;
    private String destinationFinal;
    private String dateDepart;
    private int capaciteDisponible;
    private String typeMarchandise;
}

