# Notes Application

A Spring Boot REST API for managing notes with Create, Read, Update, and Delete operations.

## Overview

This project provides a RESTful API for managing notes. It allows users to create notes, retrieve all notes, update existing notes, and delete notes.

## Technologies

- **Framework:** Spring Boot 3.5.0
- **Java Version:** 21
- **Database:** H2 (In-memory)
- **Build Tool:** Maven

## Dependencies

- `spring-boot-starter-web` - REST API support
- `spring-boot-starter-data-jpa` - Database access
- `spring-boot-starter-validation` - Input validation
- `h2` - H2 database
- `spring-boot-devtools` - Development tools

## Project Structure

```
Notes/
└── practice/
    ├── pom.xml
    └── src/
        └── main/
            ├── java/
            │   └── com/
            │       └── example/
            │           └── practice/
            │               ├── PracticeApplication.java
            │               ├── config/
            │               │   └── AppConfig.java
            │               ├── controller/
            │               │   └── NoteController.java
            │               ├── dto/
            │               │   ├── NoteCreateRequest.java
            │               │   ├── NoteResponse.java
            │               │   └── NoteUpdateRequest.java
            │               ├── model/
            │               │   └── Note.java
            │               ├── repository/
            │               │   └── NoteRepository.java
            │               └── service/
            │                   └── NoteService.java
            └── resources/
                └── application.properties
```

## Configuration

Located in `practice/src/main/resources/application.properties`:

```properties
spring.application.name=practice
```

Uses default H2 in-memory database configuration.

## API Endpoints

| Method | Endpoint | Description |
|--------|----------|-------------|
| GET | `/api/notes` | Get all notes |
| POST | `/api/notes` | Create a new note |
| PUT | `/api/notes/{id}` | Update a note |
| DELETE | `/api/notes/{id}` | Delete a note |

## Data Models

### NoteCreateRequest
```json
{
    "title": "My Note",
    "content": "Note content goes here"
}
```

### NoteUpdateRequest
```json
{
    "title": "Updated Title",
    "content": "Updated content"
}
```

### NoteResponse
```json
{
    "id": "1",
    "title": "My Note",
    "content": "Note content goes here"
}
```

## Postman Request Examples

### 1. Get All Notes

**Request:**
```
GET http://localhost:8080/api/notes
```

**Response:**
```json
[
    {
        "id": "1",
        "title": "My First Note",
        "content": "This is my first note"
    }
]
```

### 2. Create a New Note

**Request:**
```
POST http://localhost:8080/api/notes
Content-Type: application/json

{
    "title": "New Note",
    "content": "This is a new note"
}
```

**Response:**
```json
{
    "id": "1",
    "title": "New Note",
    "content": "This is a new note"
}
```

### 3. Update a Note

**Request:**
```
PUT http://localhost:8080/api/notes/1
Content-Type: application/json

{
    "title": "Updated Note Title",
    "content": "Updated note content"
}
```

**Response:**
```json
{
    "id": "1",
    "title": "Updated Note Title",
    "content": "Updated note content"
}
```

### 4. Delete a Note

**Request:**
```
DELETE http://localhost:8080/api/notes/1
```

**Response:** No content (204)

## Running the Application

```bash
# Using Maven wrapper
cd Notes/practice
./mvnw spring-boot:run

# Or using Maven
cd Notes/practice
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## Features

1. **Get All Notes** - Retrieve list of all notes
2. **Create Note** - Add new notes with title and content
3. **Update Note** - Modify existing notes (full update)
4. **Delete Note** - Remove notes by ID
5. **Input Validation** - Jakarta Validation support
6. **DTO Pattern** - Request/Response separation using Data Transfer Objects

## Code Highlights

### Note Entity
```java
@Entity
public class Note {
    @Id
    private String id;
    private String title;
    private String content;
    // getters, setters, constructors
}
```

### Note Controller
```java
@RestController
@RequestMapping("/api/notes")
public class NoteController {
    @GetMapping
    public List<Note> getNotes() { ... }
    
    @PostMapping
    public NoteResponse add(@RequestBody NoteCreateRequest request) { ... }
    
    @PutMapping("/{id}")
    public NoteResponse update(@PathVariable String id, @RequestBody NoteUpdateRequest request) { ... }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) { ... }
}
```

