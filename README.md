# Capriccio Productos - API REST

API REST desarrollada con Spring Boot para la gestión de productos y clientes del sistema Capriccio.

## 📋 Descripción

Este proyecto es un backend para un sistema de gestión de productos que incluye:
- Gestión de productos y categorías
- Gestión de clientes
- Sistema de ventas con detalle de ventas
- Autenticación y autorización con JWT (JSON Web Tokens)
- Seguridad con Spring Security

## 🛠️ Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.4.1**
- **Spring Security** - Seguridad y autenticación
- **Spring Data JPA** - Persistencia de datos
- **MySQL** - Base de datos relacional
- **JWT (jjwt 0.11.5)** - Autenticación basada en tokens
- **Lombok** - Reducción de código boilerplate
- **Maven** - Gestión de dependencias

## 📁 Estructura del Proyecto

```
src/main/java/com/capriccio/CapriccioProductos/
├── CapriccioProductosApplication.java    # Clase principal
├── controller/                           # Controladores REST
│   ├── ClienteController.java            # Endpoints de registro y perfil de usuario
│   └── ProductoController.java           # Endpoints de productos
├── dto/                                  # Data Transfer Objects
│   ├── ClienteDTO.java
│   └── ProductoDTO.java
├── model/                                # Entidades JPA
│   ├── Categoria.java
│   ├── Cliente.java
│   ├── DetalleVenta.java
│   ├── Producto.java
│   └── Venta.java
├── repository/                           # Repositorios JPA
│   ├── ClienteRepository.java
│   └── ProductoRepository.java
├── security/                             # Configuración de seguridad
│   ├── SecurityConfig.java
│   ├── filters/
│   │   ├── JwtAuthenticationFilter.java
│   │   └── JwtAuthorizationFilter.java
│   └── jwt/
│       └── JwtUtils.java
└── service/                              # Capa de servicios
    ├── ClienteService.java
    └── ProductoService.java
```

## 🗃️ Modelo de Datos

### Entidades

| Entidad | Descripción |
|---------|-------------|
| **Cliente** | Usuarios del sistema con datos personales y credenciales |
| **Producto** | Productos con precio, cantidad, nombre, imagen y descripción |
| **Categoria** | Clasificación de productos |
| **Venta** | Registro de ventas asociadas a clientes |
| **DetalleVenta** | Detalle de productos en cada venta |

## 🚀 Instalación y Configuración

### Prerrequisitos

- Java 17 o superior
- MySQL 8.0 o superior
- Maven 3.6 o superior

### Configuración de Base de Datos

1. Crear la base de datos en MySQL:
```sql
CREATE DATABASE db_capriccio;
```

2. Configurar las credenciales en `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/db_capriccio?useSSL=false&serverTimeZone=UTC&autoReconnect=true
spring.datasource.username=root
spring.datasource.password=tu_password
```

### Ejecución

1. Clonar el repositorio:
```bash
git clone <url-del-repositorio>
cd spring-boot-api-capriccio
```

2. Compilar el proyecto:
```bash
./mvnw clean install
```

3. Ejecutar la aplicación:
```bash
./mvnw spring-boot:run
```

La API estará disponible en `http://localhost:8080`

## 📡 Endpoints de la API

### Autenticación

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| POST | `/login` | Iniciar sesión y obtener token JWT | No |
| POST | `/auth/createUser` | Registrar nuevo usuario | No |
| GET | `/auth/perfil` | Obtener perfil del usuario autenticado | Sí |

### Productos

| Método | Endpoint | Descripción | Autenticación |
|--------|----------|-------------|---------------|
| GET | `/producto` | Listar todos los productos | No |

## 🔐 Autenticación JWT

La API utiliza JSON Web Tokens (JWT) para la autenticación. Para acceder a endpoints protegidos:

1. Realizar login en `/login` con username y password
2. Obtener el token JWT de la respuesta
3. Incluir el token en el header de las peticiones:
```
Authorization: Bearer <tu_token_jwt>
```

## 🌐 CORS

La API está configurada para aceptar peticiones desde `http://localhost:4200` (Angular frontend).

## 🧪 Tests

Ejecutar los tests:
```bash
./mvnw test
```

## 📄 Licencia

Este proyecto está bajo desarrollo.

## 👥 Contribuidores

- Frank18ci
