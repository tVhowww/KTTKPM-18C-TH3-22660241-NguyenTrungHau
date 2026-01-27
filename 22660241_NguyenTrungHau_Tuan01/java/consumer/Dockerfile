# Giai đoạn 1: Build file .jar bằng Maven
FROM maven:3.9.12-eclipse-temurin-21-alpine AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Giai đoạn 2: Chạy ứng dụng bằng Java nhẹ (JRE)
FROM eclipse-temurin:21-jre-ubi9-minimal
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]