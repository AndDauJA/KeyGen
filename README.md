# Key-Gererator And Database MySQL
WEB for Spring MVC learning

### Prerequisites
This project used Bootstrap 4.3.1 and Spring Boot 3.2.1.
Spring Security version 6.2 included.

### Requirements
* Language JDK 17
* Check if JAVA_HOME used JDK 17
* Docker desctop (for this project)

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

### Windows Batch Skriptas
```
@echo off
cd D:\JAVA\KEY_Generator
call mvn -N io.takari:maven:wrapper
call docker compose up -d
call mvnw spring-boot:run -Dspring.profiles.active=mysql
```

### Unix/Linux/MacOS Shell Skriptas
```
#!/bin/bash
cd /path/to/your/project
./mvnw spring-boot:run -Dspring.profiles.active=mysql
```
## Access the application
```
http://localhost:8080
```