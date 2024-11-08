# Docker 镜像构建
#FROM maven:3.5-jdk-8-alpine as builder
FROM openjdk:8-jre-alpine

# Copy local code to the container image.
WORKDIR /app
COPY user-backend-0.0.1-SNAPSHOT.jar ./

# Build a release artifact.
#RUN mvn package -DskipTests

# Run the web service on container startup.
CMD ["java","-jar","/app/user-backend-0.0.1-SNAPSHOT.jar"]
