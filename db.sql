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
-- Table structure for table `affair`
--

DROP TABLE IF EXISTS `affair`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `affair` (
  `affair_id` int NOT NULL AUTO_INCREMENT,
  `affair_time` datetime DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `record_user_id` int DEFAULT NULL,
  `affair_type` varchar(255) DEFAULT NULL,
  `affair_type_id` int DEFAULT NULL,
  PRIMARY KEY (`affair_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affair`
--

LOCK TABLES `affair` WRITE;
/*!40000 ALTER TABLE `affair` DISABLE KEYS */;
INSERT INTO `affair` VALUES (1,'2024-03-08 13:34:51','一号楼二楼3教教室需要维修',1,'1',107),(3,'2024-03-08 13:50:39','上课时间为2024-03-08 14:00:00的计算机导论课程信息更新',1,'4',19),(4,'2024-03-08 13:51:37','一号楼二楼3教教室维修完成',1,'1',107),(5,'2024-03-08 16:10:36','一号楼一楼1教灯光设备需要维修',1,'0',1),(6,'2024-03-08 17:39:02','上课时间为2024-03-08 17:00:00的测试啦课程信息添加',1,'4',36),(7,'2024-03-08 18:44:03','一号楼一楼1教灯光设备维修完成',1,'0',1);
/*!40000 ALTER TABLE `affair` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `building`
--

DROP TABLE IF EXISTS `building`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `building` (
  `building_id` int NOT NULL AUTO_INCREMENT,
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
  `room_id` int NOT NULL AUTO_INCREMENT,
  `room_name` varchar(255) DEFAULT NULL,
  `student_num` varchar(255) DEFAULT NULL,
  `floor_num` varchar(255) DEFAULT NULL,
  `building_id` int DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `position_model` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`room_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `class_room`
--

LOCK TABLES `class_room` WRITE;
/*!40000 ALTER TABLE `class_room` DISABLE KEYS */;
INSERT INTO `class_room` VALUES (101,'一号楼一楼1教','0','1',1,'0','door-left-l1-class1'),(102,'一号楼一楼2教','0','1',1,'0','door-left-l1-class2'),(103,'一号楼一楼3教','0','1',1,'0','door-left-l1-class3'),(104,'一号楼一楼4教','0','1',1,'0','door-left-l1-class4'),(105,'一号楼二楼1教','0','2',1,'0','door-left-l2-class1'),(106,'一号楼二楼2教','0','2',1,'0','door-left-l2-class2'),(107,'一号楼二楼3教','0','2',1,'0','door-left-l2-class3'),(108,'一号楼二楼4教','0','2',1,'0','door-left-l2-class4'),(109,'一号楼三楼1教','0','3',1,'0','door-left-l3-class1'),(110,'一号楼三楼2教','0','3',1,'0','door-left-l3-class2'),(111,'一号楼三楼3教','0','3',1,'0','door-left-l3-class3'),(112,'一号楼三楼4教','0','3',1,'0','door-left-l3-class4'),(113,'一号楼一楼走廊','0','1',1,'0',NULL),(114,'一号楼二楼走廊','0','1',1,'0',NULL),(115,'一号楼三楼走廊','0','1',1,'0',NULL),(201,'二号楼一楼1教','0','1',2,'0','door-right-l1-class1'),(202,'二号楼一楼2教','0','1',2,'0','door-right-l1-class2'),(203,'二号楼一楼3教','0','1',2,'0','door-right-l1-class3'),(204,'二号楼一楼4教','0','1',2,'0','door-right-l1-class4'),(205,'二号楼二楼1教','0','2',2,'0','door-right-l2-class1'),(206,'二号楼二楼2教','0','2',2,'0','door-right-l2-class2'),(207,'二号楼二楼3教','0','2',2,'0','door-right-l2-class3'),(208,'二号楼二楼4教','0','2',2,'0','door-right-l2-class4'),(209,'二号楼三楼1教','0','3',2,'0','door-right-l3-class1'),(210,'二号楼三楼2教','0','3',2,'0','door-right-l3-class2'),(211,'二号楼三楼3教','0','3',2,'0','door-right-l3-class3'),(212,'二号楼三楼4教','0','3',2,'0','door-right-l3-class4'),(213,'二号楼一楼走廊','0','1',2,'0',NULL),(214,'二号楼二楼走廊','0','1',2,'0',NULL),(215,'二号楼三楼走廊','0','1',2,'0',NULL);
/*!40000 ALTER TABLE `class_room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `course`
--

DROP TABLE IF EXISTS `course`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `course` (
  `course_id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `course_time_start` datetime DEFAULT NULL,
  `class_id` int DEFAULT NULL,
  `teacher_id` int DEFAULT NULL,
  `course_time_end` datetime DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  PRIMARY KEY (`course_id`),
  KEY `class_id` (`class_id`),
  KEY `teacher_id` (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `course`
--

LOCK TABLES `course` WRITE;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` VALUES (1,'数字逻辑','2024-03-09 13:00:00',1,3,'2024-03-09 14:00:00',105),(2,'高等数学','2024-03-09 13:00:00',10,28,'2024-03-09 14:00:00',102),(3,'单片机应用','2024-03-09 13:00:00',14,65,'2024-03-09 14:00:00',103),(5,'JavaWeb','2024-03-09 13:00:00',5,82,'2024-03-09 14:00:00',106),(6,'MySQL数据库','2024-03-09 13:00:00',6,1,'2024-03-09 14:00:00',201),(7,'计算机网络','2024-03-09 13:00:00',7,7,'2024-03-09 14:00:00',111),(8,'计算机组成原理','2024-03-09 13:00:00',8,8,'2024-03-09 14:00:00',112),(9,'离散数学','2024-03-09 13:00:00',9,9,'2024-03-09 14:00:00',202),(10,'高等数学','2024-03-09 13:00:00',10,10,'2024-03-09 14:00:00',203),(11,'大学英语二','2024-03-09 13:00:00',11,11,'2024-03-09 14:00:00',204),(12,'大学英语三','2024-03-09 13:00:00',12,12,'2024-03-09 14:00:00',205),(13,'高等数学二','2024-03-09 13:00:00',13,13,'2024-03-09 14:00:00',206),(14,'单片机应用','2024-03-09 13:00:00',1,88,'2024-03-09 14:00:00',208),(15,'数字逻辑','2024-03-09 13:00:00',2,5,'2024-03-09 14:00:00',101),(18,'离散数学','2024-03-09 14:00:00',8,28,'2024-03-09 15:00:00',111),(19,'计算机导论','2024-03-09 14:00:00',12,25,'2024-03-09 15:00:00',102),(20,'数据结构','2024-03-09 14:00:00',1,2,'2024-03-09 15:00:00',201),(21,'嵌入式技术','2024-03-09 14:00:00',2,4,'2024-03-09 15:00:00',205),(22,'计算机网络','2024-03-09 14:00:00',3,5,'2024-03-09 15:00:00',105),(23,'线性代数','2024-03-09 14:00:00',4,37,'2024-03-09 15:00:00',206),(24,'线性代数','2024-03-09 14:00:00',5,33,'2024-03-09 15:00:00',112),(25,'大学英语','2024-03-09 15:00:00',6,34,'2024-03-09 16:00:00',108),(27,'大学英语','2024-03-09 15:00:00',3,23,'2024-03-09 16:00:00',101),(28,'Java程序设计','2024-03-09 16:00:00',5,74,'2024-03-09 17:00:00',101),(29,'C语言程序设计','2024-03-09 16:00:00',9,34,'2024-03-09 17:00:00',103),(30,'C语言程序设计','2024-03-09 17:00:00',5,34,'2024-03-09 18:00:00',112),(31,'Java程序设计','2024-03-09 17:00:00',6,25,'2024-03-09 18:00:00',111),(35,'测试','2024-03-09 17:00:00',2,1,'2024-03-09 18:00:00',102),(36,'测试啦','2024-03-08 17:00:00',2,3,'2024-03-08 18:00:00',101);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `device`
--

DROP TABLE IF EXISTS `device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `device` (
  `device_id` int NOT NULL AUTO_INCREMENT,
  `device_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `device_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `device_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `room_id` int DEFAULT NULL,
  `building_id` int DEFAULT NULL,
  `floor_num` int DEFAULT NULL,
  `model_name` varchar(255) DEFAULT NULL,
  `model_position` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `device`
--

LOCK TABLES `device` WRITE;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` VALUES (1,'一号楼一楼1教灯光','0','1',101,1,1,'light-left-l1-class-1001','{x: 6.451005032376143, y: 1.0022643136058336, z: 6.827563062588781}'),(2,'一号楼一楼2教灯光','0','1',102,1,1,'light-left-l1-class-2001','{x: 3.210922368904578, y: 0.9177539015196682, z: 7.0974476149166}'),(3,'一号楼一楼3教灯光','0','0',103,1,1,'light-left-l1-class-3001','{x: -1.2065979093630383, y: 0.9140390854220355, z: 7.206042498348862}'),(4,'一号楼一楼4教灯光','0','1',104,1,1,'light-left-l1-class-4001','{x: -5.737463374119559, y: 0.9964935836906684, z: 6.953450946122798}'),(5,'一号楼二楼1教灯光','0','1',105,1,2,'light-left-l2-class-1001','{x: 5.8018678447612535, y: 1.9383088728751847, z: 6.897045251415374}'),(6,'一号楼二楼2教灯光','0','1',106,1,2,'light-left-l2-class-2001','{x: 3.3039742867772675, y: 1.978717922948196, z: 7.0140691469499785}'),(7,'一号楼二楼3教灯光','0','1',107,1,2,'light-left-l2-class-3001','{x: -1.2581640676998231, y: 1.9117584421423996, z: 7.175184115722203}'),(8,'一号楼二楼4教灯光','0','1',108,1,2,'light-left-l2-class-4001','{x: -4.554942566009124, y: 1.9280805565562622, z: 6.994708235580843}'),(9,'一号楼三楼1教灯光','0','1',109,1,3,'light-left-l3-class-1001','{x: 5.206671101309151, y: 2.8746897363879413, z: 6.916185591744946}'),(10,'一号楼三楼2教灯光','0','1',110,1,3,'light-left-l3-class-2001','{x: 3.4325972050972497, y: 2.914039300624203, z: 6.623930713933616}'),(11,'一号楼三楼3教灯光','0','1',111,1,3,'light-left-l3-class3001','{x: -1.8353632135016362, y: 2.911806352942228, z: 7.131143667845886}'),(12,'一号楼三楼4教灯光','0','1',112,1,3,'light-left-l3-class4001','{x: -4.200983833654594, y: 2.9223489511421668, z: 6.597020580385878}'),(13,'二号楼一楼1教灯光','0','1',201,2,1,'light-right-l1-class-1001','{x: 4.171393673786509, y: 0.9815394209581854, z: -6.8751028950258535}'),(14,'二号楼一楼2教灯光','0','1',202,2,1,'light-right-l1-class-2001','{x: 0.819501675712293, y: 0.966708130704461, z: -7.028629277066326}'),(15,'二号楼一楼3教灯光','0','1',203,2,1,'light-right-l1-class-3001','{x: -3.4476026577587326, y: 1.0428563961378, z: -7.236181859073792}'),(16,'二号楼一楼4教灯光','0','1',204,2,1,'light-right-l1-class-4001','{x: -6.724257741544913, y: 0.9307528826714946, z: -6.68573723563229}'),(17,'二号楼二楼1教灯光','0','1',205,2,2,'light-right-l2-class-1001','{x: 4.49991296089386, y: 1.9306747082054503, z: -7.229927781910309}'),(18,'二号楼二楼2教灯光','0','1',206,2,2,'light-right-l2-class-2001','{x: 1.8389989268929043, y: 1.9167836234842819, z: -7.386292642390775}'),(19,'二号楼二楼3教灯光','0','1',207,2,2,'light-right-l2-class-3001','{x: -3.517931925153373, y: 1.9780569595754374, z: -6.8730621810439025}'),(20,'二号楼二楼4教灯光','0','1',208,2,2,'light-right-l2-class-4001','{x: -5.8807700295435845, y: 1.9417831295591603, z: -7.125691687942286}'),(21,'二号楼三楼1教灯光','0','1',209,2,3,'light-right-l3-class-1001','{x: 4.197197909443605, y: 2.926255064627103, z: -6.799312261011642}'),(22,'二号楼三楼2教灯光','0','1',210,2,3,'light-right-l3-class-2001','{x: 0.8670032489194881, y: 2.9040061564446287, z: -6.971505755634255}'),(23,'二号楼三楼3教灯光','0','1',211,2,3,'light-right-l3-class-3001','{x: -3.5604708254170085, y: 2.919533595907868, z: -6.8266628159241804}'),(24,'二号楼三楼4教灯光','0','1',212,2,3,'light-right-l3-class-4001','{x: -6.457639974478679, y: 2.88902673602164, z: -7.084255231499936}'),(25,'一号楼一楼走廊灯光','0','1',113,1,1,'light-left-l1-zoulang002','{x: 2.2387560196224556, y: 0.9736208122534492, z: 4.483597895972059}'),(26,'一号楼二楼走廊灯光','0','1',114,1,2,'light-left-l2-zoulang002','{x: 2.295347781162951, y: 1.9753304578927553, z: 4.4039468501191275}'),(27,'一号楼三楼走廊灯光','0','1',115,1,3,'light-left-l3-zoulang002','{x: 2.2141724651134824, y: 2.9483727259044428, z: 4.387055243712496}'),(28,'二号楼一楼走廊灯光','0','1',213,2,1,'lights-right-l1-zoulang002','{x: -2.2830359346072258, y: 0.9791546681733446, z: -4.729391158590073}'),(29,'二号楼二楼走廊灯光','0','1',214,2,2,'light-right-l2-zoulang002','{x: -2.3077674637098418, y: 1.989032066915058, z: -4.664631074835162}'),(30,'二号楼三楼走廊灯光','0','1',215,2,3,'light-right-l3-zoulang002','{x: -2.2323190120484586, y: 2.954617677937082, z: -4.648034699248932}'),(31,'一号楼一楼1教大门','1','1',101,1,1,'door-left-l1-class1','{x: 4.505552886250341, y: 0.4671290823259879, z: 5.00360976335578}'),(32,'一号楼一楼2教大门','1','1',102,1,1,'door-left-l1-class2','{x: 1.2126555243264123, y: 0.4462452084371437, z: 5.268086626457487}'),(33,'一号楼一楼3教大门','1','1',103,1,1,'door-left-l1-class3','{x: -3.309217698911634, y: 0.5509667683937429, z: 5.125959110245052}'),(34,'一号楼一楼4教大门','1','1',104,1,1,'door-left-l1-class4','{x: -6.655035168610511, y: 0.5137724268540271, z: 5.331727670515537}'),(35,'一号楼二楼1教大门','1','1',105,1,2,'door-left-l2-class1','{x: 4.4862622855339165, y: 1.4518967641097946, z: 4.985941755377325}'),(36,'一号楼二楼2教大门','1','1',106,1,2,'door-left-l2-class2','{x: 1.1855908030059785, y: 1.4783861620161705, z: 5.215975647814837}'),(37,'一号楼二楼3教大门','1','1',107,1,2,'door-left-l2-class3','{x: -3.478211150228182, y: 1.484338000909884, z: 5.151406341952882}'),(38,'一号楼二楼4教大门','1','1',108,1,2,'door-left-l2-class4','{x: -6.676880359096075, y: 1.4342727123175942, z: 5.297333685204382}'),(39,'一号楼三楼1教大门','1','1',109,1,3,'door-left-l3-class1','{x: 4.747337266433524, y: 2.528550934675718, z: 5.1944940029302735}'),(40,'一号楼三楼2教大门','1','1',110,1,3,'door-left-l3-class2','{x: 1.5034176701475914, y: 2.6741108703902055, z: 5.704294742917225}'),(41,'一号楼三楼3教大门','1','1',111,1,3,'door-left-l3-class3','{x: -3.4904993932440895, y: 2.5635788565019038, z: 5.29976942573888}'),(42,'一号楼三楼4教大门','1','1',112,1,3,'door-left-l3-class4','{x: -6.710999299921401, y: 2.498166121494375, z: 5.1923943562942645}'),(43,'二号楼一楼1教大门','1','1',201,2,1,'door-right-l1-class1','{x: 6.638195895307734, y: 0.5826137845896328, z: -5.507973904710762}'),(44,'二号楼一楼2教大门','1','0',202,2,1,'door-right-l1-class2','{x: 3.25161268968649, y: 0.46103725928048855, z: -5.355848017389892}'),(45,'二号楼一楼3教大门','1','0',203,2,1,'door-right-l1-class3','{x: -1.2966430796784223, y: 0.4505053682536042, z: -5.490684882344046}'),(46,'二号楼一楼4教大门','1','1',204,2,1,'door-right-l1-class4','{x: -4.815662535052219, y: 0.5546134090060926, z: -5.487484874228673}'),(47,'二号楼二楼1教大门','1','1',205,2,2,'door-right-l2-class1','{x: 6.553573516613461, y: 1.4325761935009134, z: -5.624572492934741}'),(48,'二号楼二楼2教大门','1','1',206,2,2,'door-right-l2-class2','{x: 3.426781788559697, y: 1.5187184271467855, z: -5.619509285790628}'),(49,'二号楼二楼3教大门','1','1',207,2,2,'door-right-l2-class3','{x: -1.3124657766778436, y: 1.4711003007402854, z: -5.445489580316784}'),(50,'二号楼二楼4教大门','1','1',208,2,2,'door-right-l2-class4','{x: -4.560171516158126, y: 1.457566385607543, z: -5.211936139054423}'),(51,'二号楼三楼1教大门','1','1',209,2,3,'door-right-l3-class1','{x: 6.607906339032631, y: 2.499083798808023, z: -5.500886488655957}'),(52,'二号楼三楼2教大门','1','1',210,2,3,'door-right-l3-class2','{x: 3.3347776554677426, y: 2.5685695568071742, z: -5.6135655433827685}'),(53,'二号楼三楼3教大门','1','1',211,2,3,'door-right-l3-class3','{x: -1.3314636026347115, y: 2.5919999498106585, z: -5.701095384468199}'),(54,'二号楼三楼4教大门','1','1',212,2,3,'door-right-l3-class4','{x: -4.752307175949355, y: 2.4791488896530725, z: -5.509281926847727}'),(55,'一号楼一楼正门','1','1',113,1,1,'door-left-1','{x: 8.967082102973256, y: 0.6323686446333544, z: 4.127083966300707}'),(56,'一号楼一楼侧门','1','1',113,1,1,'door-left-2','{x: -0.017646965801163633, y: 0.5701777880575067, z: 4.31389300630926}'),(57,'一号楼一楼后门','1','1',113,1,1,'door-left-3','{x: -8.87886387572304, y: 0.6333430957402922, z: 4.471104186552958}'),(58,'二号楼一楼正门','1','1',213,2,1,'door-right-1','{x: 8.769208227014758, y: 0.6360961928945909, z: -4.876366550180685}'),(59,'二号楼一楼侧门','1','1',213,2,1,'door-right-2','{x: -0.02347962411150027, y: 0.44984969238404765, z: -4.3751967735448645}'),(60,'二号楼一楼后门','1','1',213,2,1,'door-right-3','{x: -8.982674065202893, y: 0.5589769509457174, z: -4.536473453279348}'),(61,'一号楼一楼消防栓','2','0',113,1,1,'fire_left_l1','{x: 1.9451048142149758, y: 0.42077830573078445, z: 4.096161625105135}'),(62,'一号楼二楼消防栓','2','0',114,1,2,'fire_left_l2','{x: 1.9267301195885276, y: 1.3472306559147387, z: 4.057476416705236}'),(63,'一号楼三楼消防栓','2','0',115,1,3,'fire_left_l3','{x: 1.986334812526483, y: 2.6092699732136895, z: 4.182968826298228}'),(64,'二号楼一楼消防栓','2','0',213,2,1,'fire_rigth_l1','{x: 1.7593750969420208, y: 0.40243809490845844, z: -4.436343946557061}'),(65,'二号楼二楼消防栓','2','0',214,2,2,'fire_right_l2','{x: 1.839275876390404, y: 1.5303833396125324, z: -4.413463959121327}'),(66,'二号楼三楼消防栓','2','0',215,2,3,'fire_right_l3','{x: 1.8093497419391553, y: 2.506294045655899, z: -4.257263959311368}');
/*!40000 ALTER TABLE `device` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sclass`
--

DROP TABLE IF EXISTS `sclass`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sclass` (
  `class_id` int NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) DEFAULT NULL,
  `class_num` int DEFAULT NULL,
  `class_counselor` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `counselor_number` varchar(255) DEFAULT NULL,
  `academy` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`class_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sclass`
--

LOCK TABLES `sclass` WRITE;
/*!40000 ALTER TABLE `sclass` DISABLE KEYS */;
INSERT INTO `sclass` VALUES (1,'计算机1201',49,'丁启航','12345678944','信息工程学院'),(2,'计算机1202',40,'丁启航','12345678944','信息工程学院'),(3,'计算机1203',35,'丁启航','12345678944','信息工程学院'),(4,'计算机1204',50,'丁启航','12345678944','信息工程学院'),(5,'计算机1205',5,'丁启航','12345678944','信息工程学院'),(6,'软件1201',28,'张三','12345678944','信息工程学院'),(7,'软件1202',28,'李四','12345678944','信息工程学院'),(8,'软件1203',28,'王五','12345678944','信息工程学院'),(9,'软件1204',28,'赵六','12345678944','信息工程学院'),(10,'软件1205',28,'孙七','12345678944','信息工程学院'),(11,'软件1206',28,'周八','12345678944','信息工程学院'),(12,'软件1207',28,'吴九','12345678944','信息工程学院'),(13,'物联网1201',35,'端坤坤','12345678944','信息工程学院'),(14,'物联网1202',55,'端坤坤','12345678944','信息工程学院'),(15,'物联网1203',24,'端坤坤','12345678944','信息工程学院'),(16,'物联网1204',38,'端坤坤','12345678944','信息工程学院'),(17,'物联网1205',29,'端坤坤','12345678944','信息工程学院'),(18,'物联网1206',57,'端坤坤','12345678944','信息工程学院'),(19,'体育1201',50,'张三三','12345678955','体育学院'),(20,'英语1202',38,'李思思','12345688888','外国语学院'),(21,'英语1201',46,'王五五','12365478955','外国语学院');
/*!40000 ALTER TABLE `sclass` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `staff` (
  `staff_id` int NOT NULL AUTO_INCREMENT,
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
-- Table structure for table `student_num`
--

DROP TABLE IF EXISTS `student_num`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_num` (
  `id` int NOT NULL AUTO_INCREMENT,
  `num` int DEFAULT NULL,
  `time` datetime DEFAULT NULL,
  `building_id` int DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_num`
--

LOCK TABLES `student_num` WRITE;
/*!40000 ALTER TABLE `student_num` DISABLE KEYS */;
INSERT INTO `student_num` VALUES (1,108,'2024-03-08 18:00:00',1),(2,0,'2024-03-08 18:00:00',2),(3,0,'2024-03-08 18:18:00',1),(4,0,'2024-03-08 18:18:00',2),(5,0,'2024-03-08 18:18:29',1),(6,0,'2024-03-08 18:18:29',2),(7,0,'2024-03-08 18:18:59',1),(8,0,'2024-03-08 18:18:59',2);
/*!40000 ALTER TABLE `student_num` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher`
--

DROP TABLE IF EXISTS `teacher`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher` (
  `teacher_id` int NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `teacher_title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `teacher_tel` varchar(255) DEFAULT NULL,
  `teacher_age` int DEFAULT NULL,
  `teacher_academy` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB AUTO_INCREMENT=96 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher`
--

LOCK TABLES `teacher` WRITE;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` VALUES (1,'李文彦','专家骨干','12345678955',22,'信息工程学院'),(2,'刘春燕','专家骨干','12345678955',20,'信息工程学院'),(3,'苏永红','专业教师','12345678977',20,'信息工程学院'),(4,'薛霞','专业教师','12345678944',20,'信息工程学院'),(5,'彭贝贝','辅导员','12345688888',20,'信息工程学院'),(6,'丁启航','辅导员','12345677777',20,'信息工程学院'),(7,'李凌','产业教授','12345678944',20,'信息工程学院'),(8,'兰自力','专家骨干','12345678945',20,'体育学院'),(9,'赵燕','专家骨干','12365478955',20,'体育学院'),(10,'吴飞','专业教师','12345678901',20,'体育学院'),(11,'刘涛','专业教师','12345678902',20,'体育学院'),(12,'付炜','实验教师','12345678904',20,'体育学院'),(13,'闫成龙','实验教师','12345678905',20,'体育学院'),(14,'臧守相','辅导员','12345678906',20,'体育学院'),(15,'李连国','辅导员','12345678907',20,'体育学院'),(16,'陈戬','辅导员','12345678908',20,'体育学院'),(17,'程艳霞','专家骨干','12345678908',20,'商学院'),(18,'王虎','专家骨干','12345678909',20,'商学院'),(19,'胡华夏','专家骨干','12345678910',20,'商学院'),(20,'朱金生','专家骨干','12345678911',20,'商学院'),(21,'李琼','专业教师','12345678912',20,'商学院'),(22,'蔡奎','专业教师','12345678913',20,'商学院'),(23,'林波','专业教师','12345678914',20,'商学院'),(24,'严婷婷','专业教师','12345678915',20,'商学院'),(25,'郭伟奇','实验教师','12345678916',20,'商学院'),(26,'熊小芬','实验教师','12345678917',20,'商学院'),(27,'杨杰','实验教师','12345678918',20,'商学院'),(28,'万雷浩','实验教师','12345678919',20,'商学院'),(29,'孙文胜','辅导员','12345678920',20,'商学院'),(30,'潘晶','辅导员','12345678921',20,'商学院'),(31,'刘浩波','辅导员','12345678922',20,'商学院'),(32,'王雅洁','辅导员','12345678923',20,'商学院'),(33,'张玉纯','辅导员','12345678924',20,'商学院'),(34,'李思谋','辅导员','12345678925',20,'商学院'),(35,'刘沛','教授','12345678926',20,'外国语学院'),(36,'王革','三级教授','12345678927',20,'外国语学院'),(37,'杨剑瑞','三级教授','12345678928',20,'外国语学院'),(38,'王春艳','专业教师','12345678929',20,'外国语学院'),(39,'王丽丽','专业教师','12345678930',20,'外国语学院'),(40,'陈晶','专业教师','12345678931',20,'外国语学院'),(41,'曹永波','专业教师','12345678932',20,'外国语学院'),(42,'陈晶','专业教师','12345678933',20,'外国语学院'),(43,'席颖','实验教师','12345678934',20,'外国语学院'),(44,'余世浩','专家骨干','12345678935',20,'智能制造学院'),(45,'刘凯','专家骨干','12345678936',20,'智能制造学院'),(46,'陈国良','专家骨干','12345678937',20,'智能制造学院'),(47,'刘维','专家骨干','12345678938',20,'智能制造学院'),(48,'陈全','专业教师','12345678939',20,'智能制造学院'),(49,'欧阳文凯','专业教师','12345678940',20,'智能制造学院'),(50,'黄英','专业教师','12345678941',20,'智能制造学院'),(51,'王睿','专业教师','12345678942',20,'智能制造学院'),(52,'熊映','专业教师','12345678943',20,'智能制造学院'),(53,'刘颖莹','专业教师','12345678944',20,'智能制造学院'),(54,'王建美','专业教师','12345678945',20,'智能制造学院'),(55,'刘成','实验教师','12345678946',20,'智能制造学院'),(56,'左艳迪','实验教师','12345678947',20,'智能制造学院'),(57,'向胜涛','辅导员','12345678948',20,'智能制造学院'),(58,'周丽华','辅导员','12345678949',20,'智能制造学院'),(59,'杨阳','辅导员','12345678950',20,'智能制造学院'),(60,'张哲','辅导员','12345678951',20,'智能制造学院'),(61,'路由','专家骨干','12345678952',20,'艺术设计与传媒学院'),(62,'李娇','专家骨干','12345678953',20,'艺术设计与传媒学院'),(63,'张天洁','专家骨干','12345678954',20,'艺术设计与传媒学院'),(64,'李娟','专业教师','12345678955',20,'艺术设计与传媒学院'),(65,'王晶','专业教师','12345678956',20,'艺术设计与传媒学院'),(66,'张天洁','专业教师','12345678957',20,'艺术设计与传媒学院'),(67,'刘丽娟','专业教师','12345678958',20,'艺术设计与传媒学院'),(68,'杨婷婷','专业教师','12345678959',20,'艺术设计与传媒学院'),(69,'张天洁','专业教师','12345678960',20,'艺术设计与传媒学院'),(70,'李娟','专业教师','12345678961',20,'艺术设计与传媒学院'),(71,'王晶','专业教师','12345678962',20,'艺术设计与传媒学院'),(72,'王旭龙','辅导员','12345678963',20,'艺术设计与传媒学院'),(73,'刘静','辅导员','12345678964',20,'艺术设计与传媒学院'),(74,'陈军','辅导员','12345678965',20,'艺术设计与传媒学院'),(75,'杨琦','辅导员','12345678966',20,'艺术设计与传媒学院'),(76,'陶帅','辅导员','12345678967',20,'艺术设计与传媒学院'),(77,'严虎','实验教师','12345678968',20,'艺术设计与传媒学院'),(78,'候国栋','实验教师','12345678969',20,'艺术设计与传媒学院'),(79,'傅强','高级实验师','12345678970',20,'艺术设计与传媒学院'),(80,'王密','实验教师','12345678971',20,'艺术设计与传媒学院'),(81,'王琳','实验教师','12345678972',20,'艺术设计与传媒学院'),(82,'苏永红','专业教师','12345678973',20,'信息工程学院'),(83,'张玉蓉','专业教师','12345678974',20,'信息工程学院'),(84,'王玉婷','专业教师','12345678975',20,'信息工程学院'),(85,'罗瑜','专业教师','12345678976',20,'信息工程学院'),(86,'钟学斌','专业教师','12345678977',20,'信息工程学院'),(87,'王海霞','专业教师','12345678978',20,'信息工程学院'),(88,'郭俊芳','专业教师','12345678979',20,'信息工程学院'),(89,'沈春阳','实验教师','12345678980',20,'信息工程学院'),(90,'徐国成','实验教师','12345678981',20,'信息工程学院'),(91,'熊俊','辅导员','12345678982',20,'信息工程学院'),(92,'李洋','辅导员','12345678983',20,'信息工程学院'),(93,'徐广','辅导员','12345678984',20,'信息工程学院'),(94,'张子扬','辅导员','12345678985',20,'信息工程学院');
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
  `cardnum` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8_general_ci DEFAULT NULL COMMENT '身份证号',
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
INSERT INTO `user` VALUES (1,'tianbin','123456','田斌','13297011629',NULL,NULL,NULL,'2024-01-12 08:50:47',NULL,'42282820000712292X',0,NULL,0,'0'),(2,'admin','admin','admin','13297011629',NULL,'','1999-07-12','2023-11-14 01:31:23',NULL,'42282820000712292X',0,NULL,0,'0'),(3,'xiaochen','123456','小陈','12345678911',NULL,NULL,NULL,'2023-12-28 09:48:25',NULL,'422828200007112695',0,NULL,0,'1'),(4,'xiaoli','xiaoli','小李','12345677777',NULL,NULL,NULL,'2024-02-29 10:27:13',NULL,'222222255555555555',0,NULL,0,'1'),(5,'weixiu','123456','张三','12345678944',NULL,NULL,NULL,'2024-01-22 03:02:45',NULL,'222222222222222222',0,NULL,0,'2'),(6,'weixiu1','123456','李四','12348697777',NULL,NULL,NULL,'2024-02-29 10:27:13',NULL,'333333333333333333',0,NULL,0,'2');
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

-- Dump completed on 2024-03-08 19:35:01
