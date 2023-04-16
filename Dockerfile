FROM amazoncorretto:11-alpine-jdk
MAINTAINER SofiaEgana
COPY target/backend-0.0.1-SNAPSHOT.jar kimchi.jar
ENTRYPOINT ["java","-jar","/kimchi.jar"]
