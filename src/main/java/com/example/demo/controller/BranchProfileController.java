package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.BranchProfile;
import com.example.demo.service.BranchProfileService;

@RestController
public class BranchProfileController {

    @Autowired
    private BranchProfileService studentService;

   
    @PostMapping("/students")
    public BranchProfile saveStudent(@RequestBody BranchProfile student) {
        return studentService.saveData(student);
    }

   
 @GetMapping("/students")
    public List<BranchProfile> getAllStudents() {
        return studentService.getData();
    }

   
    @GetMapping("/students/{id}")
    public BranchProfile getStudentById(@PathVariable int id) {
        return studentService.getById(id);
    }

   
    @PutMapping("/students/{id}")
    public BranchProfile updateStudent(
            @PathVariable int id,
            @RequestBody BranchProfile student) {
        return studentService.update(id, student);
    }

 
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.delete(id);
        return "Student deleted successfully";
    }
}
