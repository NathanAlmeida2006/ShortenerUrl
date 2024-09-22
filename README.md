# Shortener URL Project

## Overview

The **Shortener URL** project is a simple URL shortening service built using **Spring Boot**, **Java 21**, and **PostgreSQL**. It allows users to shorten long URLs, generate a shortened URL, and provide redirection to the original URL when accessed via the shortened link. Additionally, it generates a QR code URL for each shortened link (currently set as a placeholder).

## Features

- **URL Shortening**: Takes a long URL as input and generates a shortened version.
- **Redirection**: Redirects users from the shortened URL to the original URL.
- **QR Code URL**: Generates a placeholder QR code URL alongside the shortened URL.
- **RESTful API**: Exposes two main endpoints to shorten URLs and handle redirection.

## Technologies Used

- **Spring Boot 3.3.4**: The main framework for building the backend services.
- **PostgreSQL**: Database used to store the original and shortened URLs.
- **Lombok**: Used for reducing boilerplate code.
- **Apache Commons Lang 3**: Provides utilities, including the generation of random strings for URL shortening.

## Endpoints

### 1. Shorten URL
- **Method**: `POST /shortenURL`
- **Request Body**:
  ```json
  {
    "originalUrl": "https://example.com"
  }
  ```
- **Response**: Returns the shortened URL and metadata.
  ```json
  {
    "id": 1,
    "originalUrl": "https://example.com",
    "shortenedUrl": "http://localhost:8080/r/abc123",
    "qrCodeUrl": "QR unavailable!",
    "createdAt": "2024-09-22T12:34:56"
  }
  ```

### 2. Redirect to Original URL
- **Method**: `GET /r/{shortenedUrl}`
- **Description**: Redirects the user from the shortened URL to the original URL.
- **Response**: Performs an HTTP 302 redirection or returns a 404 error if the shortened URL is not found.

## How to Run

### Prerequisites

- **Java 21**: Ensure you have Java 21 installed.
- **PostgreSQL**: A PostgreSQL instance running locally.
- **Maven**: Used for dependency management and building the project.

### Setup

1. Clone the repository.
   ```bash
   git clone https://github.com/NathanAlmeida2006/shortener-url.git
   cd shortener-url
   ```

2. Configure the PostgreSQL database by editing the following properties in `application.properties`:
   ```
   spring.datasource.url=jdbc:postgresql://localhost:5432/shortener_url
   spring.datasource.username=your-username
   spring.datasource.password=your-password
   ```

3. Run the application using Maven.
   ```bash
   mvn spring-boot:run
   ```

### Database Configuration

Ensure that you have a running PostgreSQL database instance. The application will automatically create the necessary tables upon startup based on the `Link` entity class.

## Project Structure

- **Controller**: `LinkController.java` handles API requests for shortening URLs and redirection.
- **Service**: `LinkService.java` contains the business logic for generating and retrieving URLs.
- **Model**: `Link.java` represents the data structure for storing URLs in the database.
- **Repository**: `LinkRepository.java` is a JPA repository interface for database operations.
- **DTO**: `LinkResponse.java` is a Data Transfer Object for returning response data.

## Dependencies

- **Spring Boot Starter Data JPA**: For handling database operations.
- **Spring Boot Starter Web**: For building the REST API.
- **PostgreSQL**: Database connectivity.
- **Lombok**: For reducing boilerplate code.
- **Apache Commons Lang 3**: For utility methods like random string generation.

## Contact

If you have any questions or suggestions, feel free to open an issue in the GitHub repository or send an email to: [nathanfelipi2006@gmail.com].

---

Developed with ❤️ by [Nathan Felipi Almeida].

---

