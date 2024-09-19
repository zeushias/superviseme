package com.miage.upjv.superviseme.controller.app;

import com.miage.upjv.superviseme.entity.app.Stage;
import com.miage.upjv.superviseme.service.app.StageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/superviseme")
public class StageController {

    @Autowired
    StageService stageService;

    public Optional<Stage> getStageByDateDebutAndDateFin(@PathVariable Date dateDebut, Date dateFin) {
        return this.stageService.getStageByDateDebutAndDateFin(dateDebut, dateFin);
    }

    @PostMapping("/stage/modify")
    public ResponseEntity<String> modify(@RequestBody Stage stage) {
        Optional<Stage> existingStage = stageService.findById(stage.getId());

        // save
        if (existingStage.isPresent()) {
            stageService.save(stage);
            return ResponseEntity.ok("Stage modifié avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Stage non trouvé.");
        }
    }

    @PostMapping("/stage/save")
    public ResponseEntity<String> save(@RequestBody Stage stage) {
        // save
        stageService.save(stage);
        return ResponseEntity.ok("Stage enrégistré avec succès.");
    }

    @PostMapping("/stage/save/list")
    public ResponseEntity<String> save(@RequestBody List<Stage> stages) {
        // save
        for (Stage stage : stages) {
            stageService.save(stage);
        }
        return ResponseEntity.ok("Stages enrégistrés avec succès.");
    }
}
