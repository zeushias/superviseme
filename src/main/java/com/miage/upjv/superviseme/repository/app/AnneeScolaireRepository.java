package com.miage.upjv.superviseme.repository.app;

import com.miage.upjv.superviseme.entity.app.AnneeScolaire;
import com.miage.upjv.superviseme.entity.app.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnneeScolaireRepository extends JpaRepository<AnneeScolaire, Integer> {

    Optional<AnneeScolaire> findById(Integer id);

    Optional<AnneeScolaire> findByDesignation(String designation);

    List<Optional<AnneeScolaire>> findByActif(boolean actif);
}
