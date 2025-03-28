# Inventory System Backend

This project is the backend component of a comprehensive Inventory Management System built using Spring Boot. It provides a robust API for tracking, managing, and analyzing inventory items across warehouses or retail locations.

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.x-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-MIT-blue.svg)](LICENSE)

## Features

- **RESTful API**: Comprehensive API for inventory management operations
- **Spring Boot**: Built on the Spring Boot framework for robust backend services
- **Spring Security**: Secure authentication and authorization
- **Spring Data JPA**: Simplified data access layer with JPA/Hibernate
- **Database Integration**: Supports multiple database systems (MySQL, PostgreSQL)
- **Validation**: Request validation using Bean Validation API
- **Exception Handling**: Global exception handling with meaningful error responses
- **Logging**: Comprehensive logging using SLF4J and Logback
- **Swagger/OpenAPI**: API documentation with Swagger/OpenAPI
- **Unit & Integration Testing**: Comprehensive test coverage

## System Requirements

### Prerequisites

Make sure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version 17 or higher)
- [Maven](https://maven.apache.org/) (version 3.8 or higher)
- [MySQL](https://www.mysql.com/) or [PostgreSQL](https://www.postgresql.org/) (for database)

### Installation

1. Clone the repository:

```sh
git clone https://github.com/SandhanuDulmeth/Inventory_System_BackEnd-SpringBoot.git
cd Inventory_System_BackEnd-SpringBoot
```

2. Configure the database connection in `src/main/resources/application.properties` or `application.yml`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/inventory_db
spring.datasource.username=your_username
spring.datasource.password=your_password
```

3. Build the project:

```sh
mvn clean install
```

## Running the Application

### Development Mode

To run the application in development mode:

```sh
mvn spring-boot:run
```

The application will start and you can access it at `http://localhost:8080`.

### Production Mode

For production deployment, build a JAR file:

```sh
mvn clean package
java -jar target/inventory-system-backend.jar
```

## API Documentation

API documentation is available via Swagger UI at `http://localhost:8080/swagger-ui.html` when the application is running.

### Core API Endpoints

#### Inventory Items

- `GET /api/inventory` - Get all inventory items (supports pagination and filtering)
- `GET /api/inventory/{id}` - Get an inventory item by ID
- `POST /api/inventory` - Create a new inventory item
- `PUT /api/inventory/{id}` - Update an existing inventory item
- `DELETE /api/inventory/{id}` - Delete an inventory item

#### Categories

- `GET /api/categories` - Get all categories
- `GET /api/categories/{id}` - Get a category by ID
- `POST /api/categories` - Create a new category
- `PUT /api/categories/{id}` - Update an existing category
- `DELETE /api/categories/{id}` - Delete a category

#### Suppliers

- `GET /api/suppliers` - Get all suppliers
- `GET /api/suppliers/{id}` - Get a supplier by ID
- `POST /api/suppliers` - Create a new supplier
- `PUT /api/suppliers/{id}` - Update an existing supplier
- `DELETE /api/suppliers/{id}` - Delete a supplier

## Project Structure

```
src
├── main
│   ├── java
│   │   └── edu.sandhanu.ecom
│   │       ├── config        # Configuration classes
│   │       ├── controller    # REST controllers
│   │       ├── dto           # Data Transfer Objects
│   │       ├── exception     # Custom exceptions and handlers
│   │       ├── model         # Entity classes
│   │       ├── repository    # Data repositories
│   │       ├── service       # Business logic
│   │       └── util          # Utility classes
│   └── resources
│       ├── application.yml   # Application configuration
│       ├── data.sql          # Initial data script (optional)
│       └── logback.xml       # Logging configuration
└── test                      # Test classes
```

## Security

The API is secured using Spring Security with JWT authentication. To access protected endpoints:

1. Obtain a JWT token by authenticating at `/api/auth/login`
2. Include the token in the Authorization header: `Authorization: Bearer {token}`

## Testing

Run tests with:

```sh
mvn test                 # Run unit tests
mvn verify               # Run integration tests
```

## Troubleshooting

Common issues and solutions:

- **Database connection issues**: Verify database credentials and ensure the database server is running
- **Port conflicts**: If port 8080 is in use, configure a different port in `application.properties`:
  ```properties
  server.port=8081
  ```

## Contributing

Contributions are welcome! Please follow these steps:

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/your-feature-name`
3. Commit your changes: `git commit -m 'Add some feature'`
4. Push to the branch: `git push origin feature/your-feature-name`
5. Submit a pull request

## License

This project is licensed under the MIT License.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Maven](https://maven.apache.org/)
- [Swagger/OpenAPI](https://swagger.io/)

## Contact

For any queries or support, please contact Sandhanu Dulmeth:
- LinkedIn: [www.linkedin.com/in/sandhanu-mendis](https://www.linkedin.com/in/sandhanu-mendis)
- GitHub: [SandhanuDulmeth](https://github.com/SandhanuDulmeth)

