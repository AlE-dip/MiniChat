package com.ale.minichat.service;

import com.ale.minichat.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.UUID;

public interface UserService extends UserDetailsService {
    User save(User user);
    User findFirst();
    User findById(UUID id);

}
