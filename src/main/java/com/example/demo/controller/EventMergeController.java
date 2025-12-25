// src/main/java/com/example/demo/controller/EventMergeController.java
package com.example.demo.controller;

import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Tag(name = "Event Merge Records")
@RestController
@RequestMapping("/api/merge-records")
public class EventMergeController {

    private final EventMergeService service;

    public EventMergeController(EventMergeService service) {
        this.service = service;
    }

    @Operation(summary = "Merge events")
    @PostMapping
    public ResponseEntity<EventMergeRecord> merge(@RequestBody Map<String, Object> request) {
        @SuppressWarnings("unchecked")
        List<Long> eventIds = (List<Long>) request.get("eventIds");
        String reason = (String) request.get("reason");
        return ResponseEntity.ok(service.mergeEvents(eventIds, reason));
    }

    @Operation(summary = "Get merge record by ID")
    @GetMapping("/{id}")
    public ResponseEntity<EventMergeRecord> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getMergeRecordById(id));
    }

    @Operation(summary = "Get all merge records")
    @GetMapping
    public ResponseEntity<List<EventMergeRecord>> getAll() {
        return ResponseEntity.ok(service.getAllMergeRecords());
    }

    @Operation(summary = "Get merge records in date range")
    @GetMapping("/range")
    public ResponseEntity<List<EventMergeRecord>> getByRange(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        return ResponseEntity.ok(service.getMergeRecordsByDate(start, end));
    }
}