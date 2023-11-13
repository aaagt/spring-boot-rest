FROM bellsoft/liberica-openjdk-alpine:17

EXPOSE "8080"

COPY build/libs/auth-app-1.0-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]
