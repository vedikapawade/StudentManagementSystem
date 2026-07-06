package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController {

    @Autowired
    private StudentService service;

    // Get All Students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // Get Student By ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    // Add Student
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return service.saveStudent(student);
    }

    // Update Student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @Valid @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // Delete Student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
        return "Student deleted successfully.";
    }
}