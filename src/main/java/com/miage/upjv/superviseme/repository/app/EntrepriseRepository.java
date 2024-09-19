package com.miage.upjv.superviseme.repository.app;

import com.miage.upjv.superviseme.entity.app.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntrepriseRepository extends JpaRepository<Entreprise, Integer> {

    Optional<Entreprise> findBySiret(String siret);
}
