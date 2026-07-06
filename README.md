# StudentManagementSystem
Student Management System built using Spring Boot, Spring Data JPA, MySQL, and REST APIs with CRUD operations and exception handling.

# Student Management System

A Spring Boot CRUD application that performs Create, Read, Update, and Delete (CRUD) operations on student records using MySQL.

## Technologies Used

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- STS (Spring Tool Suite)
- Postman

## Features

- Add a Student
- View All Students
- View Student by ID
- Update Student Details
- Delete Student
- Exception Handling
- MySQL Database Integration

## Project Structure

```
src
 ├── main
 │   ├── java
 │   │    └── com.example.studentmanagement
 │   │          ├── controller
 │   │          ├── model
 │   │          ├── repository
 │   │          ├── service
 │   │          ├── exception
 │   │          └── StudentManagementApplication.java
 │   └── resources
 │         └── application.properties
```

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | /students | Get all students |
| GET | /students/{id} | Get student by ID |
| POST | /students | Add new student |
| PUT | /students/{id} | Update student |
| DELETE | /students/{id} | Delete student |

## Database

Database Name:

```
studentdb
```

Table Name:

```
students
```

## Author

Vedika Pawade
