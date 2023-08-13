package com.ale.minichat.service;

import com.ale.minichat.entity.User;
import com.ale.minichat.repository.UserRepository;
import com.ale.minichat.security.UserInfo;
import com.ale.minichat.util.MessageContent;
import com.ale.minichat.util.exception.AppException;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicReference;

@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new UserInfo(user);
    }

    @Override
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public User findFirst() {
        return userRepository.findFirstByOrderByUuidAsc();
    }

    @Override
    public User findById(UUID uuid) {
        AtomicReference<User> atomicReference = new AtomicReference<>();
        userRepository.findById(uuid).ifPresentOrElse(atomicReference::set, () -> {
            throw new AppException(MessageContent.ID_DOES_NOT_EXIST + User.class.getName());
        });
        return atomicReference.get();
    }
}
