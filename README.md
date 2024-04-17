# HBV202GAssignment5

## Introduction

This is the final assignemnt in the course HBV202G Software Development at the University of Iceland. Einar Andri Víðisosn is the author of this project.
It is a memory game implemented in Javafx where the player gambles coinson each game.

## Running the Main Method

This project's POM file is configured to support the execution of a main method. You can run the main method by using the following command:

```bash
mvn exec:java
```

## Git

The project is hosted on GitHub and it was regularly pushed to the repository, it uses Github Actions to run the tests on each push. Gitignore is used to ignore .vscode folder.

## Maven

Project info was added to the POM file, the project was built with Maven and the POM file was configured to support the execution of a main method. There are no outdated versions. It supports the following goals:

- `mvn compile` - Compiles the project
- `mvn test` - Runs the tests
- `mvn site` - Generates a site for the project
- `mvn package` - Packages the project into a JAR file
- `mvn exec:java` - Executes the main method of the project

## Junit

Junit was used to test the all business logic classes (CoinService, Kubbur, Notandi, Notendur) in the project, the tests are located in the test folder. The tests are run with a Github Action on each push to the repository. You can also run the tests locally using the following commands:

```bash
mvn test
```

## UML design

See the [DESIGN.md](./src/site/markdown/design.md) file for details on the design of the program.

## Design Patterns

### Singleton

The Viewswitcher is a singleton class. It is used to switch between different views in the application and store data, should obviously only be one instance of it.

### Observer

BudController is an observer class. It observes the coins of the Notandi class and updates the view when the coins change.

### Factory

The class NotendurFactory is a factory class. It creates Notandi objects.

## Refactoring

I often refactored the code to make it more readable and maintainable.

## Packaging the Program

You can package the program by running the create_package.bat file.

This will create a package file in the `target` directory. You can run the program without IDE or Maven by running the run_app.bat file.

## Documentation

This Readme file includes everything you need to know about the project. This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.