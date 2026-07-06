package com.example.studentmanagement.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.studentmanagement.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.city = ?1")
    List<Student> findStudentsByCity(String city);

    @Query("SELECT s FROM Student s WHERE s.course = ?1")
    List<Student> findStudentsByCourse(String course);

    Page<Student> findAll(Pageable pageable);
}