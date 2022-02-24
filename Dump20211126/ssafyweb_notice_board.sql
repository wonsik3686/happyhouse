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
-- Table structure for table `notice_board`
--

DROP TABLE IF EXISTS `notice_board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `notice_board` (
  `articleno` int NOT NULL AUTO_INCREMENT,
  `userid` varchar(16) DEFAULT NULL,
  `subject` varchar(100) DEFAULT NULL,
  `content` varchar(2000) DEFAULT NULL,
  `hit` int DEFAULT '0',
  `regtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`articleno`),
  KEY `question_to_member_fk` (`userid`),
  CONSTRAINT `notice_to_member_fk` FOREIGN KEY (`userid`) REFERENCES `ssafy_member` (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notice_board`
--

LOCK TABLES `notice_board` WRITE;
/*!40000 ALTER TABLE `notice_board` DISABLE KEYS */;
INSERT INTO `notice_board` VALUES (13,'admin','[공지사항] 해피하우스 이용약관 변경 사전 안내','안녕하세요. 해피하우스 운영팀입니다. \n항상 해피하우스 이용해주시는 회원 여러분께 감사 드리며, 새로운 이용약관 시행에 관한 안내 말씀 드립니다.\n\n오는 30일부터 만 14세 미만 사용자는 다방 신규 회원가입이 불가하며, 기존 회원 중에도 만 14세 미만 사용자는 서비스 이용계약이 해지될 수 있습니다.\n\n새롭게 바뀌는 이용약관의 변경사항을 확인하시어 서비스 이용에 참고해 주시기 바랍니다.',1,'2021-11-25 00:38:09'),(14,'admin','[공지사항] 해피하우스 허위매물 예방 5계명 안내','해피하우스 허위매물 예방 5계명 안내',0,'2021-11-25 00:38:40'),(15,'admin','[공지사항] 해피하우스 개인정보 처리방침 주요 개정사항(VER1.5)에 대한 안내 말씀드립니다',' 개인정보보호법, 정보통신망 이용촉진 및 정보보호 등에 관한 법률 등 정보통신서비스 관련 법규상의 개인정보보호 규정을 준수하며, 관련 법령에 의거한 개인정보처리방침을 정하여 사용자 권익 보호를 위해 노력하고 있습니다.',0,'2021-11-25 00:39:11'),(16,'admin','[공지사항] LH 마이홈포털 공공임대주택 정보 제공 안내','주택 정보를 자세히 보기를 원하시면 클릭 시\n소재지, 모집호수 등 상세 정보가 담긴 안내페이지가 뜨며\n입주자모집공고로 바로 연결되는 마이홈포털 URL도 제공됩니다.\n\n앞으로도 고객님들의 주거 정보를 보다 다양하게 제공할 수 있도록 노력하겠습니다.\n\n감사합니다.',0,'2021-11-25 00:39:31'),(17,'admin','[공지사항] 해피하우스 개인정보 처리방침 개정 안내',' 개인정보보호법, 정보통신망 이용촉진 및 정보보호 등에 관한 법률 등 정보통신서비스 관련 법규상의 개인정보 보호 규정을 준수하며, 관련 법령에 의거한 개인정보처리방침을 정하여 사용자의 권익 보호를 위해 노력하고 있습니다.\n\n아래와 같이 개인정보처리방침 개정될 예정임을 안내드리오니, 확인 후 이용에 참고하시기 바랍니다.',2,'2021-11-25 00:39:46'),(18,'admin','[공지사항] 부동산거래현황 통계 정정',' 2014년 1월부터 10월까지 부동산 거래관리시스템에 접수된 외국인거래 일부가 부동산거래현황 통계에 누락되어 정정하였으니 통계활용에 참고하시기 바랍니다.\n\n\n\n  세부문의 사항은 통계생산기관(053-663-8524)으로 연락해주시기 바랍니다.',0,'2021-11-25 00:44:19'),(19,'admin','[공지사항] 홈페이지 오픈 개선의견 이벤트 당첨자 발표','홈페이지 오픈 개선의견 이벤트 당첨자를 발표합니다.\n당첨자분들께는 개별적으로 연락을 드려 소정의 선물을 제공할 예정입니다.\n다시 한 번 감사의 말씀을 드립니다.\n\n[당첨자명단]\n김복* 010-2351-****\n문형* 010-9386-****\n김상* 010-5463-****\n김동* 010-7321-****\n안광* 010-8389-****\n유명* 010-3432-****\n황소* 010-4115-****\n이기* 010-7292-****\n안익* 010-3655-****\n신우* 010-5597-****\n김민* 010-9762-****\n백종* 010-2224-****\n고준* 010-4353-****',0,'2021-11-25 00:44:56'),(20,'admin','[공지사항] 실거래 데이터 07월 31일자 기준 업데이트 안내','언제 어디서든 전국 토지·건물 실거래가와 매물을\n한 번에 확인할 수 있는 \'실거래가 조회\' 서비스의\n실거래 데이터가 2021년 07월 31일자 기준으로 \n반영되었습니다.',0,'2021-11-25 00:46:24'),(21,'admin','[공지사항] 실거래 데이터 08월 15일자 기준 업데이트 안내','언제 어디서든 전국 토지·건물 실거래가와 매물을\n한 번에 확인할 수 있는 \'실거래가 조회\' 서비스의\n실거래 데이터가 2021년 08월 15일자 기준으로 \n반영되었습니다.',0,'2021-11-25 00:46:42'),(22,'admin',' [공지사항] 해피하우스 이용약관 변경 사전 안내',' ',0,'2021-11-25 00:53:03'),(23,'admin','[공지사항] 해피하우스 개인정보 처리방침 개정 안내',' ',2,'2021-11-25 00:53:24');
/*!40000 ALTER TABLE `notice_board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-11-26  2:55:59
