# Host: localhost  (Version 5.7.19)
# Date: 2020-11-25 18:29:51
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "goods_info"
#

DROP TABLE IF EXISTS `goods_info`;
CREATE TABLE `goods_info` (
  `id` varchar(15) NOT NULL DEFAULT '' COMMENT '商品id，格式：G20201125180000',
  `name` varchar(100) NOT NULL DEFAULT '' COMMENT '商品名',
  `note` text COMMENT '商品备注',
  `price` int(11) NOT NULL DEFAULT '0' COMMENT '商品价格，该值存储值=实际值*100',
  `create_at` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_at` bigint(13) DEFAULT NULL COMMENT '更新时间',
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品表';

#
# Data for table "goods_info"
#


#
# Structure for table "order_info"
#

DROP TABLE IF EXISTS `order_info`;
CREATE TABLE `order_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(15) NOT NULL DEFAULT '' COMMENT '用户id',
  `contact_id` int(11) NOT NULL DEFAULT '0' COMMENT '联系人id',
  `goods_id` varchar(15) NOT NULL DEFAULT '' COMMENT '商品id',
  `num` int(11) NOT NULL DEFAULT '1' COMMENT '购买数量',
  `create_at` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_at` bigint(13) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单信息表';

#
# Data for table "order_info"
#


#
# Structure for table "user_contact"
#

DROP TABLE IF EXISTS `user_contact`;
CREATE TABLE `user_contact` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '联系人id',
  `user_id` varchar(15) NOT NULL DEFAULT '' COMMENT '用户id',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '联系人名',
  `phone` int(11) NOT NULL DEFAULT '0' COMMENT '联系人电话',
  `address` varchar(100) NOT NULL DEFAULT '' COMMENT '联系地址',
  `create_at` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `update_at` bigint(13) DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户联系人资料';

#
# Data for table "user_contact"
#


#
# Structure for table "user_info"
#

DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` varchar(15) NOT NULL DEFAULT '' COMMENT '用户id，格式：U20201125175000',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '用户名',
  `nickname` varchar(25) DEFAULT NULL COMMENT '昵称',
  `phone` int(11) NOT NULL DEFAULT '0' COMMENT '手机号',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱号',
  `terminal_device` varchar(50) NOT NULL DEFAULT '' COMMENT '终端设备',
  `create_at` bigint(13) NOT NULL DEFAULT '0' COMMENT '创建时间',
  `last_login_at` bigint(13) DEFAULT NULL COMMENT '最近登录时间',
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

#
# Data for table "user_info"
#

