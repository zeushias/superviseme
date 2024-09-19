package com.miage.upjv.superviseme.service.app;

import com.miage.upjv.superviseme.entity.app.AnneeScolaire;
import com.miage.upjv.superviseme.repository.app.AnneeScolaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

@Service
public class AnneeScolaireService {

    @Autowired
    AnneeScolaireRepository anneeScolaireRepository;

    public Optional<AnneeScolaire> findById(Integer id){
        return this.anneeScolaireRepository.findById(id);
    }

    public Optional<AnneeScolaire> findByDesignation(String designation){
        return this.anneeScolaireRepository.findByDesignation(designation);
    }

    public boolean save(AnneeScolaire anneeScolaire){
        anneeScolaireRepository.save(anneeScolaire);
        return true;
    }

    public List<AnneeScolaire> findAll(){
        return anneeScolaireRepository.findAll();
    }

    public @NotBlank boolean findByActif(boolean actif){

        List<Optional<AnneeScolaire>> anneeScolaires = anneeScolaireRepository.findByActif(actif);

        if(anneeScolaires.isEmpty()){
            return false;
        }
        return true;
    }

    public List<Optional<AnneeScolaire>> findAnneeActif(boolean actif){
        return anneeScolaireRepository.findByActif(actif);
    }

}
