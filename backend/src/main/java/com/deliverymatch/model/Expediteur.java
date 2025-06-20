package com.deliverymatch.model;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Expediteur extends User {

    @OneToMany(mappedBy = "expediteur", cascade = CascadeType.ALL)
    private List<Demande> demandes;

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }
}