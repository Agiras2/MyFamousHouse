# Real Estate Web Application

## Descripción

Este proyecto es una aplicación web para una inmobiliaria que permite a los usuarios gestionar propiedades, realizar transacciones y ver información sobre inmuebles. Está desarrollado utilizando Java con servlets, JSPs y MariaDB para la base de datos. La aplicación incluye funcionalidades de autenticación, matriculación de propiedades, búsqueda de propiedades y manejo de transacciones.

## Estructura del Proyecto

realstate:
       src:
             main:
                      java:
                            control:
                                     controller:
                                                BankAccountsController.java
                                                CustomersController.java
                                                PropertyController.java
                                                TransactionsController.java
                                                WebAccountController.java
                                     dao:
                                                BankAccountsDao.java
                                                CustomersDao.java
                                                PropertyDao.java
                                                TransactionsDao.java
                                                WebAccountDao
                                     Servlet:
                                                AboutPropertyServlet.java
                                                DeletePropertyServlet.java
                                                HomeServlet.java
                                                ListingServlet.java
                                                LoginServlet.java
                                                LogoutServlet.java
                                                MainPageFilter.java
                                                MyPropertiesServlet.java
                                                PayPropertyServlet.java
                                                PostPropertyServlet.java
                                                PreparePayPropertyServlet.java
                                                SearchServlet.java
                                                SessionFilter.java
                                                UpdatePropertyServlet.java
                                                ViewPropertyServlet.java
                            model:
                                     entity:
                                                BankAccounts.java
                                                Customers.java
                                                Property.java
                                                Transactions.java
                                                WebAccount.java
                                     util:
                                                DatabaseUtil.java
                      webapp:
                            resources:
                                     css:
                                                style.css
                                                stylebanck.css
                                     images:
                                     js:
                                                script.js
                                     about.jsp
                                     aboutlog.jsp
                                     bank.jsp
                                     contact.jsp
                                     contactlog.jsp
                                     error_page.jsp
                                     home.jsp
                                     listings.jsp
                                     login.jsp
                                     my_properties.jsp
                                     post_property.jsp
                                     search.jsp
                                     UpdateProperty.jsp
                                     view_property.jsp
                            WEB-INF:
                                     web.xml
                            index.jsp
             test:
                     BankAccountsControllerTest.java
                     CustomersControllerTest.java
                     PropertyControllerTest.java
                     TransactionsControllerTest.java
                     WebAccountControllerTest.java
       target:
       pom.xml



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

