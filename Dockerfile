FROM openjdk:11-jre

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} Mediscreen_practionner_notes-0.0.1-SNAPSHOT.jar

EXPOSE 8082

CMD ["java", "-jar", "/Mediscreen_practionner_notes-0.0.1-SNAPSHOT.jar"]