package com.example.demo.service;

import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.UserAccount;

import java.util.List;

public interface UserAccountService {

    void register(RegisterRequest request);

    List<UserAccount> getAllUsers();

    UserAccount getUser(Long id);
}
