# Profile Management API

A Spring Boot REST API for managing user profiles with full CRUD operations.

## Overview

This project provides a RESTful API for creating, reading, updating, and deleting user profiles. It includes input validation, global exception handling, and uses H2 in-memory database.

## Technologies

- **Framework:** Spring Boot 3.5.0
- **Java Version:** 21
- **Database:** H2 (In-memory file-based)
- **Build Tool:** Maven

## Dependencies

- `spring-boot-starter-web` - REST API support
- `spring-boot-starter-data-jpa` - Database access
- `spring-boot-starter-validation` - Input validation
- `h2` - H2 database
- `spring-boot-devtools` - Development tools

## Project Structure

```
profile_managementAPi/
├── pom.xml
├── data/
│   └── testdb.mv.db
└── src/
    └── main/
        ├── java/
        │   └── com/
        │       └── example/
        │           └── practice/
        │               ├── PracticeApplication.java
        │               ├── controller/
        │               │   └── ProfileController.java
        │               ├── dto/
        │               │   ├── ProfileCreateRequest.java
        │               │   ├── ProfileResponse.java
        │               │   └── ProfileUpdateRequest.java
        │               ├── entity/
        │               │   └── Profile.java
        │               ├── exception/
        │               │   ├── GlobalExceptionHandler.java
        │               │   └── ResourceNotFoundException.java
        │               ├── repository/
        │               │   └── ProfileRepository.java
        │               └── service/
        │                   ├── ProfileService.java
        │                   └── impl/
        │                       └── ProfileServiceImpl.java
        └── resources/
            └── application.properties
```

## Configuration

Located in `src/main/resources/application.properties`:

```properties
spring.application.name=practice
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:file:./data/testdb
spring.datasource.driver-class-name=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
```

## API Endpoints

| Method | Endpoint | Description | Status Code |
|--------|----------|-------------|-------------|
| POST | `/api/profiles` | Create a new profile | 201 Created |
| GET | `/api/profiles/{id}` | Get profile by ID | 200 OK |
| PUT | `/api/profiles/{id}` | Update profile (full) | 200 OK |
| DELETE | `/api/profiles/{id}` | Delete profile | 204 No Content |
| GET | `/api/profiles` | Get all profiles | 200 OK |

## Data Models

### ProfileCreateRequest
```json
{
    "name": "John Doe",
    "email": "john@example.com",
    "age": 30,
    "bio": "Software developer"
}
```

### ProfileUpdateRequest
```json
{
    "name": "John Updated",
    "email": "john.updated@example.com",
    "age": 31,
    "bio": "Senior developer"
}
```

### ProfileResponse
```json
{
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "age": 30,
    "bio": "Software developer"
}
```

## Postman Request Examples

### 1. Create a New Profile

**Request:**
```
POST http://localhost:8080/api/profiles
Content-Type: application/json

{
    "name": "John Doe",
    "email": "john@example.com",
    "age": 30,
    "bio": "Software developer"
}
```

**Response (201 Created):**
```json
{
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "age": 30,
    "bio": "Software developer"
}
```

### 2. Get Profile by ID

**Request:**
```
GET http://localhost:8080/api/profiles/1
```

**Response (200 OK):**
```json
{
    "id": 1,
    "name": "John Doe",
    "email": "john@example.com",
    "age": 30,
    "bio": "Software developer"
}
```

### 3. Update Profile

**Request:**
```
PUT http://localhost:8080/api/profiles/1
Content-Type: application/json

{
    "name": "John Updated",
    "email": "john.updated@example.com",
    "age": 31,
    "bio": "Senior developer"
}
```

**Response (200 OK):**
```json
{
    "id": 1,
    "name": "John Updated",
    "email": "john.updated@example.com",
    "age": 31,
    "bio": "Senior developer"
}
```

### 4. Get All Profiles

**Request:**
```
GET http://localhost:8080/api/profiles
```

**Response (200 OK):**
```json
[
    {
        "id": 1,
        "name": "John Doe",
        "email": "john@example.com",
        "age": 30,
        "bio": "Software developer"
    }
]
```

### 5. Delete Profile

**Request:**
```
DELETE http://localhost:8080/api/profiles/1
```

**Response:** 204 No Content

## Running the Application

```bash
# Using Maven wrapper
cd profile_managementAPi
./mvnw spring-boot:run

# Or using Maven
cd profile_managementAPi
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## H2 Console

Access the database console at: `http://localhost:8080/h2-console`

- **JDBC URL:** `jdbc:h2:file:./data/testdb`
- **Username:** `sa`
- **Password:** (empty)

## Features

1. **CRUD Operations** - Complete Create, Read, Update, Delete functionality
2. **Input Validation** - Using Jakarta Validation annotations
3. **Global Exception Handling** - Consistent error responses
4. **Custom Exceptions** - ResourceNotFoundException for missing resources
5. **RESTful Design** - Proper HTTP status codes and REST conventions

## Exception Handling

The application includes a global exception handler that returns consistent error responses:

```json
{
    "timestamp": "2024-01-15T10:30:00",
    "status": 404,
    "error": "Not Found",
    "message": "Profile not found with id: 1"
}
```

