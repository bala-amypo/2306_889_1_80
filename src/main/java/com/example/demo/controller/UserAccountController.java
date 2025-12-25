// src/main/java/com/example/demo/controller/UserAccountController.java
package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.UserAccount;
import com.example.demo.service.UserAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "User Accounts")
@RestController
@RequestMapping("/auth/users")
public class UserAccountController {

    private final UserAccountService service;

    public UserAccountController(UserAccountService service) {
        this.service = service;
    }

    @Operation(summary = "Get all users")
    @GetMapping
    public ResponseEntity<List<UserAccount>> getAll() {
        return ResponseEntity.ok(service.getAllUsers());
    }

    @Operation(summary = "Get user by ID")
    @GetMapping("/{id}")
    public ResponseEntity<UserAccount> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getUser(id));
    }
}