// src/main/java/com/example/demo/controller/HarmonizedCalendarController.java
package com.example.demo.controller;

import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Tag(name = "Harmonized Calendars")
@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService service;

    public HarmonizedCalendarController(HarmonizedCalendarService service) {
        this.service = service;
    }

    @Operation(summary = "Generate a harmonized calendar")
    @PostMapping("/generate")
    public ResponseEntity<HarmonizedCalendar> generate(@RequestBody Map<String, String> request) {
        String title = request.get("title");
        String generatedBy = request.get("generatedBy");
        return ResponseEntity.ok(service.generateHarmonizedCalendar(title, generatedBy));
    }

    @Operation(summary = "Get calendar by ID")
    @GetMapping("/{id}")
    public ResponseEntity<HarmonizedCalendar> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getCalendarById(id));
    }

    @Operation(summary = "Get all calendars")
    @GetMapping
    public ResponseEntity<List<HarmonizedCalendar>> getAll() {
        return ResponseEntity.ok(service.getAllCalendars());
    }

    @Operation(summary = "Get calendars in range")
    @GetMapping("/range")
    public ResponseEntity<List<HarmonizedCalendar>> getInRange(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return ResponseEntity.ok(service.getCalendarsWithinRange(start, end));
    }
}