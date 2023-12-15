FROM eclipse-temurin:17-jdk-alpine

LABEL authors="sacha"

VOLUME /spring-app

COPY ./target/*.jar app.jar

ENTRYPOINT ["sh", "-c", "java -jar /app.jar ${0} ${@}"]