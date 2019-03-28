FROM openjdk:8-jre-alpine

ADD target/*.jar app.jar

RUN sh -c 'touch /app.jar'

ENTRYPOINT java $JAVA_OPTS -jar $SPRING_PROFILE app.jar $SPRING_PROPERTIES