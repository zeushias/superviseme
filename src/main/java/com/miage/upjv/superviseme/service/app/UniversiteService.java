package com.miage.upjv.superviseme.service.app;

import com.miage.upjv.superviseme.entity.app.Stage;
import com.miage.upjv.superviseme.entity.app.Universite;
import com.miage.upjv.superviseme.repository.app.StageRepository;
import com.miage.upjv.superviseme.repository.app.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UniversiteService {

    @Autowired
    UniversiteRepository universiteRepository;

    public Optional<Universite> getUniversite(){
        return Optional.ofNullable(this.universiteRepository.findAll().get(0));
    }

    public boolean save(Universite universite){
        universiteRepository.save(universite);
        return true;
    }
}
