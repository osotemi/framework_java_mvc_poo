-- MySQL dump 10.13  Distrib 5.6.30, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: db_framework
-- ------------------------------------------------------
-- Server version	5.6.30-0ubuntu0.15.10.1

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin` (
  `age` int(11) NOT NULL,
  `avatar` varchar(200) CHARACTER SET latin1 NOT NULL,
  `date_birthday` varchar(45) CHARACTER SET latin1 NOT NULL,
  `dni` varchar(10) CHARACTER SET latin1 NOT NULL,
  `email` varchar(100) CHARACTER SET latin1 NOT NULL,
  `phone` varchar(9) CHARACTER SET latin1 NOT NULL,
  `name` varchar(45) CHARACTER SET latin1 NOT NULL,
  `lastname` varchar(100) CHARACTER SET latin1 NOT NULL,
  `password` varchar(200) CHARACTER SET latin1 NOT NULL,
  `state` varchar(30) CHARACTER SET latin1 NOT NULL,
  `user` varchar(100) CHARACTER SET latin1 NOT NULL,
  `benefit` float NOT NULL,
  `activity` int(11) NOT NULL,
  `antiqueness` int(11) NOT NULL,
  `date_hiredate` varchar(45) CHARACTER SET latin1 NOT NULL,
  `salary` float NOT NULL,
  PRIMARY KEY (`dni`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (20,'/home/osotemi/NetBeansProjects/Framework_v1.6.3/src/framework/img/profile_pictures/people-22.png','8/4/1996','02733416G','dany@mail.com','999888777','Dani','Adrian','dani123D','Loged','DaniPreb',564,5640,7,'14/9/2015',1136.75),(39,'/home/osotemi/NetBeansProjects/Framework_v1.6.3/src/framework/img/profile_pictures/people-6.png','22/4/1976','37661593J','bertRom@mail.com','666666666','Berto','Romero','alcasoAL05','Loged','BerRom',231,2310,132,'7/4/2005',1793),(50,'/home/osotemi/NetBeansProjects/Framework_v1.6.3/src/framework/img/profile_pictures/people-25.png','23/10/1965','43013914-G','jim.cobain@gmail.com','625517477','Jim','Cobain Martínez','vO7eIc98Jwoj8r43','Logged','JimCob',458.1,4581,17,'24/11/2014',1189.25),(29,'/home/osotemi/NetBeansProjects/Framework_v1.6.3/src/framework/img/profile_pictures/people-16.png','5/5/1986','53382477y','oscar.otero.millan@gmail.com','669554383','Oscar','Otero Millán','oreto05OT','Online','osotemi',10,100,19,'14/9/2014',1199.75),(29,'/home/osotemi/NetBeansProjects/Framework_v1.6.3/src/framework/img/profile_pictures/people-18.png','9/3/1987','55862615-P','sara.rabadan@omail.com','632979605','Sara','Rabadan Plaza','m5HH93E84waF','Online','SarRab',842.5,8425,64,'22/11/2010',1436),(58,'/home/osotemi/NetBeansProjects/Framework_v1.6.3/src/framework/img/profile_pictures/people-0.png','6/5/1957','67814045-V','ismael.plaza@gmail.com','646427424','Ismael','Plaza Rabadan','7ISh746Jkl26bUD1','Offline','IsmPla',337.4,3374,24,'3/4/2014',1226),(35,'/home/osotemi/NetBeansProjects/Framework_v1.6.3/src/framework/img/profile_pictures/people-13.png','30/9/1980','71637622-M','ana.callau@gmail.com','605294523','Ana María','Callaú Beltrán','CLTK21SbZJEWHAwp','Online','AnaCal',635.3,6353,143,'28/5/2004',1850.75),(32,'/home/osotemi/NetBeansProjects/Framework_v1.6.3/src/framework/img/profile_pictures/people-12.png','12/2/1984','86038887-G','joan.zorrilla@gmail.com','692565054','Joan','Zormilla Banús','MGg1Foz966Ks','Online','JoaZor',1.6,16,104,'28/7/2007',1646),(39,'/home/osotemi/NetBeansProjects/Framework_v1.6.3/src/framework/img/profile_pictures/people-24.png','20/5/1976','96430707X','Admpru@omail.com','612345678','Administrador','Prueba Entrega','Admin1234','Offline','yomogan',823,8230,116,'1/9/2006',1709);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-03  2:48:50
