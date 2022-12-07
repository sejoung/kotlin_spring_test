# kotlin_spring_test

```shell

./gradlew clean build
docker build -t spring-test:0.1 ./
docker tag spring-test:0.1 sejoung/spring-test:0.1
docker push sejoung/spring-test:0.1
docker rmi batch:0.2 sejoung/spring-test:0.1

```
