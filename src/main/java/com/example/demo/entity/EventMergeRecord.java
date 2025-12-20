package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
public class EventMergeRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sourceEventIds;
    private String mergedTitle;
    private LocalDate mergedStartDate;
    private LocalDate mergedEndDate;
    private String mergeReason;

    public EventMergeRecord() {}

    public void setSourceEventIds(String sourceEventIds) {
        this.sourceEventIds = sourceEventIds;
    }

    public void setMergedTitle(String mergedTitle) {
        this.mergedTitle = mergedTitle;
    }

    public void setMergedStartDate(LocalDate mergedStartDate) {
        this.mergedStartDate = mergedStartDate;
    }

    public void setMergedEndDate(LocalDate mergedEndDate) {
        this.mergedEndDate = mergedEndDate;
    }

    public void setMergeReason(String mergeReason) {
        this.mergeReason = mergeReason;
    }
}
