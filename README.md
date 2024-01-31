# Shopping Sale backend is a Java spring boot maven application

## Run:
### Can be started by running SaleTaxesBeApplication in an ide
### From the root folder:
    mvnw spring-boot:run

## Dependencies:
### It starts its own postgreSQL container

## Tests:
### Can be started by running Maven test lifecycle phase
### From the root folder:
    mvnw test

## Database:
### It creates and drops data from:
    src/main/resources/import.sql

## Test Database
### It's an H2 in memory database and does no use import.sql data

## Generate interfaces:
### Interfaces gui:
    http://localhost:8080/swagger-ui/index.html
### Interfaces json:
    http://localhost:8080/v3/api-docs

