package com.example.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.studentmanagement.exception.StudentNotFoundException;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    // Get all students
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    // Get student by ID
    public Student getStudentById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with ID: " + id));
    }

    // Add new student
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    // Update existing student
    public Student updateStudent(Integer id, Student student) {

        Student existingStudent = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with ID: " + id));

        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setCourse(student.getCourse());
        existingStudent.setCity(student.getCity());

        return repository.save(existingStudent);
    }

    // Delete student
    public void deleteStudent(Integer id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with ID: " + id));

        repository.delete(student);
    }
}