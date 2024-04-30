FROM eclipse-temurin:17-jdk-alpine AS build

WORKDIR /app

COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY gradlew .
COPY gradle ./gradle

COPY src ./src

RUN chmod +x gradlew

RUN ./gradlew build

FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 80

CMD ["java", "-jar", "app.jar"]
