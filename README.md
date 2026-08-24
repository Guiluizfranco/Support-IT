# Support-IT
Backend project developed in Java for internal user support using REST API architecture,  JPA and Hibernate technologies.

The system allows users to ask internal support through HTTP requests using sender and receiver identifiers.

## Freatures
User registration
Internal support call sending
REST API communication
Business rule validation
JPA and Hibernate
Separation of responsibilities
Object-oriented design

## Technologies Used
Java
Spring Boot
Maven
REST API
HTTP Protocol
SQL
Object-Oriented Programming (OOP)
JPA
Hibernate
Exception Handling

## Project Structuresrc/
│
├── entity/
│   ├── User
│   └── Call
│
├── controller/
│   ├── UserController
│   └── CallController
│
├── repository/
│   ├── UserRepository
│   └── CallRepository
│
├── dto/
│   ├── UserDTO
│   └── CallDTO
│
├── service/
│   ├── UserService
│   └── CallService
│
└── Support_IT (Main)

## Main Entities
### User
Represents system users responsible for sending and receiving calls support.

### Calls
Represents internal calls supports exchanged between users

## API Concepts
The project follows REST API principles using HTTP requests for communication between client and server.

## Learning Objectives
This project was created to practice and improve skills in:
-Backend development with Java
-REST API architecture
-HTTP communication
-Software organization
-Clean code concepts
-Business logic implementation
-JPA and Hibernate
-Object-oriented programming

## Author
Guilherme Luiz Franco
