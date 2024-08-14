package com.miage.upjv.superviseme.service.app;

import com.miage.upjv.superviseme.repository.app.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UniversiteService {

    @Autowired
    UniversiteRepository universiteRepository;

}
