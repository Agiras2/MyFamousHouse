# Real Estate Web Application

## Descripción

Este proyecto es una aplicación web para una inmobiliaria que permite a los usuarios gestionar propiedades, realizar transacciones y ver información sobre inmuebles. Está desarrollado utilizando Java con servlets, JSPs y MariaDB para la base de datos. La aplicación incluye funcionalidades de autenticación, matriculación de propiedades, búsqueda de propiedades y manejo de transacciones.

## Estructura del Proyecto

- Incluida en el archivo "Proyecto Final.docx"


## Requisitos

- Java 8 o superior
- Apache Tomcat 7
- MariaDB
- Maven
- DBeaver (opcional, para manejo de base de datos)

## Configuración del Proyecto

1. Clonar el repositorio:

   ```bash
   git clone https://github.com/Agiras2/MyFamousHouse.git


2. Importar el proyecto en tu IDE favorito (Eclipse, IntelliJ IDEA, etc.)

3. Configurar la base de datos en MariaDB:

 - Archivo inlcuido en el repositorio


4. Configurar el archivo src/main/java/model/util/DatabaseUtil.java con los detalles de conexión a la base de datos:

   - private static final String URL = "jdbc:mariadb://localhost:3307/inmobiliaria";
   - private static final String USER = "root";
   - private static final String PASSWORD = "root";

5. Compilar y desplegar el proyecto en Tomcat:

   mvn clean install
   
   Desplegar el archivo WAR generado en la carpeta target en tu servidor Tomcat.


6. Acceder a la aplicación web en tu navegador:

   http://localhost:9090/realstate


Uso
La aplicación proporciona las siguientes funcionalidades:

- Autenticación: Login para usuarios registrados.
- Gestión de Propiedades: Añadir, actualizar y eliminar propiedades.
- Búsqueda de Propiedades: Buscar propiedades disponibles.
- Transacciones: Comprar propiedades y registrar transacciones.


Enlace al diagrama de clases:
https://drive.google.com/file/d/1FVqyf1BeMJ92P1smNodHiyPsnyZziAHM/view?usp=drive_link
