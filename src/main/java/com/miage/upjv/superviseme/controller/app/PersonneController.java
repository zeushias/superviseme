package com.miage.upjv.superviseme.controller.app;

import com.miage.upjv.superviseme.entity.app.Personne;
import com.miage.upjv.superviseme.service.app.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/superviseme/personnes")
public class PersonneController {

    @Autowired
    PersonneService personneService;

    @PostMapping("/save")
    public boolean save(List<Personne> personnes){
        return personneService.save(personnes);
    }
}