-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: inmobiliaria
-- ------------------------------------------------------
-- Server version	11.3.2-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bankaccounts`
--

DROP TABLE IF EXISTS `bankaccounts`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bankaccounts` (
  `ID_CUSTOMER` int(11) NOT NULL COMMENT 'Identificacion del cliente',
  `ACCOUNT_ID` bigint(20) NOT NULL COMMENT 'Identificador de la cuenta',
  `MONEY_ON_ACCOUNT` bigint(20) NOT NULL COMMENT 'Dinero disponible en la cuenta',
  PRIMARY KEY (`ID_CUSTOMER`),
  CONSTRAINT `BANK_ACCOUNTS_customers_1_FK` FOREIGN KEY (`ID_CUSTOMER`) REFERENCES `customers` (`ID_CUSTOMER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bankaccounts`
--

LOCK TABLES `bankaccounts` WRITE;
/*!40000 ALTER TABLE `bankaccounts` DISABLE KEYS */;
INSERT INTO `bankaccounts` VALUES (1,1234567890,48500000),(1002456759,2458719645,10902500000),(1006748696,9789569314,10000000000),(1027845961,3845124797,10000000000),(1047968236,4891275632,10000000000),(1074246135,7459812415,9050000000),(1078459623,8541236981,10000000000),(1089456248,1254875234,10000000000);
/*!40000 ALTER TABLE `bankaccounts` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customers`
--

DROP TABLE IF EXISTS `customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customers` (
  `ID_CUSTOMER` int(11) NOT NULL COMMENT 'Identificador unico de la tabla',
  `NAME` varchar(100) NOT NULL COMMENT 'Nombres de los clientes',
  `LAST_NAME_1` varchar(100) NOT NULL COMMENT 'Apellidos de los clientes',
  `LAST_NAME_2` varchar(100) DEFAULT NULL COMMENT 'Apellidos de los clientes',
  `ADDRESS` varchar(100) NOT NULL COMMENT 'Dirección del cliente',
  `PHONE` bigint(20) NOT NULL COMMENT 'Telefono del cliente',
  `BIRTH` timestamp NOT NULL COMMENT 'Fechas de nacimiento',
  PRIMARY KEY (`ID_CUSTOMER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci COMMENT='Tabla de almacenamiento de la infromación referente al cliente';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customers`
--

LOCK TABLES `customers` WRITE;
/*!40000 ALTER TABLE `customers` DISABLE KEYS */;
INSERT INTO `customers` VALUES (1,'web','user',NULL,'1',1,'2024-05-31 06:01:54'),(1002456759,'Jeremy','Renner',NULL,'Cra 98 #12 sur 58',3113842567,'1971-01-08 01:51:39'),(1006748696,'Robert','Downey','Jr.','Cra 01 #01 norte 01',5555555551,'1970-04-05 01:59:57'),(1027845961,'Scarlett','Johansson',NULL,'Cra 78 #78 norte 25',3184569232,'1984-11-23 01:49:29'),(1047968236,'Chris','Hemsworth',NULL,'Cl 08 #74 sur 02, Asgard',5555214869,'1983-08-12 02:02:22'),(1074246135,'Mark','Ruffalo',NULL,'Cl 12 #36 este 28',5555124368,'1970-11-23 00:54:01'),(1078459623,'Tom','Hiddleston',NULL,'Cl 19 #23 este 05, Asgard',5555855631,'1981-02-10 02:05:28'),(1089456248,'Chris','Evans',NULL,'Cl 11 #65 oeste 07',5555788912,'1981-06-14 01:57:42');
/*!40000 ALTER TABLE `customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `property`
--

DROP TABLE IF EXISTS `property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `property` (
  `ID_CUSTOMER` int(11) NOT NULL COMMENT 'Identificación del cliente/propietario',
  `ENROLLMENT_ID` int(11) NOT NULL COMMENT 'Numero de matricula',
  `PROPERTY_NAME` varchar(100) NOT NULL COMMENT 'Nombre del inmueble',
  `BASE_PRICE` bigint(20) NOT NULL COMMENT 'Precio base del inmueble',
  `PROPERTY_ADDRESS` varchar(100) NOT NULL COMMENT 'Direccion del inmueble',
  `OFFER_TYPE` varchar(100) NOT NULL COMMENT 'Tipo de oferta, venta o subasta',
  `PROPERTY_TYPE` varchar(100) NOT NULL COMMENT 'Tipo de propiedad, casa, apartamento, terreno o estudio.',
  `PROPERTY_STATUS` varchar(100) NOT NULL COMMENT 'Estado de la propiedad, lista para mudarse,  dias de espera',
  `FURNISHED_STATUS` varchar(100) NOT NULL COMMENT 'Estado de amoblamiento, amobaldo, no amoblado.',
  `BHK` int(11) DEFAULT NULL COMMENT 'Numero de habitacion, sala y cocina',
  `BEDROOMS` int(11) NOT NULL COMMENT 'Numero de habitaciones',
  `BATHROOMS` int(11) NOT NULL COMMENT 'Numero de baños',
  `BALCONY` int(11) NOT NULL COMMENT 'Cantidad de balcones',
  `PROPERTY_AGE` int(11) NOT NULL COMMENT 'Edad de la propiedad',
  `FLOOR` int(11) NOT NULL COMMENT 'Cantidad de pisos',
  `PROPERTY_DESCRIPTION` varchar(1500) NOT NULL COMMENT 'Breve descripcion del inmueble',
  `LIFTS` tinyint(1) DEFAULT NULL COMMENT 'Si tiene ascensores',
  `SECURITY_GUARD` tinyint(1) DEFAULT NULL COMMENT 'Si posee guardias de seguridad',
  `PLAY_GROUND` tinyint(1) DEFAULT NULL COMMENT 'Si posee parque de juegos.',
  `GARDEN` tinyint(1) DEFAULT NULL COMMENT 'Si posee jardin',
  `WATER_SUPPLY` tinyint(1) DEFAULT NULL COMMENT 'Si posee suministro de agua',
  `POWER_BACKUP` tinyint(1) DEFAULT NULL COMMENT 'Si posee reserva de energia',
  `PARKING_AREA` tinyint(1) DEFAULT NULL COMMENT 'Si posee parqueadero',
  `GYM` tinyint(1) DEFAULT NULL COMMENT 'Si posee gimnasio',
  `SHOPING_MALL` tinyint(1) DEFAULT NULL COMMENT 'Si es cercano a un centro comercial',
  `HOSPITAL` tinyint(1) DEFAULT NULL COMMENT 'Si es cercano a un hospital',
  `SCHOOL` tinyint(1) DEFAULT NULL COMMENT 'Si esta cerca de una escuela o centro educativo',
  PRIMARY KEY (`ENROLLMENT_ID`),
  KEY `PROPERTY_customers_1_FK` (`ID_CUSTOMER`),
  CONSTRAINT `PROPERTY_customers_1_FK` FOREIGN KEY (`ID_CUSTOMER`) REFERENCES `customers` (`ID_CUSTOMER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `property`
--

LOCK TABLES `property` WRITE;
/*!40000 ALTER TABLE `property` DISABLE KEYS */;
INSERT INTO `property` VALUES (1078459623,111029,'Ciudad Esmeralda',300000000,'890 Elm Lane, Lexington, KY','Venta','Estudio','lista para mudanza','Semi-amoblada',0,1,1,1,5,1,'Un estudio ideal para grabacion y creacion.',1,1,0,0,1,1,1,1,1,1,1),(1006748696,129644,'Casita de Campo',7000000000,'1231 Elmwood Avenue, Buffalo, NY','Venta','Casa','lista para mudanza','Semi-amoblada',6,9,8,7,50,5,'Una casita de campo',1,1,1,1,1,1,1,1,0,0,1),(1078459623,166974,'Casa Dorada',800000000,'1234 Maple Street, Springfield, IL','Venta','Casa','lista para mudanza','Semi-amoblada',3,6,4,4,10,3,'Una Lujosa mansion tematica de Hollywood',0,1,1,1,1,1,1,1,1,1,0),(1078459623,215401,'Tierra Valhalla',8000000000,'567 Pine Avenue, Oakville, CA','Venta','Terreno','bajo construccion','Sin amoblar',0,0,0,0,1,0,'Un terreno ideal para los fanaticos de lo nordico',0,1,0,1,0,0,0,0,0,1,1),(1006748696,228413,'Lujoso Apartamento',500000000,'4567 Magnolia Lane, Savannah, GA','Venta','Apartamento','lista para mudanza','Sin amoblar',1,3,2,1,12,1,'Un lujoso apartamento en el centro de la ciudad',1,1,1,0,1,1,1,1,1,1,1),(1074246135,279445,'Depa Cerca al Lago',950000000,'1234 Pinecrest Lane, Boise, ID','Venta','Apartamento','lista para mudanza','Sin amoblar',2,4,3,2,0,1,'Un bello departamento cerca al lago bajo construccion',1,1,1,0,1,1,1,1,1,1,1),(1006748696,324412,'Tecno Palacio',4000000000,'6789 Oakwood Drive, Austin, TX','Venta','Casa','lista para mudanza','Amoblada',4,8,5,5,75,3,'Una hermosa mansion readecuada con la nueva tecnologia',1,1,1,1,1,1,1,0,0,1,1),(1089456248,367996,'Casa Grande',1000000000,'8901 Pinecrest Court, Seattle, WA','Venta','Casa','lista para mudanza','Semi-amoblada',2,4,2,2,25,2,'Una casa grande en las afueras de la ciudad',0,0,1,1,1,1,1,0,0,1,1),(1047968236,388597,'El Ragnarok',800000000,'8910 Birch Avenue, Boulder, CO','Venta','Apartamento','bajo construccion','Sin amoblar',2,5,3,2,0,1,'Un bello apartamento bajo construccion',1,1,1,1,1,1,1,1,1,1,1),(1074246135,392597,'Fuerte Nuclear',3500000000,'1234 Cedar Lane, Nashville, TN','Venta','Casa','lista para mudanza','Semi-amoblada',2,4,2,0,3,0,'Un fuerte bunker resistente ante todo',0,0,0,1,1,1,0,0,0,1,1),(1074246135,505607,'Ciencia a la mano',500000000,'5678 Birchwood Court, Providence, RI','Venta','Apartamento','lista para mudanza','Amoblada',0,3,1,1,0,1,'Un estudio perfecto para investigacion cientifica',0,1,0,0,1,1,1,1,0,1,1),(1047968236,522435,'Cabana Cervecera',700000000,'2467 Cedar Road, Charleston, SC','Venta','Apartamento','lista para mudanza','Amoblada',2,5,3,0,35,1,'Una bella cabana para pasar las vacaciones',0,0,1,1,1,1,1,0,0,0,0),(1074246135,529719,'Modesto Apartamento',250000000,'2345 Macedonia Boulevard, Acres lake.','Venta','Apartamento','lista para mudanza','Amoblada',1,3,1,1,2,1,'Un modesto pero bello apartamento ubicado cerca al centro de la ciudad',1,1,1,1,1,1,1,1,1,1,1),(1002456759,569914,'Campo de tiro',6000000000,'3456 Oakhurst Street, Phoenix, AZ','Venta','Terreno','lista para mudanza','Sin amoblar',1,3,1,0,43,1,'Un viejo campo de tiro perfecto para lo que se desee',0,1,0,1,1,1,1,1,1,1,0),(1002456759,571470,'Mansion Moderna',4000000000,'7890 Maplewood Drive, New Orleans, LA','Venta','Casa','lista para mudanza','Amoblada',3,6,6,6,5,3,'Una bella mansion moderna con todas las comodidades',1,1,1,1,1,1,1,1,1,1,1),(1089456248,600847,'Terreno Cercano',5000000000,'2345 Sycamore Boulevard, Miami, FL','Venta','Terreno','lista para mudanza','Sin amoblar',0,0,0,0,0,0,'Un terreno perfecto para construir negocios',0,1,0,1,1,0,1,1,1,1,1),(1074246135,673921,'Casa Verde',5000000000,'9012 Willow Avenue, Pittsburgh, PA','Venta','Casa','lista para mudanza','Amoblada',2,5,2,1,84,1,'Una antigua casa acogedora',0,1,1,1,1,1,1,1,1,1,1),(1027845961,850206,'Depa Central',820000000,'5678 Elmwood Court, Albuquerque, NM','Venta','Apartamento','lista para mudanza','Amoblada',2,4,3,3,7,1,'Un  bello apartamento cerca al paque central',1,1,1,0,1,1,1,0,1,1,1),(1047968236,899224,'Casita De Roca',350000000,'345 Willow Street, Portland, OR','Venta','Apartamento','lista para mudanza','Semi-amoblada',1,3,2,1,5,1,'Un bello apartamento con vista al mar',1,1,1,1,1,1,1,0,1,1,1),(1027845961,899652,'Centro de entrenamiento',2500000000,'9012 Magnolia Drive, Oklahoma City, OK','Venta','Estudio','lista para mudanza','Sin amoblar',0,1,1,0,15,1,'Un gran espacio para practicar deporte',0,1,0,1,1,1,1,1,1,1,1),(1027845961,933037,'Castillo Estilo Medieval',9000000000,'2345 Cedarwood Lane, Salt Lake City, UT','Venta','Apartamento','lista para mudanza','Amoblada',6,9,9,9,90,3,'Un bello castillo tipo medieval patrimonio de la ciudad',0,1,1,1,1,1,1,1,1,1,1),(1089456248,950032,'Estudio Alejado',250000000,'6789 Maplewood Drive, Denver, CO','Venta','Estudio','lista para mudanza','Sin amoblar',0,2,1,0,2,1,'Un estudio alejado del ruido citadino',1,1,0,1,1,1,1,0,0,1,1);
/*!40000 ALTER TABLE `property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transactions`
--

DROP TABLE IF EXISTS `transactions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `transactions` (
  `TRANSACTIONAL_ID` int(11) NOT NULL COMMENT 'Id de la transacción',
  `CLIENT_ID_BUYER` int(11) NOT NULL COMMENT 'Id del comprador',
  `CLIENT_ID_SELLER` int(11) NOT NULL COMMENT 'Id del vendedor',
  `ENROLLMENT_ID` int(11) NOT NULL COMMENT 'Matricula del inmueble',
  `TRANSACTION_DATE` timestamp NOT NULL COMMENT 'Fechay hora de la transaccion',
  `AMOUNT` decimal(10,0) NOT NULL COMMENT 'Monto total de la transaccion',
  `COMMISSION` decimal(10,0) NOT NULL COMMENT 'Ganancia para el negocio',
  `TRANSACTION_STATUS` tinyint(1) NOT NULL COMMENT 'Estado de la transaccion',
  `PAYMENT_METHOD` varchar(100) NOT NULL COMMENT 'Forma de pago',
  PRIMARY KEY (`TRANSACTIONAL_ID`),
  KEY `transactions_property_FK` (`ENROLLMENT_ID`),
  CONSTRAINT `transactions_property_FK` FOREIGN KEY (`ENROLLMENT_ID`) REFERENCES `property` (`ENROLLMENT_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci COMMENT='En esta tabla se llevara un registro de todas las transacciones del negocio';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transactions`
--

LOCK TABLES `transactions` WRITE;
/*!40000 ALTER TABLE `transactions` DISABLE KEYS */;
INSERT INTO `transactions` VALUES (19689563,1074246135,1002456759,279445,'2024-06-01 06:56:43',950000000,47500000,1,'BANK_TRANSFER');
/*!40000 ALTER TABLE `transactions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `webaccount`
--

DROP TABLE IF EXISTS `webaccount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `webaccount` (
  `ID_CUSTOMER` int(11) NOT NULL COMMENT 'Identificacion del cliente',
  `USERNAME` varchar(100) NOT NULL COMMENT 'Nombre de usuario',
  `PASSWORD` varchar(100) NOT NULL COMMENT 'Contraseña de usuario',
  `EMAIL` varchar(100) NOT NULL COMMENT 'Correo electronico del cliente',
  PRIMARY KEY (`ID_CUSTOMER`),
  CONSTRAINT `WEB_ACCOUNT_customers_1_FK` FOREIGN KEY (`ID_CUSTOMER`) REFERENCES `customers` (`ID_CUSTOMER`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci COMMENT='En esta tabla se encuentran los datos del ingreso de usuario';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `webaccount`
--

LOCK TABLES `webaccount` WRITE;
/*!40000 ALTER TABLE `webaccount` DISABLE KEYS */;
INSERT INTO `webaccount` VALUES (1002456759,'Hawk','Hawk','hawkeye.jeremy@gmail.com'),(1006748696,'Iron','Iron','ironman.robert@gmail.com'),(1027845961,'Widow','Widow','blackwidow.scarlett@gmail.com'),(1047968236,'Thor','Thor','thor.chris@gmail.com'),(1074246135,'Hulk','Hulk','hulk.mark@gmail.com'),(1078459623,'Loki','Loki','loki.tom@gmail.com'),(1089456248,'Capi','Capi','captainamerica.chris@gmail.com');
/*!40000 ALTER TABLE `webaccount` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'inmobiliaria'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-01  3:16:58


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
