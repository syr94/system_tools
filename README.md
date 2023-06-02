# JavaFX Application

TODO: explanation

## Prerequisites

- Java 17
- JavaFX 20
- Maven

## Setup

1. Ensure you have Java 17 installed on your machine. If not, you can download it from [here](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).

2. The JavaFX SDK is included in the project under the `lib/javafx-sdk-20.0.1/lib` directory.
3. Set the `PATH_TO_FX` environment variable to point to the `lib/javafx-sdk-20.0.1/lib` directory in the project root. If you are using Linux, you can do this by adding the following line to your `~/.bashrc` or `~/.zshrc` file:

   `export PATH_TO_FX=/path/to/your/project/lib/javafx-sdk-20.0.1/lib`

   Replace `/path/to/your/project` with the actual path to your project.
4. Run the command `source ~/.bashrc` or `source ~/.zshrc` in the terminal to load the new environment variable.

## Building the project

1. Navigate to the project root directory in the terminal
2. Run `mvn clean package` to build the project.

## Running the project

1. Navigate to the project root directory in the terminal.

2. Run `mvn exec:java -Dexec.mainClass=com.app.ApplicationMain` to start the application.

## Features

TODO

## Contributing

TODO
## License

TODO
## Contact

### Mail
1. syr94@mail.ru
   2. llancelot1994@gmail.com

### Telegramm
@callmy_name