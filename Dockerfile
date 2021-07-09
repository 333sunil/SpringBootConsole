FROM openjdk:8-jre-slim
RUN mkdir /app
WORKDIR /app
COPY ./build/libs/SpringBootConsole*.jar /app/SpringBootConsole.jar
