package com.miage.upjv.superviseme.entity.app;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "RES")
public class Responsable extends Personne{

    private String poste;

    public Responsable() {
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
}
