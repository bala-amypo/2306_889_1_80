// src/main/java/com/example/demo/controller/BranchProfileController.java
package com.example.demo.controller;

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

    private final BranchProfileService branchProfileService;

    public BranchProfileController(BranchProfileService branchProfileService) {
        this.branchProfileService = branchProfileService;
    }

    @Operation(summary = "Create a branch profile")
    @PostMapping
    public ResponseEntity<BranchProfile> createBranch(@RequestBody BranchProfile branch) {
        return ResponseEntity.ok(branchProfileService.createBranch(branch));
    }

    @Operation(summary = "Update branch status")
    @PutMapping("/{id}/status")
    public ResponseEntity<BranchProfile> updateBranchStatus(@PathVariable Long id, @RequestParam boolean active) {
        return ResponseEntity.ok(branchProfileService.updateBranchStatus(id, active));
    }

    @Operation(summary = "Get branch by ID")
    @GetMapping("/{id}")
    public ResponseEntity<BranchProfile> getBranchById(@PathVariable Long id) {
        return ResponseEntity.ok(branchProfileService.getBranchById(id));
    }

    @Operation(summary = "Get all branches")
    @GetMapping
    public ResponseEntity<List<BranchProfile>> getAllBranches() {
        return ResponseEntity.ok(branchProfileService.getAllBranches());
    }

    @Operation(summary = "Find branch by code")
    @GetMapping("/lookup/{branchCode}")
    public ResponseEntity<BranchProfile> findByBranchCode(@PathVariable String branchCode) {
        return ResponseEntity.ok(branchProfileService.findByBranchCode(branchCode));
    }
}