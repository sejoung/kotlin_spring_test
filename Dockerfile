FROM adoptopenjdk:11.0.11_9-jre-hotspot
COPY ./build/libs/kotlin_spring_test-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT exec java -jar app.jar
