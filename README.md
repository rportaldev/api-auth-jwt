# \# API REST con JWT y Roles

# 

# Sistema backend seguro desarrollado con Spring Boot y JWT, que permite el registro e inicio de sesión de usuarios, protegiendo el acceso a los recursos mediante autorización basada en roles.

# 

# \## Descripción

# 

# Implementa autenticación mediante JSON Web Tokens (JWT) y autorización basada en roles (`ROLE\_ADMIN`, `ROLE\_USER`) para proteger los endpoints de la API, evitando el acceso no autorizado a la información.

# 

# \## Funcionalidades

# 

# \- Registro de usuarios con contraseña cifrada (BCrypt).

# \- Inicio de sesión con generación de token JWT.

# \- Autorización basada en roles (`ROLE\_ADMIN`, `ROLE\_USER`).

# \- Protección de endpoints mediante un filtro JWT personalizado.

# \- Consulta del perfil del usuario autenticado.

# \- Listado y eliminación de usuarios (solo `ROLE\_ADMIN`).

# \- Manejo centralizado de errores con respuestas JSON estructuradas.

# 

# \## Tecnologías

# 

# Java 17 · Spring Boot 3 · Spring Security · Spring Data JPA · PostgreSQL · JJWT · Lombok · Maven

# 

# \## Endpoints

# 

# \### Públicos

# 

# | Método | Endpoint          | Descripción                    |

# |--------|-------------------|----------------------------------|

# | POST   | `/auth/register`  | Registra un nuevo usuario        |

# | POST   | `/auth/login`     | Inicia sesión y genera un JWT    |

# 

# \### Protegidos (requieren token JWT)

# 

# | Método | Endpoint            | Rol requerido | Descripción                    |

# |--------|---------------------|---------------|----------------------------------|

# | GET    | `/usuarios/perfil`  | Cualquiera    | Perfil del usuario autenticado   |

# | GET    | `/usuarios`         | `ROLE\_ADMIN`  | Lista todos los usuarios         |

# | DELETE | `/usuarios/{id}`    | `ROLE\_ADMIN`  | Elimina un usuario por su ID     |

# 

# \*\*Códigos de error manejados:\*\* 400 (datos inválidos), 401 (sin token o credenciales incorrectas), 403 (sin permisos), 404 (no encontrado), 409 (correo duplicado).

# 

# \## Configuración

# 

# Edita `src/main/resources/application.properties`:

# 

# ```

# spring.datasource.url=jdbc:postgresql://localhost:5432/db\_auth

# spring.datasource.username=tu\_usuario

# spring.datasource.password=tu\_password

# 

# jwt.secret=tu\_clave\_secreta\_de\_al\_menos\_32\_caracteres

# jwt.expiration=86400000

# 

# server.port=8082

# ```

# 

# \## Cómo ejecutar el proyecto

# 

# 1\. Clona el repositorio:

# 

# &#x20;  git clone https://github.com/rportaldev/api-auth-jwt.git

# 

# 2\. Crea la base de datos en PostgreSQL:

# 

# &#x20;  CREATE DATABASE db\_auth;

# 

# 3\. Configura tus credenciales en `application.properties`.

# 4\. Ejecuta la aplicación desde Spring Tool Suite (clic derecho sobre el proyecto → Run As → Spring Boot App), o desde consola:

# 

# &#x20;  ./mvnw spring-boot:run

# 

# 5\. La API estará disponible en `http://localhost:8082`.

# 

# \## Pruebas

# 

# Probado exhaustivamente con Postman: registro y login exitoso, acceso con y sin token, autorización por rol (USER vs ADMIN), correo duplicado, credenciales incorrectas y validación de datos.

# 

# \## Autor

# 

# Ricardo — Estudiante de Desarrollo de Software

# Cibertec Perú — 4to ciclo

