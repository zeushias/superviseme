package com.miage.upjv.superviseme.entity.app;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "entreprises",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "idEntreprise"),
                @UniqueConstraint(columnNames = "designation")
        })
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_entreprise", nullable = false)
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String designation;

    @NotBlank
    @Size(max = 50)
    private String siret;

    @NotBlank
    private String adresse;

    @NotBlank
    @Size(max = 14)
    private String telephone;

    public Entreprise() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank @Size(max = 50) String getDesignation() {
        return designation;
    }

    public void setDesignation(@NotBlank @Size(max = 50) String designation) {
        this.designation = designation;
    }

    public @NotBlank String getAdresse() {
        return adresse;
    }

    public void setAdresse(@NotBlank String adresse) {
        this.adresse = adresse;
    }

    public @NotBlank @Size(max = 14) String getTelephone() {
        return telephone;
    }

    public void setTelephone(@NotBlank @Size(max = 14) String telephone) {
        this.telephone = telephone;
    }

    public @NotBlank @Size(max = 50) String getSiret() {
        return siret;
    }

    public void setSiret(@NotBlank @Size(max = 50) String siret) {
        this.siret = siret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entreprise that = (Entreprise) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
