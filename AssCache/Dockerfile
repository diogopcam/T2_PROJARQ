FROM eclipse-temurin:22-jre-alpine

COPY target/assCache-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "/app.jar"]