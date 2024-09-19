package com.miage.upjv.superviseme.entity.app;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue(value = "RES")
public class Responsable extends Personne{

    private String poste;

    public Responsable() {
    }

    public Responsable(String nomPrenoms, String email, String telephone, String adresse, String password, String poste) {
        super(nomPrenoms, email, telephone, adresse, password);
        this.poste = poste;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }
}
