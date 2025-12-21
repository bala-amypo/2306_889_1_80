package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "event_merge_records")
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEventIds;
    private String mergedTitle;
    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;
    private LocalDateTime createdAt;

    public EventMergeRecord() {
    }

    public EventMergeRecord(Long id, String sourceEventIds, String mergedTitle,
            LocalDate mergedStartDate, LocalDate mergedEndDate,
            String mergeReason, LocalDateTime createdAt) {
        this.id = id;
        this.sourceEventIds = sourceEventIds;
        this.mergedTitle = mergedTitle;
        this.mergedStartDate = mergedStartDate;
        this.mergedEndDate = mergedEndDate;
        this.mergeReason = mergeReason;
        this.createdAt = createdAt;
    }

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public String getSourceEventIds() {
        return sourceEventIds;
    }

    public String getMergedTitle() {
        return mergedTitle;
    }

    public LocalDate getMergedStartDate() {
        return mergedStartDate;
    }

    public LocalDate getMergedEndDate() {
        return mergedEndDate;
    }

    public String getMergeReason() {
        return mergeReason;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
