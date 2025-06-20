package com.deliverymatch.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Conducteur extends User {
    @OneToMany(mappedBy = "conducteur", cascade = CascadeType.ALL)
    private List<Annonce> annonces;

    @Override
    public List<Annonce> getAnnonces() {
        return annonces;
    }

    @Override
    public void setAnnonces(List<Annonce> annonces) {
        this.annonces = annonces;
    }
}
