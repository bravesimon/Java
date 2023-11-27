-- MySQL dump 10.13  Distrib 8.2.0, for macos13 (x86_64)
--
-- Host: localhost    Database: f1
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `eredmeny`
--

DROP TABLE IF EXISTS `eredmeny`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `eredmeny` (
  `datum` int DEFAULT NULL,
  `pilotaaz` int unsigned NOT NULL,
  `helyezes` varchar(10) DEFAULT NULL,
  `hiba` varchar(150) DEFAULT NULL,
  `csapat` varchar(150) NOT NULL,
  `tipus` varchar(150) NOT NULL,
  `motor` varchar(150) NOT NULL
);
--ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `eredmeny`
--

--LOCK TABLES `eredmeny` WRITE;
/*!40000 ALTER TABLE `eredmeny` DISABLE KEYS */;
INSERT INTO `eredmeny` VALUES (19540717,460,'11','','Sir Jeremy Boles','Connaught ','Lea'),(19500903,42,'2','','Scuderia Ferrari','Ferrari ','Ferrari'),(19511028,248,'','gyujtes','Scuderia Ferrari','Ferrari ','Ferrari'),(19510729,721,'3','','Scuderia Ferrari','Ferrari ','Ferrari'),(19510530,167,'','tengely','Ludson Morris','Kurtis ','Offenhauser'),(19570530,645,'9','','Phillips','Phillips','Offenhauser'),(19590802,597,'6','','Scuderia Centro Sud','Cooper ','Maserati'),(19600530,43,'','gyujtas','Kurtis Kraft','Kurtis ','Offenhauser'),(19530530,683,'9','','JC Agajanian','Kurtis ','Offenhauser'),(19500521,625,'4','','Scuderia Ferrari','Ferrari ','Ferrari'),(19570519,83,'','karambol','Vandervell Products Ltd','Vanwall','Vanwall'),(19550522,83,'9','','Daimler Benz AG','Mercedes ','Mercedes'),(19520518,382,'2','','Ecurie Espadon','Ferrari ','Ferrari'),(19590531,19,'4','','Team Lotus','Lotus ','Climax'),(19570908,1,'2','','Officine Alfieri Maserati','Maserati ','Maserati'),(19600606,743,'','futom','Team Lotus','Lotus ','Climax'),(19540801,759,'8','','Ecurie Rosier','Ferrari ','Ferrari'),(19580706,452,'','motor','Scuderia Centro Sud','Maserati ','Maserati'),(19560603,83,'3','','Officine Alfieri Maserati','Maserati ','Maserati'),(19560122,45,'6','','Alberto Uria','Maserati ','Maserati');
/*!40000 ALTER TABLE `eredmeny` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `form`
--

DROP TABLE IF EXISTS `form`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `form` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `message` varchar(500) NOT NULL,
  `sent` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
);
-- ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `form`
--

--LOCK TABLES `form` WRITE;
/*!40000 ALTER TABLE `form` DISABLE KEYS */;
INSERT INTO `form` VALUES (1,'Bela2','Tetszik','2023.11.24 12:46'),(2,'Jozsef','nagyon joo','2023.11.24 12:48'),(3,'Jozsef3','valami valami','2023.11.23 11:00'),(4,'Jozsef5','valami valami','2023.11.24 16:00'),(5,'Pistike','nem tudom','2023.11.24 1:33'),(6,'Jozsef','nagyon jo','2023.11.24 1:35');
/*!40000 ALTER TABLE `form` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `gp`
--

DROP TABLE IF EXISTS `gp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gp` (
  `datum` int DEFAULT NULL,
  `nev` varchar(150) NOT NULL,
  `helyszin` varchar(150) NOT NULL
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gp`
--

--LOCK TABLES `gp` WRITE;
/*!40000 ALTER TABLE `gp` DISABLE KEYS */;
INSERT INTO `gp` VALUES (19940515,'Monacoi','Monaco'),(19790714,'Brit','Nagy-Britannia'),(19760718,'Brit','Nagy-Britannia'),(19940731,'Nemet','Nemetorszag'),(19780910,'Olasz','Olaszorszag'),(19760815,'Osztrak','Ausztria'),(20061008,'Japan','Japan'),(19520518,'Svajci','Svajc'),(19830814,'Osztrak','Ausztria'),(19930523,'Monacoi','Monaco'),(20040530,'Europa','Nemetorszag'),(19500521,'Monacoi','Monaco'),(19870621,'USA','USA'),(19550530,'Indy 500','USA'),(19930725,'Nemet','Nemetorszag'),(19740707,'Francia','Franciaorszag'),(19750622,'Holland','Hollandia'),(20011014,'Japan','Japan'),(19790204,'Brazil','Brazilia'),(19760829,'Holland','Hollandia'),(19990926,'Europa','Nemetorszag'),(19540905,'Olasz','Olaszorszag'),(19921108,'Ausztral','Ausztralia'),(19940417,'Japan','Japan'),(19760328,'USA','USA'),(19830925,'Europa','Nagy-Britannia'),(19891022,'Japan','Japan'),(19770814,'Osztrak','Ausztria'),(20020331,'Brazil','Brazilia'),(19951112,'Ausztral','Ausztralia'),(19741006,'USA','USA'),(19570519,'Monacoi','Monaco'),(19910512,'Monacoi','Monaco'),(19620721,'Brit','Nagy-Britannia'),(19851019,'Del-Afrikai','Del-Afrika'),(19851103,'Ausztral','Ausztralia'),(19950611,'Kanadai','Kanada'),(19540704,'Francia','Franciaorszag'),(19570720,'Brit','Nagy-Britannia'),(20041010,'Japan','Japan'),(19840909,'Olasz','Olaszorszag'),(19920927,'Portugal','Portugalia'),(19820606,'USA','USA'),(19590802,'Nemet','Nemetorszag'),(20060319,'Malaj','Malaysia'),(19810412,'Argentin','Argentina'),(20050821,'Torok','Torokorszag'),(19991031,'Japan','Japan'),(19800127,'Brazil','Brazilia'),(19781001,'USA','USA'),(20010715,'Brit','Nagy-Britannia'),(19990530,'Spanyol','Spanyolorszag'),(19631027,'Mexikoi','Mexiko'),(19820123,'Del-Afrikai','Del-Afrika'),(19870517,'Belga','Belgium'),(19990627,'Francia','Franciaorszag'),(19790527,'Monacoi','Monaco'),(19641004,'USA','USA'),(19910310,'USA','USA'),(19940612,'Kanadai','Kanada'),(20060312,'Bahreini','Bahrain'),(20010429,'Spanyol','Spanyolorszag'),(20050508,'Spanyol','Spanyolorszag'),(19790930,'Kanadai','Kanada'),(20000730,'Nemet','Nemetorszag'),(19991017,'Malaj','Malaysia'),(19870906,'Olasz','Olaszorszag'),(19790729,'Nemet','Nemetorszag'),(19511028,'Spanyol','Spanyolorszag'),(19920614,'Kanadai','Kanada'),(20060806,'Magyar','Magyarorszag'),(20020317,'Malaj','Malaysia'),(19560714,'Brit','Nagy-Britannia'),(19610806,'Nemet','Nemetorszag'),(20050612,'Kanadai','Kanada'),(19541024,'Spanyol','Spanyolorszag'),(19830501,'San Marinoi','San Marino'),(19890716,'Brit','Nagy-Britannia'),(19640510,'Monacoi','Monaco'),(19740609,'Sved','Svedorszag'),(20040523,'Monacoi','Monaco'),(20031012,'Japan','Japan'),(20030420,'San Marinoi','San Marino'),(20060910,'Olasz','Olaszorszag'),(19990516,'Monacoi','Monaco'),(20040613,'Kanadai','Kanada'),(19990725,'Osztrak','Ausztria');
/*!40000 ALTER TABLE `gp` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `gp_model`
--

DROP TABLE IF EXISTS `gp_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gp_model` (
  `id` int NOT NULL AUTO_INCREMENT,
  `datum` int DEFAULT NULL,
  `nev` varchar(255) DEFAULT NULL,
  `helyszin` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gp_model`
--

--LOCK TABLES `gp_model` WRITE;
/*!40000 ALTER TABLE `gp_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `gp_model` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `pilot_model`
--

DROP TABLE IF EXISTS `pilot_model`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pilot_model` (
  `id` int NOT NULL AUTO_INCREMENT,
  `az` int DEFAULT NULL,
  `nev` varchar(255) DEFAULT NULL,
  `nemzet` varchar(255) DEFAULT NULL,
  `nem` varchar(255) DEFAULT NULL,
  `szuldat` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pilot_model`
--

--LOCK TABLES `pilot_model` WRITE;
/*!40000 ALTER TABLE `pilot_model` DISABLE KEYS */;
/*!40000 ALTER TABLE `pilot_model` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `pilota`
--

DROP TABLE IF EXISTS `pilota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pilota` (
  `az` int unsigned NOT NULL,
  `nev` varchar(150) NOT NULL,
  `nem` varchar(5) NOT NULL,
  `szuldat` varchar(255) DEFAULT NULL,
  `nemzet` varchar(150) NOT NULL
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pilota`
--

--LOCK TABLES `pilota` WRITE;
/*!40000 ALTER TABLE `pilota` DISABLE KEYS */;
INSERT INTO `pilota` VALUES (1,'Juan-Manuel Fangio','F','1911-06-24','argentin'),(2,'Sam Posey','F','1944-05-26','amerikai'),(3,'Ernesto Prinoth','F','1923-01-01','olasz'),(4,'Hubert Hahne','F','1935-03-28','nemet'),(5,'Bob Drake','F','1919-12-14','amerikai'),(6,'Perry McCarthy','F','1962-03-03','brit'),(7,'Bertil Roos','F','1943-10-12','sved'),(8,'Tom Pryce','F','1949-06-11','brit'),(9,'Heinz-Harald Frentzen','F','1967-05-18','nemet'),(10,'Eddie Russo','F','1925-11-19','amerikai'),(11,'Derek Warwick','F','1954-08-27','brit'),(12,'Jo Siffert','F','1936-07-07','svajci'),(13,'Fabrizio Barbazza','F','1963-04-02','olasz'),(14,'Damon Hill','F','1960-09-17','brit'),(15,'Mike Harris','F','1939-05-25','zimbabwei'),(16,'Hans Heyer','F','1943-03-16','nemet'),(17,'Peter Revson','F','1939-02-27','amerikai'),(18,'Huub Rothengatter','F','1954-10-08','holland'),(19,'Innes Ireland','F','1930-12-16','brit'),(20,'Bill Holland','F','1907-12-13','amerikai'),(21,'Franck Lagorce','F','1968-09-01','francia');
/*!40000 ALTER TABLE `pilota` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `id` int NOT NULL AUTO_INCREMENT,
  `datum` int DEFAULT NULL,
  `hiba` varchar(255) DEFAULT NULL,
  `motor` varchar(255) DEFAULT NULL,
  `pilotaaz` int DEFAULT NULL,
  `helyezes` varchar(255) DEFAULT NULL,
  `csapat` varchar(255) DEFAULT NULL,
  `tipus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
);
-- ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

--LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
--UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(30) NOT NULL DEFAULT 'ROLE_USER',
  PRIMARY KEY (`id`)
);
-- ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

--LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'admin','admin.hu','$2a$10$h1ym3oeSAkrmPhsd2Y.0XOihKZCto9915nyOqp3V8IuhO8zfkltfm','ROLE_ADMIN'),(2,'bela','bela.hu','$2a$10$pxjKnD/LBx3s9jpLvTifVe0qmlNanvjVKNy3oM6gm6UqDjOm7mR8i','ROLE_Vendeg'),(3,'admin2','admin2.hu','$2a$10$xOXHh8ygoTFdXKTvYXVoHuWiZDXSnI.nqptKYocWQDfzRkdiGUZty','ROLE_ADMIN'),(4,'patrik','patrik@p.hu','$2a$10$UV/vowFMlklMoYAwPyLLkO42sg4P8EqNjaYcLX1qT4Ad9PbeGuNEq','ROLE_Vendeg'),(5,'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa','alma','$2a$10$khCZrlrpxd.zkh.aG2un3Ow42XbOHAJ2pCJkHU1yTqXWa4qDVhr56','ROLE_Vendeg');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
--UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-24 16:06:55
