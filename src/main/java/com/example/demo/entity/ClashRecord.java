package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
public class ClashRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long eventAId;
    private Long eventBId;
    private Boolean resolved;

    public ClashRecord() {}

    public Long getId() {
        return id;
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

    public Boolean getResolved() {
        return resolved;
    }

    public void setResolved(Boolean resolved) {
        this.resolved = resolved;
    }
}
