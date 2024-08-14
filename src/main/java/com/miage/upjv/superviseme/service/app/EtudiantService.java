package com.miage.upjv.superviseme.service.app;

import com.miage.upjv.superviseme.repository.app.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtudiantService {

    @Autowired
    EtudiantRepository etudiantRepository;
}
