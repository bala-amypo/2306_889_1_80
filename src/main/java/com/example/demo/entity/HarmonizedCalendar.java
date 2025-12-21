package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "harmonized_calendars")
public class HarmonizedCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String generatedBy;
    private LocalDateTime generatedAt;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    @Column(columnDefinition = "TEXT")
    private String eventsJson;

    public HarmonizedCalendar() {
    }

    public HarmonizedCalendar(Long id, String title, String generatedBy,
            LocalDateTime generatedAt, LocalDate effectiveFrom,
            LocalDate effectiveTo, String eventsJson) {
        this.id = id;
        this.title = title;
        this.generatedBy = generatedBy;
        this.generatedAt = generatedAt;
        this.effectiveFrom = effectiveFrom;
        this.effectiveTo = effectiveTo;
        this.eventsJson = eventsJson;
    }

    @PrePersist
    public void onGenerate() {
        this.generatedAt = LocalDateTime.now();
    }

    // getters and setters
}
