-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	6.0.3-alpha-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema construction_manager
--

CREATE DATABASE IF NOT EXISTS construction_manager;
USE construction_manager;

--
-- Definition of table `business_company`
--

DROP TABLE IF EXISTS `business_company`;
CREATE TABLE `business_company` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `office_phone` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `address` text,
  `mobile_phone` varchar(45) DEFAULT NULL,
  `project` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_business_company_1` (`project`),
  CONSTRAINT `FK_business_company_1` FOREIGN KEY (`project`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `business_company`
--

/*!40000 ALTER TABLE `business_company` DISABLE KEYS */;
INSERT INTO `business_company` (`id`,`name`,`office_phone`,`fax`,`address`,`mobile_phone`,`project`) VALUES 
 (1,'NONE','','','','',1);
/*!40000 ALTER TABLE `business_company` ENABLE KEYS */;


--
-- Definition of table `payment`
--

DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `payment_type` varchar(45) DEFAULT NULL,
  `paid_to_user` int(10) unsigned DEFAULT NULL,
  `paid_to_business` int(10) unsigned DEFAULT NULL,
  `task` int(10) unsigned NOT NULL,
  `amount` double NOT NULL,
  `comment` text,
  `percentage_task_completed` int(10) unsigned DEFAULT NULL,
  `date` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_payment_1` (`task`),
  KEY `FK_payment_2` (`paid_to_user`),
  KEY `FK_payment_5` (`paid_to_business`),
  KEY `FK_payment_4` (`payment_type`),
  KEY `FK_payment_6` (`percentage_task_completed`),
  CONSTRAINT `FK_payment_4` FOREIGN KEY (`payment_type`) REFERENCES `payment_types` (`code`),
  CONSTRAINT `FK_payment_6` FOREIGN KEY (`percentage_task_completed`) REFERENCES `percentage_values` (`percentage_code`),
  CONSTRAINT `FK_payment_1` FOREIGN KEY (`task`) REFERENCES `task` (`id`),
  CONSTRAINT `FK_payment_2` FOREIGN KEY (`paid_to_user`) REFERENCES `users` (`id`),
  CONSTRAINT `FK_payment_5` FOREIGN KEY (`paid_to_business`) REFERENCES `business_company` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment`
--

/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` (`id`,`payment_type`,`paid_to_user`,`paid_to_business`,`task`,`amount`,`comment`,`percentage_task_completed`,`date`) VALUES 
 (2,'CREDIT',1,1,1,152000,'',40,'');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;


--
-- Definition of table `payment_types`
--

