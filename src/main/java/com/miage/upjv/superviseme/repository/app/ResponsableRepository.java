package com.miage.upjv.superviseme.repository.app;

import com.miage.upjv.superviseme.entity.app.Responsable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ResponsableRepository extends JpaRepository<Responsable, Integer> {

    Optional<Responsable> findById(Integer id);

    Optional<Responsable> findByEmail(String email);
}
