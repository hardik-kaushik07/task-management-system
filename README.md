# 📝 Task Management System

A secure Task Management System built using **Spring Boot**, **Spring Security**, and **JWT Authentication**. This application allows users to register, login, and manage their personal tasks through secured REST APIs.

---

## 🚀 Features

- 🔐 User Registration & Login (JWT Authentication)
- 🧑‍💻 Secure APIs using Spring Security
- 📋 Create, Update, Fetch Tasks
- 🔍 Filter tasks by status
- 🛡️ Stateless authentication using JWT
- 🗄️ MySQL Database Integration
- 🧱 Layered Architecture (Controller, Service, Repository)

---

## 🛠️ Tech Stack

- **Backend:** Spring Boot, Spring Security  
- **Authentication:** JWT (JSON Web Token)  
- **Database:** MySQL  
- **ORM:** Spring Data JPA (Hibernate)  
- **Build Tool:** Maven  

---

## 📁 Project Structure
src/main/java/com/hardik/taskmanagementsystem
│
├── Configuration # JWT config & security filter
├── Controller # REST APIs
├── Model # Entity classes
├── Repository # Database access
├── Service # Business logic
└── TaskManagementSystemApplication.java

## ⚙️ Setup Instructions

### 1. Clone the Repository

git clone https://github.com/hardik-kaushik07/task-management-system.git
cd task-management-system

### 2. Configure Database

Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/your_db
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update

### 3️. Run the Application

mvn spring-boot:run

App runs on:
http://localhost:8080


🔑 API Endpoints
Auth APIs
POST /register → Register new user
POST /login → Authenticate and receive JWT
Task APIs (Protected)
GET /tasks → Get all tasks (user-specific)
POST /tasks → Create new task
PUT /update/{id} → Update task
DELETE/delete/{id} → delete task

🧪 Testing

Use Postman:

Login → get JWT token
Add header:
Authorization: Bearer <your_token>


🔒 Security
Passwords encrypted using BCrypt
JWT-based stateless authentication
Custom JWT filter for request validation

📌 Future Improvements
Role-based authorization (ADMIN / USER)
Refresh Token support
Pagination & sorting
Frontend integration (React)


🙌 Author
Hardik Kaushik

⭐ Support

If you found this useful, consider giving it a ⭐ on GitHub!
