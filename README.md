# 🧾 User Profile REST API

This is a simple **Spring Boot + MySQL** based REST API for managing user profiles. It supports basic **CRUD operations** and follows a layered architecture using **Controller, Service, Repository**.

---

## 🔧 Technologies Used

- Java 21
- Spring Boot 3.5.3
- Spring Data JPA
- MySQL Database
- Maven
- Lombok

---

## 📁 Folder Structure

src/
└── main/
└── java/com/example/demo/
├── controller/
│ └── UserProfileController.java
├── model/
│ └── UserProfile.java
├── repository/
│ └── UserProfileRepository.java
└── service/
└── UserProfileService.java





---

## ⚙️ Application Configuration

In your `src/main/resources/application.properties`, add the following:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/user_db
spring.datasource.username=root
spring.datasource.password=your_password

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect

server.port=8080

🔁 Replace user_db and your_password as per your MySQL setup.



🧪 API Endpoints
Method	Endpoint	Description
POST	/api/user	Create new user
GET	/api/user	Get all users
GET	/api/user/{id}	Get user by ID
PUT	/api/user/{id}	Update user by ID
DELETE	/api/user/{id}	Delete user by ID


📦 Sample JSON Request (Create/Update)
json
Copy
Edit
{
  "name": "Vedansh Tiwari",
  "email": "vedansh@example.com",
  "mobile": "9999999999",
  "address": "Varanasi"
}


▶️ How to Run
✅ Make sure MySQL is running and a database named user_db is created:

sql
Copy
Edit
CREATE DATABASE user_db;
✅ Build and run the application:

bash
Copy
Edit
mvn spring-boot:run
✅ Access API on:

bash
Copy
Edit
http://localhost:8080/api/user
📄





