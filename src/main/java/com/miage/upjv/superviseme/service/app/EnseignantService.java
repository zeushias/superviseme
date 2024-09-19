package com.miage.upjv.superviseme.service.app;

import com.miage.upjv.superviseme.entity.app.Enseignant;

import com.miage.upjv.superviseme.repository.app.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnseignantService {

    @Autowired
    EnseignantRepository enseignantRepository;

    public boolean save(Enseignant enseignant){
        enseignantRepository.save(enseignant);
        return true;
    }

    public Optional<Enseignant> findById(Integer id) {
        return enseignantRepository.findById(id);
    }
}
