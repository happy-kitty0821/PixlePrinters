-- MariaDB dump 10.19  Distrib 10.11.6-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: PixlePrint
-- ------------------------------------------------------
-- Server version	10.11.6-MariaDB-0+deb12u1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Brand`
--

DROP TABLE IF EXISTS `Brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Brand` (
  `brandId` int(11) NOT NULL AUTO_INCREMENT,
  `companyName` varchar(100) NOT NULL,
  `country` varchar(100) DEFAULT NULL,
  `contactInformation` varchar(255) DEFAULT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`brandId`),
  UNIQUE KEY `CompanyName` (`companyName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Brand`
--

LOCK TABLES `Brand` WRITE;
/*!40000 ALTER TABLE `Brand` DISABLE KEYS */;
INSERT INTO `Brand` VALUES
(1,'Canon','US','canon@us.com','canon.com'),
(2,'FujiFlim','Japan','FujiFlim@gmail.com','fujiflim.com'),
(3,'Axonix','US','axonix.@printercom.us','axonix.com.us'),
(4,'Epson','Us','1234567890','epson.com');
/*!40000 ALTER TABLE `Brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Cart`
--

DROP TABLE IF EXISTS `Cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Cart` (
  `userId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `productName` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  PRIMARY KEY (`userId`,`productId`),
  KEY `Cart_ibfk_2` (`productId`),
  CONSTRAINT `Cart_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`),
  CONSTRAINT `Cart_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `Product` (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cart`
--

