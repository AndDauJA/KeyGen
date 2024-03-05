
@echo off
cd D:\JAVA\KEY_Generator

call mvn -N io.takari:maven:wrapper

call docker compose up -d

call mvnw spring-boot:run -Dspring.profiles.active=mysql
