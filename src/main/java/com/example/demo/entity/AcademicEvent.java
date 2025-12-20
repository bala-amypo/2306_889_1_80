package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public AcademicEvent() {}

    @PrePersist
    public void onCreate() {
        this.submittedAt = LocalDateTime.now();
    }

    public LocalDate getStartDate() { return startDate; }
    public LocalDate getEndDate() { return endDate; }

    public void setTitle(String title) { this.title = title; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public void setStartDate(LocalDate startDate) { this.startDate = startDate; }
    public void setEndDate(LocalDate endDate) { this.endDate = endDate; }
    public void setLocation(String location) { this.location = location; }
    public void setDescription(String description) { this.description = description; }
}
