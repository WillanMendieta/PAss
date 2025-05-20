# Proyecto Quarkus - bancoprueba

Este proyecto implementa servicios REST usando Quarkus, incluyendo integración con la PokéAPI y tareas programadas.

## 🧩 Servicios implementados

- `/api/v1/test`: POST para concatenación de strings (pendiente)
- `/api/v2/move`: GET para consultar movimientos desde PokéAPI (en proceso)
- Tarea periódica que llama a `/api/v2/move` cada 5 minutos (pendiente)

## 🚀 Requisitos

- Java 17+
- Maven 3.8+
- Acceso a internet para consumir PokéAPI

## ⚙️ Despliegue local

1. Empaquetar:
```bash
./mvnw clean package -DskipTests
