package com.example.demo.controller;

import com.example.demo.entity.AcademicEvent;
import com.example.demo.service.AcademicEventService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class AcademicEventController {

    private final AcademicEventService academicEventService;

    public AcademicEventController(AcademicEventService academicEventService) {
        this.academicEventService = academicEventService;
    }

    @PostMapping
    public AcademicEvent createEvent(@RequestBody AcademicEvent event) {
        return academicEventService.createEvent(event);
    }

    @PutMapping("/{id}")
    public AcademicEvent updateEvent(@PathVariable Long id,
                                     @RequestBody AcademicEvent event) {
        return academicEventService.updateEvent(id, event);
    }

    @GetMapping("/{id}")
    public AcademicEvent getEvent(@PathVariable Long id) {
        return academicEventService.getEventById(id);
    }

    @GetMapping
    public List<AcademicEvent> getAllEvents() {
        return academicEventService.getAllEvents();
    }

    @GetMapping("/branch/{branchId}")
    public List<AcademicEvent> getByBranch(@PathVariable Long branchId) {
        return academicEventService.getEventsByBranch(branchId);
    }
}
