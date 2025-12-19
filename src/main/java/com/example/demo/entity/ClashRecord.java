package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class ClashRecord {
    @Id
    private Long id;
    private  Long eventAId;
    private Long eventBId;
    private String clashType;
    private String severity;
    private String details;
    private LocalDateTime detctedAt;
    private  Boolean resolved;
    public ClashRecord(Long eventAId, Long eventBId, String clashType, String severity, String details,
            LocalDateTime detctedAt, Boolean resolved) {
        this.eventAId = eventAId;
        this.eventBId = eventBId;
        this.clashType = clashType;
        this.severity = severity;
        this.details = details;
        this.detctedAt = detctedAt;
        this.resolved = resolved;
    }
    public Long getEventAId() {
        return eventAId;
    }
    public void setEventAId(Long eventAId) {
        this.eventAId = eventAId;
    }
    public Long getEventBId() {
        return eventBId;
    }
    public void setEventBId(Long eventBId) {
        this.eventBId = eventBId;
    }
    public String getClashType() {
        return clashType;
    }
    public void setClashType(String clashType) {
        this.clashType = clashType;
    }
    public String getSeverity() {
        return severity;
    }
    public void setSeverity(String severity) {
        this.severity = severity;
    }
    public String getDetails() {
        return details;
    }
    public void setDetails(String details) {
        this.details = details;
    }
    public LocalDateTime getDetctedAt() {
        return detctedAt;
    }
    public void setDetctedAt(LocalDateTime detctedAt) {
        this.detctedAt = detctedAt;
    }
    public Boolean getResolved() {
        return resolved;
    }
    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }


}
