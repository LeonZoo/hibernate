/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `test`;

/*Table structure for table `category_` */

DROP TABLE IF EXISTS `category_`;

CREATE TABLE `category_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `category_` */

insert  into `category_`(`id`,`NAME`) values (1,'c1'),(2,'c2'),(3,'c3');

/*Table structure for table `product_` */

DROP TABLE IF EXISTS `product_`;

CREATE TABLE `product_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC42BD1507467F801` (`cid`),
  CONSTRAINT `FKC42BD1507467F801` FOREIGN KEY (`cid`) REFERENCES `category_` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `product_` */

insert  into `product_`(`id`,`name`,`price`,`cid`) values (1,'iphone7',7000,NULL),(2,'iphone0',0,NULL),(3,'iphone1',1,3),(4,'iphone-modified',2,1),(6,'iphone4',4,3),(8,'iphone6',6,1),(9,'iphone7',7,NULL),(10,'iphone8',8,NULL),(11,'iphone9',9,NULL),(14,'p1',0,NULL),(16,'p1',0,NULL);

/*Table structure for table `user_` */

DROP TABLE IF EXISTS `user_`;

CREATE TABLE `user_` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `user_` */

insert  into `user_`(`id`,`name`) values (1,'user0'),(2,'user1'),(3,'user2');

/*Table structure for table `user_product` */

DROP TABLE IF EXISTS `user_product`;

CREATE TABLE `user_product` (
  `pid` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  PRIMARY KEY (`uid`,`pid`),
  KEY `FK487D647BA63654E0` (`uid`),
  KEY `FK487D647B7558E795` (`pid`),
  CONSTRAINT `FK487D647B7558E795` FOREIGN KEY (`pid`) REFERENCES `product_` (`id`),
  CONSTRAINT `FK487D647BA63654E0` FOREIGN KEY (`uid`) REFERENCES `user_` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_product` */

insert  into `user_product`(`pid`,`uid`) values (1,1),(1,2),(1,3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
