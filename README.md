# Key-Gererator And Database MySQL
WEB for Spring MVC learning

### Prerequisites
This project used Bootstrap 4.3.1 and Spring Boot 3.2.1.
Spring Security version 6.2 included.

### Requirements
* Language JDK 17
* Check if JAVA_HOME used JDK 17

### Environment Variables
add path of you JDK bin

## Create maven connection
### for Windows OS
```
mvn -N io.takari:maven:wrapper 
```
## Run DB with Docker
### Run mysql
```
docker compose up -d 
```
## Run application using spring-boot
### on MySQL DB
```
 ./mvnw spring-boot:run -Dspring.profiles.active=mysql 
```
## Access the application
http://localhost:8080