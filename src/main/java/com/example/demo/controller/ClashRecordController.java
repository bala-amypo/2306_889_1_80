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

    private final ClashDetectionService service;

    public ClashRecordController(ClashDetectionService service) {
        this.service = service;
    }

    @Operation(summary = "Log a clash")
    @PostMapping
    public ResponseEntity<ClashRecord> log(@RequestBody ClashRecord clash) {
        return ResponseEntity.ok(service.logClash(clash));
    }

    @Operation(summary = "Resolve a clash")
    @PutMapping("/{id}/resolve")
    public ResponseEntity<ClashRecord> resolve(@PathVariable Long id) {
        return ResponseEntity.ok(service.resolveClash(id));
    }

    @Operation(summary = "Get clashes for event")
    @GetMapping("/event/{eventId}")
    public ResponseEntity<List<ClashRecord>> getForEvent(@PathVariable Long eventId) {
        return ResponseEntity.ok(service.getClashesForEvent(eventId));
    }

    @Operation(summary = "Get unresolved clashes")
    @GetMapping("/unresolved")
    public ResponseEntity<List<ClashRecord>> getUnresolved() {
        return ResponseEntity.ok(service.getUnresolvedClashes());
    }

    @Operation(summary = "Get all clashes")
    @GetMapping
    public ResponseEntity<List<ClashRecord>> getAll() {
        return ResponseEntity.ok(service.getAllClashes());
    }
}