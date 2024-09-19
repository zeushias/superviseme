package com.miage.upjv.superviseme.service.app;

import com.miage.upjv.superviseme.entity.app.Etudiant;
import com.miage.upjv.superviseme.repository.app.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EtudiantService {

    @Autowired
    EtudiantRepository etudiantRepository;

    public boolean save(Etudiant etudiant){
        etudiantRepository.save(etudiant);
        return true;
    }

    public Optional<Etudiant> findById(Integer id) {
        return  etudiantRepository.findById(id);
    }
}
