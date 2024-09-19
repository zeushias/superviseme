package com.miage.upjv.superviseme.service.app;

import com.miage.upjv.superviseme.entity.app.Personne;
import com.miage.upjv.superviseme.repository.app.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Personne> findByEmail(String email){
        return personneRepository.findByEmail(email);
    }

    public Optional<Personne> findById(Integer id){ return personneRepository.findById(id); }

}