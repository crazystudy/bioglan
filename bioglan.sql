/*
 Navicat Premium Data Transfer

 Source Server         : 阿里云
 Source Server Type    : MySQL
 Source Server Version : 50641
 Source Host           : 47.105.71.127
 Source Database       : bioglan

 Target Server Type    : MySQL
 Target Server Version : 50641
 File Encoding         : utf-8

 Date: 09/07/2018 17:39:37 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `S_QUESTION`
-- ----------------------------
DROP TABLE IF EXISTS `S_QUESTION`;
CREATE TABLE `S_QUESTION` (
  `question` varchar(250) DEFAULT NULL,
  `id` varchar(32) NOT NULL,
  `options` varchar(250) DEFAULT NULL,
  `answer` varchar(10) DEFAULT NULL,
  `score` double(8,0) DEFAULT NULL,
  `include_image` tinyint(1) DEFAULT NULL,
  `type` int(1) DEFAULT NULL,
  `second_question` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `S_QUESTION`
-- ----------------------------
BEGIN;
INSERT INTO `S_QUESTION` VALUES ('由于澳大利亚对动物的保护有严格规定，游客只能在哪个州抱考拉合照?', 'd2c80e997c264377b30382eb479dbc01', 'A.维多利亚州;B.新南威尔士州;C.西澳大利亚州;D.昆士兰州', 'D', '10', '0', '1', ''), ('澳大利亚被划分为几个州和几个领地?', 'd2c80e997c264377b30382eb479dbc02', 'A.5个州，2个领地;B.5个州，3个领地;C.6个州，2个领地;D.6个州，3个领地', 'C', null, null, null, ''), ('澳大利亚地势最低处位于什么地方?', 'd2c80e997c264377b30382eb479dbc03', 'A.大堡礁;B.墨累河;C.艾尔湖', 'C', null, null, null, ''), ('澳大利亚的人多还是袋鼠多？', 'd2c80e997c264377b30382eb479dbc04', 'A.袋鼠多;B.澳大利亚人多', 'B', null, null, null, ''), ('澳大利亚的国土面积，在世界上排名第几位？?', 'd2c80e997c264377b30382eb479dbc05', '第一位;B.第二位;C.第六位;D.第十位', 'C', null, null, null, ''), ('澳大利亚的第一和第二大城市，分别是？?', 'd2c80e997c264377b30382eb479dbc06', 'A.悉尼、墨尔本;B.墨尔本、悉尼;C.悉尼、阿德莱德;D.墨尔本、珀斯', 'A', null, null, null, ''), ('澳大利亚最大的河流是?', 'd2c80e997c264377b30382eb479dbc07', 'A.墨累河;B.泰晤士河;C.尼罗河;D.底格里斯河', 'A', null, null, null, ''), ('汉堡王来到澳洲叫什么?', 'd2c80e997c264377b30382eb479dbc08', 'A.Pie Face;B.Macca’s;C.Hungry Jack’s', 'C', null, null, null, ''), ('澳大利亚人最情有独钟的咖啡是什么?', 'd2c80e997c264377b30382eb479dbc09', 'A.Latte;B.Flat White;C.Black Coffee', 'B', null, null, null, ''), ('袋鼠为什么会在澳洲国徽上?', 'd2c80e997c264377b30382eb479dbc10', 'A.长相可爱;B.跳得高;C.肉好吃，有营养;袋鼠只能向前移动，不能后退', 'D', null, null, null, ''), ('以下哪项是澳大利亚人发明的?', 'd2c80e997c264377b30382eb479dbc11', 'A.Wi-Fi;B.空调;C.手机', 'A', null, null, null, ''), ('澳大利亚的国旗上有几颗星?', 'd2c80e997c264377b30382eb479dbc12', 'A.四颗;B.五颗;C.六颗;D.八颗', 'C', null, null, null, ''), ('澳大利亚国歌Advance Australia Fair, 是在哪一年被选中的?', 'd2c80e997c264377b30382eb479dbc13', 'A.1984年;B.1985年;C.1986年;D.1987年', 'A', null, null, null, ''), ('澳大利亚俚语“Arvo”的意思是?', 'd2c80e997c264377b30382eb479dbc14', 'A.到达;B.下午;C.我怎么知道', 'B', null, null, null, ''), ('澳洲土著旗的颜色是什么?', 'd2c80e997c264377b30382eb479dbc15', 'A.黑、红、黄;B.绿、白、黑;C.蓝、白、绿', 'A', null, null, null, ''), ('澳大利亚的Boxing Day是什么时候?', 'd2c80e997c264377b30382eb479dbc16', 'A.12月25日;B.12月26日;C.12月27日', 'B', null, null, null, ''), ('澳大利亚的国家宝石是什么?', 'd2c80e997c264377b30382eb479dbc17', 'A.澳宝;B.金;C.钻石', 'A', null, null, null, ''), ('澳大利亚的澳新军团日（ANZAC Day）,是哪一天?', 'd2c80e997c264377b30382eb479dbc18', 'A.10月1日;B.4月25日;C.1月26日', 'B', null, null, null, ''), ('澳大利亚最大的州是哪个', 'd2c80e997c264377b30382eb479dbc19', 'A.昆士兰州;B.南澳大利亚;C.西澳大利亚州', 'C', null, null, null, ''), ('悉尼歌剧院的设计灵感是从哪来的', 'd2c80e997c264377b30382eb479dbc20', 'A.帆船;B.贝壳;C.橘子瓣', 'C', null, null, null, ''), ('1.用最快的速度，算出55555+55555-55555×55555÷55555=?', 'd2c80e997c264377b30382eb479dbc21', 'A.55555;B.1;C.我数学不好', 'A', null, null, null, ''), ('https://www.dandandev.cn/images/logos.png', 'd2c80e997c264377b30382eb479dbc22', 'A.55555;B.1;C.我数学不好', 'A', null, null, null, '刚的出现的圆圈中有几个点'), ('记住下面一组数字:53、67、80、42、17、9、99', 'd2c80e997c264377b30382eb479dbc23', 'A.42;B.17;C.9', 'B', null, null, null, '刚出现的一组数字中第5个数字是什么');
COMMIT;

-- ----------------------------
--  Table structure for `S_RECORD`
-- ----------------------------
DROP TABLE IF EXISTS `S_RECORD`;
CREATE TABLE `S_RECORD` (
  `create_time` datetime DEFAULT NULL,
  `open_id` varchar(32) DEFAULT NULL,
  `id` varchar(32) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
--  Records of `S_RECORD`
-- ----------------------------
BEGIN;
INSERT INTO `S_RECORD` VALUES ('2018-09-07 16:49:39', '12314', '209aa558daf242939f321016380a21ce'), ('2018-09-07 16:45:10', '12314', '5d33d37bbd2b4e8da5d73ddb25124c0c'), ('2018-09-05 17:35:36', '12314', '7f6d93e8c7bd4536bbd33611c73c3269'), ('2018-09-07 16:40:02', '12314', 'a581d255f7384b69988c72cf8004a2c4'), ('2018-09-07 16:40:10', '12314', 'bec21ac6eaba4b1e85305c764a82908b'), ('2018-09-05 17:10:49', '12314', 'd2c80e997c264377b30382eb479db128'), ('2018-09-07 16:46:12', '12314', 'da0735ab168c465686b7a7b5a6edbb22'), ('2018-09-05 17:38:49', '12314', 'e14d240df8d8418fa0a311d1572d1ef4'), ('2018-09-06 14:14:17', '12314', 'f23566e723d1473ea5c49cc85185b62f'), ('2018-09-05 17:28:32', '12314', 'f94100a9d38942e085946c178d8238c7');
COMMIT;

-- ----------------------------
--  Table structure for `S_SCORE`
-- ----------------------------
DROP TABLE IF EXISTS `S_SCORE`;
CREATE TABLE `S_SCORE` (
  `score` int(10) DEFAULT NULL,
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
