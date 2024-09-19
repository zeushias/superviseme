package com.miage.upjv.superviseme.controller.app;

import com.miage.upjv.superviseme.controller.security.UserInfoService;
import com.miage.upjv.superviseme.entity.app.AnneeScolaire;
import com.miage.upjv.superviseme.entity.app.Entreprise;
import com.miage.upjv.superviseme.entity.app.Etudiant;
import com.miage.upjv.superviseme.entity.security.ERole;
import com.miage.upjv.superviseme.entity.security.UserInfo;
import com.miage.upjv.superviseme.service.app.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/superviseme")
public class EtudiantController {

    @Autowired
    EtudiantService etudiantService;

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/etudiant/modify")
    public ResponseEntity<String> modify(@RequestBody Etudiant etudiant){

        Optional<Etudiant> existingEtudiant = etudiantService.findById(etudiant.getId());

        // save
        if (existingEtudiant.isPresent()) {
            etudiantService.save(etudiant);
            return ResponseEntity.ok("Etudiant modifié avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Etudiant non trouvé.");
        }
    }

    @PostMapping("/etudiant/save")
    public ResponseEntity<String> save(@RequestBody Etudiant etudiant){
        etudiantService.save(etudiant);
        UserInfo user = new UserInfo();
        user.setRoles(ERole.ROLE_ETUDIANT.toString());
        user.setName(etudiant.getNomPrenoms());
        user.setEmail(etudiant.getEmail());
        user.setPassword(etudiant.getEmail());

        userInfoService.addUser(user);
        return ResponseEntity.ok("Etudiant enrégistré avec succès.");
    }

    @PostMapping("/etudiant/save/list")
    public ResponseEntity<String> save(@RequestBody List<Etudiant> etudiants){
        // save
        for(Etudiant etudiant : etudiants){
            etudiantService.save(etudiant);
        }
        return ResponseEntity.ok("Etudiants enrégistrés avec succès.");
    }
}
