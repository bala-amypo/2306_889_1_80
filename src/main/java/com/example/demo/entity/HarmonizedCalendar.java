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

    public HarmonizedCalendar() {}

    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public void setTitle(String title) { this.title = title; }
    public void setGeneratedBy(String generatedBy) { this.generatedBy = generatedBy; }
    public void setEffectiveFrom(LocalDate effectiveFrom) { this.effectiveFrom = effectiveFrom; }
    public void setEffectiveTo(LocalDate effectiveTo) { this.effectiveTo = effectiveTo; }
    public void setEventsJson(String eventsJson) { this.eventsJson = eventsJson; }
}
