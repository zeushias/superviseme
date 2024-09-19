package com.miage.upjv.superviseme.repository.security;

/**
 *
 * @author kodzo
 */
import com.miage.upjv.superviseme.entity.security.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    Optional<UserInfo> findByEmail(String email); // Use 'email' if that is the correct field for login

    Optional<UserInfo> findUserInfoByEmail(String email);
}
