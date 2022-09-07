FROM maven:3.8.6-openjdk-11 as build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests
FROM openjdk:11
WORKDIR /app
COPY --from=build ./app/target/*.jar ./app.jar
EXPOSE 8761
ENTRYPOINT  java -jar -Dspring.profiles.active=production app.jar