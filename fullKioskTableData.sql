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

SET @@GLOBAL.GTID_PURGED=/*!80000 '+'*/ '4bd30c20-216e-11f1-b8d6-709188f6393a:1-17';

--
-- Table structure for table `allClothingItems_tbl`
--

DROP TABLE IF EXISTS `allClothingItems_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `allClothingItems_tbl` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `color` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `allClothingItems_tbl`
--

LOCK TABLES `allClothingItems_tbl` WRITE;
/*!40000 ALTER TABLE `allClothingItems_tbl` DISABLE KEYS */;
INSERT INTO `allClothingItems_tbl` VALUES (1,'Red T-Shirt','Shirt','Red'),(2,'Blue T-Shirt','Shirt','Blue'),(3,'Black Hoodie','Sweater','Black'),(4,'White Hoodie','Sweater','White'),(5,'Grey Sweatpants','Pants','Grey'),(6,'Black Jeans','Pants','Black'),(7,'Blue Jeans','Pants','Blue'),(8,'Khaki Shorts','Shorts','Khaki'),(9,'Denim Jacket','Jacket','Blue'),(10,'Leather Jacket','Jacket','Black'),(11,'White Dress Shirt','Shirt','White'),(12,'Black Dress Shirt','Shirt','Black'),(13,'Floral Dress','Dress','Pink'),(14,'Red Dress','Dress','Red'),(15,'Blue Dress','Dress','Blue'),(16,'Green Dress','Dress','Green'),(17,'Yellow Dress','Dress','Yellow'),(18,'Orange Dress','Dress','Orange'),(19,'Purple Dress','Dress','Purple'),(20,'Black Dress','Dress','Black'),(21,'White Dress','Dress','White'),(22,'Striped Shirt','Shirt','Multi'),(23,'Plaid Shirt','Shirt','Multi'),(24,'Graphic Tee','Shirt','Multi'),(25,'Tank Top','Shirt','White'),(26,'Crop Top','Shirt','Black'),(27,'Sweatshirt','Sweater','Grey'),(28,'Cardigan','Sweater','Beige'),(29,'Pullover','Sweater','Navy'),(30,'Blazer','Jacket','Black'),(31,'Suit Jacket','Jacket','Grey'),(32,'Rain Jacket','Jacket','Yellow'),(33,'Windbreaker','Jacket','Red'),(34,'Puffer Jacket','Jacket','Black'),(35,'Trench Coat','Jacket','Beige'),(36,'Cargo Pants','Pants','Green'),(37,'Joggers','Pants','Black'),(38,'Leggings','Pants','Black'),(39,'Yoga Pants','Pants','Grey'),(40,'Chinos','Pants','Khaki'),(41,'Dress Pants','Pants','Black'),(42,'Athletic Shorts','Shorts','Black'),(43,'Denim Shorts','Shorts','Blue'),(44,'Running Shorts','Shorts','Grey'),(45,'Basketball Shorts','Shorts','Red'),(46,'Mini Skirt','Skirt','Black'),(47,'Maxi Skirt','Skirt','White'),(48,'Pleated Skirt','Skirt','Grey'),(49,'Pencil Skirt','Skirt','Black'),(50,'Wrap Skirt','Skirt','Blue'),(51,'Overalls','Pants','Blue'),(52,'Jumpsuit','Suit','Black'),(53,'Romper','Suit','Floral'),(54,'Swimsuit','Swimwear','Blue'),(55,'Bikini','Swimwear','Red'),(56,'Swim Trunks','Swimwear','Black'),(57,'Bathrobe','Loungewear','White'),(58,'Pajama Set','Loungewear','Blue'),(59,'Nightgown','Loungewear','Pink'),(60,'Thermal Shirt','Shirt','Grey'),(61,'Thermal Pants','Pants','Grey'),(62,'Base Layer Top','Shirt','Black'),(63,'Base Layer Bottom','Pants','Black'),(64,'Hiking Jacket','Jacket','Green'),(65,'Ski Jacket','Jacket','Blue'),(66,'Snow Pants','Pants','Black'),(67,'Work Shirt','Shirt','Navy'),(68,'Work Pants','Pants','Brown'),(69,'Uniform Shirt','Shirt','White'),(70,'Uniform Pants','Pants','Black'),(71,'Chef Coat','Jacket','White'),(72,'Lab Coat','Jacket','White'),(73,'Scrubs Top','Shirt','Blue'),(74,'Scrubs Bottom','Pants','Blue'),(75,'Apron','Accessory','Black'),(76,'Vest','Jacket','Grey'),(77,'Suit Vest','Jacket','Black'),(78,'Poncho','Jacket','Brown'),(79,'Kimono','Robe','Multi'),(80,'Caftan','Dress','Multi'),(81,'Tunic','Shirt','White'),(82,'Henley Shirt','Shirt','Grey'),(83,'Polo Shirt','Shirt','Blue'),(84,'Rugby Shirt','Shirt','Green'),(85,'Baseball Jersey','Shirt','White'),(86,'Soccer Jersey','Shirt','Red'),(87,'Track Jacket','Jacket','Black'),(88,'Track Pants','Pants','Black'),(89,'Compression Shirt','Shirt','Black'),(90,'Compression Shorts','Shorts','Black'),(91,'Golf Shirt','Shirt','White'),(92,'Golf Pants','Pants','Beige'),(93,'Cycling Jersey','Shirt','Yellow'),(94,'Cycling Shorts','Shorts','Black'),(95,'Fishing Shirt','Shirt','Light Blue'),(96,'Hawaiian Shirt','Shirt','Multi'),(97,'Dress Vest','Jacket','Grey'),(98,'Evening Gown','Dress','Black'),(99,'Ball Gown','Dress','Blue'),(100,'Cocktail Dress','Dress','Red');
/*!40000 ALTER TABLE `allClothingItems_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itemsInStore_tbl`
--

DROP TABLE IF EXISTS `itemsInStore_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itemsInStore_tbl` (
  `storeID` int NOT NULL,
  `itemID` int NOT NULL,
  `inStock` tinyint(1) DEFAULT NULL,
  `price` decimal(5,2) DEFAULT NULL,
  `aisle` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`storeID`,`itemID`),
  KEY `itemID` (`itemID`),
  CONSTRAINT `itemsinstore_tbl_ibfk_1` FOREIGN KEY (`storeID`) REFERENCES `storesInMall_Tbl` (`ID`),
  CONSTRAINT `itemsinstore_tbl_ibfk_2` FOREIGN KEY (`itemID`) REFERENCES `allClothingItems_tbl` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itemsInStore_tbl`
