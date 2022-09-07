FROM maven:3.8.6-openjdk-11 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:11
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar

ARG EUREKA_SERVER=localhost
ARG MYSQL_SERVER=localhost
ENTRYPOINT  java -jar -Dspring.profiles.active=production app.jar