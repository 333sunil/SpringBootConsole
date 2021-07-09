FROM openjdk:8
RUN mkdir /app
WORKDIR /app
COPY ./build/libs/SpringBootConsole*.jar /app/SpringBootConsole*.jar
