package com.example.demo.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.StudentEntity;

@Service
public class StudentService {

    private Map<Integer, StudentEntity> studentMap = new HashMap<>();

   
    public StudentEntity saveData(StudentEntity student) {
        studentMap.put(student.getId(), student);
        return student;
    }

 
    public List<StudentEntity> getData() {
        return new ArrayList<>(studentMap.values());
    }

   
    public StudentEntity getById(int id) {
        return studentMap.get(id);
    }

    // UPDATE
    public StudentEntity update(int id, StudentEntity student) {
        studentMap.put(id, student);
        return student;
    }

   
    public void delete(int id) {
        studentMap.remove(id);
    }
}
