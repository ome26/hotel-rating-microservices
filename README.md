# Hotel Rating Microservices

A Spring Boot-based microservices application that manages users, hotels, and ratings through three independent services. The services communicate with each other to retrieve and combine related information.

## Project Overview

The project follows a microservices architecture, where each service handles a specific business responsibility.

### Microservices

| Service | Responsibility |
|---|---|
| User Service | Manages user information and retrieves associated rating details. |
| Hotel Service | Manages hotel information. |
| Rating Service | Manages user ratings and retrieves corresponding hotel details. |

## Architecture

The application consists of three independent microservices:

```text
             User Service
                  |
                  | 
                  v
             Rating Service
                  |
                  |
                  v
             Hotel Service
```

### Service Communication

- **User Service → Rating Service:** Retrieves ratings associated with a particular user.
- **Rating Service → Hotel Service:** Retrieves hotel details associated with a rating.

This communication allows the application to combine information from multiple services.

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- REST APIs
- Maven
- MySQL
- Git & GitHub

## Project Structure

```text
Hotel-Rating/
│
├── user-service/
│   ├── src/
│   ├── pom.xml
│   └── mvnw
│
├── hotel-service/
│   ├── src/
│   ├── pom.xml
│   └── mvnw
│
├── rating-service/
│   ├── src/
│   ├── pom.xml
│   └── mvnw
│
├── .gitignore
└── README.md
```

## Features

### User Service
- Create and manage user information.
- Retrieve user details.
- Retrieve ratings associated with a user through inter-service communication.

### Hotel Service
- Create and manage hotel information.
- Retrieve hotel details.

### Rating Service
- Create and manage ratings.
- Retrieve ratings.
- Communicate with Hotel Service to fetch hotel details.

## Database Configuration

Each microservice maintains its own database configuration through its `application.properties` file.

For database security, the database password is configured using an environment variable:

```properties
spring.datasource.password=${DB_PASSWORD}
```

Set the environment variable before running the services.

**Windows PowerShell:**

```powershell
$env:DB_PASSWORD="your_database_password"
```

Replace `your_database_password` with your actual database password.

## Running the Project

Make sure Java, Maven, and MySQL are installed and configured.

### 1. Clone the Repository

```bash
git clone https://github.com/ome26/hotel-rating-microservices.git
```

### 2. Navigate to the Project

```bash
cd hotel-rating-microservices
```

### 3. Configure the Database

Configure the database connection details in the `application.properties` file of each microservice.

Set the `DB_PASSWORD` environment variable before starting the applications.

### 4. Run the Microservices

Open separate terminals for each service.

**User Service**

```bash
cd user-service
.\mvnw.cmd spring-boot:run
```

**Hotel Service**

```bash
cd hotel-service
.\mvnw.cmd spring-boot:run
```

**Rating Service**

```bash
cd rating-service
.\mvnw.cmd spring-boot:run
```

Make sure the configured service ports are available and that the database is running.

## GitHub Repository

[Hotel Rating Microservices](https://github.com/ome26/hotel-rating-microservices)

## Author

Developed as a learning project to understand Spring Boot, REST APIs, database integration, and microservices communication.
