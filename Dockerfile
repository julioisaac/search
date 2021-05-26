FROM openjdk:11.0.4-jre-slim-buster
MAINTAINER Julio Isaac <julioisaac7@gmail.com>

    ARG APP=target/search-1.0.0-SNAPSHOT.jar

    COPY ${JAR_FILE} /opt/lib/search.jar

    EXPOSE 80