DROP TABLE IF EXISTS `payment_types`;
CREATE TABLE `payment_types` (
  `code` varchar(45) NOT NULL DEFAULT '',
  `description` varchar(45) NOT NULL,
  PRIMARY KEY (`code`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `payment_types`
--

/*!40000 ALTER TABLE `payment_types` DISABLE KEYS */;
INSERT INTO `payment_types` (`code`,`description`) VALUES 
 ('CREDIT',''),
 ('PRODUCT',''),
 ('SERVICE','');
/*!40000 ALTER TABLE `payment_types` ENABLE KEYS */;


--
-- Definition of table `percentage_values`
--

DROP TABLE IF EXISTS `percentage_values`;
CREATE TABLE `percentage_values` (
  `percentage_code` int(10) unsigned NOT NULL,
  PRIMARY KEY (`percentage_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `percentage_values`
--

/*!40000 ALTER TABLE `percentage_values` DISABLE KEYS */;
INSERT INTO `percentage_values` (`percentage_code`) VALUES 
 (20),
 (40),
 (50),
 (70),
 (90),
 (100);
/*!40000 ALTER TABLE `percentage_values` ENABLE KEYS */;


--
-- Definition of table `priority_types`
--

DROP TABLE IF EXISTS `priority_types`;
CREATE TABLE `priority_types` (
  `priority_code` varchar(45) NOT NULL,
  PRIMARY KEY (`priority_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `priority_types`
--

/*!40000 ALTER TABLE `priority_types` DISABLE KEYS */;
INSERT INTO `priority_types` (`priority_code`) VALUES 
 ('CRITICAL'),
 ('HIGH'),
 ('LOW'),
 ('MEDIUM');
/*!40000 ALTER TABLE `priority_types` ENABLE KEYS */;


--
-- Definition of table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` text,
  `estimated_budget` double DEFAULT NULL,
  `estimated_start_date` varchar(45) DEFAULT NULL,
  `estimated_finish_date` varchar(45) DEFAULT NULL,
  `current_balance` double DEFAULT NULL,
  `invested_amount` double DEFAULT NULL,
  `manager_id` int(10) unsigned NOT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_project_1` (`manager_id`),
  KEY `FK_project_2` (`status`),
  CONSTRAINT `FK_project_2` FOREIGN KEY (`status`) REFERENCES `status_codes` (`code`),
  CONSTRAINT `FK_project_1` FOREIGN KEY (`manager_id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

/*!40000 ALTER TABLE `project` DISABLE KEYS */;
INSERT INTO `project` (`id`,`title`,`description`,`estimated_budget`,`estimated_start_date`,`estimated_finish_date`,`current_balance`,`invested_amount`,`manager_id`,`status`) VALUES 
 (1,'test','',NULL,'','',NULL,NULL,1,'COMPLETED');
/*!40000 ALTER TABLE `project` ENABLE KEYS */;


--
-- Definition of table `status_codes`
--

DROP TABLE IF EXISTS `status_codes`;
CREATE TABLE `status_codes` (
  `code` varchar(45) NOT NULL,
  PRIMARY KEY (`code`) 
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `status_codes`
--

/*!40000 ALTER TABLE `status_codes` DISABLE KEYS */;
INSERT INTO `status_codes` (`code`) VALUES 
 ('COMPLETED'),
 ('NOT-STARTED'),
 ('ON-HOLD'),
 ('STARTED');
/*!40000 ALTER TABLE `status_codes` ENABLE KEYS */;


--
-- Definition of table `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE `task` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` text,
  `start_date` varchar(45) DEFAULT NULL,
  `end_date` varchar(45) DEFAULT NULL,
  `planned_completion_date` varchar(45) DEFAULT NULL,
  `completion_date` varchar(45) DEFAULT NULL,
  `priority` varchar(45) NOT NULL DEFAULT '1',
  `percentage_completed` int(10) unsigned DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `alloted_amount` double DEFAULT NULL,
  `finish_date` varchar(45) DEFAULT NULL,
  `project` int(10) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_task_1` (`project`),
  KEY `FK_task_2` (`priority`),
  KEY `FK_task_3` (`percentage_completed`),
  KEY `FK_task_4` (`status`),
  CONSTRAINT `FK_task_2` FOREIGN KEY (`priority`) REFERENCES `priority_types` (`priority_code`),
  CONSTRAINT `FK_task_3` FOREIGN KEY (`percentage_completed`) REFERENCES `percentage_values` (`percentage_code`),
  CONSTRAINT `FK_task_4` FOREIGN KEY (`status`) REFERENCES `status_codes` (`code`),
  CONSTRAINT `FK_task_1` FOREIGN KEY (`project`) REFERENCES `project` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task`
--

/*!40000 ALTER TABLE `task` DISABLE KEYS */;
INSERT INTO `task` (`id`,`title`,`description`,`start_date`,`end_date`,`planned_completion_date`,`completion_date`,`priority`,`percentage_completed`,`status`,`alloted_amount`,`finish_date`,`project`) VALUES 
 (1,'renovate washroom','','','','','','CRITICAL',20,'COMPLETED',NULL,'',1);
/*!40000 ALTER TABLE `task` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `office_phone` varchar(45) DEFAULT NULL,
  `mobile_phone` varchar(45) DEFAULT NULL,
  `fax` varchar(45) DEFAULT NULL,
  `other_phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`,`firstname`,`lastname`,`email`,`office_phone`,`mobile_phone`,`fax`,`other_phone`) VALUES 
 (1,'intesar','mohammed','mdshannan','','773.699.7898','',''),
 (2,'amena','sultana','','','','',''),
 (3,'shanoor','fatima','','','','',''),
 (4,'aziz','mohammed','1','','','',''),
 (5,'ashraf','mohammed','','','9393053111','','');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
