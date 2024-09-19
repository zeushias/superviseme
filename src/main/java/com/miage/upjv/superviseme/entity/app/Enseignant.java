package com.miage.upjv.superviseme.entity.app;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ENS")
public class Enseignant extends Personne {

    private String matiere;

    public Enseignant() {
    }

    public Enseignant(String nomPrenoms, String email, String telephone, String adresse, String password, String matiere) {
        super(nomPrenoms, email, telephone, adresse, password);
        this.matiere = matiere;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

}
