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
-- Create schema e_commerce
--

CREATE DATABASE IF NOT EXISTS e_commerce;
USE e_commerce;

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
 (1,'DINNER',NULL,1),
 (20,'LUNCH',NULL,1),
 (30,'BEVERAGES',NULL,1);
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
  `description` varchar(45) default NULL,
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
 (1,'CHICKEN BIRYANI','HYD SPICY RICE DISH',5.99,0.00785,1,'biryani.jpg',100),
 (2,'EGG BIRYANI','SPICY EGG BIRYANI',6.99,0.00785,1,'biryani.jpg',100);
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
 (2,1);
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
