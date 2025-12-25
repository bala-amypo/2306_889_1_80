// src/main/java/com/example/demo/controller/ClashRecordController.java
package com.example.demo.controller;

import com.example.demo.entity.ClashRecord;
import com.example.demo.service.ClashDetectionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Clash Records")
@RestController
@RequestMapping("/api/clashes")
public class ClashRecordController {

    private final ClashDetectionService clashDetectionService;

    public ClashRecordController(ClashDetectionService clashDetectionService) {
        this.clashDetectionService = clashDetectionService;
    }

    @Operation(summary = "Log a new clash")
    @PostMapping
    public ResponseEntity<ClashRecord> logClash(@RequestBody ClashRecord clash) {
        return ResponseEntity.ok(clashDetectionService.logClash(clash));
    }

    @Operation(summary = "Mark a clash as resolved")
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClashRecord> resolveClash(@PathVariable Long id) {
        return ResponseEntity.ok(clashDetectionService.resolveClash(id));
    }

    @Operation(summary = "Get clashes involving a specific event")
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<ClashRecord>> getClashesForEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(clashDetectionService.getClashesForEvent(eventId));
    }

    @Operation(summary = "Get all unresolved clashes")
    @GetMapping("/unresolved")
    public ResponseEntity<List<ClashRecord>> getUnresolvedClashes() {
        return ResponseEntity.ok(clashDetectionService.getUnresolvedClashes());
    }

    @Operation(summary = "Get all clash records")
    @GetMapping
    public ResponseEntity<List<ClashRecord>> getAllClashes() {
        return ResponseEntity.ok(clashDetectionService.getAllClashes());
    }
}