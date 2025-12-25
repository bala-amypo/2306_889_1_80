// src/main/java/com/example/demo/controller/BranchProfileController.java
package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Branch Profiles")
@RestController
@RequestMapping("/api/branches")
public class BranchProfileController {

    private final BranchProfileService service;

    public BranchProfileController(BranchProfileService service) {
        this.service = service;
    }

    @Operation(summary = "Create a new branch")
    @PostMapping
    public ResponseEntity<BranchProfile> create(@RequestBody BranchProfile branch) {
        return ResponseEntity.ok(service.createBranch(branch));
    }

    @Operation(summary = "Update branch status")
    @PutMapping("/{id}/status")
    public ResponseEntity<BranchProfile> updateStatus(@PathVariable Long id, @RequestParam boolean active) {
        return ResponseEntity.ok(service.updateBranchStatus(id, active));
    }

    @Operation(summary = "Get branch by ID")
    @GetMapping("/{id}")
    public ResponseEntity<BranchProfile> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getBranchById(id));
    }

    @Operation(summary = "Get all branches")
    @GetMapping
    public ResponseEntity<List<BranchProfile>> getAll() {
        return ResponseEntity.ok(service.getAllBranches());
    }

    @Operation(summary = "Lookup branch by code")
    @GetMapping("/lookup/{branchCode}")
    public ResponseEntity<BranchProfile> findByCode(@PathVariable String branchCode) {
        return ResponseEntity.ok(service.findByBranchCode(branchCode));
    }
}