-- MySQL dump 10.13  Distrib 9.6.0, for macos15 (arm64)
--
-- Host: localhost    Database: mall_kiosk_system
-- ------------------------------------------------------
-- Server version	9.6.0

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
SET @MYSQLDUMP_TEMP_LOG_BIN = @@SESSION.SQL_LOG_BIN;
SET @@SESSION.SQL_LOG_BIN= 0;

--
-- GTID state at the beginning of the backup 
--

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '4bd30c20-216e-11f1-b8d6-709188f6393a:1-34';

--
-- Table structure for table `inventory_tbl`
--

DROP TABLE IF EXISTS `inventory_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inventory_tbl` (
  `storeID` int NOT NULL,
  `itemID` int NOT NULL,
  `inStock` tinyint(1) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `aisle` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`storeID`,`itemID`),
  KEY `itemID` (`itemID`),
  CONSTRAINT `inventory_tbl_ibfk_1` FOREIGN KEY (`storeID`) REFERENCES `stores_tbl` (`ID`),
  CONSTRAINT `inventory_tbl_ibfk_2` FOREIGN KEY (`itemID`) REFERENCES `items_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory_tbl`
--

LOCK TABLES `inventory_tbl` WRITE;
/*!40000 ALTER TABLE `inventory_tbl` DISABLE KEYS */;
INSERT INTO `inventory_tbl` VALUES (1,1,1,19.99,'A1'),(1,5,1,34.99,'B1'),(1,6,1,49.99,'B2'),(1,9,1,69.99,'C1'),(1,11,1,39.99,'A2'),(1,14,1,79.99,'D1'),(1,20,0,89.99,'D2'),(1,31,1,99.99,'C2'),(1,40,1,44.99,'B3'),(1,46,1,29.99,'E1'),(1,47,1,39.99,'E2'),(1,50,1,42.99,'E3'),(1,97,1,149.99,'D3'),(1,98,0,199.99,'D4'),(1,99,1,119.99,'D5'),(1,100,1,109.99,'D6'),(2,1,1,12.99,'A1'),(2,2,1,12.99,'A1'),(2,7,1,29.99,'B1'),(2,8,1,17.99,'B2'),(2,13,1,34.99,'C1'),(2,15,1,34.99,'C2'),(2,16,1,34.99,'C3'),(2,23,1,19.99,'A2'),(2,24,1,16.99,'A3'),(2,25,1,14.99,'A4'),(2,26,1,16.99,'A5'),(2,36,1,29.99,'B3'),(2,37,1,24.99,'B4'),(2,43,1,19.99,'B5'),(2,46,1,24.99,'D1'),(2,51,1,39.99,'C4'),(2,52,1,44.99,'C5'),(2,53,0,29.99,'C6'),(2,80,1,22.99,'A6'),(2,81,1,18.99,'A7'),(3,42,1,24.99,'A1'),(3,44,1,29.99,'A2'),(3,45,1,34.99,'A3'),(3,67,1,39.99,'B1'),(3,84,1,54.99,'B2'),(3,85,1,44.99,'B3'),(3,86,1,49.99,'C1'),(3,87,1,34.99,'C2'),(3,90,1,39.99,'C3'),(3,91,0,49.99,'C4'),(3,93,1,59.99,'D1'),(3,94,1,45.99,'D2'),(6,11,1,45.99,'A1'),(6,12,1,45.99,'A2'),(6,14,1,69.99,'B1'),(6,15,1,69.99,'B2'),(6,18,1,72.99,'B3'),(6,20,1,79.99,'B4'),(6,21,0,79.99,'B5'),(6,30,1,89.99,'C1'),(6,31,1,109.99,'C2'),(6,35,1,129.99,'C3'),(6,39,1,35.99,'D1'),(6,40,1,49.99,'D2'),(6,46,1,39.99,'E1'),(6,48,1,45.99,'E2'),(6,49,1,49.99,'E3'),(6,50,1,44.99,'E4'),(6,79,1,42.99,'A3'),(6,95,1,59.99,'A4'),(8,13,1,59.99,'A1'),(8,16,1,64.99,'A2'),(8,19,1,69.99,'A3'),(8,21,1,74.99,'A4'),(8,26,1,24.99,'B1'),(8,38,1,39.99,'B2'),(8,39,1,44.99,'B3'),(8,47,1,39.99,'C1'),(8,50,0,42.99,'C2'),(8,55,1,49.99,'D1'),(8,56,1,39.99,'D2'),(8,59,1,34.99,'D3'),(10,1,1,11.99,'A1'),(10,2,1,11.99,'A1'),(10,8,1,15.99,'B1'),(10,13,1,29.99,'C1'),(10,14,1,31.99,'C2'),(10,15,1,31.99,'C3'),(10,17,1,32.99,'C4'),(10,18,1,34.99,'C5'),(10,22,1,16.99,'A2'),(10,24,1,14.99,'A3'),(10,25,1,12.99,'A4'),(10,26,1,14.99,'A5'),(10,36,1,27.99,'B2'),(10,43,1,17.99,'B3'),(10,46,1,21.99,'D1'),(10,48,1,24.99,'D2'),(10,49,0,26.99,'D3'),(10,53,1,24.99,'E1'),(10,80,1,18.99,'A6'),(10,96,1,27.99,'A7');
/*!40000 ALTER TABLE `inventory_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items_tbl`
--

DROP TABLE IF EXISTS `items_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items_tbl` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  `gender` varchar(25) DEFAULT NULL,
  `occasion` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items_tbl`
--

LOCK TABLES `items_tbl` WRITE;
/*!40000 ALTER TABLE `items_tbl` DISABLE KEYS */;
INSERT INTO `items_tbl` VALUES (1,'Red T-Shirt','Shirt','Red','unisex','casual'),(2,'Blue T-Shirt','Shirt','Blue','unisex','casual'),(3,'Black Hoodie','Sweater','Black','unisex','casual'),(4,'White Hoodie','Sweater','White','unisex','casual'),(5,'Grey Sweatpants','Pants','Grey','unisex','casual'),(6,'Black Jeans','Pants','Black','unisex','casual'),(7,'Blue Jeans','Pants','Blue','unisex','casual'),(8,'Khaki Shorts','Shorts','Khaki','unisex','casual'),(9,'Denim Jacket','Jacket','Blue','unisex','casual'),(10,'Leather Jacket','Jacket','Black','unisex','casual'),(11,'White Dress Shirt','Shirt','White','unisex','casual'),(12,'Black Dress Shirt','Shirt','Black','unisex','casual'),(13,'Floral Dress','Dress','Pink','women','formal'),(14,'Red Dress','Dress','Red','women','formal'),(15,'Blue Dress','Dress','Blue','women','formal'),(16,'Green Dress','Dress','Green','women','formal'),(17,'Yellow Dress','Dress','Yellow','women','formal'),(18,'Orange Dress','Dress','Orange','women','formal'),(19,'Purple Dress','Dress','Purple','women','formal'),(20,'Black Dress','Dress','Black','women','formal'),(21,'White Dress','Dress','White','women','formal'),(22,'Striped Shirt','Shirt','Multi','unisex','casual'),(23,'Plaid Shirt','Shirt','Multi','unisex','casual'),(24,'Graphic Tee','Shirt','Multi','unisex','casual'),(25,'Tank Top','Shirt','White','unisex','casual'),(26,'Crop Top','Shirt','Black','unisex','casual'),(27,'Sweatshirt','Sweater','Grey','unisex','casual'),(28,'Cardigan','Sweater','Beige','unisex','casual'),(29,'Pullover','Sweater','Navy','unisex','casual'),(30,'Blazer','Jacket','Black','unisex','casual'),(31,'Suit Jacket','Jacket','Grey','unisex','casual'),(32,'Rain Jacket','Jacket','Yellow','unisex','casual'),(33,'Windbreaker','Jacket','Red','unisex','casual'),(34,'Puffer Jacket','Jacket','Black','unisex','casual'),(35,'Trench Coat','Jacket','Beige','unisex','casual'),(36,'Cargo Pants','Pants','Green','unisex','casual'),(37,'Joggers','Pants','Black','unisex','casual'),(38,'Leggings','Pants','Black','unisex','casual'),(39,'Yoga Pants','Pants','Grey','unisex','casual'),(40,'Chinos','Pants','Khaki','unisex','casual'),(41,'Dress Pants','Pants','Black','unisex','casual'),(42,'Athletic Shorts','Shorts','Black','unisex','casual'),(43,'Denim Shorts','Shorts','Blue','unisex','casual'),(44,'Running Shorts','Shorts','Grey','unisex','casual'),(45,'Basketball Shorts','Shorts','Red','unisex','casual'),(46,'Mini Skirt','Skirt','Black','women','casual'),(47,'Maxi Skirt','Skirt','White','women','casual'),(48,'Pleated Skirt','Skirt','Grey','women','casual'),(49,'Pencil Skirt','Skirt','Black','women','casual'),(50,'Wrap Skirt','Skirt','Blue','women','casual'),(51,'Overalls','Pants','Blue','unisex','casual'),(52,'Jumpsuit','Suit','Black','unisex','casual'),(53,'Romper','Suit','Floral','unisex','casual'),(54,'Swimsuit','Swimwear','Blue','unisex','casual'),(55,'Bikini','Swimwear','Red','unisex','casual'),(56,'Swim Trunks','Swimwear','Black','unisex','casual'),(57,'Bathrobe','Loungewear','White','unisex','casual'),(58,'Pajama Set','Loungewear','Blue','unisex','casual'),(59,'Nightgown','Loungewear','Pink','unisex','casual'),(60,'Thermal Shirt','Shirt','Grey','unisex','casual'),(61,'Thermal Pants','Pants','Grey','unisex','casual'),(62,'Base Layer Top','Shirt','Black','unisex','casual'),(63,'Base Layer Bottom','Pants','Black','unisex','casual'),(64,'Hiking Jacket','Jacket','Green','unisex','casual'),(65,'Ski Jacket','Jacket','Blue','unisex','casual'),(66,'Snow Pants','Pants','Black','unisex','casual'),(67,'Work Shirt','Shirt','Navy','unisex','casual'),(68,'Work Pants','Pants','Brown','unisex','casual'),(69,'Uniform Shirt','Shirt','White','unisex','casual'),(70,'Uniform Pants','Pants','Black','unisex','casual'),(71,'Chef Coat','Jacket','White','unisex','casual'),(72,'Lab Coat','Jacket','White','unisex','casual'),(73,'Scrubs Top','Shirt','Blue','unisex','casual'),(74,'Scrubs Bottom','Pants','Blue','unisex','casual'),(75,'Apron','Accessory','Black','unisex','casual'),(76,'Vest','Jacket','Grey','unisex','casual'),(77,'Suit Vest','Jacket','Black','unisex','casual'),(78,'Poncho','Jacket','Brown','unisex','casual'),(79,'Kimono','Robe','Multi','unisex','casual'),(80,'Caftan','Dress','Multi','women','formal'),(81,'Tunic','Shirt','White','unisex','casual'),(82,'Henley Shirt','Shirt','Grey','unisex','casual'),(83,'Polo Shirt','Shirt','Blue','unisex','casual'),(84,'Rugby Shirt','Shirt','Green','unisex','casual'),(85,'Baseball Jersey','Shirt','White','unisex','casual'),(86,'Soccer Jersey','Shirt','Red','unisex','casual'),(87,'Track Jacket','Jacket','Black','unisex','casual'),(88,'Track Pants','Pants','Black','unisex','casual'),(89,'Compression Shirt','Shirt','Black','unisex','casual'),(90,'Compression Shorts','Shorts','Black','unisex','casual'),(91,'Golf Shirt','Shirt','White','unisex','casual'),(92,'Golf Pants','Pants','Beige','unisex','casual'),(93,'Cycling Jersey','Shirt','Yellow','unisex','casual'),(94,'Cycling Shorts','Shorts','Black','unisex','casual'),(95,'Fishing Shirt','Shirt','Light Blue','unisex','casual'),(96,'Hawaiian Shirt','Shirt','Multi','unisex','casual'),(97,'Dress Vest','Jacket','Grey','unisex','casual'),(98,'Evening Gown','Dress','Black','women','formal'),(99,'Ball Gown','Dress','Blue','women','formal'),(100,'Cocktail Dress','Dress','Red','women','formal');
/*!40000 ALTER TABLE `items_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `receipt_tbl`
--

DROP TABLE IF EXISTS `receipt_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `receipt_tbl` (
  `ReceiptID` int NOT NULL AUTO_INCREMENT,
  `SessionID` int DEFAULT NULL,
  `OutfitID` int DEFAULT NULL,
  `GeneratedAt` datetime DEFAULT NULL,
  `TotalPrice` float DEFAULT NULL,
  PRIMARY KEY (`ReceiptID`),
  UNIQUE KEY `SessionID` (`SessionID`),
  CONSTRAINT `receipt_tbl_ibfk_1` FOREIGN KEY (`SessionID`) REFERENCES `session_tbl` (`SessionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `receipt_tbl`
--

LOCK TABLES `receipt_tbl` WRITE;
/*!40000 ALTER TABLE `receipt_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `receipt_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `session_tbl`
--

DROP TABLE IF EXISTS `session_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `session_tbl` (
  `SessionID` int NOT NULL AUTO_INCREMENT,
  `StartTime` datetime DEFAULT NULL,
  `EndTime` datetime DEFAULT NULL,
  PRIMARY KEY (`SessionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `session_tbl`
--

LOCK TABLES `session_tbl` WRITE;
/*!40000 ALTER TABLE `session_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `session_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storeHours_tbl`
--

DROP TABLE IF EXISTS `storeHours_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storeHours_tbl` (
  `storeID` int NOT NULL,
  `dayOfWeek` varchar(10) NOT NULL,
  `openTime` time DEFAULT NULL,
  `closeTime` time DEFAULT NULL,
  PRIMARY KEY (`storeID`,`dayOfWeek`),
  CONSTRAINT `storehours_tbl_ibfk_1` FOREIGN KEY (`storeID`) REFERENCES `stores_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storeHours_tbl`
--

LOCK TABLES `storeHours_tbl` WRITE;
/*!40000 ALTER TABLE `storeHours_tbl` DISABLE KEYS */;
INSERT INTO `storeHours_tbl` VALUES (1,'Friday','10:00:00','22:00:00'),(1,'Monday','10:00:00','21:00:00'),(1,'Saturday','10:00:00','22:00:00'),(1,'Sunday','11:00:00','19:00:00'),(1,'Thursday','10:00:00','21:00:00'),(1,'Tuesday','10:00:00','21:00:00'),(1,'Wednesday','10:00:00','21:00:00'),(2,'Friday','09:00:00','21:00:00'),(2,'Monday','09:00:00','20:00:00'),(2,'Saturday','09:00:00','21:00:00'),(2,'Sunday','11:00:00','18:00:00'),(2,'Thursday','09:00:00','20:00:00'),(2,'Tuesday','09:00:00','20:00:00'),(2,'Wednesday','09:00:00','20:00:00'),(3,'Friday','10:00:00','21:00:00'),(3,'Monday','10:00:00','20:00:00'),(3,'Saturday','10:00:00','21:00:00'),(3,'Sunday','12:00:00','18:00:00'),(3,'Thursday','10:00:00','20:00:00'),(3,'Tuesday','10:00:00','20:00:00'),(3,'Wednesday','10:00:00','20:00:00'),(4,'Friday','11:00:00','20:00:00'),(4,'Monday','11:00:00','19:00:00'),(4,'Saturday','10:00:00','20:00:00'),(4,'Sunday','12:00:00','17:00:00'),(4,'Thursday','11:00:00','19:00:00'),(4,'Tuesday','11:00:00','19:00:00'),(4,'Wednesday','11:00:00','19:00:00'),(5,'Friday','10:00:00','22:00:00'),(5,'Monday','10:00:00','21:00:00'),(5,'Saturday','10:00:00','22:00:00'),(5,'Sunday','11:00:00','19:00:00'),(5,'Thursday','10:00:00','21:00:00'),(5,'Tuesday','10:00:00','21:00:00'),(5,'Wednesday','10:00:00','21:00:00'),(6,'Friday','09:00:00','21:00:00'),(6,'Monday','09:00:00','19:00:00'),(6,'Saturday','09:00:00','21:00:00'),(6,'Sunday','09:00:00','19:00:00'),(6,'Thursday','09:00:00','19:00:00'),(6,'Tuesday','09:00:00','19:00:00'),(6,'Wednesday','09:00:00','19:00:00'),(7,'Friday','10:00:00','23:00:00'),(7,'Monday','11:00:00','20:00:00'),(7,'Saturday','09:00:00','20:00:00'),(7,'Sunday','11:00:00','18:00:00'),(7,'Thursday','11:00:00','19:00:00'),(7,'Tuesday','11:00:00','19:00:00'),(7,'Wednesday','11:00:00','18:00:00'),(8,'Friday','08:00:00','22:00:00'),(8,'Monday','08:00:00','20:00:00'),(8,'Saturday','08:00:00','22:00:00'),(8,'Sunday','08:00:00','22:00:00'),(8,'Thursday','08:00:00','20:00:00'),(8,'Tuesday','08:00:00','20:00:00'),(8,'Wednesday','08:00:00','20:00:00'),(9,'Friday','08:00:00','22:00:00'),(9,'Monday','08:00:00','20:00:00'),(9,'Saturday','08:00:00','22:00:00'),(9,'Sunday','08:00:00','22:00:00'),(9,'Thursday','08:00:00','20:00:00'),(9,'Tuesday','08:00:00','20:00:00'),(9,'Wednesday','08:00:00','20:00:00'),(10,'Friday','08:00:00','22:00:00'),(10,'Monday','08:00:00','20:00:00'),(10,'Saturday','08:00:00','22:00:00'),(10,'Sunday','08:00:00','22:00:00'),(10,'Thursday','08:00:00','20:00:00'),(10,'Tuesday','08:00:00','20:00:00'),(10,'Wednesday','08:00:00','20:00:00');
/*!40000 ALTER TABLE `storeHours_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stores_tbl`
--

DROP TABLE IF EXISTS `stores_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stores_tbl` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stores_tbl`
--

LOCK TABLES `stores_tbl` WRITE;
/*!40000 ALTER TABLE `stores_tbl` DISABLE KEYS */;
INSERT INTO `stores_tbl` VALUES (1,'Macy\'s','9095551001'),(2,'H&M','9095551002'),(3,'Foot Locker','9095551003'),(4,'Sephora','9095551004'),(5,'Apple Store','9095551005'),(6,'Zara','9095551006'),(7,'Bath & Body Works','9095551007'),(8,'Victoria\'s Secret','9095551008'),(9,'GameStop','9095551009'),(10,'Forever 21','9095551010');
/*!40000 ALTER TABLE `stores_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userProfile_tbl`
--

DROP TABLE IF EXISTS `userProfile_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `userProfile_tbl` (
  `ProfileID` int NOT NULL AUTO_INCREMENT,
  `SessionID` int DEFAULT NULL,
  `Gender` varchar(50) DEFAULT NULL,
  `ColorPalette` varchar(100) DEFAULT NULL,
  `TopSize` varchar(20) DEFAULT NULL,
  `BottomSize` varchar(20) DEFAULT NULL,
  `ShoeSize` float DEFAULT NULL,
  PRIMARY KEY (`ProfileID`),
  UNIQUE KEY `SessionID` (`SessionID`),
  CONSTRAINT `userprofile_tbl_ibfk_1` FOREIGN KEY (`SessionID`) REFERENCES `session_tbl` (`SessionID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userProfile_tbl`
--

LOCK TABLES `userProfile_tbl` WRITE;
/*!40000 ALTER TABLE `userProfile_tbl` DISABLE KEYS */;
/*!40000 ALTER TABLE `userProfile_tbl` ENABLE KEYS */;
UNLOCK TABLES;
SET @@SESSION.SQL_LOG_BIN = @MYSQLDUMP_TEMP_LOG_BIN;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-04-22 14:27:46
