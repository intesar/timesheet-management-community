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
-- Create schema authenticator
--

CREATE DATABASE IF NOT EXISTS authenticator;
USE authenticator;

--
-- Definition of table `community`
--

DROP TABLE IF EXISTS `community`;
CREATE TABLE `community` (
  `community_name` varchar(45) NOT NULL default '',
  `description` varchar(45) default NULL,
  `creation_date` date default NULL,
  `last_modified_date` date default NULL,
  `create_user` varchar(45) default NULL,
  PRIMARY KEY  (`community_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `community`
--

/*!40000 ALTER TABLE `community` DISABLE KEYS */;
INSERT INTO `community` (`community_name`,`description`,`creation_date`,`last_modified_date`,`create_user`) VALUES 
 ('ADMIN','ADMINISTRATION',NULL,NULL,NULL),
 ('TIMESHEET','TIMESHEET COMMUNITY',NULL,NULL,NULL);
/*!40000 ALTER TABLE `community` ENABLE KEYS */;


--
-- Definition of table `role`
--

DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role` varchar(45) NOT NULL,
  `community_name` varchar(45) default NULL,
  `description` varchar(45) default NULL,
  `creation_date` date default NULL,
  `last_modified_date` date default NULL,
  `is_deleted` tinyint(1) default NULL,
  PRIMARY KEY  (`role`),
  KEY `FK_role_1` (`community_name`),
  CONSTRAINT `FK_role_1` FOREIGN KEY (`community_name`) REFERENCES `community` (`community_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `role`
--

/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` (`role`,`community_name`,`description`,`creation_date`,`last_modified_date`,`is_deleted`) VALUES 
 ('ROLE_ADMIN_TIMESHEET','TIMESHEET',NULL,NULL,NULL,NULL),
 ('ROLE_USER_TIMESHEET','TIMESHEET',NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `role` ENABLE KEYS */;


--
-- Definition of table `user_address`
--

DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `id` int(10) unsigned NOT NULL default '0',
  `username` varchar(45) NOT NULL default '',
  `type` varchar(45) default NULL,
  `street` varchar(45) NOT NULL,
  `city` varchar(45) NOT NULL,
  `state` varchar(45) NOT NULL,
  `zipcode` varchar(45) NOT NULL,
  `country` varchar(45) NOT NULL,
  `is_public` tinyint(1) unsigned default '0',
  `creation_date` date default NULL,
  `last_modified_date` date NOT NULL,
  `is_deleted` tinyint(1) default NULL,
  `CREATED_BY` varchar(45) default NULL,
  `LAST_MODIFIED_BY` varchar(45) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `Index_2` USING BTREE (`username`),
  CONSTRAINT `FK_user_address_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_address`
--

/*!40000 ALTER TABLE `user_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_address` ENABLE KEYS */;


--
-- Definition of table `user_address_audit`
--

DROP TABLE IF EXISTS `user_address_audit`;
CREATE TABLE `user_address_audit` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `userame` varchar(45) default NULL,
  `type` varchar(45) default NULL,
  `street` varchar(45) default NULL,
  `city` varchar(45) default NULL,
  `state` varchar(45) default NULL,
  `zipcode` varchar(45) default NULL,
  `country` varchar(45) default NULL,
  `is_public` tinyint(1) default NULL,
  `creation_date` date default NULL,
  `last_modified_date` date default NULL,
  `audit_user` varchar(45) default NULL,
  `audit_date` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_address_audit`
--

/*!40000 ALTER TABLE `user_address_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_address_audit` ENABLE KEYS */;


--
-- Definition of table `user_community`
--

DROP TABLE IF EXISTS `user_community`;
CREATE TABLE `user_community` (
  `username` varchar(45) NOT NULL,
  `community_name` varchar(45) NOT NULL default '',
  `enabled` tinyint(1) default '1',
  `creation_date` date default NULL,
  `last_modified_date` date default NULL,
  `expiration_date` date default NULL,
  `creation_user` varchar(45) default NULL,
  `last_modified_user` varchar(45) default NULL,
  `is_deleted` tinyint(1) default NULL,
  `id` int(10) unsigned default NULL,
  PRIMARY KEY  (`community_name`,`username`),
  KEY `FK_user_community_1` (`username`),
  CONSTRAINT `FK_user_community_1` FOREIGN KEY (`username`) REFERENCES `users` (`username`),
  CONSTRAINT `FK_user_community_2` FOREIGN KEY (`community_name`) REFERENCES `community` (`community_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_community`
--

/*!40000 ALTER TABLE `user_community` DISABLE KEYS */;
INSERT INTO `user_community` (`username`,`community_name`,`enabled`,`creation_date`,`last_modified_date`,`expiration_date`,`creation_user`,`last_modified_user`,`is_deleted`,`id`) VALUES 
 ('a','TIMESHEET',1,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `user_community` ENABLE KEYS */;


--
-- Definition of table `user_community_audit`
--

DROP TABLE IF EXISTS `user_community_audit`;
CREATE TABLE `user_community_audit` (
  `username` varchar(45) default NULL,
  ` company` varchar(45) default NULL,
  `enabled` tinyint(1) default NULL,
  `creation_date` date default NULL,
  `last_modified_date` date default NULL,
  `expiration_date` date default NULL,
  `creation_user` varchar(45) default NULL,
  `last_modified_user` varchar(45) default NULL,
  `audit_user` varchar(45) default NULL,
  `audit_date` varchar(45) default NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_community_audit`
--

/*!40000 ALTER TABLE `user_community_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_community_audit` ENABLE KEYS */;


--
-- Definition of table `user_login_ip_audit`
--

DROP TABLE IF EXISTS `user_login_ip_audit`;
CREATE TABLE `user_login_ip_audit` (
  `username` varchar(45) NOT NULL,
  `login_ip` varchar(45) default NULL,
  `audit_date` date default NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_login_ip_audit`
--

/*!40000 ALTER TABLE `user_login_ip_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_login_ip_audit` ENABLE KEYS */;


--
-- Definition of table `user_login_lock_audit`
--

DROP TABLE IF EXISTS `user_login_lock_audit`;
CREATE TABLE `user_login_lock_audit` (
  `username` varchar(45) NOT NULL,
  `summary` varchar(45) default NULL,
  `creation_date` date default NULL,
  `last_modified_date` date default NULL,
  `audit_user` varchar(45) default NULL,
  `audit_date` date default NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_login_lock_audit`
--

/*!40000 ALTER TABLE `user_login_lock_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_login_lock_audit` ENABLE KEYS */;


--
-- Definition of table `user_old_password_audit`
--

DROP TABLE IF EXISTS `user_old_password_audit`;
CREATE TABLE `user_old_password_audit` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) default NULL,
  `password_strength` varchar(45) default NULL,
  `creation_date` date default NULL,
  `last_modified_date` date default NULL,
  `audit_date` date default NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_old_password_audit`
--

/*!40000 ALTER TABLE `user_old_password_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_old_password_audit` ENABLE KEYS */;


--
-- Definition of table `user_phone`
--

DROP TABLE IF EXISTS `user_phone`;
CREATE TABLE `user_phone` (
  `ID` int(10) unsigned NOT NULL auto_increment,
  `USERNAME` varchar(45) NOT NULL,
  `PHONE_TYPE` varchar(45) NOT NULL default 'OTHER',
  `PHONE_NUMBER` varchar(45) NOT NULL,
  `IS_PUBLIC` tinyint(3) unsigned default '0',
  `IS_DELETED` tinyint(3) unsigned default '0',
  `CREATION_DATE` date default NULL,
  `CREATED_BY` varchar(45) NOT NULL,
  `LAST_MODIFIED_DATE` date NOT NULL,
  `LAST_MODIFIED_BY` varchar(45) NOT NULL,
  PRIMARY KEY  (`ID`),
  KEY `FK_user_phone_1` (`USERNAME`),
  CONSTRAINT `FK_user_phone_1` FOREIGN KEY (`USERNAME`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_phone`
--

/*!40000 ALTER TABLE `user_phone` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_phone` ENABLE KEYS */;


--
-- Definition of table `user_phone_audit`
--

DROP TABLE IF EXISTS `user_phone_audit`;
CREATE TABLE `user_phone_audit` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) default NULL,
  `type` varchar(45) default NULL,
  `phone_number` varchar(45) default NULL,
  `is_public` varchar(45) default NULL,
  `creation_date` date default NULL,
  `last_modified_date` varchar(45) default NULL,
  `audit_user` varchar(45) default NULL,
  `audit_date` date default NULL,
  `user_id` int(10) unsigned default NULL,
  `is_deleted` tinyint(3) unsigned default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_phone_audit`
--

/*!40000 ALTER TABLE `user_phone_audit` DISABLE KEYS */;
INSERT INTO `user_phone_audit` (`id`,`username`,`type`,`phone_number`,`is_public`,`creation_date`,`last_modified_date`,`audit_user`,`audit_date`,`user_id`,`is_deleted`) VALUES 
 (1,'a','mobile','213.444.444','1',NULL,NULL,'root@localhost','2007-07-04',NULL,NULL),
 (2,'a','mobile','213.444.4447','1',NULL,NULL,'root@localhost','2007-07-04',NULL,NULL);
/*!40000 ALTER TABLE `user_phone_audit` ENABLE KEYS */;


--
-- Definition of table `user_profile_audit`
--

DROP TABLE IF EXISTS `user_profile_audit`;
CREATE TABLE `user_profile_audit` (
  `username` varchar(45) NOT NULL,
  `first_name` varchar(45) default NULL,
  `last_name` varchar(45) default NULL,
  `middle_name` varchar(45) default NULL,
  `title` varchar(45) default NULL,
  `company` varchar(45) default NULL,
  `summary` text,
  `creation_date` date default NULL,
  `last_modified_date` date default NULL,
  `audit_user` varchar(45) default NULL,
  `audit_date` date default NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_profile_audit`
--

/*!40000 ALTER TABLE `user_profile_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_profile_audit` ENABLE KEYS */;


--
-- Definition of table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
CREATE TABLE `user_roles` (
  `username` varchar(45) NOT NULL,
  `role` varchar(45) NOT NULL default '',
  `creation_date` date default NULL,
  `last_modified_date` date default NULL,
  `is_deleted` tinyint(1) default NULL,
  `CREATED_BY` varchar(45) default NULL,
  `LAST_MODIFIED_BY` varchar(45) default NULL,
  PRIMARY KEY  USING BTREE (`username`,`role`),
  KEY `FK_user_roles_1` (`role`),
  CONSTRAINT `FK_user_roles_1` FOREIGN KEY (`role`) REFERENCES `role` (`role`),
  CONSTRAINT `FK_user_roles_2` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_roles`
--

/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` (`username`,`role`,`creation_date`,`last_modified_date`,`is_deleted`,`CREATED_BY`,`LAST_MODIFIED_BY`) VALUES 
 ('a','ROLE_ADMIN_TIMESHEET',NULL,NULL,0,NULL,NULL),
 ('a','ROLE_USER_TIMESHEET',NULL,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;


--
-- Definition of table `user_roles_audit`
--

DROP TABLE IF EXISTS `user_roles_audit`;
CREATE TABLE `user_roles_audit` (
  `username` varchar(45) NOT NULL,
  `role` varchar(45) default NULL,
  `creation_date` date default NULL,
  `last_modified_date` date default NULL,
  `audit_user` varchar(45) default NULL,
  `audit_date` varchar(45) default NULL,
  `id` int(10) unsigned NOT NULL auto_increment,
  PRIMARY KEY  USING BTREE (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_roles_audit`
--

/*!40000 ALTER TABLE `user_roles_audit` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_roles_audit` ENABLE KEYS */;


--
-- Definition of table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `password_strength` varchar(45) default NULL,
  `encryption_key` varchar(45) default NULL,
  `is_encrypted` tinyint(1) default NULL,
  `password_expiration_date` date default NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `middle_name` varchar(45) default NULL,
  `secondary_email` varchar(45) default NULL,
  `title` varchar(45) default NULL,
  `company` varchar(45) default NULL,
  `summary` text,
  `last_login_ip` varchar(45) default NULL,
  `enabled` tinyint(1) default NULL,
  `lock_reason` varchar(45) default NULL,
  `secret_question` varchar(45) default NULL,
  `secret_answer` varchar(45) default NULL,
  `creation_date` date default NULL,
  `last_modified_date` date default NULL,
  `is_deleted` tinyint(1) default NULL,
  `CREATED_BY` varchar(45) default NULL,
  `LAST_MODIFIED_BY` varchar(45) default NULL,
  PRIMARY KEY  (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`username`,`password`,`password_strength`,`encryption_key`,`is_encrypted`,`password_expiration_date`,`first_name`,`last_name`,`middle_name`,`secondary_email`,`title`,`company`,`summary`,`last_login_ip`,`enabled`,`lock_reason`,`secret_question`,`secret_answer`,`creation_date`,`last_modified_date`,`is_deleted`,`CREATED_BY`,`LAST_MODIFIED_BY`) VALUES 
 ('a','a',NULL,NULL,NULL,NULL,'a','a',NULL,NULL,NULL,NULL,NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
