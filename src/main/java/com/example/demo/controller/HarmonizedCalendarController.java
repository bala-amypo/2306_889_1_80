// src/main/java/com/example/demo/controller/HarmonizedCalendarController.java
package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.HarmonizedCalendar;
import com.example.demo.service.HarmonizedCalendarService;
import io.swagger.v3.oas.annotations.Operation;
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

    private final HarmonizedCalendarService harmonizedCalendarService;

    public HarmonizedCalendarController(HarmonizedCalendarService harmonizedCalendarService) {
        this.harmonizedCalendarService = harmonizedCalendarService;
    }

    @Operation(summary = "Generate a new harmonized calendar")
    @PostMapping("/generate")
    public ResponseEntity<ApiResponse> generateCalendar(@RequestBody Map<String, String> request) {
        String title = request.get("title");
        String generatedBy = request.get("generatedBy");
        HarmonizedCalendar calendar = harmonizedCalendarService.generateHarmonizedCalendar(title, generatedBy);
        return ResponseEntity.ok(new ApiResponse(true, "Calendar generated successfully", calendar));
    }

    @Operation(summary = "Get calendar by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getCalendarById(@PathVariable Long id) {
        HarmonizedCalendar calendar = harmonizedCalendarService.getCalendarById(id);
        return ResponseEntity.ok(new ApiResponse(true, "Calendar found", calendar));
    }

    @Operation(summary = "Get all calendars")
    @GetMapping
    public ResponseEntity<ApiResponse> getAllCalendars() {
        List<HarmonizedCalendar> calendars = harmonizedCalendarService.getAllCalendars();
        return ResponseEntity.ok(new ApiResponse(true, "Calendars retrieved", calendars));
    }

    @Operation(summary = "Get calendars within range")
    @GetMapping("/range")
    public ResponseEntity<ApiResponse> getCalendarsWithinRange(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        List<HarmonizedCalendar> calendars = harmonizedCalendarService.getCalendarsWithinRange(start, end);
        return ResponseEntity.ok(new ApiResponse(true, "Calendars in range retrieved", calendars));
    }
}