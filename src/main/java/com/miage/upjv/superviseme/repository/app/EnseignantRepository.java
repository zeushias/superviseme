package com.miage.upjv.superviseme.repository.app;

import com.miage.upjv.superviseme.entity.app.Enseignant;
import com.miage.upjv.superviseme.entity.app.Etudiant;
import com.miage.upjv.superviseme.entity.app.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {

    Optional<Enseignant> findById(Integer id);

    Optional<Enseignant> findByEmail(String email);
}
