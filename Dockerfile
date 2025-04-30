# Etapa 1: Build con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build

WORKDIR /app

# Copiamos el código fuente
COPY . .

# Compilamos el proyecto (sin correr tests)
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final con solo el JAR
FROM amazoncorretto:17-alpine-jdk

WORKDIR /app

# Copiamos el .jar generado desde la etapa de build
COPY --from=build /app/target/*.jar app.jar

# Comando de arranque
ENTRYPOINT ["java", "-jar", "app.jar"]
