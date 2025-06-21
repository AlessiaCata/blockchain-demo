# Blockchain Demo

Este proyecto simula contratos de compraventa usando una lógica inspirada en blockchain, desarrollado con Spring Boot.

## 🚀 Funcionalidades

- Crear contratos entre comprador y vendedor
- Simular pagos
- Confirmar entregas
- Iniciar disputas
- Ver todos los contratos registrados

## 🛠️ Tecnologías

- Java 17
- Spring Boot 3
- Maven
- Postman (colección incluida)
- GitHub

## 📦 Estructura del Proyecto

com.ucc.demo
├── controller
├── service
├── model
├── DTO
├── exception
└── DemoApplication.java


## 📬 Pruebas con Postman

Se incluye una colección de Postman lista para importar:

- Archivo: `blockchain-demo.postman_collection.json`
- Pasos:
    1. Abrí Postman
    2. Hacé clic en “Import”
    3. Seleccioná el archivo
    4. Probá los endpoints fácilmente

## 🧪 Principales Endpoints

| Método | URL                                | Función               |
|--------|-------------------------------------|------------------------|
| POST   | `/contratos`                        | Crear contrato         |
| PUT    | `/contratos/{id}/pagar`            | Simular pago           |
| PUT    | `/contratos/{id}/confirmar`        | Confirmar entrega      |
| PUT    | `/contratos/{id}/disputa`          | Iniciar disputa        |
| GET    | `/contratos`                        | Obtener todos los contratos |

## 💡 Consideraciones

- Solo se puede confirmar una entrega si el contrato **está en estado PENDIENTE**.
- No se puede confirmar una entrega si ya fue **PAGADO**, eso desencadena una advertencia.
- El sistema es una simulación educativa de contratos tipo blockchain.
