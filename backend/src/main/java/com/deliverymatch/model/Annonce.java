package com.deliverymatch.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
public class Annonce {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String pointDepart;
    private String destinationFinal;
    private String dateDepart;
    private int capaciteDisponible;
    private String typeMarchandise;

    @ManyToOne
    private Conducteur conducteur;

    @OneToMany(mappedBy = "annonce")
    private List<Demande> demandes;

    public User getConducteur() {
        return conducteur;
    }

    public void setConducteur(Conducteur conducteur) {
        this.conducteur = conducteur;
    }

    public List<Demande> getDemandes() {
        return demandes;
    }

    public void setDemandes(List<Demande> demandes) {
        this.demandes = demandes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
