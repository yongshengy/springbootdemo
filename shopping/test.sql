DROP TABLE IF EXISTS `easybuy_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `easybuy_cart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productid` int(11) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL,
  `cost` int(11) DEFAULT NULL,
  `userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `productId` (`productid`),
  KEY `userId` (`userid`),
  CONSTRAINT `easybuy_cart_ibfk_1` FOREIGN KEY (`productid`) REFERENCES `easybuy_product` (`id`),
  CONSTRAINT `easybuy_cart_ibfk_2` FOREIGN KEY (`userid`) REFERENCES `easybuy_user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `easybuy_news`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `easybuy_news` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(40) NOT NULL COMMENT '标题',
  `content` varchar(1000) NOT NULL COMMENT '内容',
  `createtime` varchar(10) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___C63B5EE724927208` (`id`),
  UNIQUE KEY `UQ__EASYBUY___C12AD09D276EDEB3` (`title`)
) ENGINE=InnoDB AUTO_INCREMENT=708 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `easybuy_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `easybuy_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userid` int(255) DEFAULT NULL COMMENT '用户主键',
  `loginname` varchar(255) DEFAULT NULL,
  `useraddress` varchar(255) DEFAULT NULL COMMENT '用户地址',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `cost` float DEFAULT NULL COMMENT '总消费',
  `serialnumber` varchar(255) DEFAULT NULL COMMENT '订单号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=77 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `easybuy_order_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `easybuy_order_detail` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `orderid` int(10) NOT NULL COMMENT '订单主键',
  `productid` int(10) NOT NULL COMMENT '商品主键',
  `quantity` int(10) NOT NULL COMMENT '数量',
  `cost` float NOT NULL COMMENT '消费',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___66E1BD8E2F10007B` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `easybuy_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `easybuy_product` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(200) NOT NULL COMMENT '名称',
  `description` varchar(1024) DEFAULT NULL COMMENT '描述',
  `price` float NOT NULL COMMENT '价格',
  `stock` int(10) NOT NULL COMMENT '库存',
  `categoryleveloneid` int(10) DEFAULT NULL COMMENT '分类1',
  `categoryleveltwoid` int(10) DEFAULT NULL COMMENT '分类2',
  `categorylevelthreeid` int(10) DEFAULT NULL COMMENT '分类3',
  `filename` varchar(200) DEFAULT NULL COMMENT '文件名称',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___94F6E55132E0915F` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=777 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `easybuy_product_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `easybuy_product_category` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) NOT NULL COMMENT '名称',
  `parentid` int(10) NOT NULL COMMENT '父级目录id',
  `type` int(11) DEFAULT NULL COMMENT '级别(1:一级 2：二级 3：三级)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___9EC2A4E236B12243` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=697 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `easybuy_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `easybuy_user` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `loginname` varchar(255) NOT NULL COMMENT '登录名',
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `password` varchar(255) NOT NULL COMMENT '密码',
  `sex` int(2) NOT NULL DEFAULT '1' COMMENT '性别(1:男 0：女)',
  `identitycode` varchar(60) DEFAULT NULL COMMENT '身份证号',
  `email` varchar(80) DEFAULT NULL COMMENT '邮箱',
  `mobile` varchar(11) DEFAULT NULL COMMENT '手机',
  `type` int(2) DEFAULT '0' COMMENT '类型（1：后台 0:前台）',
  `filename` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `PK__EASYBUY___C96109CC3A81B327` (`loginname`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `easybuy_user_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `easybuy_user_address` (
  `id` int(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `userid` int(255) DEFAULT NULL COMMENT '用户主键',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `isdefault` int(2) DEFAULT '0' COMMENT '是否是默认地址（1:是 0否）',
  `remark` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;
