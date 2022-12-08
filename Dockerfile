FROM eclipse-temurin:11-jre-focal
RUN apt-get update
RUN apt-get install -y net-tools
RUN apt-get install -y htop
COPY ./build/libs/kotlin_spring_test-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT exec java -jar app.jar
