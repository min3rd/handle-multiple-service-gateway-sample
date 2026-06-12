FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY common common
COPY bct-adapter bct-adapter
RUN mvn clean package -pl bct-adapter -am -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/bct-adapter/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
