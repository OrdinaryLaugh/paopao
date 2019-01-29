/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : paopao

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2019-01-29 14:39:25
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `address`
-- ----------------------------
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `address_id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`address_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of address
-- ----------------------------

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类的id',
  `category_parent_id` int(11) DEFAULT NULL COMMENT '当父分类的id为0时为一级目录',
  `category_name` varchar(255) DEFAULT NULL COMMENT '分类的名称',
  `category_is_parent` enum('true','false') DEFAULT 'true' COMMENT '该类是否为父目录',
  `category_created_date` datetime DEFAULT NULL COMMENT '创建该条记录的时间',
  `category_update_date` datetime DEFAULT NULL COMMENT '更新该条记录的时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------

-- ----------------------------
-- Table structure for `item`
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `item_name` varchar(255) DEFAULT NULL,
  `item_price` double DEFAULT NULL,
  `item_image_path` varchar(255) DEFAULT NULL,
  `item_category_id` int(11) DEFAULT NULL,
  `item_status` enum('0','1','2') DEFAULT '0' COMMENT '0：正常 1：下架 2：删除',
  `item_create_date` datetime DEFAULT NULL,
  `item_update_date` datetime DEFAULT NULL,
  `item_describe` varchar(255) DEFAULT NULL,
  `item_user_id` int(11) DEFAULT NULL,
  `item_user_phone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `order_seller_id` int(11) DEFAULT NULL,
  `order_seller_name` varchar(255) DEFAULT NULL,
  `order_buyer_id` int(11) DEFAULT NULL,
  `order_buyer_name` varchar(255) DEFAULT NULL,
  `order_receive_id` int(11) DEFAULT NULL,
  `order_status` enum('') DEFAULT NULL,
  `order_item_describe` varchar(255) DEFAULT NULL,
  `order_receive_name` varchar(255) DEFAULT NULL,
  `order_price` double DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_item`
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `order_item_id` int(11) NOT NULL,
  `order_item_count` int(11) DEFAULT NULL,
  `order_item_price` double DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `item_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_item
-- ----------------------------

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  `user_phone` varchar(255) DEFAULT NULL,
  `user_mail` varchar(255) DEFAULT NULL,
  `user_create_date` datetime DEFAULT NULL,
  `user_update_date` datetime DEFAULT NULL,
  `user_identity` varchar(16) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'asdf', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('2', 'vcbn', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('3', 'cvbn', null, null, null, null, null, null);
