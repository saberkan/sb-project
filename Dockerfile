FROM openjdk:8-jdk-alpine3.7 

COPY target/gs-rest-service-0.1.0.jar  app.jar
ADD external-libs .

EXPOSE 8080
EXPOSE 8089
ENTRYPOINT ["java","-javaagent:external-libs/jmx_prometheus_javaagent-0.12.0.jar=8089:external-libs/jmx_prometheus_javaagent-default.yaml","-jar","/app.jar"]
