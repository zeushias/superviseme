package com.miage.upjv.superviseme.service.app;

import com.miage.upjv.superviseme.entity.app.AnneeScolaire;
import com.miage.upjv.superviseme.entity.app.Entreprise;
import com.miage.upjv.superviseme.repository.app.EntrepriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntrepriseService {

    @Autowired
    EntrepriseRepository entrepriseRepository;

    public void save(Entreprise entreprise) {
        entrepriseRepository.save(entreprise);
    }

    public List<Entreprise> findAll(){
        return entrepriseRepository.findAll();
    }

    public Optional<Entreprise> findById(Integer id) {
        return  entrepriseRepository.findById(id);
    }

    public Optional<Entreprise> findBySiret(String siret) {
        return  entrepriseRepository.findBySiret(siret);
    }
}
