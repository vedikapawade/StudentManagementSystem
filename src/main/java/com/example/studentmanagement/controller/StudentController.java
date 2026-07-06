package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return service.getAllStudents();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Integer id) {
        return service.getStudentById(id);
    }

    // Add student
    @PostMapping
    public Student addStudent(@Valid @RequestBody Student student) {
        return service.saveStudent(student);
    }

    // Update student
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @Valid @RequestBody Student student) {
        return service.updateStudent(id, student);
    }

    // Delete student
    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id) {
        service.deleteStudent(id);
        return "Student deleted successfully.";
    }

    // Search students by city
    @GetMapping("/city/{city}")
    public List<Student> getStudentsByCity(@PathVariable String city) {
        return service.getStudentsByCity(city);
    }

    // Search students by course
    @GetMapping("/course/{course}")
    public List<Student> getStudentsByCourse(@PathVariable String course) {
        return service.getStudentsByCourse(course);
    }

    // Pagination
    @GetMapping("/page")
    public Page<Student> getStudentsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return service.getStudentsWithPagination(page, size);
    }
}