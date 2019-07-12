-- MySQL dump 10.13  Distrib 5.7.26, for Linux (x86_64)
--
-- Host: localhost    Database: GUI
-- ------------------------------------------------------
-- Server version	5.7.26-0ubuntu0.19.04.1

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
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('admin','1111');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class`
--

DROP TABLE IF EXISTS `class`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `class` (
  `classId` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `collegeId` int(11) NOT NULL,
  PRIMARY KEY (`classId`),
  KEY `FK_class_college` (`collegeId`),
  CONSTRAINT `FK_class_college` FOREIGN KEY (`collegeId`) REFERENCES `college` (`collegeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class`
--

LOCK TABLES `class` WRITE;
/*!40000 ALTER TABLE `class` DISABLE KEYS */;
INSERT INTO `class` VALUES (1234,'中国一班',1111),(1906242044,'中国2班',1111),(1906242730,'其',1111),(1906242936,'造型',1111),(1906243127,'sss搜索',1111),(1906244736,'eef的',1111);
/*!40000 ALTER TABLE `class` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `college`
--

DROP TABLE IF EXISTS `college`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `college` (
  `collegeId` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`collegeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `college`
--

LOCK TABLES `college` WRITE;
/*!40000 ALTER TABLE `college` DISABLE KEYS */;
INSERT INTO `college` VALUES (1111,'智慧与体力学院'),(2222,'至上集团学院');
/*!40000 ALTER TABLE `college` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grade`
--

DROP TABLE IF EXISTS `grade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grade` (
  `gradeId` int(11) NOT NULL,
  `core` int(2) NOT NULL,
  `slId` int(11) NOT NULL,
  PRIMARY KEY (`gradeId`),
  KEY `FK_grade_sl` (`slId`),
  CONSTRAINT `FK_grade_sl` FOREIGN KEY (`slId`) REFERENCES `stuless` (`slId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grade`
--

LOCK TABLES `grade` WRITE;
/*!40000 ALTER TABLE `grade` DISABLE KEYS */;
INSERT INTO `grade` VALUES (142,0,4200),(742,0,4204),(1042,0,4208),(1342,0,4212),(2608,0,822),(2908,0,828),(3208,0,831),(3608,0,834),(3908,0,838),(29256,0,56286),(29756,0,56294),(30456,0,56302),(30956,0,56306),(31256,0,56311),(34142,0,42339),(34442,0,42342),(34942,0,42346),(35242,0,42350),(35442,0,42353),(93432,0,32932),(93932,99,32937),(94132,0,32940),(94532,0,32943),(94832,0,32946),(99841,0,41995);
/*!40000 ALTER TABLE `grade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lesson`
--

DROP TABLE IF EXISTS `lesson`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lesson` (
  `lessId` int(11) NOT NULL,
  `teaId` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  PRIMARY KEY (`lessId`),
  KEY `FK_less_tea` (`teaId`),
  CONSTRAINT `FK_less_tea` FOREIGN KEY (`teaId`) REFERENCES `teacher` (`teaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lesson`
--

LOCK TABLES `lesson` WRITE;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` VALUES (1,1,'2 '),(1123,1232,'111'),(1223,1232,'d副副'),(4565,1314,'他还和'),(34554,1314,'副法大赛');
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student` (
  `stuId` int(11) NOT NULL,
  `classId` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` varchar(5) DEFAULT NULL,
  `tel` int(11) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stuId`),
  KEY `FK_stu_class` (`classId`),
  CONSTRAINT `FK_stu_class` FOREIGN KEY (`classId`) REFERENCES `class` (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (334,1234,'2d','5','男',4,NULL,'3'),(1231,1906242044,'万人','4','女',1231,NULL,'123'),(1234,1906242044,'s的的','sss','nv',12342,NULL,'的风俗'),(3432,1906242936,'第三方法','4','男',111,NULL,'111'),(34434,1906242936,'dsf地方','4','晓东',111,NULL,'111'),(20176273,1234,'秦晓东','1234','女',112233,NULL,'1122333');
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stuless`
--

DROP TABLE IF EXISTS `stuless`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stuless` (
  `slId` int(11) NOT NULL,
  `stuId` int(11) NOT NULL,
  `lessId` int(11) NOT NULL,
  PRIMARY KEY (`slId`),
  KEY `FK_sl_s` (`stuId`),
  KEY `FK_sl_l` (`lessId`),
  CONSTRAINT `FK_sl_l` FOREIGN KEY (`lessId`) REFERENCES `lesson` (`lessId`),
  CONSTRAINT `FK_sl_s` FOREIGN KEY (`stuId`) REFERENCES `student` (`stuId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stuless`
--

LOCK TABLES `stuless` WRITE;
/*!40000 ALTER TABLE `stuless` DISABLE KEYS */;
INSERT INTO `stuless` VALUES (822,334,1223),(828,1231,1223),(831,1234,1223),(834,3432,1223),(838,34434,1223),(4200,1231,1),(4204,1234,1),(4208,3432,1),(4212,34434,1),(32932,334,34554),(32937,1231,34554),(32940,1234,34554),(32943,3432,34554),(32946,34434,34554),(41995,334,1),(42339,334,4565),(42342,1231,4565),(42346,1234,4565),(42350,3432,4565),(42353,34434,4565),(56286,334,1123),(56294,1231,1123),(56302,1234,1123),(56306,3432,1123),(56311,34434,1123);
/*!40000 ALTER TABLE `stuless` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `teacher` (
  `teaId` int(11) NOT NULL,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `sex` varchar(5) DEFAULT '男',
  `major` varchar(20) DEFAULT '中级教师',
  PRIMARY KEY (`teaId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'2','3','女','中级教师'),(1232,'搜索','1234','男','中级教师'),(1314,'ssf的的','223','男','中级教师'),(2123,'2岁的','1234','男','中级教师'),(8769,'阿四方','1234','男','中级教师'),(12345,'q等的','1234','男','中级教师'),(23453,'清代','1234','男','中级教师'),(65456,'黄河','1234','男','中级教师'),(20176364,'liuyi','1234','男','中级教师');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-26 14:58:05