--

LOCK TABLES `itemsInStore_tbl` WRITE;
/*!40000 ALTER TABLE `itemsInStore_tbl` DISABLE KEYS */;
INSERT INTO `itemsInStore_tbl` VALUES (1,1,1,19.99,'A1'),(1,5,1,34.99,'B1'),(1,6,1,49.99,'B2'),(1,9,1,69.99,'C1'),(1,11,1,39.99,'A2'),(1,14,1,79.99,'D1'),(1,20,0,89.99,'D2'),(1,31,1,99.99,'C2'),(1,40,1,44.99,'B3'),(1,46,1,29.99,'E1'),(1,47,1,39.99,'E2'),(1,50,1,42.99,'E3'),(1,97,1,149.99,'D3'),(1,98,0,199.99,'D4'),(1,99,1,119.99,'D5'),(1,100,1,109.99,'D6'),(2,1,1,12.99,'A1'),(2,2,1,12.99,'A1'),(2,7,1,29.99,'B1'),(2,8,1,17.99,'B2'),(2,13,1,34.99,'C1'),(2,15,1,34.99,'C2'),(2,16,1,34.99,'C3'),(2,23,1,19.99,'A2'),(2,24,1,16.99,'A3'),(2,25,1,14.99,'A4'),(2,26,1,16.99,'A5'),(2,36,1,29.99,'B3'),(2,37,1,24.99,'B4'),(2,43,1,19.99,'B5'),(2,46,1,24.99,'D1'),(2,51,1,39.99,'C4'),(2,52,1,44.99,'C5'),(2,53,0,29.99,'C6'),(2,80,1,22.99,'A6'),(2,81,1,18.99,'A7'),(3,42,1,24.99,'A1'),(3,44,1,29.99,'A2'),(3,45,1,34.99,'A3'),(3,67,1,39.99,'B1'),(3,84,1,54.99,'B2'),(3,85,1,44.99,'B3'),(3,86,1,49.99,'C1'),(3,87,1,34.99,'C2'),(3,90,1,39.99,'C3'),(3,91,0,49.99,'C4'),(3,93,1,59.99,'D1'),(3,94,1,45.99,'D2'),(6,11,1,45.99,'A1'),(6,12,1,45.99,'A2'),(6,14,1,69.99,'B1'),(6,15,1,69.99,'B2'),(6,18,1,72.99,'B3'),(6,20,1,79.99,'B4'),(6,21,0,79.99,'B5'),(6,30,1,89.99,'C1'),(6,31,1,109.99,'C2'),(6,35,1,129.99,'C3'),(6,39,1,35.99,'D1'),(6,40,1,49.99,'D2'),(6,46,1,39.99,'E1'),(6,48,1,45.99,'E2'),(6,49,1,49.99,'E3'),(6,50,1,44.99,'E4'),(6,79,1,42.99,'A3'),(6,95,1,59.99,'A4'),(8,13,1,59.99,'A1'),(8,16,1,64.99,'A2'),(8,19,1,69.99,'A3'),(8,21,1,74.99,'A4'),(8,26,1,24.99,'B1'),(8,38,1,39.99,'B2'),(8,39,1,44.99,'B3'),(8,47,1,39.99,'C1'),(8,50,0,42.99,'C2'),(8,55,1,49.99,'D1'),(8,56,1,39.99,'D2'),(8,59,1,34.99,'D3'),(10,1,1,11.99,'A1'),(10,2,1,11.99,'A1'),(10,8,1,15.99,'B1'),(10,13,1,29.99,'C1'),(10,14,1,31.99,'C2'),(10,15,1,31.99,'C3'),(10,17,1,32.99,'C4'),(10,18,1,34.99,'C5'),(10,22,1,16.99,'A2'),(10,24,1,14.99,'A3'),(10,25,1,12.99,'A4'),(10,26,1,14.99,'A5'),(10,36,1,27.99,'B2'),(10,43,1,17.99,'B3'),(10,46,1,21.99,'D1'),(10,48,1,24.99,'D2'),(10,49,0,26.99,'D3'),(10,53,1,24.99,'E1'),(10,80,1,18.99,'A6'),(10,96,1,27.99,'A7');
/*!40000 ALTER TABLE `itemsInStore_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storesInMall_tbl`
--

DROP TABLE IF EXISTS `storesInMall_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `storesInMall_tbl` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `telephone` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storesInMall_tbl`
--

LOCK TABLES `storesInMall_tbl` WRITE;
/*!40000 ALTER TABLE `storesInMall_tbl` DISABLE KEYS */;
INSERT INTO `storesInMall_tbl` VALUES (1,'Macy\'s','9095551001'),(2,'H&M','9095551002'),(3,'Foot Locker','9095551003'),(4,'Sephora','9095551004'),(5,'Apple Store','9095551005'),(6,'Zara','9095551006'),(7,'Bath & Body Works','9095551007'),(8,'Victoria\'s Secret','9095551008'),(9,'GameStop','9095551009'),(10,'Forever 21','9095551010');
/*!40000 ALTER TABLE `storesInMall_tbl` ENABLE KEYS */;
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

-- Dump completed on 2026-03-19 21:45:10
