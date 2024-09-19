package com.miage.upjv.superviseme.service.app;

import com.miage.upjv.superviseme.entity.app.Stage;
import com.miage.upjv.superviseme.repository.app.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class StageService {

    @Autowired
    StageRepository stageRepository;

    public Optional<Stage> getStageByDateDebutAndDateFin(Date dateDebut, Date dateFin){
        return this.stageRepository.getStageByDateDebutAndDateFin(dateDebut, dateFin);
    }

    /**
     *
     * @param stage
     * @return
     */
    public boolean save(Stage stage){
        stageRepository.save(stage);
        return true;
    }

    /**
     *
     * @param id
     * @return
     */
    public Optional<Stage> findById(Integer id) {
        return stageRepository.findById(id);
    }
}
