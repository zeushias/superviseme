package com.miage.upjv.superviseme.entity.app;

import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(	name = "stages",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "idStage"),
                @UniqueConstraint(columnNames = "themeStage"),
                @UniqueConstraint(columnNames = "dateDebut"),
                @UniqueConstraint(columnNames = "dateFin")
        })
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Column(name = "theme_stage", nullable = false)
    private String themeStage;

    @NotBlank
    private String responsable;

    @NotBlank
    @Column(name = "contact_responsable", nullable = false)
    private String contactResponsable;

    @NotBlank
    @Column(name = "date_debut", nullable = false)
    private Date dateDebut;

    @NotBlank
    @Column(name = "date_fin", nullable = false)
    private Date dateFin;

    @ManyToOne
    @JoinColumn (name = "id_Etudiant", nullable = true)
    private  Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "id_Enseignant", nullable = true)
    private Enseignant enseignant;

    @ManyToOne
    @JoinColumn(name = "id_Entreprise", nullable = true)
    private Entreprise entreprise;

    @ManyToOne
    @JoinColumn(name = "idAnnee", nullable = true)
    private AnneeScolaire anneeScolaire;

    public Stage() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank String getThemeStage() {
        return themeStage;
    }

    public void setThemeStage(@NotBlank String themeStage) {
        this.themeStage = themeStage;
    }

    public @NotBlank String getResponsable() {
        return responsable;
    }

    public void setResponsable(@NotBlank String responsable) {
        this.responsable = responsable;
    }

    public @NotBlank String getContactResponsable() {
        return contactResponsable;
    }

    public void setContactResponsable(@NotBlank String contactResponsable) {
        this.contactResponsable = contactResponsable;
    }

    public @NotBlank Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(@NotBlank Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public @NotBlank Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(@NotBlank Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return Objects.equals(id, stage.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
