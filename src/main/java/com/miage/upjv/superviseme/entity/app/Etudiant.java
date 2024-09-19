package com.miage.upjv.superviseme.entity.app;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ETU")
public class Etudiant extends Personne {

    private String niveauScolaire;

    public Etudiant() {
    }

    public Etudiant(String nomPrenoms, String email, String telephone, String adresse, String password, String niveauScolaire) {
        super(nomPrenoms, email, telephone, adresse, password);
        this.niveauScolaire = niveauScolaire;
    }

    public String getNiveauScolaire() {
        return niveauScolaire;
    }

    public void setNiveauScolaire(String niveauScolaire) {
        this.niveauScolaire = niveauScolaire;
    }
}
