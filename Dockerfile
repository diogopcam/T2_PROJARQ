FROM eclipse-temurin:22-jre-alpine

COPY target/demo-0.0.1-SNAPSHOT.jar /app.jar

EXPOSE 8000

ENTRYPOINT ["java", "-jar", "/app.jar"]