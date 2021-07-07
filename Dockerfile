FROM openjdk:11-jre-slim
ARG JAR_FILE=./target/*.jar
COPY ${JAR_FILE} webapp.jar
CMD ["java", "-jar","${DB_HOST}","${DB_PORT}","${DB_NAME}","${DB_USER}","${DB_PASSWORD}","webapp.jar"]