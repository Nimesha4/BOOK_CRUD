# Book CRUD Application with JWT Authentication

This project is a Spring Boot RESTful API for managing books, featuring full CRUD (Create, Read, Update, Delete) operations. It uses PostgreSQL for data storage and implements secure authentication and authorization using JWT (JSON Web Tokens). The application supports user roles (ADMIN and USER), allowing only admins to create, update, or delete books, while both users and admins can view book details.

## Features
- User registration and login with JWT authentication
- Role-based access control (ADMIN/USER)
- Secure endpoints for managing books
- Password encryption with BCrypt
- PostgreSQL database integration
- Built with Spring Boot, Spring Security, JPA, Lombok

## Endpoints

### Authentication
- `POST /auth/register` — Register a new user
- `POST /auth/login` — Login and receive JWT token

### Products (Books)
- `GET /products` — List all books (USER & ADMIN)
- `GET /products/{id}` — Get book by ID (USER & ADMIN)
- `POST /products` — Create a new book (ADMIN only)
- `PUT /products/{id}` — Update a book (ADMIN only)
- `DELETE /products/{id}` — Delete a book (ADMIN only)

### Hello
- `GET /hello` — Test endpoint for authenticated users

## Technologies Used
- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- PostgreSQL
- Lombok
- JWT (io.jsonwebtoken)

## Getting Started

1. **Clone the repository:**
   ```bash
   git clone <repo-url>
   cd crudjwt
   ```
2. **Configure the database:**
   - Update `src/main/resources/application.properties` with your PostgreSQL credentials.
3. **Build and run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```
4. **API Usage:**
   - Use tools like Postman to interact with the endpoints.
   - Register a user, login to get a JWT, and use the token in the `Authorization` header as `Bearer <token>` for protected endpoints.

## License
This project is for educational purposes.

---
 
