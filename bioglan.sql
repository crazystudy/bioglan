/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : bioglan

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-09-03 22:59:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `s_question`
-- ----------------------------
DROP TABLE IF EXISTS `s_question`;
CREATE TABLE `s_question` (
  `question` varchar(250) DEFAULT NULL,
  `id` varchar(32) NOT NULL,
  `options` varchar(250) DEFAULT NULL,
  `answer` varchar(10) DEFAULT NULL,
  `score` double(8,0) DEFAULT NULL,
  `include_image` tinyint(1) DEFAULT NULL,
  `type` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_question
-- ----------------------------

-- ----------------------------
-- Table structure for `s_record`
-- ----------------------------
DROP TABLE IF EXISTS `s_record`;
CREATE TABLE `s_record` (
  `create_time` datetime DEFAULT NULL,
  `open_id` varchar(32) DEFAULT NULL,
  `id` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_record
-- ----------------------------

-- ----------------------------
-- Table structure for `s_score`
-- ----------------------------
DROP TABLE IF EXISTS `s_score`;
CREATE TABLE `s_score` (
  `score` double(10,0) DEFAULT NULL,
  `id` varchar(32) NOT NULL,
  `open_id` varchar(32) DEFAULT NULL,
  `time` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_score
-- ----------------------------

-- ----------------------------
-- Table structure for `s_user`
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `open_id` varchar(32) NOT NULL,
  `union_id` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  `avatar_url` varchar(250) DEFAULT NULL,
  `real_name` varchar(32) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `gender` varchar(3) DEFAULT NULL,
  `country` varchar(20) DEFAULT NULL,
  `city` varchar(20) DEFAULT NULL,
  `province` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`open_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
