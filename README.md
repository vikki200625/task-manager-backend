# Task Manager Web Application - Backend (Spring Boot)

This repository contains the backend REST API for the full-stack Task Manager application.

## 🎯 Objectives Achieved
*   Full CRUD operations implemented (`GET`, `POST`, `PUT`, `DELETE`).
*   REST API endpoints built and tested via Postman.
*   Data persistence achieved using Hibernate and MySQL.
*   CORS configuration enabled for integration with the React frontend (running on localhost:3000).

## 🛠️ Setup and Running Locally

### Prerequisites
1.  Java 17+ (JDK)
2.  Apache Maven
3.  MySQL Server (running on port 3306)

### 1. Database Setup
1.  Ensure your MySQL server is running.
2.  Create the database: `CREATE DATABASE taskdb;`
3.  Execute the script located in `tasks.sql` to create the necessary `tasks` table.

### 2. Configuration
1.  Open the file `src/main/resources/application.properties`.
2.  Update the database credentials with your local settings:

    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
    spring.datasource.username=root
    spring.datasource.password=YOUR_MYSQL_PASSWORD_HERE
    ```

### 3. Running the Server
1.  Build the project using Maven: `mvn clean install`
2.  Run the application from your IDE (IntelliJ) or via the generated JAR file:
    ```bash
    java -jar target/task-manager-0.0.1-SNAPSHOT.jar
    ```
The API will be available at `http://localhost:8080/api/tasks`.
