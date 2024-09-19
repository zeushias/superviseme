package com.miage.upjv.superviseme.controller.app;

import com.miage.upjv.superviseme.entity.app.AnneeScolaire;
import com.miage.upjv.superviseme.service.app.AnneeScolaireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/superviseme")
public class AnneeScolaireController {

    @Autowired
    AnneeScolaireService anneeScolaireService;

    @GetMapping("/annee/all")
    public List<AnneeScolaire> findAll(){
        return anneeScolaireService.findAll();
    }

    @GetMapping("/annee/actif")
    public List<AnneeScolaire> findAnneeActif(){
        List<AnneeScolaire> anneeScolaires = new ArrayList<>();
        List<Optional<AnneeScolaire>> scolaires = anneeScolaireService.findAnneeActif(true);
        if(!scolaires.isEmpty()){
             for(Optional<AnneeScolaire> sc : scolaires){
                 anneeScolaires.add(sc.get());
             }
        }
        return anneeScolaires;
    }

    @PostMapping("/annee/close")
    public ResponseEntity<String> close(@RequestBody AnneeScolaire anneeScolaire){

        Optional<AnneeScolaire> as = null;

        // vérifier si l'année existe

        if(anneeScolaire != null) {
            if (anneeScolaire.getId() != null) {
                as = anneeScolaireService.findById(anneeScolaire.getId());
            } else {
                if (anneeScolaire.getDesignation() != null && anneeScolaire.getDesignation() != "") {
                    as = anneeScolaireService.findByDesignation(anneeScolaire.getDesignation());
                }
            }

            if(!as.isEmpty()){
                // save
                as.get().setActif(false);
                anneeScolaireService.save(as.get());
                return ResponseEntity.ok("Année scolaire fermée avec succès.");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Année scolaire n'existe pas.");
    }

    @PostMapping("/annee/modify")
    public ResponseEntity<String> modify(@RequestBody AnneeScolaire anneeScolaire){
        //contrôle
        // Check if the entity with the given ID exists
        Optional<AnneeScolaire> existingAnnee = anneeScolaireService.findById(anneeScolaire.getId());

        // save
        if (existingAnnee.isPresent()) {
            anneeScolaireService.save(anneeScolaire);
            return ResponseEntity.ok("Année Scolaire modifiée avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Année scolaire non trouvée.");
        }
    }

    @PostMapping("/annee/save")
    public  ResponseEntity<String> save(@RequestBody AnneeScolaire anneeScolaire){
        //contrôle
        // save
        if(this.controle(anneeScolaire)) {
            anneeScolaireService.save(anneeScolaire);
            return ResponseEntity.ok("Année scolaire modifiée avec successfully.");
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Année scolaire existe déjà");
    }

    public boolean controle(AnneeScolaire anneeScolaire){

        Optional<AnneeScolaire> scolaire = anneeScolaireService.findByDesignation(anneeScolaire.getDesignation());

        // enregistrement
        if(anneeScolaire.getId() == null || anneeScolaire.getId() == 0){

            // vérifions s'il y a une annee actif
            boolean actif = anneeScolaireService.findByActif(true);
            if (actif){
                // on ne peut plus enrégistrer
                return false;
            } else {
                // vérifions la désignation
                // si on a un enrégistrement
                if(!scolaire.isEmpty()){
                    return false;
                }
            }
        } else {
            // vérifions la désignation
            // si on a un enrégistrement
            if(scolaire != null){
                return false;
            }
        }

        return true;
    }
}
