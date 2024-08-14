package com.miage.upjv.superviseme.repository.security;

import java.util.Optional;

import com.miage.upjv.superviseme.entity.security.ERole;
import com.miage.upjv.superviseme.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	Optional<Role> findByName(ERole name);

}
