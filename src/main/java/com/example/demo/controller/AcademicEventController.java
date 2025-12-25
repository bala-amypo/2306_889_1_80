// src/main/java/com/example/demo/controller/AcademicEventController.java
package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Academic Events")
@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService service;

    public AcademicEventController(AcademicEventService service) {
        this.service = service;
    }

    @Operation(summary = "Create a new event")
    @PostMapping
    public ResponseEntity<AcademicEvent> create(@RequestBody AcademicEvent event) {
        return ResponseEntity.ok(service.createEvent(event));
    }

    @Operation(summary = "Update an event")
    @PutMapping("/{id}")
    public ResponseEntity<AcademicEvent> update(@PathVariable Long id, @RequestBody AcademicEvent event) {
        return ResponseEntity.ok(service.updateEvent(id, event));
    }

    @Operation(summary = "Get events by branch ID")
    @GetMapping("/branch/{branchId}")
    public ResponseEntity<List<AcademicEvent>> getByBranch(@PathVariable Long branchId) {
        return ResponseEntity.ok(service.getEventsByBranch(branchId));
    }

    @Operation(summary = "Get event by ID")
    @GetMapping("/{id}")
    public ResponseEntity<AcademicEvent> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getEventById(id));
    }

    @Operation(summary = "Get all events")
    @GetMapping
    public ResponseEntity<List<AcademicEvent>> getAll() {
        return ResponseEntity.ok(service.getAllEvents());
    }
}