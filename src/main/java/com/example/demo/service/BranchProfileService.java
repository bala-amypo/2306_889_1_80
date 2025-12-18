package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BranchProfile;

@Service
public class BranchProfileService {

    private Map<Long, BranchProfile> branchMap = new HashMap<>();

    // CREATE
    public BranchProfile saveData(BranchProfile branchProfile) {
        branchMap.put(branchProfile.getId(), branchProfile);
        return branchProfile;
    }

    // READ ALL
    public List<BranchProfile> getData() {
        return new ArrayList<>(branchMap.values());
    }

    // READ BY ID
    public BranchProfile getById(Long id) {
        return branchMap.get(id);
    }

    // UPDATE
    public BranchProfile update(Long id, BranchProfile branchProfile) {
        branchMap.put(id, branchProfile);
        return branchProfile;
    }

    // DELETE
    public void delete(Long id) {
        branchMap.remove(id);
    }
}