LOCK TABLES `Cart` WRITE;
/*!40000 ALTER TABLE `Cart` DISABLE KEYS */;
INSERT INTO `Cart` VALUES
(1,1,'PIXMA G44770',6,10000.00),
(1,2,'axonix',2,10000.00);
/*!40000 ALTER TABLE `Cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ContactUsFormMessage`
--

DROP TABLE IF EXISTS `ContactUsFormMessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ContactUsFormMessage` (
  `MessageId` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `ContactNumber` varchar(100) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `Message` varchar(255) NOT NULL,
  `DateTime` datetime NOT NULL DEFAULT current_timestamp(),
  PRIMARY KEY (`MessageId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ContactUsFormMessage`
--

LOCK TABLES `ContactUsFormMessage` WRITE;
/*!40000 ALTER TABLE `ContactUsFormMessage` DISABLE KEYS */;
INSERT INTO `ContactUsFormMessage` VALUES
(1,'nice','+977 9862162552','np05cp4a220010@iic.edu.np','this is a test message','2024-05-04 11:17:24');
/*!40000 ALTER TABLE `ContactUsFormMessage` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Product`
--

DROP TABLE IF EXISTS `Product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Product` (
  `productId` int(11) NOT NULL AUTO_INCREMENT,
  `productName` varchar(100) NOT NULL,
  `productDesc` longtext NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int(11) NOT NULL,
  `companyName` varchar(100) NOT NULL,
  `productImage` varchar(55) DEFAULT NULL,
  `printTechnology` enum('Inkjet','Laser','LED','Dot Matrix','Dye Sublimation') NOT NULL,
  `printSpeed` varchar(50) NOT NULL,
  `printResulotion` varchar(50) NOT NULL,
  `weight` varchar(50) NOT NULL,
  `dimensions` varchar(40) NOT NULL,
  `operatingSystem` varchar(150) NOT NULL,
  `supportedPageSize` varchar(200) NOT NULL,
  `color` varchar(50) DEFAULT NULL,
  `printColor` enum('Black','White','Both') NOT NULL,
  PRIMARY KEY (`productId`),
  UNIQUE KEY `uc_productName` (`productName`),
  KEY `CompanyName` (`companyName`),
  CONSTRAINT `Product_ibfk_1` FOREIGN KEY (`companyName`) REFERENCES `Brand` (`companyName`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Product`
--

LOCK TABLES `Product` WRITE;
/*!40000 ALTER TABLE `Product` DISABLE KEYS */;
INSERT INTO `Product` VALUES
(1,'PIXMA G44770 ','this is a good product',10000.00,19,'Canon','L18050-(4).jpg','Laser','532 CPM','4,800 (horizontal)*1 x 1,200 (vertical) dpi','6 KG','1m x 0.80ms','Windows 11 / 10 / 8.1 / 7 SP1','A4, A5, A6, B5, LTR, LGL, Executive, Oficio2','Black','Black'),
(2,'axonix','dasdsad',10000.00,12,'Axonix','L18050-(4).jpg','Laser','550 CPM','4,800 (horizontal)*1 x 1,200 (vertical) dpi','6 KG','1m x 0.80m','Windows 11 / 10 / 8.1 / 7 SP1','A4, A5, A6, B5, LTR, LGL, Executive, Oficio2','Supports Both','Black'),
(3,'Epson LQ310 Printer','This was super super long ',25000.00,10,'FujiFlim','download.jpeg','Dot Matrix','420 CPS','4,800 (horizontal)*1 x 1,200 (vertical) dpi','6 KG','1m x 0.80m','Windows 11 / 10 / 8.1 / 7 SP1, MacOs','A4, A5, A6, B5, LTR, LGL, Executive, Oficio2','Black','Black');
/*!40000 ALTER TABLE `Product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Purchase`
--

DROP TABLE IF EXISTS `Purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Purchase` (
  `purchaseId` int(11) NOT NULL AUTO_INCREMENT,
  `DateTime` datetime DEFAULT current_timestamp(),
  `quantity` int(11) NOT NULL,
  `totalAmount` decimal(10,2) NOT NULL,
  `userId` int(11) DEFAULT NULL,
  `productId` int(11) DEFAULT NULL,
  `purchaseStatus` enum('Delivered','Pending') NOT NULL DEFAULT 'Pending',
  PRIMARY KEY (`purchaseId`),
  KEY `Purchase_ibfk_1` (`userId`),
  KEY `Purchase_ibfk_2` (`productId`),
  CONSTRAINT `Purchase_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `User` (`userId`),
  CONSTRAINT `Purchase_ibfk_2` FOREIGN KEY (`productId`) REFERENCES `Product` (`productId`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Purchase`
--

LOCK TABLES `Purchase` WRITE;
/*!40000 ALTER TABLE `Purchase` DISABLE KEYS */;
INSERT INTO `Purchase` VALUES
(1,'2024-05-09 04:16:29',1,10000.00,1,1,'Pending');
/*!40000 ALTER TABLE `Purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `User`
--

DROP TABLE IF EXISTS `User`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `User` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `fullName` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `accountType` enum('User','Admin') NOT NULL DEFAULT 'User',
  `password` varchar(100) NOT NULL,
  `phoneNumber` varchar(20) NOT NULL,
  `profilePicture` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email` (`email`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `User`
--

LOCK TABLES `User` WRITE;
/*!40000 ALTER TABLE `User` DISABLE KEYS */;
INSERT INTO `User` VALUES
(1,'Aayush Wanem Limbu','np05cp4a220010@iic.edu.np','Aayush','User','$2a$10$o8KsdZny6258e8753sja1uxsUbQqJfdH7M4.zqY.93qPDrXDgy536','+977 9862162552','wallhaven-8586my.png'),
(2,'Admin User','ayushhaang09@gmail.com','admin','Admin','$2a$10$eilxMDwIcmOD3hT1VSrWPOo3HhGtzXX5mX7tbAcIqWq5jj8gNGnZe','+977 9804085324','wallhaven-dp3lrj.png'),
(4,'Asmin Shrestha','np05cp4a220011@iic.edu.np','TEST USER','User','$2a$10$LF1EKUwHZKbd6.xZoO8INuCMPtrRgE/07aP2YyX87GSBVhB/oq2hy','1234509876','wallhaven-dp3lrj.png'),
(5,'AdminAdminAdmin','aaaa@aaaa.com','test admin','Admin','$2a$10$45MIr8g2MmsWmzMJITZMQOdloG5xUHTXfWVnNi.MecbqsDS3tY.16','1234509876','wallhaven-8586my.png'),
(8,'AdminAdminAdmin','sthaesha@aaaa.com','ayushstha','Admin','$2a$10$IrHhjkjDdYtJuYmJCguza.T.OAJZtZJZydwLlb2mvD4Fxabh93ItS','1234509876','wallhaven-8586my.png'),
(9,'hero hero hero','xyz@pixleprint.com','herooo','User','$2a$10$HoFjOd6s3h/DLlyQlmR7kuLiS5MGHZvnJNJnslPbJ6VIso2EOHtBy','+9771122334455','wallhaven-8586my.png');
/*!40000 ALTER TABLE `User` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-05-10  8:42:25
