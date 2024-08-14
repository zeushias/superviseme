package com.miage.upjv.superviseme.repository.app;

import com.miage.upjv.superviseme.entity.app.Universite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Integer> {

}
