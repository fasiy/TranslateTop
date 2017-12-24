/*
Navicat MySQL Data Transfer

Source Server         : 119.29.22.107_mysql
Source Server Version : 50719
Source Host           : 119.29.22.107:3306
Source Database       : translate

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2017-12-20 23:17:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for USER_BASIC_INFO
-- ----------------------------
DROP TABLE IF EXISTS `USER_BASIC_INFO`;
CREATE TABLE `USER_BASIC_INFO` (
  `id` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `mobile` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `workPlace` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of USER_BASIC_INFO
-- ----------------------------
