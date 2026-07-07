# 🎓 Student Management System

A Spring Boot REST API project for managing student records using CRUD operations. This project demonstrates Java, Spring Boot, Spring Data JPA, MySQL, validation, pagination, custom queries, and exception handling.

---

## 🚀 Features

- ➕ Add a new student
- 📋 View all students
- 🔍 View student by ID
- ✏️ Update student details
- ❌ Delete a student
- 🏙️ Search students by city
- 📚 Search students by course
- 📄 Pagination support
- ✅ Input validation
- ⚠️ Global exception handling
- 💾 MySQL database integration

---

## 🛠️ Technologies Used

- Java 17+
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Jakarta Validation
- Lombok (Optional)
- STS 4 / Eclipse
- MySQL Workbench
- Git & GitHub

---

## 📂 Project Structure

```
StudentManagement
│
├── controller
│      StudentController.java
│
├── service
│      StudentService.java
│
├── repository
│      StudentRepository.java
│
├── model
│      Student.java
│
├── exception
│      StudentNotFoundException.java
│      ErrorResponse.java
│      GlobalExceptionHandler.java
│
├── resources
│      application.properties
│
└── StudentManagementApplication.java
```

---

## 🗄️ Database Configuration

Update `application.properties` with your MySQL credentials.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/studentdb
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

---

## 📌 REST API Endpoints

| Method | Endpoint | Description |
|---------|----------|-------------|
| GET | `/students` | Get all students |
| GET | `/students/{id}` | Get student by ID |
| POST | `/students` | Add a student |
| PUT | `/students/{id}` | Update student |
| DELETE | `/students/{id}` | Delete student |
| GET | `/students/city/{city}` | Search by city |
| GET | `/students/course/{course}` | Search by course |
| GET | `/students/page?page=0&size=5` | Get students with pagination |

---

## 📥 Sample JSON Request

```json
{
  "name": "Vedika Pawade",
  "age": 21,
  "course": "Computer Science",
  "city": "Nagpur"
}
```

---

## ▶️ How to Run

1. Clone the repository

```bash
git clone https://github.com/vedikapawade/StudentManagementSystem.git
```

2. Open the project in STS or Eclipse.

3. Configure MySQL in `application.properties`.

4. Create the database:

```sql
CREATE DATABASE studentdb;
```

5. Run the project as a Spring Boot Application.

6. Test the REST APIs using Postman.

---

## 📸 API Testing

Example:

```
GET http://localhost:8080/students
```

```
POST http://localhost:8080/students
```

```
PUT http://localhost:8080/students/1
```

```
DELETE http://localhost:8080/students/1
```

---

## 🔮 Future Enhancements

- JWT Authentication
- Spring Security
- Swagger/OpenAPI Documentation
- Role-Based Access Control
- Caching
- Sorting and Filtering
- Docker Support
- Unit and Integration Testing

---

## 👩‍💻 Author

**Vedika Pawade**

- B.Tech Computer Science Engineering
- Java Full Stack Developer
- Spring Boot | MySQL | REST API

---

## 📄 License

This project is developed for learning purposes and academic use.
