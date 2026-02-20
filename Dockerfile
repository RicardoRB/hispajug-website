# Fase 1: Construir
FROM maven:3.9-eclipse-temurin-25-alpine AS build

WORKDIR /app

# Copia pom.xml y descarga sus dependencias
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia código fuente
COPY src ./src

# Construir aplicación
RUN mvn clean package -DskipTests

# Fase 2: Ejecutar
FROM eclipse-temurin:25-jre-alpine

WORKDIR /app

# Copia el JAR de la fase de creación
COPY --from=build /app/target/hispajug-website-*.jar app.jar

# Crea un usuario sin permisos root
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

# Expone el puerto
EXPOSE 8080

# Arranca la app
ENTRYPOINT ["java", "-jar", "app.jar"]
