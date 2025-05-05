# Build stage
FROM ghcr.io/graalvm/native-image-community:21.0.2-ol8-20240116 AS build
WORKDIR /app
RUN microdnf install -y findutils unzip
COPY . .
RUN ./gradlew nativeCompile

# Run stage
FROM debian:bookworm-slim
WORKDIR /app
COPY --from=build /app/build/native/nativeCompile/learn-micronaut .
EXPOSE 8080
ENTRYPOINT ["/app/learn-micronaut"]
