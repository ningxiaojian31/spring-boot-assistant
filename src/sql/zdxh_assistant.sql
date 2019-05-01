/*
Navicat MySQL Data Transfer

Source Server         : ning
Source Server Version : 50721
Source Host           : localhost:3306
Source Database       : zdxh_assistant

Target Server Type    : MYSQL
Target Server Version : 50721
File Encoding         : 65001

Date: 2019-05-01 23:46:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `com_date` date DEFAULT NULL,
  `com_content` varchar(255) DEFAULT NULL,
  `com_laud` int(30) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `inv_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid` (`user_id`),
  KEY `iid` (`inv_id`),
  CONSTRAINT `iid` FOREIGN KEY (`inv_id`) REFERENCES `invitation` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('2', '2018-10-27', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('3', '2018-10-10', '真的吗', '10', '2', '1');
INSERT INTO `comment` VALUES ('6', '2018-11-07', '嘻嘻，我也看见了~', '52', '1', '1');
INSERT INTO `comment` VALUES ('7', '2018-11-07', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('8', '2018-11-07', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('9', '2018-11-07', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('10', '2018-11-07', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('11', '2018-11-08', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('12', '2018-11-22', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('13', '2018-12-10', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('14', '2018-12-11', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('15', '2018-12-15', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('16', '2018-12-16', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('17', '2018-12-16', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('18', '2018-12-16', '嘻嘻，我也看见了~', '50', '1', '1');
INSERT INTO `comment` VALUES ('19', '2018-12-21', '嘻嘻，我也看见了~', '50', '1', '1');

-- ----------------------------
-- Table structure for `invitation`
-- ----------------------------
DROP TABLE IF EXISTS `invitation`;
CREATE TABLE `invitation` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `inv_content` varchar(255) DEFAULT NULL,
  `inv_laud` int(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of invitation
-- ----------------------------
INSERT INTO `invitation` VALUES ('1', '今天在篮球场看到一个很漂亮的小姐姐哦', '81');
INSERT INTO `invitation` VALUES ('4', '灌灌灌灌灌过', '1');
INSERT INTO `invitation` VALUES ('5', '水电费水电费', '525');
INSERT INTO `invitation` VALUES ('6', '是的发放', '5425');
INSERT INTO `invitation` VALUES ('7', '撒旦法师法', '1252');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `pub_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid3` (`user_id`),
  KEY `pid` (`pub_id`),
  CONSTRAINT `pid` FOREIGN KEY (`pub_id`) REFERENCES `publish` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `uid3` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '2', '1');
INSERT INTO `order` VALUES ('2', '3', '1');
INSERT INTO `order` VALUES ('3', '2', '1');
INSERT INTO `order` VALUES ('5', '14', '1');

-- ----------------------------
-- Table structure for `publish`
-- ----------------------------
DROP TABLE IF EXISTS `publish`;
CREATE TABLE `publish` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pub_sign` int(11) DEFAULT NULL,
  `pub_image` varchar(255) DEFAULT NULL,
  `pub_content` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `uid2` (`user_id`),
  CONSTRAINT `uid2` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of publish
-- ----------------------------
INSERT INTO `publish` VALUES ('1', '1', 'www', '我在新饭三楼等你哦，约吗', '1');

-- ----------------------------
-- Table structure for `reply`
-- ----------------------------
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `re_type` int(11) DEFAULT NULL,
  `re_content` varchar(255) DEFAULT NULL,
  `re_laud` int(11) DEFAULT NULL,
  `com_id` int(11) DEFAULT NULL,
  `user_id_from` int(11) DEFAULT NULL,
  `user_id_to` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `cid2` (`com_id`),
  KEY `uidfrom` (`user_id_from`),
  KEY `uidto` (`user_id_to`),
  CONSTRAINT `cid2` FOREIGN KEY (`com_id`) REFERENCES `comment` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uidfrom` FOREIGN KEY (`user_id_from`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `uidto` FOREIGN KEY (`user_id_to`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of reply
-- ----------------------------
INSERT INTO `reply` VALUES ('1', '1', '我也看见了，好甜美啊', '21', '2', '2', '1');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_loginname` varchar(50) DEFAULT NULL,
  `user_password` varchar(50) DEFAULT NULL,
  `user_name` varchar(50) DEFAULT NULL,
  `user_studentID` varchar(50) DEFAULT NULL,
  `user_image` varchar(255) DEFAULT NULL,
  `user_wx_number` varchar(50) DEFAULT NULL,
  `user_type` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'ning', '123456', '宁晓健', '16053081', 'http:www', '664650322', '2');
INSERT INTO `user` VALUES ('2', 'xiao', '12345', '侧田', '16053080', 'https:www', '5555200000', '2');
INSERT INTO `user` VALUES ('3', 'ningg', '123456', '宁晓健', '160530811', 'www', '664650322', '2');
INSERT INTO `user` VALUES ('4', 'xiao', '12345', '侧田', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('5', 'xiao', '12345', '侧田', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('6', 'xiao', '12345', '侧田', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('7', 'xiao', '12345', '侧田', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('8', 'xiao', '12345', '侧田', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('9', 'xiao', '12345', '侧田', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('10', null, null, null, null, 'nnnnnnnnnn', null, '2');
INSERT INTO `user` VALUES ('11', 'xiao', '12345', '侧田', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('12', 'xiao', '12345', '侧田', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('13', 'xiao', '12345', '侧田', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('14', 'xiao', '12345', 'kkkk', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('15', 'xiao', '12345', '侧田', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('16', 'xiao', '12345', '侧田', '16053080', null, '5555200000', '2');
INSERT INTO `user` VALUES ('17', 'admin', '123456', '我是管理员', '4245254242', 'wwwwwww', '11111111111111', '1');
INSERT INTO `user` VALUES ('18', 'xiao', '12345', '侧田', '16053080', null, '5555200000', null);
