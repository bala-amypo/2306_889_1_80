package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.BranchProfile;

@Service
public class BranchProfileService {

    private Map<Integer, BranchProfile> studentMap = new HashMap<>();

   
    public BranchProfile saveData(BranchProfile student) {
        studentMap.put(student.getId(), student);
        return student;
    }

    
    public List<BranchProfile> getData() {
        return new ArrayList<>(studentMap.values());
    }

   
    public BranchProfile getById(int id) {
        return studentMap.get(id);
    }

  
    public BranchProfile update(int id, BranchProfile) {
        studentMap.put(id, student);
        return student;
    }

   
    public void delete(int id) {
        studentMap.remove(id);
    }
}
