-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: db_amartek_academy
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `tb_m_biodata`
--

DROP TABLE IF EXISTS `tb_m_biodata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_m_biodata` (
  `id` varchar(10) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `birth_date` date DEFAULT NULL,
  `no_telp` int DEFAULT NULL,
  `address` text,
  `summary` text,
  PRIMARY KEY (`id`),
  CONSTRAINT `tb_m_biodata_ibfk_1` FOREIGN KEY (`id`) REFERENCES `tb_m_user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_m_biodata`
--

LOCK TABLES `tb_m_biodata` WRITE;
/*!40000 ALTER TABLE `tb_m_biodata` DISABLE KEYS */;
INSERT INTO `tb_m_biodata` VALUES ('USR001','ilham ajah','2000-09-03',98765,'jalan jalan raya','fresh graduate ');
/*!40000 ALTER TABLE `tb_m_biodata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_m_degree`
--

DROP TABLE IF EXISTS `tb_m_degree`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_m_degree` (
  `id` int NOT NULL AUTO_INCREMENT,
  `degree_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_m_degree`
--

LOCK TABLES `tb_m_degree` WRITE;
/*!40000 ALTER TABLE `tb_m_degree` DISABLE KEYS */;
INSERT INTO `tb_m_degree` VALUES (1,'S1');
/*!40000 ALTER TABLE `tb_m_degree` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_m_job`
--

DROP TABLE IF EXISTS `tb_m_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_m_job` (
  `id` int NOT NULL AUTO_INCREMENT,
  `title_job` varchar(100) DEFAULT NULL,
  `location` text,
  `open_date` date DEFAULT NULL,
  `close_date` date DEFAULT NULL,
  `job_desc` text,
  `job_require` text,
  `job_benefit` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_m_job`
--

LOCK TABLES `tb_m_job` WRITE;
/*!40000 ALTER TABLE `tb_m_job` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_m_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_m_major`
--

DROP TABLE IF EXISTS `tb_m_major`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_m_major` (
  `id` int NOT NULL AUTO_INCREMENT,
  `major_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_m_major`
--

LOCK TABLES `tb_m_major` WRITE;
/*!40000 ALTER TABLE `tb_m_major` DISABLE KEYS */;
INSERT INTO `tb_m_major` VALUES (1,'Informatika');
/*!40000 ALTER TABLE `tb_m_major` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_m_project`
--

DROP TABLE IF EXISTS `tb_m_project`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_m_project` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(10) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `project_start` date DEFAULT NULL,
  `project_end` date DEFAULT NULL,
  `project_desc` text,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `tb_m_project_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_m_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_m_project`
--

LOCK TABLES `tb_m_project` WRITE;
/*!40000 ALTER TABLE `tb_m_project` DISABLE KEYS */;
INSERT INTO `tb_m_project` VALUES (5,'USR001','Graduate Development Program','2023-03-02','2023-04-01','Proyek lah ini pokoknya');
/*!40000 ALTER TABLE `tb_m_project` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_m_role`
--

DROP TABLE IF EXISTS `tb_m_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_m_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_m_role`
--

LOCK TABLES `tb_m_role` WRITE;
/*!40000 ALTER TABLE `tb_m_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_m_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_m_skill`
--

DROP TABLE IF EXISTS `tb_m_skill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_m_skill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `skill_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_m_skill`
--

LOCK TABLES `tb_m_skill` WRITE;
/*!40000 ALTER TABLE `tb_m_skill` DISABLE KEYS */;
INSERT INTO `tb_m_skill` VALUES (1,'Java'),(2,'React');
/*!40000 ALTER TABLE `tb_m_skill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_m_univ`
--

DROP TABLE IF EXISTS `tb_m_univ`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_m_univ` (
  `id` int NOT NULL AUTO_INCREMENT,
  `univ_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_m_univ`
--

LOCK TABLES `tb_m_univ` WRITE;
/*!40000 ALTER TABLE `tb_m_univ` DISABLE KEYS */;
INSERT INTO `tb_m_univ` VALUES (1,'Universitas Jakarta');
/*!40000 ALTER TABLE `tb_m_univ` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_m_user`
--

DROP TABLE IF EXISTS `tb_m_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_m_user` (
  `id` varchar(10) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `role_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `role_id` (`role_id`),
  CONSTRAINT `tb_m_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `tb_m_role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_m_user`
--

LOCK TABLES `tb_m_user` WRITE;
/*!40000 ALTER TABLE `tb_m_user` DISABLE KEYS */;
INSERT INTO `tb_m_user` VALUES ('USR001','apaja@gmail.com','123457',NULL);
/*!40000 ALTER TABLE `tb_m_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tr_education`
--

DROP TABLE IF EXISTS `tb_tr_education`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tr_education` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(10) DEFAULT NULL,
  `degree_id` int DEFAULT NULL,
  `univ_id` int DEFAULT NULL,
  `gpa` varchar(10) DEFAULT NULL,
  `major_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `degree_id` (`degree_id`),
  KEY `univ_id` (`univ_id`),
  KEY `major_id` (`major_id`),
  CONSTRAINT `tb_tr_education_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_m_user` (`id`),
  CONSTRAINT `tb_tr_education_ibfk_2` FOREIGN KEY (`degree_id`) REFERENCES `tb_m_degree` (`id`),
  CONSTRAINT `tb_tr_education_ibfk_3` FOREIGN KEY (`univ_id`) REFERENCES `tb_m_univ` (`id`),
  CONSTRAINT `tb_tr_education_ibfk_4` FOREIGN KEY (`major_id`) REFERENCES `tb_m_major` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tr_education`
--

LOCK TABLES `tb_tr_education` WRITE;
/*!40000 ALTER TABLE `tb_tr_education` DISABLE KEYS */;
INSERT INTO `tb_tr_education` VALUES (8,'USR001',1,1,'3.89',1),(9,'USR001',1,1,'3.77',1);
/*!40000 ALTER TABLE `tb_tr_education` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tr_recruitment`
--

DROP TABLE IF EXISTS `tb_tr_recruitment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tr_recruitment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `applicant_id` varchar(10) DEFAULT NULL,
  `hr_id` varchar(10) DEFAULT NULL,
  `trainer_id` varchar(10) DEFAULT NULL,
  `job_id` int DEFAULT NULL,
  `date_interview_trainer` date DEFAULT NULL,
  `status_trainer` enum('approve','reject') DEFAULT NULL,
  `date_interview_hr` date DEFAULT NULL,
  `status_hr` enum('approve','reject') DEFAULT NULL,
  `status_applicant` enum('reviewing','approve','reject') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `applicant_id` (`applicant_id`),
  KEY `hr_id` (`hr_id`),
  KEY `trainer_id` (`trainer_id`),
  KEY `job_id` (`job_id`),
  CONSTRAINT `tb_tr_recruitment_ibfk_1` FOREIGN KEY (`applicant_id`) REFERENCES `tb_m_user` (`id`),
  CONSTRAINT `tb_tr_recruitment_ibfk_2` FOREIGN KEY (`hr_id`) REFERENCES `tb_m_user` (`id`),
  CONSTRAINT `tb_tr_recruitment_ibfk_3` FOREIGN KEY (`trainer_id`) REFERENCES `tb_m_user` (`id`),
  CONSTRAINT `tb_tr_recruitment_ibfk_4` FOREIGN KEY (`job_id`) REFERENCES `tb_m_job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tr_recruitment`
--

LOCK TABLES `tb_tr_recruitment` WRITE;
/*!40000 ALTER TABLE `tb_tr_recruitment` DISABLE KEYS */;
/*!40000 ALTER TABLE `tb_tr_recruitment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_tr_userskill`
--

DROP TABLE IF EXISTS `tb_tr_userskill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_tr_userskill` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(10) DEFAULT NULL,
  `skill_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_id` (`user_id`),
  KEY `skill_id` (`skill_id`),
  CONSTRAINT `tb_tr_userskill_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `tb_m_user` (`id`),
  CONSTRAINT `tb_tr_userskill_ibfk_2` FOREIGN KEY (`skill_id`) REFERENCES `tb_m_skill` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_tr_userskill`
--

LOCK TABLES `tb_tr_userskill` WRITE;
/*!40000 ALTER TABLE `tb_tr_userskill` DISABLE KEYS */;
INSERT INTO `tb_tr_userskill` VALUES (1,'USR001',1),(2,'USR001',2);
/*!40000 ALTER TABLE `tb_tr_userskill` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-12  9:59:02
