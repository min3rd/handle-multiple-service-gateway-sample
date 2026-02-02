FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY common common
COPY nsw-gateway nsw-gateway
RUN mvn clean package -pl nsw-gateway -am -DskipTests

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/nsw-gateway/target/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
