package com.miage.upjv.superviseme.controller.app;

import com.miage.upjv.superviseme.entity.app.Universite;
import com.miage.upjv.superviseme.repository.app.UniversiteRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/superviseme")
public class UniversiteController {

    private final UniversiteRepository universiteRepository;

    public UniversiteController(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    @PostMapping("/universite/modify")
    public boolean modify(Universite universite){
        // save
        universiteRepository.save(universite);
        return true;
    }

    @PostMapping("/universite/save")
    public boolean save(Universite universite){
        // save
        universiteRepository.save(universite);
        return true;
    }
}
