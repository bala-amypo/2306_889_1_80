package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_accounts", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;
    private String email;
    private String password;
    private String role;
    private String department;

    private LocalDateTime createdAt;

    public UserAccount() {}

    public UserAccount(Long id, String fullName, String email, String password,
                       String role, String department, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // getters & setters
    public Long getId() { return id; }
    public String getFullName() { return fullName; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public String getRole() { return role; }
    public String getDepartment() { return department; }

    public void setRole(String role) { this.role = role; }
    public void setPassword(String password) { this.password = password; }
}
