package com.miage.upjv.superviseme.entity.app;

import jakarta.persistence.Entity;

@Entity
public class Etudiant extends Personne{

    private String niveauScolaire;

    public Etudiant() {
    }

    public String getNiveauScolaire() {
        return niveauScolaire;
    }

    public void setNiveauScolaire(String niveauScolaire) {
        this.niveauScolaire = niveauScolaire;
    }
}
