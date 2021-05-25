FROM openjdk:11.0.4-jre-slim-buster
MAINTAINER Julio Isaac <julioisaac7@gmail.com>

    ARG APP=target/search-1.0.0-SNAPSHOT.jar

    # environment variable with default value
    ENV SPRING_PROFILE=dev

    COPY ${JAR_FILE} /opt/lib/search.jar

    EXPOSE 80
