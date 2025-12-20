package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
    name = "branch_profiles",
    uniqueConstraints = @UniqueConstraint(columnNames = "branchCode")
)
public class BranchProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String branchCode;

    private String branchName;

    private String contactEmail;

    private LocalDateTime lastSyncAt;

    private Boolean active;

    public BranchProfile() {
    }

    public BranchProfile(Long id, String branchCode, String branchName,
                         String contactEmail, LocalDateTime lastSyncAt,
                         Boolean active) {
        this.id = id;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.contactEmail = contactEmail;
        this.lastSyncAt = lastSyncAt;
        this.active = active;
    }

    @PrePersist
    public void prePersist() {
        this.lastSyncAt = LocalDateTime.now();
        if (this.active == null) {
            this.active = true;
        }
    }

  
}
