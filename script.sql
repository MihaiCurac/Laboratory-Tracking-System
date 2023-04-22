
--
-- Table structure for table `assignments`
--

DROP TABLE IF EXISTS `assignments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `assignments` (
  `id` int NOT NULL,
  `lab_id` int NOT NULL,
  `name` varchar(255) NOT NULL,
  `deadline` date NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `assignments_ibfk_1` (`lab_id`),
  CONSTRAINT `assignments_ibfk_1` FOREIGN KEY (`lab_id`) REFERENCES `laboratories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `assignments` WRITE;
/*!40000 ALTER TABLE `assignments` DISABLE KEYS */;
INSERT INTO `assignments` VALUES (1,1,'Ticket Selling System','2023-04-01','Use JAVA/C# to design and implement a ticket selling system for the Untold music festival. The application should have two types of users (a cashier and an administrator) which must provide a username and a password to use the application.');
/*!40000 ALTER TABLE `assignments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `id` int NOT NULL,
  `lab_id` int DEFAULT NULL,
  `students` varchar(2000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `attendance_ibfk_1` (`lab_id`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`lab_id`) REFERENCES `laboratories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,1,'Andrei Popescu, Daniel Maria, Florin Munteanu, Mihai Curac, Zimbru Pop'),(2,4,'Test Test, Andrei Popescu, Daniel Maria, Florin Munteanu, Mara Ghenea, Mihai Curac, Zimbru Pop');
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `laboratories`
--

DROP TABLE IF EXISTS `laboratories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `laboratories` (
  `id` int NOT NULL,
  `nr` int NOT NULL,
  `date` date NOT NULL,
  `title` varchar(255) NOT NULL,
  `curricula` varchar(255) NOT NULL,
  `description` varchar(2000) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `laboratories` WRITE;
/*!40000 ALTER TABLE `laboratories` DISABLE KEYS */;
INSERT INTO `laboratories` VALUES (1,1,'2023-03-01','UML Diagrams Recap. SOLID Principles','UML Diagrams, SOLID Principles','În cadrul acestei lucrări se urmărește recapitularea diagramelor UML (diagrama cazurilor de utilizare și diagrama de clase) și consolidarea principiilor SOLID.'),(2,2,'2023-03-14','Database connections and specific operations','Database Connections','În cadrul acestei lucrări se urmărește consolidarea operațiilor de creare a unei bazei de date, de realizare a conexiunii la baza de date, de creare a tabelelor și de interogare a tabelelor bazei de date, precum și de scriere a testelor unitate pentru fiecare operație specifică bazei de date.'),(3,5,'2023-03-07','Database connections and specific operations','Database Connection','În cadrul acestei lucrări se urmărește consolidarea operațiilor de creare a unei bazei de date, de realizare a conexiunii la baza de date, de creare a tabelelor și de interogare a tabelelor bazei de date, precum și de scriere a testelor unitate pentru fiecare operație specifică bazei de date.'),(4,6,'2023-04-07','MVC and MVVM architectural patterns','MVC, MVVM','În cadrul acestei lucrări de laborator se urmărește consolidarea abilităților în utilizarea eficientă a șabloanelor arhitecturale MVC (Model-View-Controller) și MVVM (Model-View-ViewModel)');
/*!40000 ALTER TABLE `laboratories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` int NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `full_name` varchar(255) NOT NULL,
  `group_nr` int NOT NULL,
  `hobby` varchar(255) NOT NULL,
  `token` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `students_ibfk_1` (`email`),
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`email`) REFERENCES `users` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (1,'curacmihai@gmail.com','Mihai Curac',30431,'Video Games','YiIOM2JYt0hKy3OONFCUMi8YO3WeN024KpCW0MGxtw4q24g2pGqmyFlFtSf5sQBhIXaXE5jGfqUxX6lOX6dVzrz1H6Rr8coooDIHPGZwxiCq6WscSmKthc6vwguvRZfX'),(2,'andreipopescu@gmail.com','Andrei Popescu',30431,'Playing tennis','lxrJ9D3Rwa8X8sh80Sm6kzJnQzuJX3k2F3ix8u1FHFYt8QEtuhZG0EpIuCJvPH0A7F4r2Eed0mbnNpph6f2xk3T2xpqKrbKEJTO1ceVzR0sPfknj8g98zwFlpbFp6zpc');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `email` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `role` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;


LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'teacher1@gmail.com','dGVhY2hlcjE=','teacher'),(2,'curacmihai@gmail.com','c3R1ZGVudDE=','student'),(3,'teacher2@yahoo.com','dGVhY2hlcjI=','teacher'),(5,'andreipopescu@gmail.com','c3R1ZGVudDI=','student');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
