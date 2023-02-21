FROM openjdk:11-jre

ARG JAR_FILE=target/Mediscreen_practionner_notes-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} practionnernotes.jar

EXPOSE 8082

CMD ["java", "-jar", "/practionnernotes.jar"]