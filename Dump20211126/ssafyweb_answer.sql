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
-- Table structure for table `answer`
--

DROP TABLE IF EXISTS `answer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `answer` (
  `articleno` int NOT NULL,
  `userid` varchar(16) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `hit` int DEFAULT '0',
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleno`),
  KEY `answer_to_member_fk` (`userid`),
  CONSTRAINT `answer_ibfk_1` FOREIGN KEY (`articleno`) REFERENCES `question` (`articleno`),
  CONSTRAINT `answer_to_member_fk` FOREIGN KEY (`userid`) REFERENCES `ssafy_member` (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answer`
--

LOCK TABLES `answer` WRITE;
/*!40000 ALTER TABLE `answer` DISABLE KEYS */;
INSERT INTO `answer` VALUES (33,'admin','허위매물 전담팀이 수시로 매물을 살펴보고 허위매물을 필터링하고 있습니다.\n\n▶ 지역구별 평균 시세를 파악해 시세에 비해 확연히 저렴한 매물이나 실사진이 아닌 사진이 포함된 경우 직접 연락을 취해 정보 수정을 요청합니다. \n\n▶ 광고 기간이 30일이 지난 매물의 경우 자동으로 비공개 처리하여 계약이 완료된 매물의 노출 가능성을 줄였고, 내부 규정에 따라 경고 및 서비스 이용 제재를 부과하고 있습니다.\n\n▶ 사용자가 직접 허위매물을 신고할 수 있도록 관련 제도를 마련하여 다방면에서 허위매물 ZERO를 위한 노력을 기울이고 있습니다.',0,'2021-11-25 00:35:26'),(34,'admin','개인회원의 경우 직거래 매물 1건에 대해 무료 광고가 가능합니다. \n광고는 30일 간 공개 되며 기간이 지날 경우 비공개처리됩니다. \n비공개된 매물은 수정하여 다시 노출할 수 있습니다.',0,'2021-11-25 00:35:46'),(35,'admin','해피하우스 회원탈퇴를 원하실 경우\n\n▶ 해피하우스의 ‘회원 프로필’ 메뉴에서 ‘정보수정’으로 이동 후 화면 하단에 \'회원탈퇴\'를 탭하시면 탈퇴가 가능합니다.',0,'2021-11-25 00:36:26'),(36,'admin','해피하우스에 회원가입 후 로그인을 하시면 \n\n▶ ‘관심목록\'의 내용을 안전하게 저장! \n원룸, 투∙쓰리룸, 오피스텔∙도시형생활주택 등 다양한 매물을 살펴보는 과정에서 매물을 조회하고 찜한 내역이 무제한으로 쌓이는 ‘관심목록\'의 내용을 PC와 모바일에서 동일하게 확인할 수 있습니다. 또한 앱 업데이트 시에도 그 내용이 그대로 유지됩니다. ',0,'2021-11-25 00:36:53');
/*!40000 ALTER TABLE `answer` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-26  2:56:00
