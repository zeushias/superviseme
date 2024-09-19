package com.miage.upjv.superviseme.controller.app;

import com.miage.upjv.superviseme.bateau.PersonneDetails;
import com.miage.upjv.superviseme.controller.security.UserInfoService;
import com.miage.upjv.superviseme.entity.app.Enseignant;
import com.miage.upjv.superviseme.entity.app.Etudiant;
import com.miage.upjv.superviseme.entity.app.Personne;
import com.miage.upjv.superviseme.entity.app.Responsable;
import com.miage.upjv.superviseme.entity.security.ERole;
import com.miage.upjv.superviseme.entity.security.Role;
import com.miage.upjv.superviseme.entity.security.UserInfo;
import com.miage.upjv.superviseme.service.app.EnseignantService;
import com.miage.upjv.superviseme.service.app.EtudiantService;
import com.miage.upjv.superviseme.service.app.PersonneService;
import com.miage.upjv.superviseme.service.app.ResponsableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/superviseme")
public class PersonneController {

    @Autowired
    PersonneService personneService;

    @Autowired
    EtudiantService etudiantService;

    @Autowired
    EnseignantService enseignantService;

    @Autowired
    ResponsableService responsableService;

    @Autowired
    UserInfoService userInfoService;

    @PostMapping("/personne/save")
    public ResponseEntity<String> save(@RequestBody List<PersonneDetails> ListPersonneDetails){

        for(PersonneDetails personneDetail : ListPersonneDetails) {

            List<Role> roles = new ArrayList<>();
            UserInfo user = new UserInfo();
            // (String nomPrenoms, String email, String telephone, String adresse, String password)
            if (personneDetail.getPoste() != null && personneDetail.getPoste() != "") {
                Responsable responsable = new Responsable(
                        personneDetail.getNomPrenoms(),
                        personneDetail.getEmail(),
                        personneDetail.getTelephone(),
                        personneDetail.getAdresse(),
                        personneDetail.getPassword(),
                        personneDetail.getPoste());
                responsableService.save(responsable);

                user.setRoles(ERole.ROLE_ADMIN.toString());
            } else if (personneDetail.getMatiere() != null && personneDetail.getMatiere() != "") {
                Enseignant enseignant = new Enseignant(
                        personneDetail.getNomPrenoms(),
                        personneDetail.getEmail(),
                        personneDetail.getTelephone(),
                        personneDetail.getAdresse(),
                        personneDetail.getPassword(),
                        personneDetail.getMatiere());
                enseignantService.save(enseignant);

                user.setRoles(ERole.ROLE_PROFESSEUR.toString());
            } else if (personneDetail.getNiveauScolaire() != null && personneDetail.getNiveauScolaire() != "") {
                {
                    Etudiant etudiant = new Etudiant(
                            personneDetail.getNomPrenoms(),
                            personneDetail.getEmail(),
                            personneDetail.getTelephone(),
                            personneDetail.getAdresse(),
                            personneDetail.getPassword(),
                            personneDetail.getNiveauScolaire());
                    etudiantService.save(etudiant);

                    user.setRoles(ERole.ROLE_PROFESSEUR.toString());
                }

                user.setName(personneDetail.getNomPrenoms());
                user.setEmail(personneDetail.getEmail());
                user.setPassword(personneDetail.getEmail());

                userInfoService.addUser(user);
            }
        }
        return ResponseEntity.ok("Personnes enrégistrées avec succès.");
    }

    @GetMapping("/personne/find/{email}")
    public Optional<Personne> findByEmail(@PathVariable("email") String email){
        return personneService.findByEmail(email);
    }

    @GetMapping("/personne/find/{id}")
    public Optional<Personne> findById(@PathVariable("id") Integer id){
        return personneService.findById(id);
    }

}
