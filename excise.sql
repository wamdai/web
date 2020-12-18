/*
SQLyog Ultimate v11.11 (64 bit)
MySQL - 5.1.68-community : Database - excise
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`excise` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `excise`;

/*Table structure for table `t_downloadlist` */

DROP TABLE IF EXISTS `t_downloadlist`;

CREATE TABLE `t_downloadlist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT '显示名称',
  `path` varchar(255) DEFAULT NULL COMMENT '存放路径及文件名',
  `description` varchar(255) DEFAULT NULL COMMENT '描述',
  `size` longblob COMMENT '文件大小，字节为单位',
  `star` int(11) DEFAULT NULL COMMENT '星级',
  `image` varchar(255) DEFAULT NULL COMMENT '图片路径及名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

/*Data for the table `t_downloadlist` */

insert  into `t_downloadlist`(`id`,`name`,`path`,`description`,`size`,`star`,`image`) values (1,'a1','/login/File/a1.txt','这是文件a1',NULL,NULL,NULL),(2,'a2','/login/File/a2.txt','这是文件a2',NULL,NULL,NULL),(3,'a3','/login/File/a3.txt','这是文件a3',NULL,NULL,NULL);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `userName` varchar(255) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `Name` varchar(255) DEFAULT NULL,
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(225) DEFAULT NULL,
  `shengfen` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`userName`,`password`,`role`,`Name`,`id`,`email`,`shengfen`,`city`) values ('admin','admin','1',NULL,1,NULL,NULL,NULL),('tom','123','2',NULL,2,NULL,NULL,NULL),('tom1','12345','2','222',3,'1111@qqq','hennan','111'),('tom1','12345',NULL,'222',4,'1111@qqq','hennan','111'),('tom111','1111',NULL,'正在转',5,'1654037035@qq.com','河南省','信阳市'),('tom111','1111',NULL,'正在转',6,'1654037035@qq.com','山东省','德州市'),('tom111','11111',NULL,'正在转',7,'1654037035@qq.com','湖南省','永州市');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
