# CRUD App with Java Spring Boot, JPA, and MySQL

This is a simple CRUD (Create, Read, Update, Delete) application implemented using **Java Spring Boot**, **JPA**, and **MySQL** to demonstrate database interaction with `Person` entity management. The application interacts with the database through **phpMyAdmin** and showcases basic CRUD operations using repository patterns.

---

## Table of Contents
- [Project Overview](#project-overview)  
- [Technologies Used](#technologies-used)  
- [Setup Instructions](#setup-instructions)  
- [Features](#features)  
- [Database Configuration](#database-configuration)  
- [Endpoints & Functionalities](#endpoints--functionalities)  

---

## Project Overview
This project is a simple demonstration of how to use **Java Spring Boot** with **JPA repositories** for database interaction. The application allows basic CRUD operations for a `Person` entity with properties for first and last names.

The app uses **phpMyAdmin** for database management and implements database operations such as saving, deleting, reading (single and all records), and updating data.

---

## Technologies Used
- **Java Spring Boot**  
- **Java Persistence API (JPA)**  
- **MySQL Database** (via phpMyAdmin)  
- **Maven** (build tool)  
- **phpMyAdmin** (database management UI)  

---

## Setup Instructions

To set up and run this application locally:

### 1. Prerequisites
Make sure the following are installed on your local machine:
- Java Development Kit (JDK) 8 or higher
- MySQL database server
- phpMyAdmin (optional, for database UI management)
- Maven (for dependency management)

---

### 2. Clone the Repository
```bash
git clone <repository-url>
cd <repository-folder>
```

### 3. Configure MySQL Database
Open phpMyAdmin or a MySQL client.
Create a database (e.g., `crud_app_db`).
sql
```bash
CREATE DATABASE crud_app_db;
```
Configure database credentials in application.properties.


### 4. Update Database Configuration
Update `src/main/resources/application.properties` with your database credentials:
```bash
spring.datasource.url=jdbc:mysql://localhost:3306/crud_app_db
spring.datasource.username=<your-db-username>
spring.datasource.password=<your-db-password>
spring.jpa.hibernate.naming.physical-strategy=org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL5Dialect
```

### 5. Build & Run the Application
Build the application using Maven
```bash
mvn clean install
```
Start the application:
```bash
mvn spring-boot:run
```

### 6. Interact with the Application
Once the application runs, it will automatically execute some initial CRUD operations in the database through `CommandLineRunner`. Observe the logs for:

- Insert operation.
- Fetch data by ID.
- Fetch all data.
- Update operations.
You can manually interact with your database through phpMyAdmin for data inspection.

---

### Features
- Create: Insert a new Person record into the database.
- Read: Fetch individual records by ID or list all records.
- Update: Modify an existing record's first name and last name.
- Delete: Remove a specific record (though only implemented in the method without exposing a direct endpoint)

---
    
### Database Configuration
The app uses JPA with the MySQL database configured through application.properties. The database schema consists of a single `Person` entity.

Example of Table Schema
```bash
CREATE TABLE person (
    id INT AUTO_INCREMENT PRIMARY KEY,
    fname VARCHAR(50) NOT NULL,
    lname VARCHAR(50) NOT NULL
);
```
---

### Database Management with Spring Data JPA
The table `person` is managed by **Spring Data JPA** automatically upon application startup (assuming the database is correctly configured).

---

## Endpoints & Functionalities
The application runs CRUD commands using `CommandLineRunner`. While not exposed as HTTP endpoints in this version, you can extend this application by exposing REST endpoints using `@RestController` annotations for these operations.

---

### Core Logic
The following methods define the core logic of database operations:

- **`saveData()`**  
  Inserts a new `Person` object into the database.

- **`getData()`**  
  Retrieves a single `Person` record by ID.

- **`getAllData()`**  
  Retrieves all records from the database.

- **`updateData()`**  
  Updates an existing record's first name and last name.

- **`deleteData()`**  
  Deletes a record by ID.
