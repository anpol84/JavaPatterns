FROM openjdk:1.8
FROM maven:3.8.1-openjdk-8

WORKDIR /app

COPY . .

RUN mvn clean package

EXPOSE 9090

CMD ["java", "-jar", "/app/target/practice15-0.0.1-SNAPSHOT.jar"]