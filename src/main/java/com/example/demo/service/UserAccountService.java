package com.example.demo.service;

import com.example.demo.entity.UserAccount;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserAccountService extends UserDetailsService {

    UserAccount register(UserAccount user);

    UserAccount findByEmail(String email);

    // ✅ ADD THESE
    List<UserAccount> getAllUsers();

    UserAccount getUser(Long id);
}
