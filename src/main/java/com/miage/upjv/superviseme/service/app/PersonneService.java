package com.miage.upjv.superviseme.service.app;

import com.miage.upjv.superviseme.entity.app.Personne;
import com.miage.upjv.superviseme.repository.app.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonneService {

    @Autowired
    PersonneRepository personneRepository;

    public boolean save(List<Personne> personnes){
        for(Personne personne : personnes) {
            personneRepository.save(personne);
        }
        return true;
    }

}