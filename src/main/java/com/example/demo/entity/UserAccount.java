package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.ValidationException;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "user_accounts",
    uniqueConstraints = @UniqueConstraint(columnNames = "email")
)
public class UserAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(nullable = false, unique = true)
    private String email;

    private String password;

    private String role;

    private String department;

    private LocalDateTime createdAt;

    public UserAccount() {
    }

    public UserAccount(Long id, String fullName, String email,
                       String password, String role,
                       String department, LocalDateTime createdAt) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
        this.department = department;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.role == null) {
            this.role = "REVIEWER";
        }
    }

    
}
