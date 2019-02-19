-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: localhost    Database: idemia_hire
-- ------------------------------------------------------
-- Server version	8.0.12

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `candidate` (
  `candidate_id` varchar(45) NOT NULL,
  `candidate_email` varchar(45) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(10) DEFAULT NULL,
  `contact_number` varchar(45) DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `requirement_id` varchar(30) DEFAULT NULL,
  `date_of_entry` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`candidate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES ('1234jOHN','john.doe@gmail.com','John','Doe','1234567890','Selected','567','2018-09-05 11:09:41'),('234567poiu','as@qw.com','john','doe','1234567890','Profile Created','123',NULL),('AfXPT4227Y','dsingh12@gmail.com','Dharmendra Singh','Thakur','9599261630','Profile Created','234','2018-09-05 11:00:47'),('DFREW2223W','jhuifhweu@ghail.com','Mohmmad','cdsfew','7865256376','Profile Created','567',NULL),('DJEPS9090Z','myunus0411@gmail.com','Mohmmad','Salim','7415948984','Profile Created','123',NULL),('DOYPK12345','aditya.kumar@idemia.com','Aditya','Kumar','9717514980','Profile Created','567','2018-08-05 11:00:47'),('IDMA4561','sm@in.com','Sumeet','Mehra','6524356781','Selected','123','2018-09-05 11:00:47'),('IDMA4562','hk@mail.com','Harshit ','Mehra','8356728635','Selected','567','2018-09-05 11:00:47'),('IDMA4563','sm@in.com','Sumeet','Mehra','1018910048','Selected','234','2018-09-05 11:00:47'),('IDMA4564','hk@mail.com','Harshit ','Mehra','1202147234','Rejected','123','2018-09-05 11:00:47'),('IDMA4565','sm@in.com','Sumeet','Mehra','1385384419','Selected','123','2018-09-05 11:00:47'),('IDMA4566','hk@mail.com','Harshit ','Mehra','1568621605','Rejected','567','2018-09-05 11:00:47'),('IDMA4567','sm@in.com','Sumeet','Mehra','1751858790','Selected','234','2018-09-05 11:00:47'),('IDMA4568','hk@mail.com','Harshit ','Mehra','1935095975','Rejected','567','2018-09-05 11:00:47'),('IDMA4569','akmldt@gmail.com','test','admin','1234567891','Selected','234','2018-09-05 11:00:47'),('IDMA4571','sm@in.com','Sumeet','Mehra','6532435781','Selected','123','2018-09-05 11:00:47'),('IDMA4580','sm@in.com','Kunal','Mehra','6524356781','Selected','123','2018-09-05 11:00:47'),('IDMA5676','akmldt@gmail.com','test','admin','1234567891','Selected','234','2018-09-05 11:00:47'),('IDMA6561','akmldt@gmail.com','aditya','kumar','9715237398','Selected','567','2018-09-05 11:00:47'),('q33r3224','dwqwe@HMAIL.COM','asdsafd','efewfwe','9087676765','Profile Created','567',NULL),('test','test@test.com','test','test','2314231423','Profile Created','781',NULL);
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `interview`
--

DROP TABLE IF EXISTS `interview`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `interview` (
  `candidate_id` varchar(45) NOT NULL,
  `online_test_score` varchar(45) DEFAULT NULL,
  `first_level_name` varchar(45) DEFAULT NULL,
  `first_level_feedback` varchar(45) DEFAULT NULL,
  `second_level_name` varchar(45) DEFAULT NULL,
  `second_level_feedback` varchar(45) DEFAULT NULL,
  `third_level_name` varchar(45) DEFAULT NULL,
  `third_level_feedback` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `date_of_offer` date DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  `revised_joining_date` date DEFAULT NULL,
  PRIMARY KEY (`candidate_id`),
  UNIQUE KEY `candidate_id_UNIQUE` (`candidate_id`),
  KEY `pancard_FK` (`candidate_id`),
  CONSTRAINT `candidate_id` FOREIGN KEY (`candidate_id`) REFERENCES `candidate` (`candidate_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `interview`
--

LOCK TABLES `interview` WRITE;
/*!40000 ALTER TABLE `interview` DISABLE KEYS */;
INSERT INTO `interview` VALUES ('1234jOHN',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('234567poiu',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('AfXPT4227Y',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-06',NULL,NULL),('DFREW2223W',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('DJEPS9090Z',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('DOYPK12345','70','John Doe','Good','John Doe','Good','John Doe','Good',NULL,'2018-07-24',NULL,NULL),('IDMA4561','90','Unknown_1','Good','Unknoiwn_2','good','Unknown_3','Good','Selected','2018-08-22','2018-08-22','2018-08-22'),('IDMA4562','90','Unknown_1','Good','Unknoiwn_2','good','Unknown_4','Good','Selected','2018-08-23','2018-08-23','2018-08-23'),('IDMA4563','90','Unknown_1','Good','Unknoiwn_2','good','Unknown_5','Good','Selected','2018-08-24','2018-08-24','2018-08-24'),('IDMA4564','20','Unknown_1','Good','Unknoiwn_2','good','Unknown_6','Good','Selected','2018-08-25','2018-08-25','2018-08-25'),('IDMA4565','100','Unknown_1','Good','Unknoiwn_2','good','Unknown_7','Good','Selected','2018-08-26','2018-08-26','2018-08-26'),('IDMA4566','90','Unknown_1','Good','Unknoiwn_2','good','Unknown_8','Good','Selected','2018-08-27','2018-08-27','2018-08-27'),('IDMA4567','90','Unknown_1','bad','Unknoiwn_2','good','Unknown_9','Good','Selected','2018-08-28','2018-08-28','2018-08-28'),('IDMA4568','90','Unknown_1','poor','Unknoiwn_2','good','Unknown_10','Good','Selected','2018-08-29','2018-08-29','2018-08-29'),('IDMA4571','90','Unknown_1','Good','Unknoiwn_2','good','Unknown_3','Good','Selected','2018-08-22','2018-08-22','2018-08-22'),('IDMA4580','90','Unknown_6','Excellent','Unknoiwn_2','good','Unknown_3','Poor','Selected','2018-08-22','2018-08-22','2018-08-22'),('IDMA5676','90','Unknown_1',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('IDMA6561','90',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('q33r3224',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),('test',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `interview` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `requirement`
--

DROP TABLE IF EXISTS `requirement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `requirement` (
  `id` varchar(30) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `domain` varchar(45) DEFAULT NULL,
  `sub_domain` varchar(100) DEFAULT NULL,
  `reporting_manager` varchar(100) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `vacancy` int(11) DEFAULT NULL,
  `job_location` varchar(30) DEFAULT NULL,
  `min_exp` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `requirementID_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `requirement`
--

LOCK TABLES `requirement` WRITE;
/*!40000 ALTER TABLE `requirement` DISABLE KEYS */;
INSERT INTO `requirement` VALUES ('121','DotNet developer','DTP','Core','Peeyush Kumar','Open',4,'Noida',1),('123','Senior Software Engineer','DTP','Core','Nikhil Goyal','Open',2,'Noida',2),('145','sdfdfd','core','core','Yunus','Open',2,'Noida',1),('167','Core Java Developer','DTP','Core','Anil Sharma','Close',1,'Pune',0),('273','Database Administrator','DTP','Non-Core','Neha','Open',2,'Noida',5),('321','DotNet Developer','DTP','core','Rahul Sharma','Close',1,'Pune',4),('564','Software Engineer','DTP','Core','Nikhil','Close',2,'Noida',2),('567','Associate Software Engineer','DTP','Core','Nikhil Goyal','Open',5,'Noida',0),('717','Core Java Developer','DTP','Core','Anil Sharma','Close',5,'Noida',1),('781','Angular Developer','DTP','Core','Ramesh Kumar','Open',2,'Pune',0);
/*!40000 ALTER TABLE `requirement` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-06 10:48:47
