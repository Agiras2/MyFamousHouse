# Real Estate Web Application

## Descripción

Este proyecto es una aplicación web para una inmobiliaria que permite a los usuarios gestionar propiedades, realizar transacciones y ver información sobre inmuebles. Está desarrollado utilizando Java con servlets, JSPs y MariaDB para la base de datos. La aplicación incluye funcionalidades de autenticación, matriculación de propiedades, búsqueda de propiedades y manejo de transacciones.

## Estructura del Proyecto

realstate
│
├── src
│ ├── main
│ │ ├── java
│ │ │ ├── control
│ │ │ │ ├── controller
│ │ │ │ │ ├── BankAccountsController.java
│ │ │ │ │ ├── CustomersController.java
│ │ │ │ │ ├── PropertyController.java
│ │ │ │ │ ├── TransactionsController.java
│ │ │ │ │ ├── WebAccountController.java
│ │ │ │ ├── dao
│ │ │ │ │ ├── BankAccountsDao.java
│ │ │ │ │ ├── CustomersDao.java
│ │ │ │ │ ├── PropertyDao.java
│ │ │ │ │ ├── TransactionsDao.java
│ │ │ │ │ ├── WebAccountDao.java
│ │ │ │ ├── Servlet
│ │ │ │ │ ├── AboutPropertyServlet.java
│ │ │ │ │ ├── DeletePropertyServlet.java
│ │ │ │ │ ├── HomeServlet.java
│ │ │ │ │ ├── ListingServlet.java
│ │ │ │ │ ├── LoginServlet.java
│ │ │ │ │ ├── LogoutServlet.java
│ │ │ │ │ ├── MainPageFilter.java
│ │ │ │ │ ├── MyPropertiesServlet.java
│ │ │ │ │ ├── PayPropertyServlet.java
│ │ │ │ │ ├── PostPropertyServlet.java
│ │ │ │ │ ├── PreparePayPropertyServlet.java
│ │ │ │ │ ├── SearchServlet.java
│ │ │ │ │ ├── SessionFilter.java
│ │ │ │ │ ├── UpdatePropertyServlet.java
│ │ │ │ │ ├── ViewPropertyServlet.java
│ │ │ ├── model
│ │ │ │ ├── entity
│ │ │ │ │ ├── BankAccounts.java
│ │ │ │ │ ├── Customers.java
│ │ │ │ │ ├── Property.java
│ │ │ │ │ ├── Transactions.java
│ │ │ │ │ ├── WebAccount.java
│ │ │ │ ├── util
│ │ │ │ │ ├── DatabaseUtil.java
│ │ ├── webapp
│ │ │ ├── resources
│ │ │ │ ├── css
│ │ │ │ │ ├── style.css
│ │ │ │ │ ├── stylebank.css
│ │ │ │ ├── images
│ │ │ │ ├── js
│ │ │ │ │ ├── script.js
│ │ │ │ ├── about.jsp
│ │ │ │ ├── aboutlog.jsp
│ │ │ │ ├── bank.jsp
│ │ │ │ ├── contact.jsp
│ │ │ │ ├── contactlog.jsp
│ │ │ │ ├── error_page.jsp
│ │ │ │ ├── home.jsp
│ │ │ │ ├── listings.jsp
│ │ │ │ ├── login.jsp
│ │ │ │ ├── my_properties.jsp
│ │ │ │ ├── post_property.jsp
│ │ │ │ ├── search.jsp
│ │ │ │ ├── UpdateProperty.jsp
│ │ │ │ ├── view_property.jsp
│ │ │ ├── WEB-INF
│ │ │ │ ├── web.xml
│ │ │ ├── index.jsp
│ ├── test
│ │ ├── BankAccountsControllerTest.java
│ │ ├── CustomersControllerTest.java
│ │ ├── PropertyControllerTest.java
│ │ ├── TransactionsControllerTest.java
│ │ ├── WebAccountControllerTest.java
├── target
├── pom.xml


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

Archivo inlcuido en el repositorio


4. Configurar el archivo src/main/java/model/util/DatabaseUtil.java con los detalles de conexión a la base de datos:

private static final String URL = "jdbc:mariadb://localhost:3307/inmobiliaria";
private static final String USER = "root";
private static final String PASSWORD = "root";

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
