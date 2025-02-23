#
#
# **** Dockerfile to create spring boot image ****
#
#
### Use official base image of Java Runtime (JDK version that you use)
FROM openjdk:17
LABEL authors="ttknp"

### (Set folder on container) specific space to persist some data in your container.
# VOLUME /tmp
### OR you can use basic config
# you can use WORKDIR /app
WORKDIR /app


ARG JAR_FILE=target/basic-api.jar

## Add the application's JAR file to the container
##** copies new files, directories or remote file URLs from the source and adds them to the filesystem of the image at the provided path.
##** In this case we add the Spring Boot application to the Docker image from the source path (the JAR_FILE variable) to a destination named application.jar.
ADD ${JAR_FILE} /app/application.jar

# for running spring boot in container
# Like you run application on your current path
# java -jar target/basic-api-in-docker-container.jar

## Make port 8080 available to the world outside container
EXPOSE 8080


ENTRYPOINT ["java","-jar","/app/application.jar"]



