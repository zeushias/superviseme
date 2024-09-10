package com.miage.upjv.superviseme.repository.app;

import com.miage.upjv.superviseme.entity.app.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface StageRepository extends JpaRepository<Stage, Integer> {

    Optional<Stage> getStageByDateDebutAndDateFin(Date dateDebut, Date dateFin);

}
