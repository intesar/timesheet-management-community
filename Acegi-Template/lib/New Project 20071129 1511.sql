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
-- Create schema acegi_db
--

CREATE DATABASE IF NOT EXISTS acegi_db;
USE acegi_db;

--
-- Definition of table `authorities`
--

DROP TABLE IF EXISTS `authorities`;
CREATE TABLE `authorities` (
  `username` varchar(45) NOT NULL,
  `authority` varchar(45) NOT NULL,
  PRIMARY KEY  USING BTREE (`username`,`authority`),
  KEY `FK_authorities_2` (`authority`),
  CONSTRAINT `FK_authorities_2` FOREIGN KEY (`authority`) REFERENCES `authority` (`role`),
  CONSTRAINT `FK_authorities_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authorities`
--

/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` (`username`,`authority`) VALUES 
 ('mdshannan','ROLE_A'),
 ('mdshannan','ROLE_ADMIN'),
 ('mdshannan','ROLE_ANONYMOUS'),
 ('mdshannan','ROLE_B'),
 ('mdshannan','ROLE_USER');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;


--
-- Definition of table `authority`
--

DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `role` varchar(45) NOT NULL,
  `description` varchar(45) default NULL,
  PRIMARY KEY  (`role`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `authority`
--

/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` (`role`,`description`) VALUES 
 ('ROLE_A',NULL),
 ('ROLE_ADMIN',NULL),
 ('ROLE_ANONYMOUS',NULL),
 ('ROLE_B',NULL),
 ('ROLE_USER',NULL);
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(1) NOT NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`username`,`password`,`enabled`) VALUES 
 ('mdshannan','apple123',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
