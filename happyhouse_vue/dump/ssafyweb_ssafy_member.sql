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
-- Table structure for table `ssafy_member`
--

DROP TABLE IF EXISTS `ssafy_member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ssafy_member` (
  `userid` varchar(16) NOT NULL,
  `username` varchar(20) NOT NULL,
  `userpwd` varchar(16) NOT NULL,
  `email` varchar(20) DEFAULT NULL,
  `joindate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isAdmin` varchar(4) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `age` int NOT NULL,
  `country` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `aboutme` varchar(200) DEFAULT NULL,
  `job` varchar(45) NOT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ssafy_member`
--

LOCK TABLES `ssafy_member` WRITE;
/*!40000 ALTER TABLE `ssafy_member` DISABLE KEYS */;
INSERT INTO `ssafy_member` VALUES ('','정원식','123456','dnjstlr@naver.com','2021-11-22 05:02:16',NULL,'01022323',27,'England','london','sfsfsdf','mechanic'),('admin','관리자22','admin','admin@ssafy.com','2021-11-21 20:30:04','y',NULL,0,'','',NULL,'-'),('altjs','김미선','123456','altjs@naver.com','2021-11-22 21:28:35',NULL,'010443234342',23,'대한민국','서울','안녕하세요 반갑습니다.','판매 종사자'),('coffee','김커피','123456','coffee@gmail.com','2021-11-22 21:25:23',NULL,'0103434385',35,'대한민국','경기도','경기도에서 카페 운영하고 있습니다.','서비스 종사자'),('dngus','김우현','123456','dngus@naver.com','2021-11-22 21:28:03',NULL,'01044443333',29,'대한민국','인천','안녕하세요 반갑습니다.','사무 종사자'),('gusrud','김현경','123456','gusrud@naver.com','2021-11-22 21:29:22',NULL,'01044448888',38,'대한민국','서울','안녕하세요 반갑습니다.','서비스 종사자'),('noknok','박녹','123456','nok@naver.com','2021-11-22 21:26:10',NULL,'0103333888',31,'대한민국','서울','안녕하세요 반갑습니다.','전문가 및 관련 종사자'),('note23','김노트','123456','note@naver.com','2021-11-22 21:27:04',NULL,'01044443333',43,'대한민국','경기도','안녕하세요 반갑습니다.','판매 종사자'),('rlwjd','문기정','123456','sfsadf@naver.com','2021-11-22 21:31:45',NULL,'01043332655',54,'대한민국','서울','안녕하세요 반갑습니다.','전문가 및 관련 종사자'),('ruddn','민경우','123456','ruddn@naver.com','2021-11-22 21:30:35',NULL,'01044443333',32,'대한민국','경기도','안녕하세요 반갑습니다.','기능원 및 관련 기능 종사자'),('ssafy','김싸피','ssafy','ssafy@ssafy.com','2021-11-21 20:30:04','',NULL,0,'','',NULL,'-'),('ssafy2','김싸피','123456','daf@naver.com','2021-11-22 21:23:08',NULL,'01034343434',28,'대한민국','서울','안녕하세요','전문가 및 관련 종사자'),('tjddn','강성우','123456','tjddn@naver.com','2021-11-22 21:30:01',NULL,'01044443222',37,'대한민국','경기도','안녕하세요 반갑습니다.','전문가 및 관련 종사자'),('wnsdud','박준영','123456','wnsdud@gmail.com','2021-11-22 21:31:09',NULL,'0104332234',28,'대한민국','인천','안녕하세요 반갑습니다.','전문가 및 관련 종사자'),('wonsik','정원식','123456','wonsik@gmail.com','2021-11-21 21:06:57',NULL,'01011112222',27,'Republic of Korea','Incheon','ssafy java 트랙에서 공부중인 취준생입니다.','student'),('wonsue','원슈','123456','won@naver.com','2021-11-22 20:56:15',NULL,'01022224444',28,'대한민국','서울','안녕하세요 반갑습니다.','학생');
/*!40000 ALTER TABLE `ssafy_member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-24 16:24:50
