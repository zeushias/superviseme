package com.miage.upjv.superviseme.controller.app;

import com.miage.upjv.superviseme.entity.app.AnneeScolaire;
import com.miage.upjv.superviseme.entity.app.Entreprise;
import com.miage.upjv.superviseme.service.app.EntrepriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/superviseme")
public class EntrepriseController {

    @Autowired
    EntrepriseService entrepriseService;

    @GetMapping("/entreprise/all")
    public List<Entreprise> findAll(){
        return entrepriseService.findAll();
    }

    @PostMapping("/entreprise/modify")
    public ResponseEntity<String> modify(@RequestBody Entreprise entreprise){
        Optional<Entreprise> existingEntreprise = entrepriseService.findById(entreprise.getId());

        // save
        if (existingEntreprise.isPresent()) {
            entrepriseService.save(entreprise);
            return ResponseEntity.ok("Entreprise modifiée avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Entreprise non trouvée.");
        }
    }

    @PostMapping("/entreprise/save")
    public ResponseEntity<String> save(@RequestBody Entreprise entreprise){
        // vérification siret

        // save
        entrepriseService.save(entreprise);
        return ResponseEntity.ok("Entreprise enrégistrée avec succès.");
    }

    @PostMapping("/entreprise/save/list")
    public ResponseEntity<String> save(@RequestBody List<Entreprise> entreprises){
        // save
        for(Entreprise entreprise : entreprises){
            entrepriseService.save(entreprise);
        }
        return ResponseEntity.ok("Entreprises enrégistrées avec succès.");
    }

}
