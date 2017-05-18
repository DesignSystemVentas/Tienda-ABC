-- MySQL dump 10.16  Distrib 10.1.22-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: 172.17.0.2    Database: tienda
-- ------------------------------------------------------
-- Server version	10.1.22-MariaDB-1~jessie

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
-- Table structure for table `compra`
--

DROP TABLE IF EXISTS `compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `compra` (
  `IdCompra` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` datetime NOT NULL,
  `IdProveedor` int(11) NOT NULL,
  `Total` double NOT NULL,
  PRIMARY KEY (`IdCompra`),
  UNIQUE KEY `Compra_IdCompra_uindex` (`IdCompra`),
  KEY `Compra_Proveedor_IdProveedor_fk` (`IdProveedor`),
  CONSTRAINT `Compra_Proveedor_IdProveedor_fk` FOREIGN KEY (`IdProveedor`) REFERENCES `proveedor` (`IdProveedor`) ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra`
--

LOCK TABLES `compra` WRITE;
/*!40000 ALTER TABLE `compra` DISABLE KEYS */;
INSERT INTO `compra` VALUES (1,'2017-04-20 10:00:00',1,100),(2,'2017-04-22 00:00:00',3,70),(3,'2017-04-24 11:30:00',2,200);
/*!40000 ALTER TABLE `compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detallecompra`
--

DROP TABLE IF EXISTS `detallecompra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detallecompra` (
  `CodBarra` varchar(13) NOT NULL,
  `IdCompra` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `CostoUnitario` double NOT NULL,
  PRIMARY KEY (`IdCompra`,`CodBarra`),
  KEY `DetalleCompra_Productos_CodBarra_fk` (`CodBarra`),
  KEY `DetalleCompra_Compra_IdCompra_fk` (`IdCompra`),
  CONSTRAINT `DetalleCompra_Compra_IdCompra_fk` FOREIGN KEY (`IdCompra`) REFERENCES `compra` (`IdCompra`) ON UPDATE CASCADE,
  CONSTRAINT `DetalleCompra_Productos_CodBarra_fk` FOREIGN KEY (`CodBarra`) REFERENCES `productos` (`CodBarra`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detallecompra`
--

LOCK TABLES `detallecompra` WRITE;
/*!40000 ALTER TABLE `detallecompra` DISABLE KEYS */;
INSERT INTO `detallecompra` VALUES ('34234213',1,10,2.5);
/*!40000 ALTER TABLE `detallecompra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalleventa`
--

DROP TABLE IF EXISTS `detalleventa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detalleventa` (
  `IdVenta` int(11) NOT NULL,
  `CodBarra` varchar(13) NOT NULL,
  `Cantidad` int(11) NOT NULL,
  `PrecioUnitario` double NOT NULL,
  PRIMARY KEY (`IdVenta`,`CodBarra`),
  KEY `DetalleVenta_Venta_IdVenta_fk` (`IdVenta`),
  KEY `DetalleVenta_Productos_CodBarra_fk` (`CodBarra`),
  CONSTRAINT `DetalleVenta_Productos_CodBarra_fk` FOREIGN KEY (`CodBarra`) REFERENCES `productos` (`CodBarra`) ON UPDATE CASCADE,
  CONSTRAINT `DetalleVenta_Venta_IdVenta_fk` FOREIGN KEY (`IdVenta`) REFERENCES `venta` (`IdVenta`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalleventa`
--

LOCK TABLES `detalleventa` WRITE;
/*!40000 ALTER TABLE `detalleventa` DISABLE KEYS */;
INSERT INTO `detalleventa` VALUES (1,'34234213',10,3);
/*!40000 ALTER TABLE `detalleventa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parametros`
--

DROP TABLE IF EXISTS `parametros`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `parametros` (
  `IdParametro` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Valor` varchar(100) NOT NULL,
  PRIMARY KEY (`IdParametro`),
  UNIQUE KEY `Parametros_IdParametro_uindex` (`IdParametro`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parametros`
--

LOCK TABLES `parametros` WRITE;
/*!40000 ALTER TABLE `parametros` DISABLE KEYS */;
INSERT INTO `parametros` VALUES (1,'Nombre','Tienda ABC'),(2,'Direccion','Colonia El Calvario No. 25, Santa Ana'),(3,'Utilidad','25');
/*!40000 ALTER TABLE `parametros` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productos`
--

DROP TABLE IF EXISTS `productos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `productos` (
  `CodBarra` varchar(13) NOT NULL,
  `Inventario` int(11) NOT NULL,
  `Costo` double NOT NULL,
  `nombre` varchar(145) NOT NULL,
  PRIMARY KEY (`CodBarra`),
  UNIQUE KEY `Productos_CodBarra_uindex` (`CodBarra`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productos`
--

LOCK TABLES `productos` WRITE;
/*!40000 ALTER TABLE `productos` DISABLE KEYS */;
INSERT INTO `productos` VALUES ('34234213',50,2,'JABON ROSA');
/*!40000 ALTER TABLE `productos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `IdProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(100) NOT NULL,
  `Telefono` varchar(9) DEFAULT NULL,
  `Direccion` varchar(100) DEFAULT NULL,
  `NIT` varchar(14) DEFAULT NULL,
  PRIMARY KEY (`IdProveedor`),
  UNIQUE KEY `Proveedor_IdProveedor_uindex` (`IdProveedor`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES (1,'POLLO INDIO','2342-3435','Santa Ana','33312312341'),(2,'TORITO PINTO','2434-3944','Santa Ana','23211231231'),(3,'SUPER SELECTOS','2344-3232','Santa Ana','1231234123441');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `venta` (
  `IdVenta` int(11) NOT NULL AUTO_INCREMENT,
  `Fecha` datetime NOT NULL,
  `Cliente` varchar(100) DEFAULT NULL,
  `Total` double NOT NULL,
  PRIMARY KEY (`IdVenta`),
  UNIQUE KEY `Venta_IdVenta_uindex` (`IdVenta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'2017-04-24 00:00:00','DENIS DIEGO',10);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-04-25  2:30:38
