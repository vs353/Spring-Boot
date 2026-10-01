# Spring Boot Backend Practice

A hands-on Spring Boot backend project created to strengthen my understanding of REST APIs, CRUD operations, validation, exception handling, and backend application development.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- REST APIs
- Jakarta Bean Validation
- Maven
- Postman
- Git & GitHub

## Features Implemented

- Create an employee
- Get all employees
- Get employee by ID
- Update employee details
- Delete employee
- Input validation using `@Valid`
- Custom exception handling
- Global exception handling using `@RestControllerAdvice`
- Appropriate HTTP status codes using `ResponseEntity`

## REST API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| POST | `/employees` | Create a new employee |
| GET | `/employees` | Get all employees |
| GET | `/employees/{id}` | Get employee by ID |
| PUT | `/employees/{id}` | Update an employee |
| DELETE | `/employees/{id}` | Delete an employee |

## Validation

Employee input is validated using Jakarta Bean Validation annotations.

Exception Handling & Validation Flow

POST /employees
↓
@RequestBody converts JSON → Employee object
↓
@Valid checks Employee
↓
@NotBlank / @Positive fails
↓
Spring throws MethodArgumentNotValidException
↓
@ExceptionHandler catches it
↓
getBindingResult()
↓
getFieldErrors()
↓
extract messages
↓
400 BAD REQUEST + error messages


Examples:

- `@NotBlank` - Employee name must not be null or empty
- `@Positive` - Salary must be greater than zero
- `@Valid` - Triggers validation for the request body

### Validation Flow

POST `/employees`

↓  
`@RequestBody` converts JSON into an Employee object

↓  
`@Valid` triggers validation

↓  
Validation annotations such as `@NotBlank` and `@Positive` are checked

↓  
If validation fails, Spring throws `MethodArgumentNotValidException`

↓  
`@RestControllerAdvice` / `@ExceptionHandler` handles the exception

↓  
API returns `400 Bad Request` with validation error messages

## Exception Handling

A custom `EmployeeNotFoundException` is used when an employee ID does not exist.

The application uses a global exception handler to convert exceptions into appropriate HTTP responses.

Example:

`EmployeeNotFoundException` → `404 NOT FOUND`

`MethodArgumentNotValidException` → `400 BAD REQUEST`

## Current Status

This project is being developed as part of my Java and Spring Boot backend learning and interview preparation.

More concepts will be added progressively, including:

- Spring Data JPA
- Database integration
- Hibernate
- MySQL/PostgreSQL
- DTOs
- Service and Repository layers
- Spring Security
- Unit testing