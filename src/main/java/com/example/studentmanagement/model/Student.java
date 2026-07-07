package com.example.studentmanagement.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Student name is required")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 60, message = "Age cannot be greater than 60")
    private Integer age;

    @NotBlank(message = "Course is required")
    private String course;

    @NotBlank(message = "City is required")
    private String city;

    @Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", course=" + course + ", city=" + city + "]";
	}

	public Student() {
    }

    public Student(Integer id, String name, Integer age, String course, String city) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}