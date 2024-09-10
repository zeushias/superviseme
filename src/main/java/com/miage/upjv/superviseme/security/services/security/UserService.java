package com.miage.upjv.superviseme.security.services.security;

import com.miage.upjv.superviseme.entity.security.User;
import com.miage.upjv.superviseme.repository.security.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> allUsers() {
        List<User> users = new ArrayList<>();

        userRepository.findAll().forEach(users::add);

        return users;
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }
}
