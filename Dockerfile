# Dockerfile
FROM openjdk:8-jre-alpine
ENV JAVA_OPTS="-XX:InitialRAMPercentage=40.0 -XX:MaxRAMPercentage=80.0"
EXPOSE 8080

WORKDIR /data
COPY ./target/*.jar /data/ROOT.jar

ENTRYPOINT exec java $JAVA_OPTS -jar ROOT.jar
