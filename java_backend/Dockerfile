FROM eclipse-temurin:21-jdk as build

WORKDIR /app

COPY . .

# Add this line BEFORE you run mvnw
RUN chmod +x mvnw

RUN ./mvnw clean package -DskipTests

FROM eclipse-temurin:21-jre

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
