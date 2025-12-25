// src/main/java/com/example/demo/controller/HarmonizedCalendarController.java
package com.example.demo.controller;

import com.example.demo.dto.GenerateCalendarRequest;
import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Harmonized Calendars")
@RestController
@RequestMapping("/api/harmonized-calendars")
public class HarmonizedCalendarController {

    private final HarmonizedCalendarService harmonizedCalendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService harmonizedCalendarService) {
        this.harmonizedCalendarService = harmonizedCalendarService;
    }

    @Operation(summary = "Generate a new harmonized calendar")
    @PostMapping("/generate")
    public ResponseEntity<HarmonizedCalendar> generateCalendar(@RequestBody GenerateCalendarRequest request) {
        return ResponseEntity.ok(
                harmonizedCalendarService.generateHarmonizedCalendar(request.getTitle(), request.getGeneratedBy()));
    }

    @Operation(summary = "Get harmonized calendar by ID")
    @GetMapping("/{id}")
    public ResponseEntity<HarmonizedCalendar> getCalendarById(@PathVariable Long id) {
        return ResponseEntity.ok(harmonizedCalendarService.getCalendarById(id));
    }

    @Operation(summary = "Get all harmonized calendars")
    @GetMapping
    public ResponseEntity<List<HarmonizedCalendar>> getAllCalendars() {
        return ResponseEntity.ok(harmonizedCalendarService.getAllCalendars());
    }

    @Operation(summary = "Get calendars active within a date range")
    @GetMapping("/range")
    public ResponseEntity<List<HarmonizedCalendar>> getCalendarsWithinRange(@RequestParam LocalDate start,
                                                                            @RequestParam LocalDate end) {
        return ResponseEntity.ok(harmonizedCalendarService.getCalendarsWithinRange(start, end));
    }
}