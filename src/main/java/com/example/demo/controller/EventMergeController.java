// src/main/java/com/example/demo/controller/EventMergeController.java
package com.example.demo.controller;

import com.example.demo.dto.MergeRequest;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Event Merge Records")
@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService eventMergeService;

    public EventMergeController(EventMergeService eventMergeService) {
        this.eventMergeService = eventMergeService;
    }

    @Operation(summary = "Merge events")
    @PostMapping
    public ResponseEntity<EventMergeRecord> mergeEvents(@RequestBody MergeRequest mergeRequest) {
        return ResponseEntity.ok(eventMergeService.mergeEvents(mergeRequest.getEventIds(), mergeRequest.getReason()));
    }

    @Operation(summary = "Get merge record by ID")
    @GetMapping("/{id}")
    public ResponseEntity<EventMergeRecord> getMergeRecordById(@PathVariable Long id) {
        return ResponseEntity.ok(eventMergeService.getMergeRecordById(id));
    }

    @Operation(summary = "Get all merge records")
    @GetMapping
    public ResponseEntity<List<EventMergeRecord>> getAllMergeRecords() {
        return ResponseEntity.ok(eventMergeService.getAllMergeRecords());
    }

    @Operation(summary = "Get merge records by date range")
    @GetMapping("/range")
    public ResponseEntity<List<EventMergeRecord>> getMergeRecordsByDate(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return ResponseEntity.ok(eventMergeService.getMergeRecordsByDate(start, end));
    }
}