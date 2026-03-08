# Base Project

A Spring Boot starter project serving as a foundational template for new Spring Boot applications.

## Overview

This is an empty/basic Spring Boot 3.5.0 project with core dependencies set up. It serves as a starting point for building Spring Boot applications.

## Technologies

- **Framework:** Spring Boot 3.5.0
- **Java Version:** 21
- **Database:** H2 (In-memory)
- **Build Tool:** Maven

## Dependencies

- `spring-boot-starter-web` - For building RESTful web applications
- `spring-boot-starter-data-jpa` - For database access with JPA/Hibernate
- `spring-boot-starter-validation` - For input validation
- `h2` - In-memory H2 database
- `spring-boot-devtools` - Development tools for auto-restart

## Project Structure

```
base/
├── pom.xml
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── example/
│       │           └── practice/
│       │               └── PracticeApplication.java
│       └── resources/
│           └── application.properties
```

## Configuration

The application is configured in `src/main/resources/application.properties`:

```properties
spring.application.name=practice
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
spring.datasource.url=jdbc:h2:mem:testdb
spring.jpa.hibernate.ddl-auto=update
```

## Running the Application

```bash
# Using Maven wrapper
cd base
./mvnw spring-boot:run

# Or using Maven
cd base
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## H2 Console

Access the H2 database console at: `http://localhost:8080/h2-console`

- **JDBC URL:** `jdbc:h2:mem:testdb`
- **Username:** `sa`
- **Password:** (empty)

## Next Steps

This is a starter project. You can add:
- REST controllers
- Entity classes
- Service classes
- Repository interfaces
- Security configuration
- And more features as needed

