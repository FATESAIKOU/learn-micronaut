FROM eclipse-temurin:21-jre
WORKDIR /app
COPY build/libs/learn-micronaut-0.1-all.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
