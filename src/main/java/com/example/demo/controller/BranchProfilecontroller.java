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

import com.example.demo.entity.StudentEntity;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    // CREATE
    @PostMapping("/students")
    public StudentEntity saveStudent(@RequestBody StudentEntity student) {
        return studentService.saveData(student);
    }

    // READ ALL
    @GetMapping("/students")
    public List<StudentEntity> getAllStudents() {
        return studentService.getData();
    }

    // READ BY ID
    @GetMapping("/students/{id}")
    public StudentEntity getStudentById(@PathVariable int id) {
        return studentService.getById(id);
    }

    // UPDATE
    @PutMapping("/students/{id}")
    public StudentEntity updateStudent(
            @PathVariable int id,
            @RequestBody StudentEntity student) {
        return studentService.update(id, student);
    }

    // DELETE
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable int id) {
        studentService.delete(id);
        return "Student deleted successfully";
    }
}
