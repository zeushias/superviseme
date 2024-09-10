package com.miage.upjv.superviseme.repository.app;

import com.miage.upjv.superviseme.entity.app.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonneRepository extends JpaRepository<Personne, Integer> {

    Optional<Personne> findPersonneByIdPersonne(Integer id);

    Optional<Personne> findPersonneByEmail(String email);

}
