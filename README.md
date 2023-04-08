# Password generator

## Purpose of the software
The Password Generator is a simple Java application that generates secure random passwords with the specified length and inclusion of special characters. The purpose of this software is to provide an easy-to-use tool for generating strong passwords that can be used to protect sensitive data and online accounts.

## Requirements
For building and running the application you need:
- OpenJDK 17
- Maven

## Running the application locally
Execute the `main` method in the `org.foodfool.Application` class from your IDE with application arguments <password_length> <allow_special_chars>, 
or execute `mvn clean install` to generate the jar file. After that you can start the jar file (located in target folder)
with `java -jar PasswordGenerator-1.0-SNAPSHOT-spring-boot.jar <password_length> <allow_special_chars>` to generate your password. Example: `java -jar PasswordGenerator-1.0-SNAPSHOT-spring-boot.jar 12 true`