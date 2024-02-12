package com.anbel.TestBD.service;

import com.anbel.TestBD.entity.ERole;
import com.anbel.TestBD.entity.Role;
import com.anbel.TestBD.entity.Users;
import com.anbel.TestBD.repository.RoleRepository;
import com.anbel.TestBD.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public void registerUser(String email, String password) {
        if(usersRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("Не верные данные");
        } else {
            Users newUsers = new Users();
            Role defaultRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Роль ROLE_USER не найдена"));
            newUsers.getRoles().add(defaultRole);
            newUsers.setEmail(email);
            newUsers.setPassword(passwordEncoder.encode(password));
            usersRepository.save(newUsers);
            }
    }
}
