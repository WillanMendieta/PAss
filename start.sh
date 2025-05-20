#!/bin/bash

CONFIG_FILE=${1:-src/main/resources/application.properties}

echo "Usando archivo de configuración: $CONFIG_FILE"
./mvnw clean package -DskipTests

java -Dquarkus.config.location=$CONFIG_FILE -jar target/quarkus-app/quarkus-run.jar
