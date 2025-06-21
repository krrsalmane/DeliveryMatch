package com.deliverymatch.dto;

import lombok.Data;

@Data
public class AnnonceRequest {

    private String pointDepart;
    private String destinationFinal;
    private String dateDepart;
    private int capaciteDisponible;
    private String typeMarchandise;
    private long conducteurId;


    public String getPointDepart() {
        return pointDepart;
    }

    public void setPointDepart(String pointDepart) {
        this.pointDepart = pointDepart;
    }

    public String getDestinationFinal() {
        return destinationFinal;
    }

    public void setDestinationFinal(String destinationFinal) {
        this.destinationFinal = destinationFinal;
    }

    public String getDateDepart() {
        return dateDepart;
    }

    public void setDateDepart(String dateDepart) {
        this.dateDepart = dateDepart;
    }

    public int getCapaciteDisponible() {
        return capaciteDisponible;
    }

    public void setCapaciteDisponible(int capaciteDisponible) {
        this.capaciteDisponible = capaciteDisponible;
    }

    public String getTypeMarchandise() {
        return typeMarchandise;
    }

    public void setTypeMarchandise(String typeMarchandise) {
        this.typeMarchandise = typeMarchandise;
    }




}

