-- MySQL dump 10.13  Distrib 8.0.41, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: online_tutoring_managment
-- ------------------------------------------------------
-- Server version	9.2.0

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

CREATE DATABASE OTMS;
USE OTMS;

--
-- Table structure for table `availability`
--

DROP TABLE IF EXISTS `availability`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `availability` (
  `availability_id` int NOT NULL,
  `tutor_id` int DEFAULT NULL,
  `day_of_week` varchar(15) DEFAULT NULL,
  `start_time` time DEFAULT NULL,
  `end_time` time DEFAULT NULL,
  PRIMARY KEY (`availability_id`),
  KEY `tutor_id` (`tutor_id`),
  CONSTRAINT `availability_ibfk_1` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`tutor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `availability`
--

LOCK TABLES `availability` WRITE;
/*!40000 ALTER TABLE `availability` DISABLE KEYS */;
INSERT INTO `availability` VALUES (1,1,'Monday','14:00:00','16:00:00'),(2,2,'Tuesday','10:00:00','12:00:00'),(3,3,'Wednesday','13:00:00','15:00:00'),(4,4,'Thursday','09:00:00','11:00:00'),(5,5,'Friday','11:00:00','13:00:00'),(6,6,'Saturday','15:00:00','17:00:00'),(7,7,'Sunday','10:00:00','12:00:00'),(8,8,'Monday','13:00:00','15:00:00'),(9,9,'Wednesday','14:00:00','16:00:00'),(10,10,'Friday','12:00:00','14:00:00');
/*!40000 ALTER TABLE `availability` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `job`
--

DROP TABLE IF EXISTS `job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `job` (
  `job_id` int NOT NULL,
  `request_id` int DEFAULT NULL,
  `student_id` int DEFAULT NULL,
  `tutor_id` int DEFAULT NULL,
  `feedback_id` int DEFAULT NULL,
  `start_time` timestamp NULL DEFAULT NULL,
  `end_time` timestamp NULL DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`job_id`),
  KEY `request_id` (`request_id`),
  KEY `student_id` (`student_id`),
  KEY `tutor_id` (`tutor_id`),
  KEY `fk_feedback` (`feedback_id`),
  CONSTRAINT `fk_feedback` FOREIGN KEY (`feedback_id`) REFERENCES `rating_feedback` (`feedback_id`),
  CONSTRAINT `job_ibfk_1` FOREIGN KEY (`request_id`) REFERENCES `student_request` (`request_id`),
  CONSTRAINT `job_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `job_ibfk_3` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`tutor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `job`
--

LOCK TABLES `job` WRITE;
/*!40000 ALTER TABLE `job` DISABLE KEYS */;
INSERT INTO `job` VALUES (1,1,1,1,1,'2025-04-01 09:00:00','2025-04-01 10:00:00','Completed'),(2,2,2,2,2,'2025-04-02 05:00:00','2025-04-02 06:00:00','Completed'),(3,3,3,3,3,'2025-04-03 08:00:00','2025-04-03 09:00:00','In Progress'),(4,4,4,4,4,'2025-04-04 04:00:00','2025-04-04 05:00:00','Pending'),(5,5,5,5,5,'2025-04-05 06:00:00','2025-04-05 07:00:00','Completed'),(6,6,1,6,6,'2025-04-06 10:00:00','2025-04-06 11:00:00','Completed'),(7,7,2,7,7,'2025-04-07 05:00:00','2025-04-07 06:00:00','Pending'),(8,8,3,8,8,'2025-04-08 08:00:00','2025-04-08 09:00:00','Completed'),(9,9,4,9,9,'2025-04-09 09:00:00','2025-04-09 10:00:00','Completed'),(10,10,5,10,10,'2025-04-10 07:00:00','2025-04-10 08:00:00','In Progress');
/*!40000 ALTER TABLE `job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating_feedback`
--

DROP TABLE IF EXISTS `rating_feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rating_feedback` (
  `feedback_id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `job_id` int DEFAULT NULL,
  `rating` int DEFAULT NULL,
  `comment` text,
  `timestamp` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`feedback_id`),
  KEY `student_id` (`student_id`),
  KEY `job_id` (`job_id`),
  CONSTRAINT `rating_feedback_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `rating_feedback_ibfk_2` FOREIGN KEY (`job_id`) REFERENCES `job` (`job_id`),
  CONSTRAINT `rating_feedback_chk_1` CHECK ((`rating` between 1 and 5))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating_feedback`
--

LOCK TABLES `rating_feedback` WRITE;
/*!40000 ALTER TABLE `rating_feedback` DISABLE KEYS */;
INSERT INTO `rating_feedback` VALUES (1,1,1,5,'Great explanation!','2025-04-23 13:58:25'),(2,2,2,4,'Helpful session','2025-04-23 13:58:25'),(3,3,3,5,'Excellent tutor','2025-04-23 13:58:25'),(4,4,4,3,'Okayish','2025-04-23 13:58:25'),(5,5,5,4,'Good understanding','2025-04-23 13:58:25'),(6,1,6,5,'Very informative','2025-04-23 13:58:25'),(7,2,7,4,'Tutor was on time','2025-04-23 13:58:25'),(8,3,8,5,'Perfectly taught','2025-04-23 13:58:25'),(9,4,9,4,'Useful class','2025-04-23 13:58:25'),(10,5,10,3,'Needs more clarity','2025-04-23 13:58:25');
/*!40000 ALTER TABLE `rating_feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student` (
  `student_id` int NOT NULL,
  `grade_level` varchar(50) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`student_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student`
--

LOCK TABLES `student` WRITE;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` VALUES (1,'Grade 8',1),(2,'Grade 10',3),(3,'Grade 9',5),(4,'Grade 7',7),(5,'Grade 12',9),(6,'Grade 8',1),(7,'Grade 11',3),(8,'Grade 6',5),(9,'Grade 10',7),(10,'Grade 9',9);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_request`
--

DROP TABLE IF EXISTS `student_request`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_request` (
  `request_id` int NOT NULL,
  `student_id` int DEFAULT NULL,
  `subject_id` int DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `description` text,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`request_id`),
  KEY `student_id` (`student_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `student_request_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student` (`student_id`),
  CONSTRAINT `student_request_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_request`
--

LOCK TABLES `student_request` WRITE;
/*!40000 ALTER TABLE `student_request` DISABLE KEYS */;
INSERT INTO `student_request` VALUES (1,1,1,'Pending','Need help with algebra','2025-04-23 13:57:38'),(2,2,2,'Pending','Improve English grammar','2025-04-23 13:57:38'),(3,3,3,'Approved','Understanding Newton’s laws','2025-04-23 13:57:38'),(4,4,4,'Pending','Help with chemical reactions','2025-04-23 13:57:38'),(5,5,5,'Rejected','Need help in biology practicals','2025-04-23 13:57:38'),(6,1,6,'Approved','Programming basics','2025-04-23 13:57:38'),(7,2,7,'Pending','Essay writing','2025-04-23 13:57:38'),(8,3,8,'Pending','Islamic history clarification','2025-04-23 13:57:38'),(9,4,9,'Approved','Map reading skills','2025-04-23 13:57:38'),(10,5,10,'Pending','World wars overview','2025-04-23 13:57:38');
/*!40000 ALTER TABLE `student_request` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subject` (
  `subject_id` int NOT NULL,
  `subject_name` varchar(100) DEFAULT NULL,
  `category` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subject`
--

LOCK TABLES `subject` WRITE;
/*!40000 ALTER TABLE `subject` DISABLE KEYS */;
INSERT INTO `subject` VALUES (1,'Mathematics','Science'),(2,'English','Language'),(3,'Physics','Science'),(4,'Chemistry','Science'),(5,'Biology','Science'),(6,'Computer Science','Technology'),(7,'Urdu','Language'),(8,'Islamic Studies','Humanities'),(9,'Geography','Social Studies'),(10,'History','Social Studies');
/*!40000 ALTER TABLE `subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor`
--

DROP TABLE IF EXISTS `tutor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor` (
  `tutor_id` int NOT NULL,
  `rating` decimal(3,2) DEFAULT NULL,
  `contact_info` varchar(255) DEFAULT NULL,
  `user_id` int DEFAULT NULL,
  PRIMARY KEY (`tutor_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tutor_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor`
--

LOCK TABLES `tutor` WRITE;
/*!40000 ALTER TABLE `tutor` DISABLE KEYS */;
INSERT INTO `tutor` VALUES (1,4.50,'03211234567',2),(2,4.70,'03217654321',4),(3,4.20,'03339876543',6),(4,4.80,'03111234567',8),(5,4.90,'03001234567',10),(6,4.60,'03001111222',2),(7,4.30,'03118889999',4),(8,4.10,'03441234567',6),(9,4.00,'03556677889',8),(10,4.50,'03669874532',10);
/*!40000 ALTER TABLE `tutor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tutor_subject`
--

DROP TABLE IF EXISTS `tutor_subject`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tutor_subject` (
  `tutor_subject_id` int NOT NULL,
  `tutor_id` int DEFAULT NULL,
  `subject_id` int DEFAULT NULL,
  `experience` int DEFAULT NULL,
  PRIMARY KEY (`tutor_subject_id`),
  KEY `tutor_id` (`tutor_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `tutor_subject_ibfk_1` FOREIGN KEY (`tutor_id`) REFERENCES `tutor` (`tutor_id`),
  CONSTRAINT `tutor_subject_ibfk_2` FOREIGN KEY (`subject_id`) REFERENCES `subject` (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tutor_subject`
--

LOCK TABLES `tutor_subject` WRITE;
/*!40000 ALTER TABLE `tutor_subject` DISABLE KEYS */;
INSERT INTO `tutor_subject` VALUES (1,1,1,3),(2,1,2,2),(3,2,3,5),(4,3,4,4),(5,4,5,2),(6,5,6,3),(7,6,7,6),(8,7,8,2),(9,8,9,1),(10,9,10,3);
/*!40000 ALTER TABLE `tutor_subject` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` int NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Ali Khan','ali@example.com','pass123','student','2025-04-23 13:54:20'),(2,'Sara Ahmed','sara@example.com','pass123','tutor','2025-04-23 13:54:20'),(3,'Usman Malik','usman@example.com','pass123','student','2025-04-23 13:54:20'),(4,'Nida Fatima','nida@example.com','pass123','tutor','2025-04-23 13:54:20'),(5,'Hassan Raza','hassan@example.com','pass123','student','2025-04-23 13:54:20'),(6,'Fatima Zahra','fatima@example.com','pass123','tutor','2025-04-23 13:54:20'),(7,'Zain Ali','zain@example.com','pass123','student','2025-04-23 13:54:20'),(8,'Areeba Shah','areeba@example.com','pass123','tutor','2025-04-23 13:54:20'),(9,'Bilal Qureshi','bilal@example.com','pass123','student','2025-04-23 13:54:20'),(10,'Mariam Noor','mariam@example.com','pass123','tutor','2025-04-23 13:54:20');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'online_tutoring_managment'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-04-23 19:09:34
