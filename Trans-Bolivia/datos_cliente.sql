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
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
INSERT INTO `cliente` VALUES 
(767285,'Pablo Sagredo Bustamante','Baure #39','Normal'),
(778000,'Carmen Condori Orellana','Dr. Solares #27','Normal'),
(802460,'Juan Pablo Panozo Mamani','German Urquidi #33','Normal'),
(905393,'Ana Lopez Condori','Honduras #13','Normal'),
(919566,'Juan Vargas Figueroa','Calle Pablo Jimenes #24','Normal'),
(1132321194,'Plamat S.A.','Calle Baptista #646','Preferencial'),
(1235186134,'Plasticos Poliform','Ponsnanski Nro. 560','Preferencial'),
(1330650150,'Industrias Maca Ltda.','Av. Blanco Galindo, Km. 7','Preferencial'),
(1353685653,'Muebles Arcadia','Calle Colomi Nro. 172','Preferencial'),
(1635344581,'Hidrotec Ltda.','Juan Capriles 538 - Edificio Los Olivos','Preferencial'),
(1934766441,'100% Construccion','Calle Miguel Maria de Aguirre #1541','Preferencial');
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-21 15:15:53
