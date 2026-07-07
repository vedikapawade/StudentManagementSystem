package com.example.studentmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(service.getAllStudents());
    }

    // Get student by ID
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getStudentById(id));
    }

    // Add student
    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {

        Student savedStudent = service.saveStudent(student);

        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    // Update student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id,
                                                 @Valid @RequestBody Student student) {

        Student updatedStudent = service.updateStudent(id, student);

        return ResponseEntity.ok(updatedStudent);
    }

    // Delete student
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Integer id) {

        service.deleteStudent(id);

        return ResponseEntity.ok("Student deleted successfully.");
    }

    // Search by City
    @GetMapping("/city/{city}")
    public ResponseEntity<List<Student>> getStudentsByCity(@PathVariable String city) {

        return ResponseEntity.ok(service.getStudentsByCity(city));
    }

    // Search by Course
    @GetMapping("/course/{course}")
    public ResponseEntity<List<Student>> getStudentsByCourse(@PathVariable String course) {

        return ResponseEntity.ok(service.getStudentsByCourse(course));
    }

    // Pagination
    @GetMapping("/page")
    public ResponseEntity<Page<Student>> getStudentsWithPagination(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size) {

        return ResponseEntity.ok(service.getStudents(page, size));
    }

}