# Use an official OpenJDK runtime as a parent image
FROM openjdk:8

COPY target/spring-boot-docker.jar /usr/app/

WORKDIR /usr/app

ENTRYPOINT ["java", "-jar","spring-boot-docker.jar"]