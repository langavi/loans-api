# Loans API

Provides an interface to apply for loans via a REST API

## Built with

* 	[Spring Boot](https://spring.io/projects/spring-boot) - Framework to ease the bootstrapping and development of new Spring Applications
* 	[JDK](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html) - Java™ Platform
* 	[Lombok](https://projectlombok.org/) - Never write another getter or equals method again, with one annotation your class has a fully featured builder, Automate your logging variables, and much more.
* 	[Gradle](https://gradle.org/) - An open-source build automation tool

## Getting started

* Make sure Java Development Kit (JDK) 8 or higher is installed on your local machine.
```bash
java -version
```

## Testing

* [JUnit](https://junit.org/) - For Developer-side (unit) Testing


## Running the application locally

*   Start application: There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `za.co.momentum.investments.instructionsevent.Application` class from your IDE. Alternatively you can use the [Spring Boot Gradle plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins.html#build-tool-plugins-gradle-plugin) as follows:
```shell
./gradlew clean build
./gradlew bootRun
```
* Open Swagger UI on a browser: http://localhost:8080/swagger-ui.html
