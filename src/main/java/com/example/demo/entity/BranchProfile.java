package com.example.demo.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AcademicEvent {
     private long branchd;
  private String title;
  private String evenType;
  private LocalDate startData;
  private LocalDate ebdData;
  private String location;
  private String description;
  private LocalDateTime submittedAt;
  public AcademicEvent(long branchd, String title, String evenType, LocalDate startData, LocalDate ebdData,
        String location, String description, LocalDateTime submittedAt) {
    this.branchd = branchd;
    this.title = title;
    this.evenType = evenType;
    this.startData = startData;
    this.ebdData = ebdData;
    this.location = location;
    this.description = description;
    this.submittedAt = submittedAt;
  }
  public long getBranchd() {
    return branchd;
  }
  public void setBranchd(long branchd) {
    this.branchd = branchd;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getEvenType() {
    return evenType;
  }
  public void setEvenType(String evenType) {
    this.evenType = evenType;
  }
  public LocalDate getStartData() {
    return startData;
  }
  public void setStartData(LocalDate startData) {
    this.startData = startData;
  }
  public LocalDate getEbdData() {
    return ebdData;
  }
  public void setEbdData(LocalDate ebdData) {
    this.ebdData = ebdData;
  }
  public String getLocation() {
    return location;
  }
  public void setLocation(String location) {
    this.location = location;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public LocalDateTime getSubmittedAt() {
    return submittedAt;
  }
  public void setSubmittedAt(LocalDateTime submittedAt) {
    this.submittedAt = submittedAt;
  }
}
