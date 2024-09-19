package com.miage.upjv.superviseme.controller.app;

import com.miage.upjv.superviseme.controller.security.UserInfoService;
import com.miage.upjv.superviseme.entity.app.Etudiant;
import com.miage.upjv.superviseme.entity.app.Responsable;
import com.miage.upjv.superviseme.entity.security.ERole;
import com.miage.upjv.superviseme.entity.security.UserInfo;
import com.miage.upjv.superviseme.service.app.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/superviseme")
public class ResponsableController {

    @Autowired
    ResponsableService responsableService;

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/responsable/modify")
    public ResponseEntity<String> modify(@RequestBody Responsable responsable) {

        Optional<Responsable> existingResponsable = responsableService.findById(responsable.getId());

        // save
        if (existingResponsable.isPresent()) {
            responsableService.save(responsable);
            return ResponseEntity.ok("Responsable modifié avec succès.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Responsable non trouvé.");
        }
    }

    @PostMapping("/responsable/save")
    public ResponseEntity<String> save(@RequestBody Responsable responsable) {
        responsableService.save(responsable);

        UserInfo user = new UserInfo();
        user.setRoles(ERole.ROLE_ADMIN.toString());
        user.setName(responsable.getNomPrenoms());
        user.setEmail(responsable.getEmail());
        user.setPassword(responsable.getEmail());

        userInfoService.addUser(user);
        return ResponseEntity.ok("Responsable enrégistré avec succès.");
    }

    @PostMapping("/responsable/save/list")
    public ResponseEntity<String> save(@RequestBody List<Responsable> responsables) {
        // save
        for (Responsable responsable : responsables) {
            responsableService.save(responsable);
        }
        return ResponseEntity.ok("Responsables enrégistrés avec succès.");
    }
}
