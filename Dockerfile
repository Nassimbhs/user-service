FROM openjdk:11-jre-slim
WORKDIR /app
EXPOSE 8092
COPY target/user-1.0.jar user-service.jar
ENTRYPOINT ["java", "-jar", "/user-service.jar"]