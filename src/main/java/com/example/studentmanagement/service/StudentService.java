package com.example.studentmanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.studentmanagement.exception.StudentNotFoundException;
import com.example.studentmanagement.model.Student;
import com.example.studentmanagement.repository.StudentRepository;

@Service
@Transactional
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
                        new StudentNotFoundException("Student not found with ID : " + id));
    }

    // Add student
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    // Update student
    public Student updateStudent(Integer id, Student student) {

        Student existing = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with ID : " + id));

        existing.setName(student.getName());
        existing.setAge(student.getAge());
        existing.setCourse(student.getCourse());
        existing.setCity(student.getCity());

        return repository.save(existing);
    }

    // Delete student
    public void deleteStudent(Integer id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new StudentNotFoundException("Student not found with ID : " + id));

        repository.delete(student);
    }

    // Search by City
    public List<Student> getStudentsByCity(String city) {
        return repository.findStudentsByCity(city);
    }

    // Search by Course
    public List<Student> getStudentsByCourse(String course) {
        return repository.findStudentsByCourse(course);
    }

    // Pagination
    public Page<Student> getStudents(int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return repository.findAll(pageable);
    }

}