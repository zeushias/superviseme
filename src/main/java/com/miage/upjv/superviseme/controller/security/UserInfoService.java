package com.miage.upjv.superviseme.controller.security;

/**
 * @author kodzo
 */

import com.miage.upjv.superviseme.entity.security.UserInfo;
import com.miage.upjv.superviseme.configurations.UserInfoDetails;
import com.miage.upjv.superviseme.repository.security.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService implements UserDetailsService {

    @Autowired
    private UserInfoRepository repository;

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserInfo> userDetail = repository.findByEmail(username); // Assuming 'email' is used as username

        // Converting UserInfo to UserDetails
        return userDetail.map(UserInfoDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
    }

    /**
     *
     * @param userInfo
     * @return
     */
    public String addUser(UserInfo userInfo) {
        // vérifier si l'utilisateur n'existe pas
        Optional<UserInfo> uinfo = repository.findByEmail(userInfo.getEmail());

        // Encode password before saving the user
        if (uinfo.isEmpty()) {
            if (userInfo.getPassword() != null && userInfo.getPassword() != "") {
                userInfo.setPassword(userInfo.getEmail());
            }
            userInfo.setPassword(encoder.encode(userInfo.getPassword()));
            repository.save(userInfo);
            return "Utilisateur ajouté avec succès";
        } else {
            return "Utilisateur existe déjà avec cet email";
        }
    }

    /**
     *
     * @param email
     * @return
     */
    public UserInfo findUserInfoByEmail(String email) {
        Optional<UserInfo> userInfo = repository.findUserInfoByEmail(email);
        return userInfo.get();
    }
}
