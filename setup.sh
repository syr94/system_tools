#!/bin/bash

# Set the JavaFX version
JAVAFX_VERSION="20.0.1"

# Download JavaFX SDK
wget https://gluonhq.com/download/javafx-$JAVAFX_VERSION-sdk-linux/

# Unzip the downloaded file
unzip javafx-$JAVAFX_VERSION-sdk-linux.zip

# Move the unzipped directory to the project's lib directory
mv javafx-sdk-$JAVAFX_VERSION lib/

# Add the lib directory to the system's PATH variable
export PATH=$PATH:$(pwd)/lib/javafx-sdk-$JAVAFX_VERSION/lib/

# Echo the updated PATH variable
echo $PATH
