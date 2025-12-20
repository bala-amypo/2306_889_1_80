package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.ValidationException;
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

    public AcademicEvent() {
    }

    public AcademicEvent(Long id, Long branchId, String title,
                         String eventType, LocalDate startDate,
                         LocalDate endDate, String location,
                         String description, LocalDateTime submittedAt) {
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
    public void prePersist() {
        if (startDate != null && endDate != null && startDate.isAfter(endDate)) {
            throw new ValidationException("startDate cannot be after endDate");
        }
        this.submittedAt = LocalDateTime.now();
    }

}
