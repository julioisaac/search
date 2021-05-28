FROM maven:3.8.1-jdk-11 AS builder

WORKDIR /build
COPY . /build

RUN mvn clean package

ADD https://github.com/julioisaac/archives/raw/main/movies.zip .
RUN unzip movies.zip -d .

ENV ORIGIN_DATA_PATH=/build/data
ENV SEARCH_INDEX_PATH=/build/index

RUN mkdir $SEARCH_INDEX_PATH

RUN java -jar /build/target/search-indexer.jar

FROM openjdk:11.0.4-jre-slim-buster

WORKDIR /app
COPY --from=builder /build/target/*.jar /app/
COPY --from=builder /build/index /app/index

ENV SEARCH_INDEX_PATH=/app/index

ENTRYPOINT ["java", "-jar", "/app/search-application.jar"]





