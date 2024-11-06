# Spring Boot Microservices example with OpenFeign and PostgreSQL

This project demonstrates a simple implementation of two Spring Boot microservices using OpenFeign
for inter-service communication and PostgreSQL as the database.

The two services are:

1. **User Service**: Manages user information.
2. **Order Service**: Manages order information and fetches user details from the User Service.

## Prerequisites

- Java 11 or later
- Maven 3.6.3 or later
- PostgreSQL database
- Docker (optional, for containerization)
- PostgreSQL

# Getting Started ### Setting up

1. Install PostgreSQL or use `docker-compose`  to startup if you haven't already.
2. Create two databases: `users` and `orders`.
3. Create a user and grant necessary privileges to these databases
