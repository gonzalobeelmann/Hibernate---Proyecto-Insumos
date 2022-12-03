CREATE DATABASE  IF NOT EXISTS `finalOO2insumos` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `finalOO2insumos`;
-- MySQL dump 10.13  Distrib 5.7.22, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: finalOO2insumos
-- ------------------------------------------------------
-- Server version	5.7.22-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `insumo`
--

DROP TABLE IF EXISTS `insumo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `insumo` (
  `idinsumo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `preciounitario` decimal(6,2) NOT NULL,
  PRIMARY KEY (`idinsumo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `insumo`
--

LOCK TABLES `insumo` WRITE;
/*!40000 ALTER TABLE `insumo` DISABLE KEYS */;
INSERT INTO `insumo` VALUES (1,'lapicera',10.00),(2,'cuaderno',20.00),(3,'mouse',100.00),(4,'abrochadora',80.00),(5,'monitor',500.00),(6,'folio',5.00);
/*!40000 ALTER TABLE `insumo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itempedido`
--

DROP TABLE IF EXISTS `itempedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `itempedido` (
  `iditempedido` int(11) NOT NULL AUTO_INCREMENT,
  `idinsumo` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `idpedido` int(11) NOT NULL,
  PRIMARY KEY (`iditempedido`),
  KEY `fk_itempedido_insumo_idx` (`idinsumo`),
  KEY `fk_itempedido_pedido_idx` (`idpedido`),
  CONSTRAINT `fk_itempedido_insumo` FOREIGN KEY (`idinsumo`) REFERENCES `insumo` (`idinsumo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_itempedido_pedido` FOREIGN KEY (`idpedido`) REFERENCES `pedido` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itempedido`
--

LOCK TABLES `itempedido` WRITE;
/*!40000 ALTER TABLE `itempedido` DISABLE KEYS */;
INSERT INTO `itempedido` VALUES (1,1,10,1),(2,2,10,1),(3,3,5,2),(4,4,5,2),(5,5,10,3),(6,6,10,3),(7,1,5,4),(8,2,5,4),(9,3,10,5),(10,4,10,5),(11,5,5,6),(12,6,5,6),(13,1,10,7),(14,2,10,7),(15,3,5,8),(16,4,5,8),(17,5,10,9),(18,6,10,9),(19,5,1,10),(20,1,10,11),(21,3,1,12),(22,6,10,13),(23,4,10,14),(24,5,1,15),(25,3,1,16),(26,2,5,17),(27,5,1,18);
/*!40000 ALTER TABLE `itempedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedido`
--

DROP TABLE IF EXISTS `pedido`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedido` (
  `idpedido` int(11) NOT NULL AUTO_INCREMENT,
  `area` varchar(45) NOT NULL,
  `fechacreacion` date NOT NULL,
  `abierto` bit(1) NOT NULL,
  PRIMARY KEY (`idpedido`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedido`
--

LOCK TABLES `pedido` WRITE;
/*!40000 ALTER TABLE `pedido` DISABLE KEYS */;
INSERT INTO `pedido` VALUES (1,'area1','2021-05-10',''),(2,'area2','2021-05-11',''),(3,'area3','2021-05-12',''),(4,'area1','2021-06-13',''),(5,'area2','2021-06-14',''),(6,'area3','2021-06-15',''),(7,'area1','2021-07-16',''),(8,'area2','2021-07-16',''),(9,'area3','2021-07-16',''),(10,'area1','2021-05-01',''),(11,'area2','2021-05-10',''),(12,'area3','2021-05-22',''),(13,'area1','2021-06-03',''),(14,'area2','2021-06-14',''),(15,'area3','2021-06-25',''),(16,'area1','2021-07-04',''),(17,'area2','2021-07-10',''),(18,'area3','2021-07-16','');
/*!40000 ALTER TABLE `pedido` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidocritico`
--

DROP TABLE IF EXISTS `pedidocritico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidocritico` (
  `idpedido` int(11) NOT NULL,
  `motivo` varchar(45) NOT NULL,
  `porcentajeextra` int(11) NOT NULL,
  PRIMARY KEY (`idpedido`),
  CONSTRAINT `fk_pedidocritico_pedido` FOREIGN KEY (`idpedido`) REFERENCES `pedido` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidocritico`
--

LOCK TABLES `pedidocritico` WRITE;
/*!40000 ALTER TABLE `pedidocritico` DISABLE KEYS */;
INSERT INTO `pedidocritico` VALUES (10,'rotura de monitor',10),(11,'falta de lapiceras',10),(12,'mouse roto',10),(13,'urgencia de folios',10),(14,'urgencia de abrochadoras',10),(15,'monitor no funciona',10),(16,'mouse roto',10),(17,'urgencia de cuadernos',10),(18,'monitor sin prender',10);
/*!40000 ALTER TABLE `pedidocritico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidomensual`
--

DROP TABLE IF EXISTS `pedidomensual`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidomensual` (
  `idpedido` int(11) NOT NULL,
  `fechaentrega` date NOT NULL,
  PRIMARY KEY (`idpedido`),
  CONSTRAINT `fk_pedidomensual_pedido` FOREIGN KEY (`idpedido`) REFERENCES `pedido` (`idpedido`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidomensual`
--

LOCK TABLES `pedidomensual` WRITE;
/*!40000 ALTER TABLE `pedidomensual` DISABLE KEYS */;
INSERT INTO `pedidomensual` VALUES (1,'2021-06-02'),(2,'2021-06-02'),(3,'2021-06-02'),(4,'2021-07-03'),(5,'2021-07-03'),(6,'2021-07-03'),(7,'2021-08-04'),(8,'2021-08-04'),(9,'2021-08-04');
/*!40000 ALTER TABLE `pedidomensual` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-07-11  0:03:37
