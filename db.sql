-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: soft
-- ------------------------------------------------------
-- Server version	8.0.29

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `building` (
  `building_id` int NOT NULL,
  `building_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`building_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `building`
--

LOCK TABLES `building` WRITE;
/*!40000 ALTER TABLE `building` DISABLE KEYS */;
INSERT INTO `building` VALUES (1,'1号教学楼'),(2,'2号教学楼');
/*!40000 ALTER TABLE `building` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `class_room`
--

DROP TABLE IF EXISTS `class_room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `class_room` (
  `room_id` int NOT NULL,
  `room_name` varchar(255) DEFAULT NULL,
  `student_num` varchar(255) DEFAULT NULL,
  `floor_num` varchar(255) DEFAULT NULL,
  `building_id` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_room`
--

LOCK TABLES `class_room` WRITE;
/*!40000 ALTER TABLE `class_room` DISABLE KEYS */;
INSERT INTO `class_room` VALUES (101,'一号楼一楼1教','50','1',1,'1'),(102,'一号楼一楼2教','50','1',1,'1'),(103,'一号楼一楼3教','50','1',1,'1'),(104,'一号楼一楼4教','50','1',1,'0'),(105,'一号楼二楼1教','50','2',1,'1'),(106,'一号楼二楼2教','50','2',1,'1'),(107,'一号楼二楼3教','50','2',1,'0'),(108,'一号楼二楼4教','50','2',1,'0'),(109,'一号楼三楼1教','50','3',1,'0'),(110,'一号楼三楼2教','50','3',1,'0'),(111,'一号楼三楼3教','50','3',1,'1'),(112,'一号楼三楼4教','50','3',1,'1'),(113,'一号楼一楼走廊','0','1',1,'0'),(114,'一号楼二楼走廊','0','1',1,'0'),(115,'一号楼三楼走廊','0','1',1,'0'),(201,'二号楼一楼1教','50','1',2,'1'),(202,'二号楼一楼2教','50','1',2,'1'),(203,'二号楼一楼3教','50','1',2,'1'),(204,'二号楼一楼4教','50','1',2,'1'),(205,'二号楼二楼1教','50','2',2,'1'),(206,'二号楼二楼2教','50','2',2,'1'),(207,'二号楼二楼3教','50','2',2,'0'),(208,'二号楼二楼4教','50','2',2,'0'),(209,'二号楼三楼1教','50','3',2,'0'),(210,'二号楼三楼2教','50','3',2,'0'),(211,'二号楼三楼3教','50','3',2,'0'),(212,'二号楼三楼4教','50','3',2,'0'),(213,'二号楼一楼走廊','0','1',2,'0'),(214,'二号楼二楼走廊','0','1',2,'0'),(215,'二号楼三楼走廊','0','1',2,'0');
/*!40000 ALTER TABLE `class_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` int NOT NULL,
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course_time_start` datetime DEFAULT NULL,
  `class_id` int DEFAULT NULL,
  `teacher_id` int DEFAULT NULL,
  `course_time_end` datetime DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `class_id` (`class_id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `class_id` FOREIGN KEY (`class_id`) REFERENCES `sclass` (`class_id`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `teacher_id` FOREIGN KEY (`teacher_id`) REFERENCES `teacher` (`teacher_id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'单片机应用','2024-02-19 13:00:00',1,88,'2024-02-19 23:00:00',101),(2,'数字逻辑','2024-02-19 13:00:00',2,2,'2024-02-19 23:00:00',102),(3,'大学体育','2024-02-19 13:00:00',3,10,'2024-02-19 23:00:00',103),(4,'大学物理','2024-02-19 13:00:00',4,5,'2024-02-19 23:00:00',105),(5,'JavaWeb','2024-02-19 13:00:00',5,82,'2024-02-19 23:00:00',106),(6,'MySQL数据库','2024-02-19 13:00:00',6,1,'2024-02-19 23:00:00',201),(7,'计算机网络','2024-02-19 13:00:00',7,7,'2024-02-19 23:00:00',111),(8,'计算机组成原理','2024-02-19 13:00:00',8,8,'2024-02-19 23:00:00',112),(9,'离散数学','2024-02-19 13:00:00',9,9,'2024-02-19 23:00:00',202),(10,'高等数学','2024-02-19 13:00:00',10,10,'2024-02-19 23:00:00',203),(11,'大学英语二','2024-02-19 13:00:00',11,11,'2024-02-19 23:00:00',204),(12,'大学英语三','2024-02-19 13:00:00',12,12,'2024-02-19 23:00:00',205),(13,'高等数学二','2024-02-19 13:00:00',13,13,'2024-02-19 23:00:00',206);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `device_id` int NOT NULL,
  `device_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `device_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `device_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  `building_id` int DEFAULT NULL,
  `floor_num` int DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'一号楼一楼1教灯光','0','1',101,1,1),(2,'一号楼一楼2教灯光','0','0',102,1,1),(3,'一号楼一楼3教灯光','0','0',103,1,1),(4,'一号楼一楼4教灯光','0','0',104,1,1),(5,'一号楼二楼1教灯光','0','1',105,1,2),(6,'一号楼二楼2教灯光','0','0',106,1,2),(7,'一号楼二楼3教灯光','0','0',107,1,2),(8,'一号楼二楼4教灯光','0','0',108,1,2),(9,'一号楼三楼1教灯光','0','0',109,1,3),(10,'一号楼三楼2教灯光','0','0',110,1,3),(11,'一号楼三楼3教灯光','0','0',111,1,3),(12,'一号楼三楼4教灯光','0','0',112,1,3),(13,'二号楼一楼1教灯光','0','1',201,2,1),(14,'二号楼一楼2教灯光','0','0',202,2,1),(15,'二号楼一楼3教灯光','0','0',203,2,1),(16,'二号楼一楼4教灯光','0','0',204,2,1),(17,'二号楼二楼1教灯光','0','0',205,2,2),(18,'二号楼二楼2教灯光','0','0',206,2,2),(19,'二号楼二楼3教灯光','0','0',207,2,2),(20,'二号楼二楼4教灯光','0','0',208,2,2),(21,'二号楼三楼1教灯光','0','0',209,2,3),(22,'二号楼三楼2教灯光','0','0',210,2,3),(23,'二号楼三楼3教灯光','0','0',211,2,3),(24,'二号楼三楼4教灯光','0','0',212,2,3),(25,'一号楼一楼走廊灯光','0','0',113,1,1),(26,'一号楼二楼走廊灯光','0','0',114,1,2),(27,'一号楼三楼走廊灯光','0','0',115,1,3),(28,'二号楼一楼走廊灯光','0','0',213,2,1),(29,'二号楼二楼走廊灯光','0','0',214,2,2),(30,'二号楼三楼走廊灯光','0','0',215,2,3),(31,'一号楼一楼1教大门','1','0',101,1,1),(32,'一号楼一楼2教大门','1','0',102,1,1),(33,'一号楼一楼3教大门','1','1',103,1,1),(34,'一号楼一楼4教大门','1','1',104,1,1),(35,'一号楼二楼1教大门','1','0',105,1,2),(36,'一号楼二楼2教大门','1','0',106,1,2),(37,'一号楼二楼3教大门','1','0',107,1,2),(38,'一号楼二楼4教大门','1','0',108,1,2),(39,'一号楼三楼1教大门','1','0',109,1,3),(40,'一号楼三楼2教大门','1','0',110,1,3),(41,'一号楼三楼3教大门','1','0',111,1,3),(42,'一号楼三楼4教大门','1','0',112,1,3),(43,'二号楼一楼1教大门','1','0',201,2,1),(44,'二号楼一楼2教大门','1','0',202,2,1),(45,'二号楼一楼3教大门','1','0',203,2,1),(46,'二号楼一楼4教大门','1','0',204,2,1),(47,'二号楼二楼1教大门','1','0',205,2,2),(48,'二号楼二楼2教大门','1','0',206,2,2),(49,'二号楼二楼3教大门','1','0',207,2,2),(50,'二号楼二楼4教大门','1','0',208,2,2),(51,'二号楼三楼1教大门','1','0',209,2,3),(52,'二号楼三楼2教大门','1','0',210,2,3),(53,'二号楼三楼3教大门','1','0',211,2,3),(54,'二号楼三楼4教大门','1','0',212,2,3),(55,'一号楼一楼正门','1','0',113,1,1),(56,'一号楼一楼侧门','1','0',113,1,1),(57,'一号楼一楼后门','1','0',113,1,1),(58,'二号楼一楼正门','1','0',213,2,1),(59,'二号楼一楼侧门','1','0',213,2,1),(60,'二号楼一楼后门','1','0',213,2,1),(61,'一号楼一楼消防栓','2','0',113,1,1),(62,'一号楼二楼消防栓','2','2',114,1,2),(63,'一号楼三楼消防栓','2','0',115,1,3),(64,'二号楼一楼消防栓','2','2',213,2,1),(65,'二号楼二楼消防栓','2','0',214,2,2),(66,'二号楼三楼消防栓','2','0',215,2,3);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sclass`
--

DROP TABLE IF EXISTS `sclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sclass` (
  `class_id` int NOT NULL,
  `class_name` varchar(255) DEFAULT NULL,
  `class_num` int DEFAULT NULL,
  `class_counselor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sclass`
--

LOCK TABLES `sclass` WRITE;
/*!40000 ALTER TABLE `sclass` DISABLE KEYS */;
INSERT INTO `sclass` VALUES (1,'计算机1201',50,'丁启航'),(2,'计算机1202',40,'丁启航'),(3,'计算机1203',35,'丁启航'),(4,'计算机1204',50,'丁启航'),(5,'计算机1205',5,'丁启航'),(6,'软件1201',28,'张三'),(7,'软件1202',28,'李四'),(8,'软件1203',28,'王五'),(9,'软件1204',28,'赵六'),(10,'软件1205',28,'孙七'),(11,'软件1206',28,'周八'),(12,'软件1207',28,'吴九'),(13,'物联网1201',35,'端坤坤'),(14,'物联网1202',55,'端坤坤'),(15,'物联网1203',24,'端坤坤'),(16,'物联网1204',38,'端坤坤'),(17,'物联网1205',29,'端坤坤'),(18,'物联网1206',57,'端坤坤');
/*!40000 ALTER TABLE `sclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `staff_id` int NOT NULL,
  `staff_tel` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `staff_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `staff_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `staff_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `building_id` int DEFAULT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `teacher_id` int NOT NULL,
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `teacher_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `teacher_tel` varchar(255) DEFAULT NULL,
  `teacher_age` int DEFAULT NULL,
  `teacher_academy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'李文彦','专家骨干','12345678944',20,'信息工程学院'),(2,'刘春燕','专家骨干','12345678955',20,'信息工程学院'),(3,'苏永红','专业教师','12345678977',20,'信息工程学院'),(4,'薛霞','专业教师','12345678944',20,'信息工程学院'),(5,'彭贝贝','辅导员','12345688888',20,'信息工程学院'),(6,'丁启航','辅导员','12345677777',20,'信息工程学院'),(7,'李凌','产业教授','12345678944',20,'信息工程学院'),(8,'兰自力','专家骨干','12345678945',20,'体育学院'),(9,'赵燕','专家骨干','12365478955',20,'体育学院'),(10,'吴飞','专业教师','12345678901',20,'体育学院'),(11,'刘涛','专业教师','12345678902',20,'体育学院'),(12,'付炜','实验教师','12345678904',20,'体育学院'),(13,'闫成龙','实验教师','12345678905',20,'体育学院'),(14,'臧守相','辅导员','12345678906',20,'体育学院'),(15,'李连国','辅导员','12345678907',20,'体育学院'),(16,'陈戬','辅导员','12345678908',20,'体育学院'),(17,'程艳霞','专家骨干','12345678908',20,'商学院'),(18,'王虎','专家骨干','12345678909',20,'商学院'),(19,'胡华夏','专家骨干','12345678910',20,'商学院'),(20,'朱金生','专家骨干','12345678911',20,'商学院'),(21,'李琼','专业教师','12345678912',20,'商学院'),(22,'蔡奎','专业教师','12345678913',20,'商学院'),(23,'林波','专业教师','12345678914',20,'商学院'),(24,'严婷婷','专业教师','12345678915',20,'商学院'),(25,'郭伟奇','实验教师','12345678916',20,'商学院'),(26,'熊小芬','实验教师','12345678917',20,'商学院'),(27,'杨杰','实验教师','12345678918',20,'商学院'),(28,'万雷浩','实验教师','12345678919',20,'商学院'),(29,'孙文胜','辅导员','12345678920',20,'商学院'),(30,'潘晶','辅导员','12345678921',20,'商学院'),(31,'刘浩波','辅导员','12345678922',20,'商学院'),(32,'王雅洁','辅导员','12345678923',20,'商学院'),(33,'张玉纯','辅导员','12345678924',20,'商学院'),(34,'李思谋','辅导员','12345678925',20,'商学院'),(35,'刘沛','教授','12345678926',20,'外国语学院'),(36,'王革','三级教授','12345678927',20,'外国语学院'),(37,'杨剑瑞','三级教授','12345678928',20,'外国语学院'),(38,'王春艳','专业教师','12345678929',20,'外国语学院'),(39,'王丽丽','专业教师','12345678930',20,'外国语学院'),(40,'陈晶','专业教师','12345678931',20,'外国语学院'),(41,'曹永波','专业教师','12345678932',20,'外国语学院'),(42,'陈晶','专业教师','12345678933',20,'外国语学院'),(43,'席颖','实验教师','12345678934',20,'外国语学院'),(44,'余世浩','专家骨干','12345678935',20,'智能制造学院'),(45,'刘凯','专家骨干','12345678936',20,'智能制造学院'),(46,'陈国良','专家骨干','12345678937',20,'智能制造学院'),(47,'刘维','专家骨干','12345678938',20,'智能制造学院'),(48,'陈全','专业教师','12345678939',20,'智能制造学院'),(49,'欧阳文凯','专业教师','12345678940',20,'智能制造学院'),(50,'黄英','专业教师','12345678941',20,'智能制造学院'),(51,'王睿','专业教师','12345678942',20,'智能制造学院'),(52,'熊映','专业教师','12345678943',20,'智能制造学院'),(53,'刘颖莹','专业教师','12345678944',20,'智能制造学院'),(54,'王建美','专业教师','12345678945',20,'智能制造学院'),(55,'刘成','实验教师','12345678946',20,'智能制造学院'),(56,'左艳迪','实验教师','12345678947',20,'智能制造学院'),(57,'向胜涛','辅导员','12345678948',20,'智能制造学院'),(58,'周丽华','辅导员','12345678949',20,'智能制造学院'),(59,'杨阳','辅导员','12345678950',20,'智能制造学院'),(60,'张哲','辅导员','12345678951',20,'智能制造学院'),(61,'路由','专家骨干','12345678952',20,'艺术设计与传媒学院'),(62,'李娇','专家骨干','12345678953',20,'艺术设计与传媒学院'),(63,'张天洁','专家骨干','12345678954',20,'艺术设计与传媒学院'),(64,'李娟','专业教师','12345678955',20,'艺术设计与传媒学院'),(65,'王晶','专业教师','12345678956',20,'艺术设计与传媒学院'),(66,'张天洁','专业教师','12345678957',20,'艺术设计与传媒学院'),(67,'刘丽娟','专业教师','12345678958',20,'艺术设计与传媒学院'),(68,'杨婷婷','专业教师','12345678959',20,'艺术设计与传媒学院'),(69,'张天洁','专业教师','12345678960',20,'艺术设计与传媒学院'),(70,'李娟','专业教师','12345678961',20,'艺术设计与传媒学院'),(71,'王晶','专业教师','12345678962',20,'艺术设计与传媒学院'),(72,'王旭龙','辅导员','12345678963',20,'艺术设计与传媒学院'),(73,'刘静','辅导员','12345678964',20,'艺术设计与传媒学院'),(74,'陈军','辅导员','12345678965',20,'艺术设计与传媒学院'),(75,'杨琦','辅导员','12345678966',20,'艺术设计与传媒学院'),(76,'陶帅','辅导员','12345678967',20,'艺术设计与传媒学院'),(77,'严虎','实验教师','12345678968',20,'艺术设计与传媒学院'),(78,'候国栋','实验教师','12345678969',20,'艺术设计与传媒学院'),(79,'傅强','高级实验师','12345678970',20,'艺术设计与传媒学院'),(80,'王密','实验教师','12345678971',20,'艺术设计与传媒学院'),(81,'王琳','实验教师','12345678972',20,'艺术设计与传媒学院'),(82,'苏永红','专业教师','12345678973',20,'信息工程学院'),(83,'张玉蓉','专业教师','12345678974',20,'信息工程学院'),(84,'王玉婷','专业教师','12345678975',20,'信息工程学院'),(85,'罗瑜','专业教师','12345678976',20,'信息工程学院'),(86,'钟学斌','专业教师','12345678977',20,'信息工程学院'),(87,'王海霞','专业教师','12345678978',20,'信息工程学院'),(88,'郭俊芳','专业教师','12345678979',20,'信息工程学院'),(89,'沈春阳','实验教师','12345678980',20,'信息工程学院'),(90,'徐国成','实验教师','12345678981',20,'信息工程学院'),(91,'熊俊','辅导员','12345678982',20,'信息工程学院'),(92,'李洋','辅导员','12345678983',20,'信息工程学院'),(93,'徐广','辅导员','12345678984',20,'信息工程学院'),(94,'张子扬','辅导员','12345678985',20,'信息工程学院');
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) CHARACTER SET utf8mb3 DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb3 DEFAULT NULL COMMENT '密码',
  `realname` varchar(255) CHARACTER SET utf8mb3 DEFAULT NULL COMMENT '真实姓名',
  `telphone` varchar(16) CHARACTER SET utf8mb3 DEFAULT NULL COMMENT '手机号',
  `email` varchar(255) CHARACTER SET utf8mb3 DEFAULT NULL COMMENT '邮箱地址',
  `img` varchar(1024) CHARACTER SET utf8mb3 DEFAULT NULL COMMENT '头像地址',
  `birthday` date DEFAULT NULL COMMENT '生日',
  `regtime` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `lastmodify` datetime DEFAULT NULL COMMENT '最后一次修改时间',
  `cardnum` char(18) CHARACTER SET utf8mb3 DEFAULT NULL COMMENT '身份证号',
  `status` tinyint(1) DEFAULT '0' COMMENT '用户状态0-正常  1-禁用',
  `salt` varchar(255) CHARACTER SET utf8mb3 DEFAULT NULL COMMENT '随机盐',
  `del` tinyint(1) DEFAULT '0' COMMENT '是否删除0-否  1-是，做逻辑删除用',
  `permission` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=sjis COMMENT='用户信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'tianbin','123456','田斌','13297011629',NULL,NULL,NULL,'2024-01-12 08:50:47',NULL,NULL,0,NULL,0,'0'),(2,'admin','admin','admin','13297011629',NULL,'','1999-07-12','2023-11-14 01:31:23',NULL,'42282820000712292X',0,NULL,0,'0'),(3,'xiaochen','123456','小陈','12345678911',NULL,NULL,NULL,'2023-12-28 09:48:25',NULL,'422828200007112695',0,NULL,0,'1'),(4,'mingri','123456','明日香','12345678910',NULL,NULL,NULL,'2024-01-22 03:02:45',NULL,'111111111111111111',0,NULL,0,'2');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-19 19:09:55
