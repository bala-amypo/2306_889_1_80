package com.example.demo.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity

public class EventMergeRecord implements Serializable {

    @Id
    @Column(unique= true)
    private String sourceEventIds;

    private String merged;
    private LocalDate mergedStartDate;
    private LocalDateTime detectedAt;
    private Boolean resolved;

   
    public EventMergeRecord() {
    }

   
    public EventMergeRecord(String sourceEventIds, String merged,
            LocalDate mergedStartDate,
            LocalDateTime detectedAt,
            Boolean resolved) {
        this.sourceEventIds = sourceEventIds;
        this.merged = merged;
        this.mergedStartDate = mergedStartDate;
        this.detectedAt = detectedAt;
        this.resolved = resolved;
    }

  
    public String getSourceEventIds() {
        return sourceEventIds;
    }

    public String getMerged() {
        return merged;
    }

    public LocalDate getMergedStartDate() {
        return mergedStartDate;
    }

    public LocalDateTime getDetectedAt() {
        return detectedAt;
    }

    public Boolean getResolved() {
        return resolved;
    }

   
    public void setSourceEventIds(String sourceEventIds) {
        this.sourceEventIds = sourceEventIds;
    }

    public void setMerged(String merged) {
        this.merged = merged;
    }

    public void setMergedStartDate(LocalDate mergedStartDate) {
        this.mergedStartDate = mergedStartDate;
    }

    public void setDetectedAt(LocalDateTime detectedAt) {
        this.detectedAt = detectedAt;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
