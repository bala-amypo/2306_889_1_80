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

@Tag(name = "User Management")
@RestController
@RequestMapping("/auth")
public class UserAccountController {

    private final UserAccountService userAccountService;

    public UserAccountController(UserAccountService userAccountService) {
        this.userAccountService = userAccountService;
    }

    @Operation(summary = "Get all users", description = "ADMIN only")
    @GetMapping("/users")
    public ResponseEntity<ApiResponse> getAllUsers() {
        List<UserAccount> users = userAccountService.getAllUsers();
        return ResponseEntity.ok(new ApiResponse(true, "Users retrieved successfully", users));
    }

    @Operation(summary = "Get user by ID", description = "ADMIN only")
    @GetMapping("/users/{id}")
    public ResponseEntity<ApiResponse> getUser(@PathVariable Long id) {
        UserAccount user = userAccountService.getUser(id);
        return ResponseEntity.ok(new ApiResponse(true, "User found", user));
    }
}