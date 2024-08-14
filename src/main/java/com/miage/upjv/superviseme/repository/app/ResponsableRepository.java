package com.miage.upjv.superviseme.repository.app;

import com.miage.upjv.superviseme.entity.app.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Integer> {

}
