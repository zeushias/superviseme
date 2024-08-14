package com.miage.upjv.superviseme.entity.app;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(	name = "universites",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "idUniversite"),
                @UniqueConstraint(columnNames = "designation")
        })
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_universite", nullable = false)
    private Integer idUniversite;

    @NotBlank
    @Size(max = 50)
    private String designation;

    @NotBlank
    @Size(max = 14)
    private String telephone;

    @NotBlank
    @Size(max = 100)
    private String adresse;

    public Universite() {
    }

    public Integer getIdUniversite() {
        return idUniversite;
    }

    public void setIdUniversite(Integer idUniversite) {
        this.idUniversite = idUniversite;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Universite that = (Universite) o;
        return Objects.equals(idUniversite, that.idUniversite);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idUniversite);
    }
}
