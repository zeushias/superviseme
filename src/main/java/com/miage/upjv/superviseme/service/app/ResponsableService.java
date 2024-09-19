package com.miage.upjv.superviseme.service.app;

import com.miage.upjv.superviseme.bateau.PersonneDetails;
import com.miage.upjv.superviseme.entity.app.Responsable;
import com.miage.upjv.superviseme.repository.app.ResponsableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResponsableService {

    @Autowired
    ResponsableRepository responsableRepository;

    public boolean save(Responsable responsable){
        responsableRepository.save(responsable);
        return true;
    }

    public Optional<Responsable> findById(Integer id) {
        return responsableRepository.findById(id);
    }
}
