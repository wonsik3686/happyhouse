CREATE DATABASE  IF NOT EXISTS `ssafyweb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `ssafyweb`;
-- MySQL dump 10.13  Distrib 8.0.26, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ssafyweb
-- ------------------------------------------------------
-- Server version	8.0.26

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
-- Table structure for table `interest_location`
--

DROP TABLE IF EXISTS `interest_location`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `interest_location` (
  `userid` varchar(16) NOT NULL,
  `sido` varchar(45) NOT NULL,
  `gugun` varchar(45) NOT NULL,
  `dong` varchar(45) NOT NULL,
  KEY `interest_fk_member_userid_idx` (`userid`),
  CONSTRAINT `interest_fk_member_userid` FOREIGN KEY (`userid`) REFERENCES `ssafy_member` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interest_location`
--

LOCK TABLES `interest_location` WRITE;
/*!40000 ALTER TABLE `interest_location` DISABLE KEYS */;
INSERT INTO `interest_location` VALUES ('ssafy','서울특별시','종로구','평창동'),('ssafy','서울특별시','강남구','역삼동'),('coffee','서울특별시','관악구','봉천동'),('coffee','서울특별시','관악구','신림동'),('coffee','서울특별시','관악구','남현동'),('dngus','서울특별시','관악구','남현동'),('dngus','서울특별시','관악구','봉천동'),('gusrud','서울특별시','관악구','봉천동'),('noknok','서울특별시','관악구','봉천동'),('ruddn','서울특별시','관악구','봉천동'),('tjddn','서울특별시','관악구','봉천동'),('wonsue','서울특별시','관악구','봉천동'),('tjddn','서울특별시','관악구','신림동'),('wnsdud','서울특별시','관악구','신림동'),('wonsue','서울특별시','관악구','신림동'),('gusrud','서울특별시','서초구','방배동'),('note23','서울특별시','서초구','방배동'),('rlwjd','서울특별시','서초구','방배동'),('tjddn','서울특별시','서초구','방배동'),('altjs','서울특별시','광진구','자양동'),('ssafy2','서울특별시','광진구','자양동'),('wnsdud','서울특별시','광진구','자양동'),('wonsue','서울특별시','광진구','자양동'),('admin','서울특별시','종로구','평창동'),('','','',''),('','','',''),('','','',''),('admin','서울특별시','종로구','필운동'),('admin','서울특별시','종로구','행촌동'),('admin','서울특별시','종로구','홍파동'),('admin','서울특별시','종로구','창신동'),('admin','서울특별시','종로구','창신동'),('admin','서울특별시','종로구','창신동'),('admin','서울특별시','종로구','창신동'),('admin','서울특별시','종로구','창신동'),('admin','서울특별시','종로구','창신동'),('admin','서울특별시','강남구','대치동'),('admin','서울특별시','강남구','대치동'),('admin','서울특별시','강남구','논현동'),('admin','서울특별시','동작구','상도동'),('admin','서울특별시','동작구','신대방동'),('admin','서울특별시','동작구','신대방동'),('wonsik','서울특별시','관악구','신림동'),('wonsik','서울특별시','관악구','봉천동'),('wonsik','서울특별시','금천구','시흥동'),('wonsik','서울특별시','관악구','신림동'),('admin','서울특별시','관악구','봉천동'),('admin','서울특별시','관악구','신림동'),('admin','서울특별시','관악구','신림동');
/*!40000 ALTER TABLE `interest_location` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-26  2:55:58
