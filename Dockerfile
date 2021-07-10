FROM openjdk:8-jre-slim
RUN mkdir /app
COPY ./build/libs/SpringBootConsole*.jar /app/SpringBootConsole.jar
COPY ./springbootconsole.sh /usr/bin/springbootconsole.sh

