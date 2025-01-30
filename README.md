# SkyPayTestBankKata
Technical Test: Bank Kata

This project is a simple banking application built using Spring Boot and H2 database.
It allows users to perform basic banking operations such as depositing money, withdrawing money, and viewing their transaction history.

Technologies Used

    Spring Boot: For building the application and handling RESTful APIs.

    H2 Database: An in-memory database used for storing transaction data.

    Spring Data JPA: For managing database operations.

    Lombok: For reducing boilerplate code with annotations like @Data, @ToString, etc.

    Maven: For dependency management and building the project.

Project Structure
src/main/java
├── com.example.banking
│   ├── controller
│   │   └── AccountController.java
│   ├── model
│   │   └── Transaction.java
│   ├── repository
│   │   └── TransactionRepository.java
│   ├── service
│   │   ├── AccountService.java
│   │   └── AccountServiceImpl.java
│   └── BankingApplication.java
src/main/resources
├── application.properties


API Endpoints

    Deposit Money:

        POST /account/deposit?amount={amount}

        Example:
        curl -X POST "http://localhost:8080/account/deposit?amount=100"

    Withdraw Money:

        POST /account/withdraw?amount={amount}

        Example:
        curl -X POST "http://localhost:8080/account/withdraw?amount=50"

    View Statement:

        GET /account/statement

        Example:
         curl -X GET "http://localhost:8080/account/statement"

H2 Database Console

    The H2 database console is enabled for easy access to the database during development.

    Access it at http://localhost:8080/h2-console.

    Use the following credentials:

        JDBC URL: jdbc:h2:mem:bankdb

        Username: sa

        Password: pass

Example Usage

    Deposit $100:
    curl -X POST "http://localhost:8080/account/deposit?amount=100"

    Withdraw $50:
    curl -X POST "http://localhost:8080/account/withdraw?amount=50"

    View Statement:
    curl -X GET "http://localhost:8080/account/s