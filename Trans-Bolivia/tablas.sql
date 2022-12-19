-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: trans_bolivia_bd
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `CI_CLIENTE` int NOT NULL,
  `NOMBRE_CLIENTE` char(40) NOT NULL,
  `DIRECCION_CLIENTE` char(40) NOT NULL,
  `TIPO_CLIENTE` char(40) NOT NULL,
  PRIMARY KEY (`CI_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `conductor`
--

DROP TABLE IF EXISTS `conductor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conductor` (
  `CI_CONDUCTOR` int NOT NULL,
  `NRO_LICENCIA` int NOT NULL,
  `CATEGORIA_LICENCIA` char(10) NOT NULL,
  `NOMBRE_CONDUCTOR` char(40) NOT NULL,
  `TELEFONO_CONDUCTOR` char(40) NOT NULL,
  `DIRECCION_CONDUCTOR` char(40) NOT NULL,
  `ESTADO_CONDUCTOR` char(40) NOT NULL,
  `FECHA_VENCIMIENTO_LICENCIA` date DEFAULT NULL,
  PRIMARY KEY (`CI_CONDUCTOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `conductor_poliza`
--

DROP TABLE IF EXISTS `conductor_poliza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `conductor_poliza` (
  `ID_POLIZA` int DEFAULT NULL,
  `CI_CONDUCTOR` int DEFAULT NULL,
  `FECHA_INICIO_COBERTURA` date DEFAULT NULL,
  `FECHA_FIN_COBERTURA` date DEFAULT NULL,
  KEY `FK_RELATIONSHIP_30` (`ID_POLIZA`),
  KEY `FK_RELATIONSHIP_38` (`CI_CONDUCTOR`),
  CONSTRAINT `FK_RELATIONSHIP_30` FOREIGN KEY (`ID_POLIZA`) REFERENCES `poliza` (`ID_POLIZA`),
  CONSTRAINT `FK_RELATIONSHIP_38` FOREIGN KEY (`CI_CONDUCTOR`) REFERENCES `conductor` (`CI_CONDUCTOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `contrato`
--

DROP TABLE IF EXISTS `contrato`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `contrato` (
  `ID_RUTA` int DEFAULT NULL,
  `CI_CONDUCTOR` int DEFAULT NULL,
  `PLACA` char(15) DEFAULT NULL,
  `CI_CLIENTE` int DEFAULT NULL,
  `CI_EMPLEADO` int DEFAULT NULL,
  `NIT_SUCURSAL` int DEFAULT NULL,
  `FECHA_REG_CONTRATO` date DEFAULT NULL,
  `FECHA_SALIDA` date DEFAULT NULL,
  `FECHA_LLEGADA` date DEFAULT NULL,
  `MONTO_TOTAL` float(8,2) DEFAULT NULL,
  KEY `FK_ANOTA` (`NIT_SUCURSAL`),
  KEY `FK_CONFIRMA` (`CI_EMPLEADO`),
  KEY `FK_HACE_UN` (`CI_CLIENTE`),
  KEY `FK_REALIZA` (`ID_RUTA`),
  KEY `FK_REALIZARA` (`PLACA`),
  KEY `FK_TIENE_UN` (`CI_CONDUCTOR`),
  CONSTRAINT `FK_ANOTA` FOREIGN KEY (`NIT_SUCURSAL`) REFERENCES `sucursal` (`NIT_SUCURSAL`),
  CONSTRAINT `FK_CONFIRMA` FOREIGN KEY (`CI_EMPLEADO`) REFERENCES `empleado` (`CI_EMPLEADO`),
  CONSTRAINT `FK_HACE_UN` FOREIGN KEY (`CI_CLIENTE`) REFERENCES `cliente` (`CI_CLIENTE`),
  CONSTRAINT `FK_REALIZA` FOREIGN KEY (`ID_RUTA`) REFERENCES `ruta` (`ID_RUTA`),
  CONSTRAINT `FK_REALIZARA` FOREIGN KEY (`PLACA`) REFERENCES `vehiculo` (`PLACA`),
  CONSTRAINT `FK_TIENE_UN` FOREIGN KEY (`CI_CONDUCTOR`) REFERENCES `conductor` (`CI_CONDUCTOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `diagnostico`
--

DROP TABLE IF EXISTS `diagnostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnostico` (
  `ID_DIAGNOSTICO` int NOT NULL,
  `ID_SERVICIO` int DEFAULT NULL,
  `DESCRIPCION_DIAGNOSTICO` char(100) DEFAULT NULL,
  PRIMARY KEY (`ID_DIAGNOSTICO`),
  KEY `FK_SE_HACEN_MUCHOS` (`ID_SERVICIO`),
  CONSTRAINT `FK_SE_HACEN_MUCHOS` FOREIGN KEY (`ID_SERVICIO`) REFERENCES `servicio` (`ID_SERVICIO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `empleado`
--

DROP TABLE IF EXISTS `empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado` (
  `CI_EMPLEADO` int NOT NULL,
  `NIT_SUCURSAL` int DEFAULT NULL,
  `NOMBRE_EMPLEADO` char(40) DEFAULT NULL,
  `DIRECCION_EMPLEADO` char(40) DEFAULT NULL,
  PRIMARY KEY (`CI_EMPLEADO`),
  KEY `FK_TRABAJA` (`NIT_SUCURSAL`),
  CONSTRAINT `FK_TRABAJA` FOREIGN KEY (`NIT_SUCURSAL`) REFERENCES `sucursal` (`NIT_SUCURSAL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `empleado_poliza`
--

DROP TABLE IF EXISTS `empleado_poliza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empleado_poliza` (
  `CI_EMPLEADO` int DEFAULT NULL,
  `ID_POLIZA` int DEFAULT NULL,
  `FECHA_INICIO_COBERTURA` date DEFAULT NULL,
  `FECHA_FIN_COBERTURA` date DEFAULT NULL,
  KEY `FK_RELATIONSHIP_27` (`CI_EMPLEADO`),
  KEY `FK_RELATIONSHIP_28` (`ID_POLIZA`),
  CONSTRAINT `FK_RELATIONSHIP_27` FOREIGN KEY (`CI_EMPLEADO`) REFERENCES `empleado` (`CI_EMPLEADO`),
  CONSTRAINT `FK_RELATIONSHIP_28` FOREIGN KEY (`ID_POLIZA`) REFERENCES `poliza` (`ID_POLIZA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `inspector`
--

DROP TABLE IF EXISTS `inspector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inspector` (
  `CI_INSPECTOR` int NOT NULL,
  `NOMBRE_INSPECTOR` char(40) NOT NULL,
  `TELEFONO_INSPECTOR` char(40) NOT NULL,
  `DIRECCION_INSPECTOR` char(40) NOT NULL,
  `MECANICO_CALIFICADOR` tinyint(1) NOT NULL,
  PRIMARY KEY (`CI_INSPECTOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `inspector_poliza`
--

DROP TABLE IF EXISTS `inspector_poliza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inspector_poliza` (
  `CI_INSPECTOR` int DEFAULT NULL,
  `ID_POLIZA` int DEFAULT NULL,
  `FECHA_INICIO_COBERTURA` date DEFAULT NULL,
  `FECHA_FIN_COBERTURA` date DEFAULT NULL,
  KEY `FK_RELATIONSHIP_33` (`CI_INSPECTOR`),
  KEY `FK_RELATIONSHIP_34` (`ID_POLIZA`),
  CONSTRAINT `FK_RELATIONSHIP_33` FOREIGN KEY (`CI_INSPECTOR`) REFERENCES `inspector` (`CI_INSPECTOR`),
  CONSTRAINT `FK_RELATIONSHIP_34` FOREIGN KEY (`ID_POLIZA`) REFERENCES `poliza` (`ID_POLIZA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mantenimiento`
--

DROP TABLE IF EXISTS `mantenimiento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mantenimiento` (
  `NUMERO_REGISTRO` int NOT NULL,
  `CI_CONDUCTOR` int DEFAULT NULL,
  `CI_INSPECTOR` int DEFAULT NULL,
  `PLACA` char(15) DEFAULT NULL,
  `FECHA_INGRESO_MANTENIMIENTO` date NOT NULL,
  `HORA_INGRESO_MANTENIMIENTO` time NOT NULL,
  `FECHA_SALIDA_MANTENIMIENTO` date DEFAULT NULL,
  `COSTO_MANTENIMIENTO` float(8,2) DEFAULT NULL,
  `VISTO_BUENO_INSPECTOR` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`NUMERO_REGISTRO`),
  KEY `FK_INSPECCIONARA` (`CI_INSPECTOR`),
  KEY `FK_IRA` (`PLACA`),
  KEY `FK_LLEVARA` (`CI_CONDUCTOR`),
  CONSTRAINT `FK_INSPECCIONARA` FOREIGN KEY (`CI_INSPECTOR`) REFERENCES `inspector` (`CI_INSPECTOR`),
  CONSTRAINT `FK_IRA` FOREIGN KEY (`PLACA`) REFERENCES `vehiculo` (`PLACA`),
  CONSTRAINT `FK_LLEVARA` FOREIGN KEY (`CI_CONDUCTOR`) REFERENCES `conductor` (`CI_CONDUCTOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mecanico`
--

DROP TABLE IF EXISTS `mecanico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mecanico` (
  `CI_MECANICO` int NOT NULL,
  `NOMBRE_MECANICO` char(40) NOT NULL,
  `TELEFONO_MECANICO` char(40) NOT NULL,
  `INSPECTOR_CALIFICADO` tinyint(1) NOT NULL,
  PRIMARY KEY (`CI_MECANICO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `mecanico_poliza`
--

DROP TABLE IF EXISTS `mecanico_poliza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mecanico_poliza` (
  `ID_POLIZA` int DEFAULT NULL,
  `CI_MECANICO` int DEFAULT NULL,
  `FECHA_INICIO_COBERTURA` date DEFAULT NULL,
  `FECHA_FIN_COBERTURA` date DEFAULT NULL,
  KEY `FK_RELATIONSHIP_35` (`ID_POLIZA`),
  KEY `FK_RELATIONSHIP_36` (`CI_MECANICO`),
  CONSTRAINT `FK_RELATIONSHIP_35` FOREIGN KEY (`ID_POLIZA`) REFERENCES `poliza` (`ID_POLIZA`),
  CONSTRAINT `FK_RELATIONSHIP_36` FOREIGN KEY (`CI_MECANICO`) REFERENCES `mecanico` (`CI_MECANICO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `poliza`
--

DROP TABLE IF EXISTS `poliza`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `poliza` (
  `ID_POLIZA` int NOT NULL,
  `TIPO_POLIZA` char(80) NOT NULL,
  `EMPRESA_ASEGURADORA` char(40) DEFAULT NULL,
  `MONTO_PAGO_ANUAL` float(8,2) DEFAULT NULL,
  `MONTO_SEGURO` float(8,2) DEFAULT NULL,
  `MONTO_PAGADO_EMPLEADO` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`ID_POLIZA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `refaccion`
--

DROP TABLE IF EXISTS `refaccion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `refaccion` (
  `ID_DIAGNOSTICO` int DEFAULT NULL,
  `REPUESTO_USADO` char(100) NOT NULL,
  `CANTIDAD` int NOT NULL,
  `TIEMPO_REFACCION` time DEFAULT NULL,
  `COSTO_REPARACION` float(8,2) NOT NULL,
  KEY `FK_SE_HARAN_MUCHAS` (`ID_DIAGNOSTICO`),
  CONSTRAINT `FK_SE_HARAN_MUCHAS` FOREIGN KEY (`ID_DIAGNOSTICO`) REFERENCES `diagnostico` (`ID_DIAGNOSTICO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `renovar_licencia`
--

DROP TABLE IF EXISTS `renovar_licencia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `renovar_licencia` (
  `NOMBRE_CONDUCTOR` char(40) NOT NULL,
  `CATEGORIA_LICENCIA` char(10) NOT NULL,
  `FECHA_VENCIMIENTO_LICENCIA` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `CI_CONDUCTOR` int DEFAULT NULL,
  `PLACA` char(15) DEFAULT NULL,
  `ID_RUTA` int DEFAULT NULL,
  `CI_EMPLEADO` int DEFAULT NULL,
  `CI_CLIENTE` int DEFAULT NULL,
  `FECHA_REGISTRO_RESERVA` date NOT NULL,
  `FECHA_VIAJE_PREVISTO` date NOT NULL,
  `RESERVA_VIGENTE` tinyint(1) NOT NULL,
  `MONTO_ANTICIPADO` int NOT NULL,
  `MONTO_PERDIDO` int NOT NULL,
  KEY `FK_ELIGE` (`ID_RUTA`),
  KEY `FK_HACE` (`CI_CLIENTE`),
  KEY `FK_RELATIONSHIP_15` (`CI_EMPLEADO`),
  KEY `FK_RESERVA_UN` (`PLACA`),
  KEY `FK_TIENE` (`CI_CONDUCTOR`),
  CONSTRAINT `FK_ELIGE` FOREIGN KEY (`ID_RUTA`) REFERENCES `ruta` (`ID_RUTA`),
  CONSTRAINT `FK_HACE` FOREIGN KEY (`CI_CLIENTE`) REFERENCES `cliente` (`CI_CLIENTE`),
  CONSTRAINT `FK_RELATIONSHIP_15` FOREIGN KEY (`CI_EMPLEADO`) REFERENCES `empleado` (`CI_EMPLEADO`),
  CONSTRAINT `FK_RESERVA_UN` FOREIGN KEY (`PLACA`) REFERENCES `vehiculo` (`PLACA`),
  CONSTRAINT `FK_TIENE` FOREIGN KEY (`CI_CONDUCTOR`) REFERENCES `conductor` (`CI_CONDUCTOR`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `ruta`
--

DROP TABLE IF EXISTS `ruta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ruta` (
  `ID_RUTA` int NOT NULL,
  `DESTINO` char(40) NOT NULL,
  `TIEMPO_VIAJE` time NOT NULL,
  `ORIGEN` char(40) NOT NULL,
  `DISTANCIA` float NOT NULL,
  `TIPO_DE_RUTA` char(40) NOT NULL,
  PRIMARY KEY (`ID_RUTA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `ID_SERVICIO` int NOT NULL,
  `CI_MECANICO` int DEFAULT NULL,
  `NUMERO_REGISTRO` int DEFAULT NULL,
  `DESCRIPCION_TRABAJO` char(200) NOT NULL,
  `COSTO_SERVICIO` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`ID_SERVICIO`),
  KEY `FK_DERIVA` (`NUMERO_REGISTRO`),
  KEY `FK_FIRMADO_POR` (`CI_MECANICO`),
  CONSTRAINT `FK_DERIVA` FOREIGN KEY (`NUMERO_REGISTRO`) REFERENCES `mantenimiento` (`NUMERO_REGISTRO`),
  CONSTRAINT `FK_FIRMADO_POR` FOREIGN KEY (`CI_MECANICO`) REFERENCES `mecanico` (`CI_MECANICO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `sucursal`
--

DROP TABLE IF EXISTS `sucursal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sucursal` (
  `NIT_SUCURSAL` int NOT NULL,
  `NOMBRE_SUCURSAL` char(40) DEFAULT NULL,
  `TELEFONO_SUCURSAL` char(40) DEFAULT NULL,
  `DIRECCION_SUCURSAL` char(40) DEFAULT NULL,
  PRIMARY KEY (`NIT_SUCURSAL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `telefono_cliente`
--

DROP TABLE IF EXISTS `telefono_cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefono_cliente` (
  `CI_CLIENTE` int DEFAULT NULL,
  `TELEFONO_CLIENTE` char(40) DEFAULT NULL,
  KEY `FK_RELATIONSHIP_31` (`CI_CLIENTE`),
  CONSTRAINT `FK_RELATIONSHIP_31` FOREIGN KEY (`CI_CLIENTE`) REFERENCES `cliente` (`CI_CLIENTE`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `telefono_empleado`
--

DROP TABLE IF EXISTS `telefono_empleado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telefono_empleado` (
  `CI_EMPLEADO` int DEFAULT NULL,
  `TELEFONO_EMPLEADO` char(40) DEFAULT NULL,
  KEY `FK_RELATIONSHIP_32` (`CI_EMPLEADO`),
  CONSTRAINT `FK_RELATIONSHIP_32` FOREIGN KEY (`CI_EMPLEADO`) REFERENCES `empleado` (`CI_EMPLEADO`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `vehiculo`
--

DROP TABLE IF EXISTS `vehiculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehiculo` (
  `PLACA` char(15) NOT NULL,
  `MODELO` char(50) NOT NULL,
  `ESTADO` char(40) NOT NULL,
  `MARCA` char(40) NOT NULL,
  `TIPO` char(40) NOT NULL,
  PRIMARY KEY (`PLACA`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-18 17:55:53
