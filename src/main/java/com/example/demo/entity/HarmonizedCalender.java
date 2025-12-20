package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class HarmonizedCalendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String generatedBy;
    private LocalDate effectiveFrom;
    private LocalDate effectiveTo;

    @Lob
    private String eventsJson;

    public HarmonizedCalendar() {}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGeneratedBy(String generatedBy) {
        this.generatedBy = generatedBy;
    }

    public void setEffectiveFrom(LocalDate effectiveFrom) {
        this.effectiveFrom = effectiveFrom;
    }

    public void setEffectiveTo(LocalDate effectiveTo) {
        this.effectiveTo = effectiveTo;
    }

    public void setEventsJson(String eventsJson) {
        this.eventsJson = eventsJson;
    }
}
