package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clash_records")
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String details;
    private LocalDateTime detectedAt;
    private Boolean resolved = false;

    public ClashRecord() {}

    @PrePersist
    public void onCreate() {
        this.detectedAt = LocalDateTime.now();
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
