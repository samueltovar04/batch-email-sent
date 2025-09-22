FROM ghcr.io/graalvm/graalvm-community:22-ol9 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn package -Pnative -DskipTests -Dquarkus.native.container-build=true

# Use a compatible UBI 9 image for the final stage
FROM registry.access.redhat.com/ubi9/ubi-minimal:9.3

WORKDIR /work/

COPY --from=build /app/target/*-runner /work/application

RUN chmod 775 /work/application

EXPOSE 8080

CMD ["./application", "-Dquarkus.http.host=0.0.0.0"]