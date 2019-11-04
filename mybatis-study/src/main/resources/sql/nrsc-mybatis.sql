/*
Navicat MySQL Data Transfer

Source Server         : spring-security
Source Server Version : 80013
Source Host           : localhost:3306
Source Database       : nrsc-mybatis

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-11-05 07:47:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_company
-- ----------------------------
DROP TABLE IF EXISTS `t_company`;
CREATE TABLE `t_company` (
  `id` bigint(11) unsigned zerofill NOT NULL AUTO_INCREMENT,
  `company_code` varchar(10) DEFAULT NULL,
  `company_name` varchar(100) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_company
-- ----------------------------
INSERT INTO `t_company` VALUES ('00000000001', '1', '1', '100.00', '2019-11-03 14:36:02', '2019-11-03 14:36:02');
INSERT INTO `t_company` VALUES ('00000000002', '11', null, null, null, null);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `salary` decimal(10,2) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '帅帅', '123456', 'F', '1500.00', null, null);
INSERT INTO `t_user` VALUES ('2', 'james', '123456', 'F', '15000.00', null, null);
INSERT INTO `t_user` VALUES ('3', '张三', '123456', 'F', '1300.00', null, null);
INSERT INTO `t_user` VALUES ('4', 'rose', '123456', 'M', '1299.00', null, null);
INSERT INTO `t_user` VALUES ('5', '张伟', '123456', 'F', '5800.00', null, null);
INSERT INTO `t_user` VALUES ('6', '张伟', '123456', 'M', '5900.00', null, null);
INSERT INTO `t_user` VALUES ('7', 'king', '123456', 'F', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('8', 'james', '1234567890', 'M', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('9', 'wangwu', '1111', 'F', '3900.00', null, null);
INSERT INTO `t_user` VALUES ('10', 'guoer', '2222', 'M', '4900.00', null, null);
INSERT INTO `t_user` VALUES ('11', 'king11', '1234567', 'F', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('12', 'james11', '123456789011', 'M', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('13', 'king11', '1234567', 'F', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('14', 'james11', '123456789011', 'M', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('15', 'king11', '1234567', 'F', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('16', 'james11', '123456789011', 'M', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('17', 'king11', '1234567', 'F', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('18', 'james11', '123456789011', 'M', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('19', 'king11', '1234567', 'F', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('20', 'james11', '123456789011', 'M', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('21', 'king', '123456', 'F', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('22', 'james', '1234567890', 'M', '1800.00', null, null);
INSERT INTO `t_user` VALUES ('23', 'deer', null, null, null, null, null);
INSERT INTO `t_user` VALUES ('24', 'haha', 'heihei', null, '11111.00', null, null);
INSERT INTO `t_user` VALUES ('25', 'haha222', 'heihei222', null, '2222.00', null, null);
