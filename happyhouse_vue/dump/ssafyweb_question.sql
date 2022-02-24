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
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `question` (
  `articleno` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(16) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `hit` int DEFAULT '0',
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleno`),
  KEY `question_to_member_fk` (`userid`),
  CONSTRAINT `question_to_member_fk` FOREIGN KEY (`userid`) REFERENCES `ssafy_member` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'ssafy','1번질문 제목??','1번질문 본문!!',0,'2021-11-21 20:30:04'),(2,'ssafy','2번질문 제목??','2번질문 본문!!',1,'2021-11-21 20:30:04'),(3,'admin','3번질문 제목??','3번질문 본문!!',1,'2021-11-21 20:30:04'),(4,'ssafy','4번질문 제목??','4번질문 본문!!22',13,'2021-11-21 20:30:04'),(5,'admin','질문?','내용',0,'2021-11-22 17:52:50'),(6,'admin','질문?','내용',0,'2021-11-22 17:52:52'),(7,'admin','질문?','내용',0,'2021-11-22 17:52:52'),(8,'admin','질문?','내용',0,'2021-11-22 17:52:53'),(9,'admin','질문?','내용',0,'2021-11-22 17:52:53'),(10,'admin','질문?','내용',0,'2021-11-22 17:52:54'),(11,'admin','질문?','내용',0,'2021-11-22 17:52:54'),(12,'admin','질문?','내용',0,'2021-11-22 17:52:54'),(13,'admin','질문?','내용',0,'2021-11-22 17:52:54'),(14,'admin','질문?','내용',0,'2021-11-22 17:52:55'),(15,'admin','질문?','내용',0,'2021-11-22 17:52:55'),(16,'admin','질문?','내용',0,'2021-11-22 17:52:55'),(17,'admin','질문?','내용',0,'2021-11-22 17:52:56'),(18,'admin','질문?','내용',0,'2021-11-22 17:52:56'),(19,'admin','질문?','내용',0,'2021-11-22 17:59:21'),(20,'admin','질문?','내용',0,'2021-11-22 17:59:21'),(21,'admin','질문?','내용',0,'2021-11-22 17:59:21'),(22,'admin','질문?','내용',0,'2021-11-22 17:59:22'),(23,'admin','질문?','내용',0,'2021-11-22 17:59:22'),(24,'admin','질문?','내용',0,'2021-11-22 17:59:22'),(25,'admin','질문?','내용',1,'2021-11-22 17:59:23'),(26,'admin','질문?','내용',0,'2021-11-22 17:59:23'),(27,'admin','질문?','내용',0,'2021-11-22 17:59:23'),(28,'admin','질문?','내용',1,'2021-11-22 17:59:23'),(29,'admin','질문?','내용',1,'2021-11-22 17:59:25'),(30,'admin','질문?','내용',0,'2021-11-22 17:59:26'),(31,'admin','질문?','내용',2,'2021-11-22 17:59:26');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-24 16:24:48
