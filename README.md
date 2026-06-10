# Library Management System

A Java web application for managing books, authors, categories, and library resources.

This project was built using Java Servlets, JSP, JDBC, and PostgreSQL/MySQL style database access. It provides basic library management functionality through a web interface.

## Features

* Book Management
* Author Management
* Category Management
* Book Update & Delete Operations
* Book Image Upload
* JDBC Database Integration
* JSP Based User Interface
* Servlet-Based Request Handling

## Tech Stack

* Java
* Java Servlet
* JSP
* JDBC
* Maven
* HTML
* CSS

## Project Structure

```text
src/main/java
├── attachments
├── authors
├── books
├── category
├── db
└── utils

src/main/webapp
├── WEB-INF
├── images
├── includes
├── *.jsp
└── styles.css
```

## Main Modules

### Books

* Add Book
* View Books
* Update Book
* Delete Book

### Authors

* Add Author
* View Authors
* Manage Author Information

### Categories

* Create Categories
* Organize Books by Category

### Attachments

* Upload Book Images
* Store and Display Attachments

## Database

The application uses JDBC for database communication.

Main entities:

* Books
* Authors
* Categories
* Attachments

## How to Run

### 1. Clone Repository

```bash
git clone https://github.com/your-username/library-management-system.git
cd library-management-system
```

### 2. Configure Database

Update database settings in:

```text
src/main/java/.../db/DbConnection.java
```

### 3. Build Project

```bash
mvn clean package
```

### 4. Deploy

Deploy the generated WAR file to:

* Apache Tomcat

### 5. Open Application

```text
http://localhost:8080/library-management-system
```

## Future Improvements

* Spring Boot Migration
* Spring Security Integration
* REST API Support
* JWT Authentication
* Role-Based Access Control
* Docker Deployment

## Author

**Bekzod**

Java Backend Developer

Technologies:

* Java
* Servlet
* JSP
* JDBC
* Maven
* SQL
