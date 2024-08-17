package com.miage.upjv.superviseme.entity.app;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(	name = "personnes",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "email"),
                @UniqueConstraint(columnNames = "nomPrenoms")
        })
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_personne", nullable = false)
    private Integer idPersonne;

    @Column(name = "nom_prenoms", nullable = false)
    private String nomPrenoms;

    private String email;

    private String telephone;

    private String adresse;

    private String password;

    public Personne() {
    }

    public Integer getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(Integer idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getNomPrenoms() {
        return nomPrenoms;
    }

    public void setNomPrenoms(String nomPrenoms) {
        this.nomPrenoms = nomPrenoms;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Personne personne = (Personne) o;
        return Objects.equals(idPersonne, personne.idPersonne);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idPersonne);
    }
}
