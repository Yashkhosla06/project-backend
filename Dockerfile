FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/demo-0.0.1-SNAPSHOT.jar /target/demo-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/target/demo-0.0.1-SNAPSHOT.jar"]

