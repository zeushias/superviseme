package com.miage.upjv.superviseme.repository.security;

import java.util.Optional;

import com.miage.upjv.superviseme.entity.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByUsername(String username);

	Boolean existsByUsername(String username);

	Boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

}
