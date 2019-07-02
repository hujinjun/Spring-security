/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50156
Source Host           : localhost:3306
Source Database       : security

Target Server Type    : MYSQL
Target Server Version : 50156
File Encoding         : 65001

Date: 2013-05-30 17:07:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `auto_info`
-- ----------------------------
DROP TABLE IF EXISTS `auto_info`;
CREATE TABLE `auto_info` (
  `id` bigint(20) NOT NULL,
  `autoname` varchar(50) NOT NULL,
  `autocode` varchar(50) NOT NULL,
  `des` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auto_info
-- ----------------------------
INSERT INTO `auto_info` VALUES ('1', '添加', 'ADD', null);
INSERT INTO `auto_info` VALUES ('2', '删除', 'DELETE', null);
INSERT INTO `auto_info` VALUES ('3', '修改', 'UPDATE', null);
INSERT INTO `auto_info` VALUES ('4', '查询', 'SELECT', null);

-- ----------------------------
-- Table structure for `auto_resource_info`
-- ----------------------------
DROP TABLE IF EXISTS `auto_resource_info`;
CREATE TABLE `auto_resource_info` (
  `auto_id` bigint(20) NOT NULL,
  `resource_id` bigint(20) NOT NULL,
  KEY `FK_Reference_4` (`auto_id`),
  KEY `FK_Reference_5` (`resource_id`),
  CONSTRAINT `FK_Reference_4` FOREIGN KEY (`auto_id`) REFERENCES `auto_info` (`id`),
  CONSTRAINT `FK_Reference_5` FOREIGN KEY (`resource_id`) REFERENCES `resource_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of auto_resource_info
-- ----------------------------
INSERT INTO `auto_resource_info` VALUES ('1', '1');
INSERT INTO `auto_resource_info` VALUES ('2', '2');
INSERT INTO `auto_resource_info` VALUES ('3', '3');
INSERT INTO `auto_resource_info` VALUES ('4', '4');

-- ----------------------------
-- Table structure for `resource_info`
-- ----------------------------
DROP TABLE IF EXISTS `resource_info`;
CREATE TABLE `resource_info` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of resource_info
-- ----------------------------
INSERT INTO `resource_info` VALUES ('1', 'ADD', 'add.jsp');
INSERT INTO `resource_info` VALUES ('2', 'DELETE', 'delete.jsp');
INSERT INTO `resource_info` VALUES ('3', 'UPDATE', 'update.jsp');
INSERT INTO `resource_info` VALUES ('4', 'SELECT', 'select.jsp');

-- ----------------------------
-- Table structure for `role_auto_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_auto_info`;
CREATE TABLE `role_auto_info` (
  `role_id` bigint(20) NOT NULL,
  `auto_id` bigint(20) NOT NULL,
  KEY `FK_Reference_1` (`auto_id`),
  KEY `FK_Reference_2` (`role_id`),
  CONSTRAINT `FK_Reference_1` FOREIGN KEY (`auto_id`) REFERENCES `auto_info` (`id`),
  CONSTRAINT `FK_Reference_2` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_auto_info
-- ----------------------------
INSERT INTO `role_auto_info` VALUES ('1', '1');
INSERT INTO `role_auto_info` VALUES ('1', '2');
INSERT INTO `role_auto_info` VALUES ('1', '3');
INSERT INTO `role_auto_info` VALUES ('1', '4');
INSERT INTO `role_auto_info` VALUES ('2', '1');
INSERT INTO `role_auto_info` VALUES ('2', '4');

-- ----------------------------
-- Table structure for `role_info`
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info` (
  `id` bigint(20) NOT NULL,
  `rolename` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES ('1', '超级管理员');
INSERT INTO `role_info` VALUES ('2', '普通业务员');

-- ----------------------------
-- Table structure for `user_info`
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('1', 'admin', '123', '1');
INSERT INTO `user_info` VALUES ('2', 'user', '123', '2');
