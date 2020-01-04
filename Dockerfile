FROM openjdk:8-jdk-alpine3.7 

COPY sb-project/target/gs-rest-service-0.1.0.jar  app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
