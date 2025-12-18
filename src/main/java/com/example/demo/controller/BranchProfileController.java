package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;

@RestController
@RequestMapping("/branch")
public class BranchProfileController {

    @Autowired
    private BranchProfileService service;

 
    @PostMapping("/post")
    public BranchProfile save(@RequestBody BranchProfile branchProfile) {
        return service.saveData(branchProfile);
    }

   
    @GetMapping("/get")
    public List<BranchProfile> getAll() {
        return service.getData();
    }

    
    @GetMapping("/get/{id}")
    public BranchProfile getById(@PathVariable Long id) {
        return service.getById(id);
    }

    
    @PutMapping("/update/{id}")
    public BranchProfile update(
            @PathVariable Long id,
            @RequestBody BranchProfile branchProfile) {
        return service.update(id, branchProfile);
    }

   
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Branch deleted successfully";
    }
}
