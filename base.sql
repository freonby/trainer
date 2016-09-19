-- MySQL dump 10.13  Distrib 5.7.9, for Win32 (AMD64)
--
-- Host: 127.0.0.1    Database: user2013264_freonbase
-- ------------------------------------------------------
-- Server version	5.7.10-log

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
-- Table structure for table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authorities` (
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `ix_auth_username` (`username`,`authority`),
  CONSTRAINT `fk_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authorities`
--

LOCK TABLES `authorities` WRITE;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` VALUES ('duna','ROLE_USER'),('user','ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `part`
--

DROP TABLE IF EXISTS `part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `part` (
  `part_id` bigint(20) NOT NULL,
  `list` mediumblob,
  `name` longtext,
  PRIMARY KEY (`part_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `part`
--

LOCK TABLES `part` WRITE;
/*!40000 ALTER TABLE `part` DISABLE KEYS */;
INSERT INTO `part` VALUES (1,'�\�\0sr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0\"by.dunaenergo.training.model.Theme�Pu���c\�\0J\0idL\0listt\0Ljava/util/ArrayList;L\0textt\0Ljava/lang/String;xp\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sr\0%by.dunaenergo.training.model.Question�-w�R\0J\0idL\0answersq\0~\0L\0descriptionq\0~\0L\0\nshort_nameq\0~\0L\0textq\0~\0xp\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sr\0#by.dunaenergo.training.model.Answer�cO�\�\�\0J\0idZ\0validL\0textq\0~\0xp\0\0\0\0\0\0\0\0\0t\05При работах с трубопроводамиsq\0~\0\n\0\0\0\0\0\0\0\0\0t\08При работах в опасных условияхsq\0~\0\n\0\0\0\0\0\0\0\0t\0wПри выполнении всех видов работ на трансформаторных подстанцияхsq\0~\0\n\0\0\0\0\0\0\0\0\0t\0AПри прокладке элетрических кабелейxt\0ТКП пп.1.1.1t\0Вопрос 1t\0NВ каких случаях необходимо надевать каску?sq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\n\0\0\0\0\0\0\0\0\0t\01,2 мsq\0~\0\n\0\0\0\0\0\0\0\0\0t\02 мsq\0~\0\n\0\0\0\0\0\0\0\0\0t\00,5 мsq\0~\0\n\0\0\0\0\0\0\0\0t\01 мxt\0ТКПt\0Вопрос 2t\0>Какая должна быть глубина траншеиsq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\n\0\0\0\0\0\0\0\0\0t\030%sq\0~\0\n\0\0\0\0\0\0\0\0\0t\050%sq\0~\0\n\0\0\0\0\0\0\0\0\0t\040%sq\0~\0\n\0\0\0\0\0\0\0\0t\060%xt\0ТКП 2t\0Вопрос 3t\0TКакая влажность должна быть в сухом помещенииsq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\n\0\0\0\0\0\0\0\0\0t\070%sq\0~\0\n\0\0\0\0\0\0\0\0t\080%sq\0~\0\n\0\0\0\0\0\0\0\0\0t\060%sq\0~\0\n\0\0\0\0\0\0\0\0\0t\050%xt\0	ТКП 23t\0Вопрос 4t\0XКакая влажность должна быть в влажном помещенииxt\0 Электроснабжениеsq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0q\0~\0#q\0~\00xt\0Проектированиеx','ГИП'),(2,'�\�\0sr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0\"by.dunaenergo.training.model.Theme�Pu���c\�\0J\0idL\0listt\0Ljava/util/ArrayList;L\0textt\0Ljava/lang/String;xp\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sr\0%by.dunaenergo.training.model.Question�-w�R\0J\0idL\0answersq\0~\0L\0descriptionq\0~\0L\0\nshort_nameq\0~\0L\0textq\0~\0xp\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sr\0#by.dunaenergo.training.model.Answer�cO�\�\�\0J\0idZ\0validL\0textq\0~\0xp\0\0\0\0\0\0\0\0\0t\05При работах с трубопроводамиsq\0~\0\n\0\0\0\0\0\0\0\0\0t\08При работах в опасных условияхsq\0~\0\n\0\0\0\0\0\0\0\0t\0wПри выполнении всех видов работ на трансформаторных подстанцияхsq\0~\0\n\0\0\0\0\0\0\0\0\0t\0AПри прокладке элетрических кабелейxt\0ТКП пп.1.1.1t\0Вопрос 1t\0NВ каких случаях необходимо надевать каску?sq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\n\0\0\0\0\0\0\0\0\0t\01,2 мsq\0~\0\n\0\0\0\0\0\0\0\0\0t\02 мsq\0~\0\n\0\0\0\0\0\0\0\0\0t\00,5 мsq\0~\0\n\0\0\0\0\0\0\0\0t\01 мxt\0ТКПt\0Вопрос 2t\0>Какая должна быть глубина траншеиxt\0\"Кондиционированиеx','ГАП'),(3,'�\�\0sr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0\"by.dunaenergo.training.model.Theme�Pu���c\�\0J\0idL\0listt\0Ljava/util/ArrayList;L\0textt\0Ljava/lang/String;xp\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sr\0%by.dunaenergo.training.model.Question�-w�R\0J\0idL\0answersq\0~\0L\0descriptionq\0~\0L\0\nshort_nameq\0~\0L\0textq\0~\0xp\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sr\0#by.dunaenergo.training.model.Answer�cO�\�\�\0J\0idZ\0validL\0textq\0~\0xp\0\0\0\0\0\0\0\0\0t\030%sq\0~\0\n\0\0\0\0\0\0\0\0\0t\050%sq\0~\0\n\0\0\0\0\0\0\0\0\0t\040%sq\0~\0\n\0\0\0\0\0\0\0\0t\060%xt\0ТКП 2t\0Вопрос 3t\0TКакая влажность должна быть в сухом помещенииsq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\n\0\0\0\0\0\0\0\0\0t\070%sq\0~\0\n\0\0\0\0\0\0\0\0t\080%sq\0~\0\n\0\0\0\0\0\0\0\0\0t\060%sq\0~\0\n\0\0\0\0\0\0\0\0\0t\050%xt\0	ТКП 23t\0Вопрос 4t\0XКакая влажность должна быть в влажном помещенииxt\0Проектированиеsq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\n\0\0\0\0\0\0\0\0\0t\05При работах с трубопроводамиsq\0~\0\n\0\0\0\0\0\0\0\0\0t\08При работах в опасных условияхsq\0~\0\n\0\0\0\0\0\0\0\0t\0wПри выполнении всех видов работ на трансформаторных подстанцияхsq\0~\0\n\0\0\0\0\0\0\0\0\0t\0AПри прокладке элетрических кабелейxt\0ТКП пп.1.1.1t\0Вопрос 1t\0NВ каких случаях необходимо надевать каску?sq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\n\0\0\0\0\0\0\0\0\0t\01,2 мsq\0~\0\n\0\0\0\0\0\0\0\0\0t\02 мsq\0~\0\n\0\0\0\0\0\0\0\0\0t\00,5 мsq\0~\0\n\0\0\0\0\0\0\0\0t\01 мxt\0ТКПt\0Вопрос 2t\0>Какая должна быть глубина траншеиxt\0\"Кондиционированиеsq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0q\0~\0&q\0~\03q\0~\0q\0~\0xt\0 Электроснабжениеx','Главспец');
/*!40000 ALTER TABLE `part` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persistent_logins`
--

DROP TABLE IF EXISTS `persistent_logins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persistent_logins`
--

LOCK TABLES `persistent_logins` WRITE;
/*!40000 ALTER TABLE `persistent_logins` DISABLE KEYS */;
/*!40000 ALTER TABLE `persistent_logins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `question`
--

DROP TABLE IF EXISTS `question`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `question` (
  `quest_id` bigint(20) NOT NULL,
  `answers` mediumblob,
  `description` longtext,
  `name` longtext,
  `short_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`quest_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `question`
--

LOCK TABLES `question` WRITE;
/*!40000 ALTER TABLE `question` DISABLE KEYS */;
INSERT INTO `question` VALUES (1,'�\�\0sr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0#by.dunaenergo.training.model.Answer�cO�\�\�\0J\0idZ\0validL\0textt\0Ljava/lang/String;xp\0\0\0\0\0\0\0\0\0t\05При работах с трубопроводамиsq\0~\0\0\0\0\0\0\0\0\0\0t\08При работах в опасных условияхsq\0~\0\0\0\0\0\0\0\0\0t\0wПри выполнении всех видов работ на трансформаторных подстанцияхsq\0~\0\0\0\0\0\0\0\0\0\0t\0AПри прокладке элетрических кабелейx','ТКП пп.1.1.1','В каких случаях необходимо надевать каску?','Вопрос 1'),(2,'�\�\0sr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0#by.dunaenergo.training.model.Answer�cO�\�\�\0J\0idZ\0validL\0textt\0Ljava/lang/String;xp\0\0\0\0\0\0\0\0\0t\01,2 мsq\0~\0\0\0\0\0\0\0\0\0\0t\02 мsq\0~\0\0\0\0\0\0\0\0\0\0t\00,5 мsq\0~\0\0\0\0\0\0\0\0\0t\01 мx','ТКП','Какая должна быть глубина траншеи','Вопрос 2'),(3,'�\�\0sr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0#by.dunaenergo.training.model.Answer�cO�\�\�\0J\0idZ\0validL\0textt\0Ljava/lang/String;xp\0\0\0\0\0\0\0\0\0t\030%sq\0~\0\0\0\0\0\0\0\0\0\0t\050%sq\0~\0\0\0\0\0\0\0\0\0\0t\040%sq\0~\0\0\0\0\0\0\0\0\0t\060%x','ТКП 2','Какая влажность должна быть в сухом помещении','Вопрос 3'),(4,'�\�\0sr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0#by.dunaenergo.training.model.Answer�cO�\�\�\0J\0idZ\0validL\0textt\0Ljava/lang/String;xp\0\0\0\0\0\0\0\0\0t\070%sq\0~\0\0\0\0\0\0\0\0\0t\080%sq\0~\0\0\0\0\0\0\0\0\0\0t\060%sq\0~\0\0\0\0\0\0\0\0\0\0t\050%x','ТКП 23','Какая влажность должна быть в влажном помещении','Вопрос 4');
/*!40000 ALTER TABLE `question` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `theme`
--

DROP TABLE IF EXISTS `theme`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `theme` (
  `theme_id` bigint(20) NOT NULL,
  `list` mediumblob,
  `name` longtext,
  PRIMARY KEY (`theme_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `theme`
--

LOCK TABLES `theme` WRITE;
/*!40000 ALTER TABLE `theme` DISABLE KEYS */;
INSERT INTO `theme` VALUES (1,'�\�\0sr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0%by.dunaenergo.training.model.Question�-w�R\0J\0idL\0answerst\0Ljava/util/ArrayList;L\0descriptiont\0Ljava/lang/String;L\0\nshort_nameq\0~\0L\0textq\0~\0xp\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sr\0#by.dunaenergo.training.model.Answer�cO�\�\�\0J\0idZ\0validL\0textq\0~\0xp\0\0\0\0\0\0\0\0\0t\05При работах с трубопроводамиsq\0~\0\0\0\0\0\0\0\0\0\0t\08При работах в опасных условияхsq\0~\0\0\0\0\0\0\0\0\0t\0wПри выполнении всех видов работ на трансформаторных подстанцияхsq\0~\0\0\0\0\0\0\0\0\0\0t\0AПри прокладке элетрических кабелейxt\0ТКП пп.1.1.1t\0Вопрос 1t\0NВ каких случаях необходимо надевать каску?sq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\0\0\0\0\0\0\0\0\0t\01,2 мsq\0~\0\0\0\0\0\0\0\0\0\0t\02 мsq\0~\0\0\0\0\0\0\0\0\0\0t\00,5 мsq\0~\0\0\0\0\0\0\0\0\0t\01 мxt\0ТКПt\0Вопрос 2t\0>Какая должна быть глубина траншеиx','Кондиционирование'),(2,'�\�\0sr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0%by.dunaenergo.training.model.Question�-w�R\0J\0idL\0answerst\0Ljava/util/ArrayList;L\0descriptiont\0Ljava/lang/String;L\0\nshort_nameq\0~\0L\0textq\0~\0xp\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sr\0#by.dunaenergo.training.model.Answer�cO�\�\�\0J\0idZ\0validL\0textq\0~\0xp\0\0\0\0\0\0\0\0\0t\030%sq\0~\0\0\0\0\0\0\0\0\0\0t\050%sq\0~\0\0\0\0\0\0\0\0\0\0t\040%sq\0~\0\0\0\0\0\0\0\0\0t\060%xt\0ТКП 2t\0Вопрос 3t\0TКакая влажность должна быть в сухом помещенииsq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\0\0\0\0\0\0\0\0\0t\070%sq\0~\0\0\0\0\0\0\0\0\0t\080%sq\0~\0\0\0\0\0\0\0\0\0\0t\060%sq\0~\0\0\0\0\0\0\0\0\0\0t\050%xt\0	ТКП 23t\0Вопрос 4t\0XКакая влажность должна быть в влажном помещенииx','Проектирование'),(3,'�\�\0sr\0java.util.ArrayListx�\��\�a�\0I\0sizexp\0\0\0w\0\0\0sr\0%by.dunaenergo.training.model.Question�-w�R\0J\0idL\0answerst\0Ljava/util/ArrayList;L\0descriptiont\0Ljava/lang/String;L\0\nshort_nameq\0~\0L\0textq\0~\0xp\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sr\0#by.dunaenergo.training.model.Answer�cO�\�\�\0J\0idZ\0validL\0textq\0~\0xp\0\0\0\0\0\0\0\0\0t\05При работах с трубопроводамиsq\0~\0\0\0\0\0\0\0\0\0\0t\08При работах в опасных условияхsq\0~\0\0\0\0\0\0\0\0\0t\0wПри выполнении всех видов работ на трансформаторных подстанцияхsq\0~\0\0\0\0\0\0\0\0\0\0t\0AПри прокладке элетрических кабелейxt\0ТКП пп.1.1.1t\0Вопрос 1t\0NВ каких случаях необходимо надевать каску?sq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\0\0\0\0\0\0\0\0\0t\01,2 мsq\0~\0\0\0\0\0\0\0\0\0\0t\02 мsq\0~\0\0\0\0\0\0\0\0\0\0t\00,5 мsq\0~\0\0\0\0\0\0\0\0\0t\01 мxt\0ТКПt\0Вопрос 2t\0>Какая должна быть глубина траншеиsq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\0\0\0\0\0\0\0\0\0t\030%sq\0~\0\0\0\0\0\0\0\0\0\0t\050%sq\0~\0\0\0\0\0\0\0\0\0\0t\040%sq\0~\0\0\0\0\0\0\0\0\0t\060%xt\0ТКП 2t\0Вопрос 3t\0TКакая влажность должна быть в сухом помещенииsq\0~\0\0\0\0\0\0\0\0sq\0~\0\0\0\0\0w\0\0\0sq\0~\0\0\0\0\0\0\0\0\0\0t\070%sq\0~\0\0\0\0\0\0\0\0\0t\080%sq\0~\0\0\0\0\0\0\0\0\0\0t\060%sq\0~\0\0\0\0\0\0\0\0\0\0t\050%xt\0	ТКП 23t\0Вопрос 4t\0XКакая влажность должна быть в влажном помещенииx','Электроснабжение');
/*!40000 ALTER TABLE `theme` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('duna','$2a$06$eHKA/Bf3RKBOz.VLsRn5YuNKt1e7ifYaJq5Lu0ILEF1fiTqz/WDBa',1),('user','$2a$06$9/K6t2bO/i8mdpBpL9mwq.HShYaFizVTKnzxDMlAYCWc8k1yEquqC',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-09-19 11:51:55
