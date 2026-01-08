FROM gradle:8.14.1-jdk21 AS build

WORKDIR /app
COPY . .

WORKDIR /app/bff-agendador-tarefas
RUN gradle build --no-daemon

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar /app/bff-agendador-tarefas.jar
EXPOSE 8080
CMD ["java", "-jar", "/app/bff-agendador-tarefas.jar"]