# Shopping Sale backend is a Java Spring boot maven application

## Dependencies:
### It starts its own postgreSQL container needs to run first from root:
    docker compose up

## Run:
### Can be started by running SaleTaxesBeApplication in an ide
### From the root folder:
    mvnw spring-boot:run

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
### Interfaces are automatically generated when the app is started.
### You can communicate with the app trough Interfaces gui.
### getBasket request gets ids: 1, 2, 3. It gives error for other responses.
### Interfaces gui:
    http://localhost:8080/swagger-ui/index.html
### Interfaces json:
    http://localhost:8080/v3/api-docs

## Run form the jar file:
### There is an attached jar file which can be executed in any system:
### where JAVA is installed and PATH is set up.
### Run sale_taxes_be.jar from the root by command:
    java -jar sale_taxes_be.jar
