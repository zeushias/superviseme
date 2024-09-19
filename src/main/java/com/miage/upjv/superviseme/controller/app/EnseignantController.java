package com.miage.upjv.superviseme.controller.app;

import com.miage.upjv.superviseme.controller.security.UserInfoService;
import com.miage.upjv.superviseme.entity.app.Enseignant;
import com.miage.upjv.superviseme.entity.app.Responsable;
import com.miage.upjv.superviseme.entity.security.ERole;
import com.miage.upjv.superviseme.entity.security.UserInfo;
import com.miage.upjv.superviseme.service.app.EnseignantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/superviseme")
public class EnseignantController {

    @Autowired
    EnseignantService enseignantService;

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/enseignant/modify")
    public ResponseEntity<String> modify(@RequestBody Enseignant enseignant) {
        Optional<Enseignant> existingEnseignant = enseignantService.findById(enseignant.getId());

        // save
        if (existingEnseignant.isPresent()) {
            enseignantService.save(enseignant);
            return ResponseEntity.ok("Enseignant modifié avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Enseignant non trouvé.");
        }
    }

    @PostMapping("/enseignant/save")
    public ResponseEntity<String> save(@RequestBody Enseignant enseignant) {
        // save
        enseignantService.save(enseignant);

        //
        UserInfo user = new UserInfo();
        user.setRoles(ERole.ROLE_PROFESSEUR.toString());
        user.setName(enseignant.getNomPrenoms());
        user.setEmail(enseignant.getEmail());
        user.setPassword(enseignant.getEmail());

        userInfoService.addUser(user);
        return ResponseEntity.ok("Enseignant enrégistré avec succès.");
    }

    @PostMapping("/enseignant/save/list")
    public ResponseEntity<String> save(@RequestBody List<Enseignant> enseignants) {
        // save
        for (Enseignant enseignant : enseignants) {
            enseignantService.save(enseignant);
        }
        return ResponseEntity.ok("Enseignants enrégistrés avec succès.");
    }
}
