package com.miage.upjv.superviseme.controller.app;

import com.miage.upjv.superviseme.entity.app.Stage;
import com.miage.upjv.superviseme.service.app.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Optional;

@RestController
public class StageController {

    @Autowired
    StageService stageService;

    public Optional<Stage> getStageByDateDebutAndDateFin(Date dateDebut, Date dateFin){
        return this.stageService.getStageByDateDebutAndDateFin(dateDebut, dateFin);
    }
}
