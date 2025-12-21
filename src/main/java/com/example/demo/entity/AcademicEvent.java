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
@Table(name = "academic_events")
public class AcademicEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long branchId;
    private String title;
    private String eventType;
    private LocalDate startDate;
    private LocalDate endDate;
    private String location;
    private String description;
    private LocalDateTime submittedAt;

    public AcademicEvent() {
    }

    public AcademicEvent(Long id, Long branchId, String title, String eventType,
            LocalDate startDate, LocalDate endDate,
            String location, String description, LocalDateTime submittedAt) {
        this.id = id;
        this.branchId = branchId;
        this.title = title;
        this.eventType = eventType;
        this.startDate = startDate;
        this.endDate = endDate;
        this.location = location;
        this.description = description;
        this.submittedAt = submittedAt;
    }

    @PrePersist
    public void onSubmit() {
        this.submittedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Long getBranchId() {
        return branchId;
    }

    public String getTitle() {
        return title;
    }

    public String getEventType() {
        return eventType;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getLocation() {
        return location;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    // getters and setters
}
