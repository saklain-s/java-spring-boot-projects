# Spring Projects for Beginners

A collection of Spring Boot projects designed for learning and practice, ranging from basic concepts to advanced features like JWT authentication and role-based access control.

## 📁 Projects Overview

This repository contains multiple Spring Boot projects, each demonstrating different concepts and features:

| Project | Description | Difficulty |
|---------|-------------|------------|
| [base](./base/README.md) | Empty starter template | ⭐ Beginner |
| [JWTauthRBAC](./JWTauthRBAC/README.md) | JWT Authentication with RBAC | ⭐⭐⭐ Advanced |
| [profile_managementAPi](./profile_managementAPi/README.md) | Profile CRUD API | ⭐⭐ Intermediate |
| [User_Role_Management](./User_Role_Management/README.md) | User & Role Management | ⭐⭐⭐ Advanced |
| [Todo](./Todo/README.md) | Simple Todo API | ⭐ Beginner |
| [profile_creation](./profile_creation/README.md) | Profile Creation API | ⭐ Beginner |
| [notes_projects](./notes_projects/README.md) | Full-Stack Notes App | ⭐⭐ Intermediate |

## 🚀 Quick Start

### Prerequisites

- Java 21 or higher
- Maven
- Node.js (for notes_projects frontend)

### Running Any Project

```bash
# Navigate to the project directory
cd <project-name>

# Run with Maven wrapper
./mvnw spring-boot:run

# Or with Maven
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## 📋 Project Details

### 1. Base Project (`base/`)
- **Purpose:** Starter template for new Spring Boot projects
- **Features:** Basic configuration with H2 database
- **Tech Stack:** Spring Boot, H2, JPA

### 2. JWT Authentication with RBAC (`JWTauthRBAC/`)
- **Purpose:** Learn JWT authentication and role-based access control
- **Features:**
  - User registration
  - JWT login
  - Role-based authorization (ADMIN, USER)
  - Token refresh
- **Endpoints:**
  - `POST /api/auth/login` - Login
  - `POST /api/public/register` - Register
  - `GET /api/admin/dashboard` - Admin only

### 3. Profile Management API (`profile_managementAPi/`)
- **Purpose:** Learn RESTful CRUD operations
- **Features:**
  - Create, Read, Update, Delete profiles
  - Input validation
  - Global exception handling
- **Endpoints:**
  - `POST /api/profiles` - Create profile
  - `GET /api/profiles/{id}` - Get profile
  - `PUT /api/profiles/{id}` - Update profile
  - `DELETE /api/profiles/{id}` - Delete profile
  - `GET /api/profiles` - List all profiles

### 4. User Role Management (`User_Role_Management/`)
- **Purpose:** Complete user management system
- **Features:**
  - User registration & login
  - JWT authentication
  - Role management (ADMIN, USER)
  - Spring Security integration
- **Endpoints:**
  - `POST /api/auth/login` - Login
  - `POST /api/public/register` - Register
  - `GET /api/admin/dashboard` - Admin only

### 5. Todo Application (`Todo/`)
- **Purpose:** Simple task management API
- **Features:**
  - Add todos
  - Mark complete
  - Delete todos
  - List all todos
- **Endpoints:**
  - `GET /api/todos` - Get all
  - `POST /api/todos` - Create
  - `PUT /api/todos/{id}/complete` - Mark complete
  - `DELETE /api/todos/{id}` - Delete

### 6. Profile Creation (`profile_creation/`)
- **Purpose:** Profile management with PATCH support
- **Features:**
  - Create profiles
  - Full profile list
  - Partial updates (PATCH)
  - Delete profiles
- **Endpoints:**
  - `POST /profiles` - Create
  - `GET /profiles` - List all
  - `PATCH /profiles/{id}` - Partial update
  - `DELETE /profiles/{id}` - Delete

### 7. Notes Application (`notes_projects/`)
- **Purpose:** Full-stack application
- **Components:**
  - **Backend:** Spring Boot REST API (`notes-server/`)
  - **Frontend:** React application (`notes-client/`)
- **Features:**
  - Create notes
  - View notes
  - Delete notes
  - CORS configuration

## 🛠️ Common Technologies

- **Framework:** Spring Boot 3.5.0
- **Java Version:** 21
- **Database:** H2 (In-memory)
- **Build Tool:** Maven
- **Security:** Spring Security + JWT

## 📖 Learning Path

For beginners, recommended order:

1. **Start with `base/`** - Understand basic Spring Boot setup
2. **Move to `Todo/`** - Learn simple REST APIs
3. **Continue with `profile_creation/`** - Practice CRUD operations
4. **Proceed to `profile_managementAPi/`** - Add validation & exceptions
5. **Study `User_Role_Management/`** - Learn Spring Security
6. **Master `JWTauthRBAC/`** - Advanced JWT & RBAC
7. **Build `notes_projects/`** - Full-stack development

## 🔧 Configuration

Most projects use H2 in-memory database. Default settings:

- **URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** (empty)
- **Console:** `http://localhost:8080/h2-console`

## 📝 Adding More Projects

This repository is designed to grow. To add a new project:

1. Create a new directory in the root
2. Add a `pom.xml` with Spring Boot dependencies
3. Create the standard Maven directory structure
4. Add a comprehensive `README.md` explaining the project

## 🤝 Contributing

Feel free to fork this repository and add your own projects!

## 📄 License

This is a learning repository. Use it as you like!

---

**Note:** These projects are for educational purposes and learning. They may not follow all production best practices.

