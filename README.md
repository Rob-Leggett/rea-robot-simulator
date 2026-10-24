rea-robot-simulator
===================

[![build](https://github.com/Rob-Leggett/rea-robot-simulator/actions/workflows/build.yml/badge.svg)](https://github.com/Rob-Leggett/rea-robot-simulator/actions/workflows/build.yml)

***Requirements***

- Java 25 (the Gradle toolchain will provision/locate a JDK 25)
- No local Gradle install needed — use the included Gradle 9.8.2 wrapper (`./gradlew`)

***How To Run***

1. Build the executable jar with `./gradlew clean fatJar` (also produced by `./gradlew build`)
2. Run `java -jar build/libs/rea-robot-simulator-all-1.0.jar src/main/resources/command/command.txt`

Alternatively run straight from Gradle: `./gradlew run --args="$PWD/src/main/resources/command/command.txt"`

***How To Test***

1. Unit Test Only - `./gradlew clean test`
2. Integration Test Only - `./gradlew clean integrationTest`
3. Both Unit and Integration Tests - `./gradlew clean check` (`./gradlew build` runs both as well)

Tests use JUnit 6 (Jupiter) and Mockito 5.

***Documentation***

1. This document refer to how to run and test the application
2. To refer to the problem statement, please refer to PROBLEM.MD
3. To refer to the solution documentation, please refer to SOLUTION.MD
