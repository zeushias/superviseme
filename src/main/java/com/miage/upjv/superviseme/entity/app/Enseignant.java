package com.miage.upjv.superviseme.entity.app;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "ENS")
public class Enseignant extends Personne {

    private String matiere;

    public Enseignant() {
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

}
