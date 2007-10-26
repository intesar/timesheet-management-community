-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.41-community-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema e_commerce_tahoora
--

CREATE DATABASE IF NOT EXISTS e_commerce_tahoora;
USE e_commerce_tahoora;

--
-- Definition of table `catagory`
--

DROP TABLE IF EXISTS `catagory`;
CREATE TABLE `catagory` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `timings` varchar(45) default NULL,
  `is_enabled` tinyint(4) default '1',
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Index_2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `catagory`
--

/*!40000 ALTER TABLE `catagory` DISABLE KEYS */;
INSERT INTO `catagory` (`id`,`name`,`timings`,`is_enabled`) VALUES 
 (1,'sweets',NULL,1),
 (2,'namkeen',NULL,1),
 (3,'chikki',NULL,1),
 (4,'bakery',NULL,1);
/*!40000 ALTER TABLE `catagory` ENABLE KEYS */;


--
-- Definition of table `images`
--

DROP TABLE IF EXISTS `images`;
CREATE TABLE `images` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `img` blob NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `images`
--

/*!40000 ALTER TABLE `images` DISABLE KEYS */;
/*!40000 ALTER TABLE `images` ENABLE KEYS */;


--
-- Definition of table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) NOT NULL,
  `description` varchar(100) default NULL,
  `price` double default '0',
  `tax` double default '0',
  `is_enabled` tinyint(3) unsigned default '1',
  `img_url` varchar(100) default NULL,
  `quantity_available` int(10) unsigned default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `Index_2` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item`
--

/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` (`id`,`name`,`description`,`price`,`tax`,`is_enabled`,`img_url`,`quantity_available`) VALUES 
 (1,'cham cham','dessert',6.5,0,1,'chumchum_small.gif',NULL),
 (2,'cream gulab jamun','dessert',6,0,1,'CreamGulabJamun_small.gif',NULL),
 (3,'falsa','dessert',6.5,0,1,'falsa_small.gif',NULL),
 (4,'kala Jamun','dessert',6.5,0,1,'kalajamun_small.gif',NULL),
 (5,'cream cutlets','dessert',6,0,1,'creamcutlet_small.gif',NULL),
 (6,'cream kala jamun','dessert',6,0,1,'CreamKalaJamun_small.gif',NULL),
 (7,'gulab jamun','dessert',5.25,0,1,'GulabJamun_small.gif',NULL),
 (8,'shahi tukra','dessert',6,0,1,'ShahiTukra_small.gif',NULL),
 (9,'aflatoon cookies','cookies',5.5,0,1,'cookies_aflatoon_small.gif',NULL),
 (10,'cashew cookies','cookies',5,0,1,'cookies_cashew_small.gif',NULL),
 (11,'jam cookies','cookies',5,0,1,'cookies_jam_small.gif',NULL),
 (12,'pape toast','cookies',4,0,1,'toast_pape_small.gif',NULL),
 (13,'zeera cookies','cookies',4.5,0,1,'cookies_zeera_small.gif',NULL),
 (14,'almond cookies','cookies',6,0,1,'UnAvailable_small.gif',NULL),
 (15,'coconut cookies','cookies',5.5,0,1,'UnAvailable_small.gif',NULL),
 (16,'khari biscuit twisted','cookies',5.25,0,1,'biscuit_khari-twist_small.gif',NULL),
 (17,'rusted cake','cookies',7,0,1,'rusk_cake_small.gif',NULL);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;


--
-- Definition of table `item_catagory`
--

DROP TABLE IF EXISTS `item_catagory`;
CREATE TABLE `item_catagory` (
  `item_id` int(10) unsigned NOT NULL,
  `catagory_id` int(10) unsigned NOT NULL,
  UNIQUE KEY `Index_1` (`item_id`,`catagory_id`),
  KEY `FK_item_catagory_1` (`catagory_id`),
  CONSTRAINT `FK_item_catagory_1` FOREIGN KEY (`catagory_id`) REFERENCES `catagory` (`id`),
  CONSTRAINT `FK_item_catagory_2` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_catagory`
--

/*!40000 ALTER TABLE `item_catagory` DISABLE KEYS */;
INSERT INTO `item_catagory` (`item_id`,`catagory_id`) VALUES 
 (1,1),
 (2,1),
 (3,1),
 (4,1),
 (5,1),
 (6,1),
 (7,1),
 (8,1),
 (9,4),
 (10,4),
 (11,4),
 (12,4),
 (13,4),
 (14,4),
 (15,4),
 (16,4),
 (17,4);
/*!40000 ALTER TABLE `item_catagory` ENABLE KEYS */;


--
-- Definition of table `item_contents`
--

DROP TABLE IF EXISTS `item_contents`;
CREATE TABLE `item_contents` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `content` varchar(45) NOT NULL,
  `item_id` int(10) unsigned NOT NULL,
  PRIMARY KEY  USING BTREE (`id`),
  UNIQUE KEY `Index_3` (`item_id`,`content`),
  KEY `Index_2` (`content`),
  CONSTRAINT `FK_item_contents_1` FOREIGN KEY (`item_id`) REFERENCES `item` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `item_contents`
--

/*!40000 ALTER TABLE `item_contents` DISABLE KEYS */;
/*!40000 ALTER TABLE `item_contents` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
