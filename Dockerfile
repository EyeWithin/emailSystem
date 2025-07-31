FROM eclipse-temurin:17-jdk-alpine
VOLUME /tmp
COPY target/emailSystem-0.0.1-SNAPSHOT.jar emailSystem.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/emailSystem.jar"]