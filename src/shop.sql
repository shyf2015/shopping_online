/*
Navicat MySQL Data Transfer

Source Server         : MySql
Source Server Version : 50536
Source Host           : localhost:3306
Source Database       : shop

Target Server Type    : MYSQL
Target Server Version : 50536
File Encoding         : 65001

Date: 2017-05-05 21:31:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_address`
-- ----------------------------
DROP TABLE IF EXISTS `t_address`;
CREATE TABLE `t_address` (
  `addressid` int(255) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `province` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `conname` varchar(255) DEFAULT NULL,
  `conphone` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`addressid`),
  KEY `PK` (`user_id`),
  CONSTRAINT `PK` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_address
-- ----------------------------
INSERT INTO `t_address` VALUES ('1', '1', '山西', '晋城', '山西晋城', 'zhangsan ', '43215', null);
INSERT INTO `t_address` VALUES ('2', '2', '山西', '太原', '山西太原', '王五', '123455', null);

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `adminid` int(11) NOT NULL AUTO_INCREMENT,
  `adminname` varchar(255) DEFAULT NULL,
  `adminpassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES ('1', 'shyf', 'shyf');
INSERT INTO `t_admin` VALUES ('2', 'sjj', 'sjj');

-- ----------------------------
-- Table structure for `t_car`
-- ----------------------------
DROP TABLE IF EXISTS `t_car`;
CREATE TABLE `t_car` (
  `carid` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) DEFAULT NULL,
  `goods_num` int(11) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`carid`),
  KEY `PK2` (`user_id`),
  CONSTRAINT `PK2` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_car
-- ----------------------------
INSERT INTO `t_car` VALUES ('1', '1', '5', '1', 'img/华为P9皓月银.jpg');
INSERT INTO `t_car` VALUES ('2', '2', '6', '1', 'img/华为P10钻雕蓝.jpg');
INSERT INTO `t_car` VALUES ('3', '3', '5', '2', 'img/华为Mate9苍穹灰.jpg');
INSERT INTO `t_car` VALUES ('4', '4', '5', '2', 'img/XiaoMiwhite.jpg');
INSERT INTO `t_car` VALUES ('5', '5', '2', '3', 'img/HongMiNote4white.jpg');
INSERT INTO `t_car` VALUES ('6', '6', '1', '3', 'img/HongMIProsilver.jpg');
INSERT INTO `t_car` VALUES ('7', '7', '2', '4', 'img/HongMIProsilver.jpg');
INSERT INTO `t_car` VALUES ('8', '1', '2', '1', 'hahah');
INSERT INTO `t_car` VALUES ('9', '2', '1', '1', 'img/华为P10钻雕金.jpg');
INSERT INTO `t_car` VALUES ('10', '2', '1', '1', 'img/华为P10钻雕金.jpg');
INSERT INTO `t_car` VALUES ('11', '2', '1', '1', 'img/华为P10钻雕金.jpg');
INSERT INTO `t_car` VALUES ('12', '2', '1', '1', 'img/华为P10钻雕金.jpg');
INSERT INTO `t_car` VALUES ('13', '2', '1', '1', 'img/华为P10草木绿.jpg');
INSERT INTO `t_car` VALUES ('14', '3', '1', '1', 'img/华为Mate9月光银.jpg');

-- ----------------------------
-- Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `goodsid` int(11) NOT NULL AUTO_INCREMENT,
  `goodsname` varchar(255) DEFAULT NULL,
  `goodsprice` double DEFAULT NULL,
  `goodsinfo` varchar(255) DEFAULT NULL,
  `goodstype_id` int(11) DEFAULT NULL,
  `goodsnum` int(11) DEFAULT NULL,
  PRIMARY KEY (`goodsid`),
  KEY `PK4` (`goodstype_id`),
  CONSTRAINT `PK4` FOREIGN KEY (`goodstype_id`) REFERENCES `t_goodstype` (`goodstypeid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goods
-- ----------------------------
INSERT INTO `t_goods` VALUES ('1', '华为P9', '3800', '这是一个好手机', '1', '100');
INSERT INTO `t_goods` VALUES ('2', '华为P10', '6000', '这是一个好电脑', '1', '150');
INSERT INTO `t_goods` VALUES ('3', '华为mate9', '5000', '这是一个好平板', '1', '120');
INSERT INTO `t_goods` VALUES ('4', '小米', '3400', '这是一个好手机', '9', '110');
INSERT INTO `t_goods` VALUES ('5', '红米note4', '8000', '这是一个号电脑', '9', '130');
INSERT INTO `t_goods` VALUES ('6', '红米Pro', '4000', '这是一个好平板', '9', '120');
INSERT INTO `t_goods` VALUES ('7', 'iphone7plus', '500', '这不是好手机', '12', '9000');
INSERT INTO `t_goods` VALUES ('8', 'iphone6plus', '200', '这个能用', '12', '10000');
INSERT INTO `t_goods` VALUES ('9', 'iphoneSE', '600', '这是一个号电脑', '12', '9000');
INSERT INTO `t_goods` VALUES ('10', '华为matebook HZ-W29', '5000', '柔光双摄着凉你的美', '7', '120');
INSERT INTO `t_goods` VALUES ('11', '华为matebook HZ-w19', '6688', '好好学习天天向上', '7', '100');
INSERT INTO `t_goods` VALUES ('12', '小米平板3', '1688', '万能的充电宝', '11', '130');
INSERT INTO `t_goods` VALUES ('13', 'ipad', '2558', '噜啦啦乱拉啊', '13', '140');
INSERT INTO `t_goods` VALUES ('14', 'ipad pro', '3938', '用过的都说好', '13', '240');
INSERT INTO `t_goods` VALUES ('15', 'ipad Pro Wlan', '4888', '你也来试试吧', '13', '300');
INSERT INTO `t_goods` VALUES ('16', '小米air13.3', '4999', '买一个回去吧', '10', '200');
INSERT INTO `t_goods` VALUES ('17', '小米', '3599', '你买不了吃亏', '10', '210');
INSERT INTO `t_goods` VALUES ('18', '小米air 12.5', '3599', '你买不力艾上当', '10', '321');
INSERT INTO `t_goods` VALUES ('19', 'macBook', '9059', '哈哈哈哈哈哈哈', '14', '321');
INSERT INTO `t_goods` VALUES ('20', 'macBook pro MF839CH', '8000', '当你老了', '14', '222');
INSERT INTO `t_goods` VALUES ('21', 'macBook', '11499', '走不动了', '14', '333');

-- ----------------------------
-- Table structure for `t_goodstype`
-- ----------------------------
DROP TABLE IF EXISTS `t_goodstype`;
CREATE TABLE `t_goodstype` (
  `goodstypeid` int(11) NOT NULL AUTO_INCREMENT,
  `goodstypename` varchar(255) DEFAULT NULL,
  `supertype` varchar(255) DEFAULT NULL,
  `brand` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`goodstypeid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_goodstype
-- ----------------------------
INSERT INTO `t_goodstype` VALUES ('1', '华为手机', '手机', '华为');
INSERT INTO `t_goodstype` VALUES ('7', '华为电脑', '电脑', '华为');
INSERT INTO `t_goodstype` VALUES ('8', '华为平板', '平板', '华为');
INSERT INTO `t_goodstype` VALUES ('9', '小米手机', '手机', '小米');
INSERT INTO `t_goodstype` VALUES ('10', '小米电脑', '电脑', '小米');
INSERT INTO `t_goodstype` VALUES ('11', '小米平板', '平板', '小米');
INSERT INTO `t_goodstype` VALUES ('12', 'iphone', '手机', '苹果');
INSERT INTO `t_goodstype` VALUES ('13', 'ipad', '平板', '苹果');
INSERT INTO `t_goodstype` VALUES ('14', 'mac', '电脑', '苹果');

-- ----------------------------
-- Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `ordernum` int(11) NOT NULL AUTO_INCREMENT,
  `orderstate` varchar(255) DEFAULT NULL,
  `ordertime` datetime DEFAULT NULL,
  `goods_name` varchar(255) DEFAULT NULL,
  `goods_price` double DEFAULT NULL,
  `goods_num` int(11) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `conname` varchar(255) DEFAULT NULL,
  `conphone` varchar(255) DEFAULT NULL,
  `sumprice` double DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `orderimgurl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ordernum`),
  KEY `PK3` (`user_id`),
  CONSTRAINT `PK3` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`userid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES ('1', '1', '2017-04-05 00:00:00', '手机', '500', '1', '山西', '张三', '12345', '500', '1', null);
INSERT INTO `t_order` VALUES ('2', '2', '2017-05-06 00:00:00', '电脑', '600', '1', '太原', '李四', '123456', '6000', '2', null);
INSERT INTO `t_order` VALUES ('3', '1', '2017-04-06 00:00:00', '平板', '400', '1', '中国', '王五', '321546', '500', '3', null);

-- ----------------------------
-- Table structure for `t_param`
-- ----------------------------
DROP TABLE IF EXISTS `t_param`;
CREATE TABLE `t_param` (
  `paramid` int(11) NOT NULL AUTO_INCREMENT,
  `cpu` varchar(255) DEFAULT NULL,
  `ram` varchar(255) DEFAULT NULL,
  `rom` varchar(255) DEFAULT NULL,
  `size` varchar(255) DEFAULT NULL,
  `battery` varchar(255) DEFAULT NULL,
  `os` varchar(255) DEFAULT NULL,
  `goods_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`paramid`),
  KEY `PK8` (`goods_id`),
  CONSTRAINT `PK8` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`goodsid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_param
-- ----------------------------
INSERT INTO `t_param` VALUES ('1', '海思', '3GB', '32GB', '5.2英寸', '3000mAh', '安卓', '1');
INSERT INTO `t_param` VALUES ('2', '麒麟960', '4GB', '64,128GB', '5.1英寸', '3200mAh', '安卓', '2');
INSERT INTO `t_param` VALUES ('3', '麒麟960', '4GB', '32，64,128GB', '5.9英寸', '4000mAh', '华为 EMUI 5.0', '3');
INSERT INTO `t_param` VALUES ('4', '高通晓龙', '3GB', '64GB', '5.15英寸', '3120mAh', 'MIUI', '4');
INSERT INTO `t_param` VALUES ('5', '联发科', '3GB', '64GB', '5.5英寸', '4100mAh', 'MIUI', '5');
INSERT INTO `t_param` VALUES ('6', '联发科', '3GB', '64GB', '5.5英寸', '4100mAh', 'MIUI', '6');
INSERT INTO `t_param` VALUES ('7', 'apple', '4GB', '32,128,256GB', '5.5英寸', '4100mAh', 'IOS9', '7');
INSERT INTO `t_param` VALUES ('8', 'aplle', '4GB', '32,128GB', '5.5英寸', '4100mAh', 'IOS9', '8');
INSERT INTO `t_param` VALUES ('9', 'apple', '2GB', '16,32GB', '4.0英寸', '4100mAh', 'IOS9', '9');
INSERT INTO `t_param` VALUES ('10', '第六代智能英特尔 酷睿m5', '8GB', '256GB', '12英寸', '4000mAH', 'windows 10', '10');
INSERT INTO `t_param` VALUES ('11', '第六代智能英特尔 酷睿m5', '4GB', '128GB', '12英寸', '4000mAH', 'windows 10', '11');
INSERT INTO `t_param` VALUES ('12', '联发科MTK', '4GB', '64GB', '7.9英寸', '4000mAH', 'Android 6.0', '12');
INSERT INTO `t_param` VALUES ('13', '64 位架构的 A9X 芯片 M9 运动协处理器', '2GB', '128GB', '9.7英寸', '4000mAH', 'iOS', '13');
INSERT INTO `t_param` VALUES ('14', '64 位架构的 A9X 芯片 M9 运动协处理器', '2GB', '32GB', '9.7英寸', '4000mAH', 'iOS 9', '14');
INSERT INTO `t_param` VALUES ('15', '64 位架构的 A9X 芯片 M9 运动协处理器', '4GB', '128GB', '9.7英寸', '4000mAH', 'iOS 9', '15');
INSERT INTO `t_param` VALUES ('16', '英特尔 酷睿 i5-6200U', '8GB', '256GB', '13.3英寸', '4芯锂电池', 'windows 10', '16');
INSERT INTO `t_param` VALUES ('17', '英特尔 酷睿 m3-7Y30', '4GB', '128GB', '12.5英寸', '4芯锂电池\r\n', 'windows 10', '17');
INSERT INTO `t_param` VALUES ('18', '英特尔 酷睿 m3-7Y30', '4GB', '256GB', '12.5英寸', '4芯锂电池\r\n', 'windows 10', '18');
INSERT INTO `t_param` VALUES ('19', 'OS X El Capitan', '8GB', '256GB', '12英寸', '4芯锂电池', 'OS X El Capitan', '19');
INSERT INTO `t_param` VALUES ('20', 'Intel Core i5-5257U(2.7GHz)', '8GB', '128GB', '13.3英寸', '锂聚合物电池', 'Mac OS', '20');
INSERT INTO `t_param` VALUES ('21', '1.1GHz 双核 Intel Core m3', '8GB', '256GB', '12英寸', '锂聚合物电池', 'Macos Sierra', '21');

-- ----------------------------
-- Table structure for `t_picture`
-- ----------------------------
DROP TABLE IF EXISTS `t_picture`;
CREATE TABLE `t_picture` (
  `goods_id` int(11) DEFAULT NULL,
  `color` varchar(255) DEFAULT NULL,
  `imgurl` varchar(255) DEFAULT NULL,
  `pictureid` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`pictureid`),
  KEY `PK7` (`goods_id`),
  CONSTRAINT `PK7` FOREIGN KEY (`goods_id`) REFERENCES `t_goods` (`goodsid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_picture
-- ----------------------------
INSERT INTO `t_picture` VALUES ('1', '皓月银', 'img/华为P9皓月银.jpg', '1');
INSERT INTO `t_picture` VALUES ('1', '太银灰', 'img/华为P9钛银灰.jpg', '2');
INSERT INTO `t_picture` VALUES ('1', '流光金', 'img/华为P9流光金.jpg', '3');
INSERT INTO `t_picture` VALUES ('2', '砖雕金', 'img/华为P10钻雕金.jpg', '4');
INSERT INTO `t_picture` VALUES ('2', '玫瑰金', 'img/华为P10玫瑰金.jpg', '5');
INSERT INTO `t_picture` VALUES ('2', '砖雕蓝', 'img/华为P10钻雕蓝.jpg', '6');
INSERT INTO `t_picture` VALUES ('2', '草木绿', 'img/华为P10草木绿.jpg', '7');
INSERT INTO `t_picture` VALUES ('3', '月银灰', 'img/华为Mate9月光银.jpg', '8');
INSERT INTO `t_picture` VALUES ('3', '苍穹灰', 'img/华为Mate9苍穹灰.jpg', '9');
INSERT INTO `t_picture` VALUES ('4', '白色', 'img/XiaoMiwhite.jpg', '10');
INSERT INTO `t_picture` VALUES ('4', '金色', 'img/XiaoMigold.jpg', '11');
INSERT INTO `t_picture` VALUES ('5', '金色', 'img/iphoneSEgold.jpg', '12');
INSERT INTO `t_picture` VALUES ('5', '白色', 'img/HongMiNote4white.jpg', '13');
INSERT INTO `t_picture` VALUES ('5', '黑色', 'img/HongMiNote4black.jpg', '14');
INSERT INTO `t_picture` VALUES ('6', '金色', 'img/HongMiNote4gold.jpg', '15');
INSERT INTO `t_picture` VALUES ('6', '银色', 'img/HongMIProsilver.jpg', '16');
INSERT INTO `t_picture` VALUES ('6', '灰色', 'img/iphone6plusgray.jpg', '17');
INSERT INTO `t_picture` VALUES ('7', '玫瑰金色', 'img/iphone6plusgold.jpg', '18');
INSERT INTO `t_picture` VALUES ('7', '黑色', 'img/HongMiNote4gold.jpg', '19');
INSERT INTO `t_picture` VALUES ('7', '红色特别版', 'img/HongMIProsilver.jpg', '20');
INSERT INTO `t_picture` VALUES ('8', '玫瑰金色', 'img/iphone6plusgold.jpg', '21');
INSERT INTO `t_picture` VALUES ('8', '金色', 'img/HongMiProgold.jpg', '22');
INSERT INTO `t_picture` VALUES ('8', '灰色', 'img/HongMiProgray.jpg', '23');
INSERT INTO `t_picture` VALUES ('9', '玫瑰金色', 'img/iphone7plusrosegold.jpg', '24');
INSERT INTO `t_picture` VALUES ('9', '金色', 'img/iphoneSErosegold.jpg', '25');
INSERT INTO `t_picture` VALUES ('10', '香槟金', 'img/HuaWei1.jpg', '26');
INSERT INTO `t_picture` VALUES ('11', '太空灰', 'img/HuaWei22.jpg', '27');
INSERT INTO `t_picture` VALUES ('12', '前黑后金', 'img/iphone1black.jpg', '28');
INSERT INTO `t_picture` VALUES ('13', '金色', 'img/iphone1gold.jpg', '29');
INSERT INTO `t_picture` VALUES ('13', '银色', 'img/iphone2silver.jpg', '30');
INSERT INTO `t_picture` VALUES ('13', '深空灰色', 'img/XiaoMi11.jpg', '31');
INSERT INTO `t_picture` VALUES ('14', '金色', 'img/XiaoMi1.jpg', '32');
INSERT INTO `t_picture` VALUES ('14', '银色', 'img/iphone1silver.jpg', '33');
INSERT INTO `t_picture` VALUES ('14', '深空灰色', 'img/Ciphone1gold.jpg', '34');
INSERT INTO `t_picture` VALUES ('15', '金色', 'img/Ciphone2gold.jpg', '35');
INSERT INTO `t_picture` VALUES ('15', '银色', 'img/Ciphone2silver.jpg', '36');
INSERT INTO `t_picture` VALUES ('15', '玫瑰金', 'img/Ciphone2rosegold.jpg', '37');
INSERT INTO `t_picture` VALUES ('16', '金色', 'img/Ciphone1gold.jpg', '38');
INSERT INTO `t_picture` VALUES ('16', '银色', 'img/Ciphone2silver.jpg', '39');
INSERT INTO `t_picture` VALUES ('16', '玫瑰金', 'img/Ciphone1rosegold.jpg', '40');
INSERT INTO `t_picture` VALUES ('17', '银白色', 'img/Ciphone1gray.jpg', '41');
INSERT INTO `t_picture` VALUES ('18', '金色', 'img/Ciphone1gold.jpg', '42');
INSERT INTO `t_picture` VALUES ('18', '银色', 'img/3XiaoMiAir13.3.jpg', '43');
INSERT INTO `t_picture` VALUES ('19', '金色', 'img/Ciphone3silver.jpg', '44');
INSERT INTO `t_picture` VALUES ('19', '银色', 'img/Ciphone33silver.jpg', '45');
INSERT INTO `t_picture` VALUES ('20', '金色', 'img/CXiaomisilver2.jpg', '46');
INSERT INTO `t_picture` VALUES ('20', '银色', 'img/Ciphone333silver.jpg', '47');
INSERT INTO `t_picture` VALUES ('21', '银色', 'img/Ciphone1silver.jpg', '48');
INSERT INTO `t_picture` VALUES ('21', '金色', 'img/Ciphone1rosegold.jpg', '49');
INSERT INTO `t_picture` VALUES ('21', '深空灰色', 'img/XiaoMiAir13.3.jpg', '50');
INSERT INTO `t_picture` VALUES ('21', '玫瑰金色', 'img/Xiaomigold.jpg', '51');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `realname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'shyf', 'shyf', '时杨帆');
INSERT INTO `t_user` VALUES ('2', 'sjj', 'sjj', '史军杰');
INSERT INTO `t_user` VALUES ('3', 'mi', 'mi', '米鹏飞');
INSERT INTO `t_user` VALUES ('4', 'pxx', 'pxx', '潘晓霞');
INSERT INTO `t_user` VALUES ('5', 'pxs', 'pxs', '裴小帅');
