#
#
# **** Dockerfile to create spring boot image **** # **** (Dynmic env) Passing Environment Variables Into a Dockerfile *****
#
#
### Use official base image of Java Runtime (JDK version that you use)
FROM openjdk:17
LABEL authors="ttknp"

### (Set folder on container) specific space to persist some data in your container.
# VOLUME /tmp
### OR you can use basic config # you can use WORKDIR /app
WORKDIR /app

# how to build .jar on project spring boot (Generate a .jar file)
# First way you just use command "mvn install" or "mvn clean package"
# I'll pass on my build cmd as --build-arg <Key>=<Value>
ARG JAR_FILE

## Add the application's JAR file to the container
##** copies new files, directories or remote file URLs from the source and adds them to the filesystem of the image at the provided path.
##** In this case we add the Spring Boot application to the Docker image from the source path (the JAR_FILE variable) ** to a destination named application.jar.
ADD $JAR_FILE /app/application.jar


## Make port 8080 available to the world outside container
EXPOSE 8080

# for running spring boot in container
# Like you run application on your current path
# java -jar target/basic-api-in-docker-container.jar
# this conflict why i have to use ip4 ???
ENTRYPOINT ["java","-jar","/app/application.jar", "--spring.datasource.url=jdbc:mysql://192.168.1.103:3307/to_do_apps_docker","--spring.datasource.username=ttknp","--spring.datasource.password=12345"]


# When you run java to some plan ** Use only jar file will be cool !
# Step to run
# ** -t <tag name : version> and -f <path to Dockerfile_v.1>
# **  --build-arg <Key>=<Value>
# 1. docker build -t springboot:latest --build-arg JAR_FILE=target/basic-api.jar . -f dockerfiles\app\Dockerfile
# ** -p 8080:80 maps port 8080 on the host machine to port 80 inside the container.
# ** -d run on background , --name=<container name> , -p <port remote to container>:<port app on container>
# ** these are run image and run mysql ? for sure! ** for the fist time
# 2. docker run --name springboot_app -p 8000:8080 -d springboot:latest
# way to access container
# 3. docker exec -it <container id> sh
# ** you can do same cmd as you work on linux
# ** java -version , ls -l , mkdir <folder name> , ...
# 3.1 exit ** for leaving container



