// src/main/java/com/example/demo/controller/EventMergeController.java
package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.EventMergeRecord;
import com.example.demo.service.EventMergeService;
import io.swagger.v3.oas.annotations.Operation;
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

    private final EventMergeService eventMergeService;

    public EventMergeController(EventMergeService eventMergeService) {
        this.eventMergeService = eventMergeService;
    }

    @Operation(summary = "Merge events")
    @PostMapping
    public ResponseEntity<ApiResponse> mergeEvents(@RequestBody Map<String, Object> request) {
        @SuppressWarnings("unchecked")
        List<Long> eventIds = (List<Long>) request.get("eventIds");
        String reason = (String) request.get("reason");

        EventMergeRecord record = eventMergeService.mergeEvents(eventIds, reason);
        return ResponseEntity.ok(new ApiResponse(true, "Events merged successfully", record));
    }

    @Operation(summary = "Get merge record by ID")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getMergeRecordById(@PathVariable Long id) {
        EventMergeRecord record = eventMergeService.getMergeRecordById(id);
        return ResponseEntity.ok(new ApiResponse(true, "Merge record found", record));
    }

    @Operation(summary = "Get all merge records")
    @GetMapping
    public ResponseEntity<ApiResponse> getAllMergeRecords() {
        List<EventMergeRecord> records = eventMergeService.getAllMergeRecords();
        return ResponseEntity.ok(new ApiResponse(true, "Merge records retrieved", records));
    }

    @Operation(summary = "Get merge records by date range")
    @GetMapping("/range")
    public ResponseEntity<ApiResponse> getMergeRecordsByDate(@RequestParam LocalDate start, @RequestParam LocalDate end) {
        List<EventMergeRecord> records = eventMergeService.getMergeRecordsByDate(start, end);
        return ResponseEntity.ok(new ApiResponse(true, "Merge records in range retrieved", records));
    }
}