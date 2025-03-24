# Inventory System BackEnd

This project is the backend part of an Inventory System built using Spring Boot.

## Features

- **Spring Boot**: Utilizes the Spring Boot framework for building the backend services.
- **Java**: The entire backend is developed in Java.
- **REST API**: Provides a RESTful API for managing inventory operations.

## Getting Started

### Prerequisites

Make sure you have the following installed:

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html) (version 11 or higher)
- [Maven](https://maven.apache.org/)

### Installation

1. Clone the repository:

```sh
git clone https://github.com/SandhanuDulmeth/Inventory_System_BackEnd-SpringBoot.git
cd Inventory_System_BackEnd-SpringBoot
```

2. Build the project:

```sh
mvn clean install
```

### Running the Application

To run the application, use the following command:

```sh
mvn spring-boot:run
```

The application will start and you can access it at `http://localhost:8080`.

### API Endpoints

Here is a list of available API endpoints:

- `GET /api/inventory` - Get all inventory items
- `GET /api/inventory/{id}` - Get an inventory item by ID
- `POST /api/inventory` - Create a new inventory item
- `PUT /api/inventory/{id}` - Update an existing inventory item
- `DELETE /api/inventory/{id}` - Delete an inventory item

## Contributing

Contributions are welcome! Please fork this repository and submit pull requests for any features, bug fixes, or enhancements.

## License

This project is licensed under the MIT License.

## Acknowledgements

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Maven](https://maven.apache.org/)
- [Java](https://www.oracle.com/java/)


Contact
For any queries or support, please contact Sandhanu Dulmeth at [www.linkedin.com/in/sandhanu-mendis].

