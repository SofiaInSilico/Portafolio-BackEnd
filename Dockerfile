FROM amazoncorretto:11-alpine-jdk
MAINTAINER sofia
COPY target/backend-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]
EXPOSE 8080
