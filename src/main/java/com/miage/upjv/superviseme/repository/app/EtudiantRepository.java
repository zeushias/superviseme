package com.miage.upjv.superviseme.repository.app;

import com.miage.upjv.superviseme.entity.app.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, Integer> {

}
