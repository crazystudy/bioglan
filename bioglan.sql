/*
 Navicat Premium Data Transfer

 Source Server         : 本地连接
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost
 Source Database       : bioglan

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : utf-8

 Date: 09/03/2018 17:39:20 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `S_RECORD`
-- ----------------------------
DROP TABLE IF EXISTS `S_RECORD`;
CREATE TABLE `S_RECORD` (
  `create_time` datetime DEFAULT NULL,
  `open_id` varchar(32) DEFAULT NULL,
  `id` varchar(32) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `S_SCORE`
-- ----------------------------
DROP TABLE IF EXISTS `S_SCORE`;
CREATE TABLE `S_SCORE` (
  `score` double(10,0) DEFAULT NULL,
  `id` varchar(32) NOT NULL,
  `open_id` varchar(32) DEFAULT NULL,
  `time` int(10) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `S_USER`
-- ----------------------------
DROP TABLE IF EXISTS `S_USER`;
CREATE TABLE `S_USER` (
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

SET FOREIGN_KEY_CHECKS = 1;
