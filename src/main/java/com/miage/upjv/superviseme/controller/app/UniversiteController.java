package com.miage.upjv.superviseme.controller.app;

import com.miage.upjv.superviseme.entity.app.Entreprise;
import com.miage.upjv.superviseme.entity.app.Stage;
import com.miage.upjv.superviseme.entity.app.Universite;
import com.miage.upjv.superviseme.repository.app.UniversiteRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/superviseme")
public class UniversiteController {

    private final UniversiteRepository universiteRepository;

    public UniversiteController(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    @PostMapping("/universite/modify")
    public ResponseEntity<String> modify(Universite universite) {
        Optional<Universite> existingUniversite = universiteRepository.findById(universite.getId());

        // save
        if (existingUniversite.isPresent()) {
            // save
            universiteRepository.save(universite);
            return ResponseEntity.ok("Universite enrégistrée avec succès.");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Universite non trouvée.");
    }

    @PostMapping("/universite/save")
    public ResponseEntity<String> save(Universite universite) {
        List<Universite> universites = universiteRepository.findAll();
        // save
        if (universites.isEmpty()) {
            universiteRepository.save(universite);
            return ResponseEntity.ok("Universite enrégistrée avec succès.");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Universite existe déjà.");
    }
}
