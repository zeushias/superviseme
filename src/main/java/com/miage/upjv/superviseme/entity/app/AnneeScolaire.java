package com.miage.upjv.superviseme.entity.app;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "annee_scolaires",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "idAnnee"),
                @UniqueConstraint(columnNames = "designation")
        })
public class AnneeScolaire {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id_annee", nullable = false)
        private Integer id;

        @NotBlank
        @Size(max = 50)
        private String designation;

        @NotBlank
        private boolean actif = true;

        public AnneeScolaire() {
        }

        public Integer getId() {
                return id;
        }

        public void setIdAnnee(Integer idEntreprise) {
                this.id = id;
        }

        public @NotBlank @Size(max = 50) String getDesignation() {
                return designation;
        }

        public void setDesignation(@NotBlank @Size(max = 50) String designation) {
                this.designation = designation;
        }

        @NotBlank
        public boolean isActif() { return actif; }

        public void setActif(@NotBlank boolean actif) { this.actif = actif; }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                AnneeScolaire that = (AnneeScolaire) o;
                return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
                return Objects.hashCode(id);
        }
}
