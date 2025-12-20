package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "branch_profiles", uniqueConstraints = @UniqueConstraint(columnNames = "branchCode"))
public class BranchProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String branchCode;
    private String branchName;
    private String contactEmail;
    private LocalDateTime lastSyncAt;
    private Boolean active = true;

    public BranchProfile() {}

    public BranchProfile(Long id, String branchCode, String branchName,
                         String contactEmail, LocalDateTime lastSyncAt, Boolean active) {
        this.id = id;
        this.branchCode = branchCode;
        this.branchName = branchName;
        this.contactEmail = contactEmail;
        this.lastSyncAt = lastSyncAt;
        this.active = active;
    }

    @PrePersist
    public void onCreate() {
        this.lastSyncAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public void setActive(Boolean active) { this.active = active; }
}
