

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminuser
-- ----------------------------
DROP TABLE IF EXISTS `adminuser`;
CREATE TABLE `adminuser` (
  `adminId` int(20) NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) DEFAULT NULL,
  `adminPassword` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`adminId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminuser
-- ----------------------------
INSERT INTO `adminuser` VALUES ('1', 'admin', '0192023a7bbd73250516f069df18b500');

-- ----------------------------
-- Table structure for recharge
-- ----------------------------
DROP TABLE IF EXISTS `recharge`;
CREATE TABLE `recharge` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Memberid` int(11) DEFAULT NULL,
  `Typeid` int(11) DEFAULT NULL,
  `Money` int(11) DEFAULT NULL,
  `ssmoney` int(11) DEFAULT NULL,
  `zlmoney` int(11) DEFAULT NULL,
  `Date` datetime DEFAULT NULL,
  `czjine` int(11) DEFAULT NULL,
  `beizhu` varchar(50) DEFAULT NULL,
  `czStatic` int(11) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=89 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recharge
-- ----------------------------
INSERT INTO gym.recharge (Memberid, Typeid, Money, ssmoney, zlmoney, Date, czjine, beizhu, czStatic) VALUES (46, null, 188, 198, 10, '2024-12-29 17:14:14', 0, '', 1);
INSERT INTO gym.recharge (Memberid, Typeid, Money, ssmoney, zlmoney, Date, czjine, beizhu, czStatic) VALUES (47, null, 648, 648, 0, '2025-01-03 11:06:26', 0, '', 1);
INSERT INTO gym.recharge (Memberid, Typeid, Money, ssmoney, zlmoney, Date, czjine, beizhu, czStatic) VALUES (46, null, 100, 100, 0, '2025-01-05 11:09:31', 0, '', 1);

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach` (
  `coachId` int(20) NOT NULL AUTO_INCREMENT,
  `coachName` varchar(20) DEFAULT NULL,
  `coachPhone` varchar(50) DEFAULT NULL,
  `coachSex` int(10) DEFAULT NULL,
  `CoachAge` int(10) DEFAULT NULL,
  `CoachData` date DEFAULT NULL,
  `Teach` int(10) DEFAULT NULL,
  `CoachWages` double DEFAULT NULL,
  `CoachAddress` varchar(100) DEFAULT NULL,
  `CoachStatic` int(11) DEFAULT '0',
  PRIMARY KEY (`coachId`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO gym.coach (coachName, coachPhone, coachSex, CoachAge, CoachData, Teach, CoachWages, CoachAddress, CoachStatic) VALUES ('范天雷', '18012345678', 0, 33, '2024-12-01', 30, 18888, '狼牙特战旅红细胞特别行动小组', 0);
INSERT INTO gym.coach (coachName, coachPhone, coachSex, CoachAge, CoachData, Teach, CoachWages, CoachAddress, CoachStatic) VALUES ('czw', '15797851904', 0, 33, '2025-01-02', 12, 123, '123', 0);

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `eqId` int(20) NOT NULL AUTO_INCREMENT,
  `eqName` varchar(20) DEFAULT NULL,
  `eqText` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`eqId`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO gym.equipment (eqName, eqText) VALUES ('95式狙击步枪', '弹道偏左');

-- ----------------------------
-- Table structure for goodinfo
-- ----------------------------
DROP TABLE IF EXISTS `goodinfo`;
CREATE TABLE `goodinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goodsid` int(11) DEFAULT NULL,
  `memberid` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goodinfo
-- ----------------------------
INSERT INTO gym.goodinfo (goodsid, memberid, count, price, remark) VALUES (9, 46, 1, 368, '');
INSERT INTO gym.goodinfo (goodsid, memberid, count, price, remark) VALUES (9, 47, 1, 368, '');
INSERT INTO gym.goodinfo (goodsid, memberid, count, price, remark) VALUES (10, 46, 1, 28888, '');


-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `goodsId` int(11) NOT NULL AUTO_INCREMENT,
  `goodsName` varchar(50) DEFAULT NULL,
  `unit` varchar(20) DEFAULT NULL,
  `unitPrice` double DEFAULT NULL,
  `sellPrice` double DEFAULT NULL,
  `inventory` int(11) DEFAULT NULL,
  `remark` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`goodsId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO gym.goods (goodsName, unit, unitPrice, sellPrice, inventory, remark) VALUES ('狙击枪瞄准镜', '个', 168, 368, 18, '');
INSERT INTO gym.goods (goodsName, unit, unitPrice, sellPrice, inventory, remark) VALUES ('95式狙击枪', '个', 18888, 28888, 17, '');

-- ----------------------------
-- Table structure for lose
-- ----------------------------
DROP TABLE IF EXISTS `lose`;
CREATE TABLE `lose` (
  `loosId` int(20) NOT NULL AUTO_INCREMENT,
  `loosName` varchar(20) DEFAULT NULL,
  `loosImages` varchar(50) DEFAULT NULL,
  `loosAddress` varchar(50) DEFAULT NULL,
  `loosjdate` datetime DEFAULT NULL,
  `loosStatus` int(10) DEFAULT NULL,
  `scavenger` varchar(50) DEFAULT NULL,
  `scavengerPhone` varchar(50) DEFAULT NULL,
  `ReceiveName` varchar(20) DEFAULT NULL,
  `ReceivePhone` varchar(20) DEFAULT NULL,
  `loosldate` datetime DEFAULT NULL,
  `admin` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`loosId`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of lose
-- ----------------------------
INSERT INTO gym.lose (loosName, loosImages, loosAddress, loosjdate, loosStatus, scavenger, scavengerPhone, ReceiveName, ReceivePhone, loosldate, admin) VALUES ('靶子', '1', '靶场', '2024-12-30 00:00:00', 0, '何晨光', '13812345678', null, null, null, 'admin');
INSERT INTO gym.lose (loosName, loosImages, loosAddress, loosjdate, loosStatus, scavenger, scavengerPhone, ReceiveName, ReceivePhone, loosldate, admin) VALUES ('瞄准镜', '1', '狙击阵地', '2025-01-08 00:00:00', 0, '李二牛', '13912345678', null, null, null, 'admin');

-- ----------------------------
-- Table structure for member
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `MemberId` int(20) NOT NULL AUTO_INCREMENT,
  `MemberName` varchar(20) DEFAULT NULL,
  `MemberPhone` varchar(20) DEFAULT NULL,
  `MemberSex` int(10) DEFAULT NULL,
  `MemberAge` int(20) DEFAULT NULL,
  `MemberTypes` int(10) DEFAULT NULL,
  `NenberDate` date DEFAULT NULL,
  `Birthday` varchar(20) DEFAULT NULL,
  `memberStatic` int(20) DEFAULT NULL,
  `Memberbalance` float DEFAULT '0',
  `Memberxufei` date DEFAULT NULL,
  PRIMARY KEY (`MemberId`),
  KEY `fk-member-membertype` (`MemberTypes`),
  CONSTRAINT `fk-member-membertype` FOREIGN KEY (`MemberTypes`) REFERENCES `membertype` (`TypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO gym.member (MemberName, MemberPhone, MemberSex, MemberAge, MemberTypes, NenberDate, Birthday, memberStatic, Memberbalance, Memberxufei) VALUES ('李二牛', '13612345678', 1, 18, 3, '2024-12-29', '06-18', 1, -28788, '2026-01-03');
INSERT INTO gym.member (MemberName, MemberPhone, MemberSex, MemberAge, MemberTypes, NenberDate, Birthday, memberStatic, Memberbalance, Memberxufei) VALUES ('何晨光', '13912345678', 1, 18, 5, '2024-12-29', '06-18', 2, 92, '2025-01-05');
INSERT INTO gym.member (MemberName, MemberPhone, MemberSex, MemberAge, MemberTypes, NenberDate, Birthday, memberStatic, Memberbalance, Memberxufei) VALUES ('王艳兵', '14012345678', 1, 18, 2, '2024-12-29', '06-18', 1, 0, '2025-01-28');

-- ----------------------------
-- Table structure for membertype
-- ----------------------------
DROP TABLE IF EXISTS `membertype`;
CREATE TABLE `membertype` (
  `TypeId` int(20) NOT NULL AUTO_INCREMENT,
  `TypeName` varchar(20) DEFAULT NULL,
  `TypeciShu` int(11) DEFAULT NULL,
  `TypeDay` int(11) DEFAULT NULL,
  `Typemoney` float DEFAULT NULL,
  PRIMARY KEY (`TypeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of membertype
-- ----------------------------
INSERT INTO gym.membertype (TypeName, TypeciShu, TypeDay, Typemoney) VALUES ('季卡', 30, 90, 500);
INSERT INTO gym.membertype (TypeName, TypeciShu, TypeDay, Typemoney) VALUES ('月卡', 10, 30, 150);
INSERT INTO gym.membertype (TypeName, TypeciShu, TypeDay, Typemoney) VALUES ('年卡', 120, 365, 1000);
INSERT INTO gym.membertype (TypeName, TypeciShu, TypeDay, Typemoney) VALUES ('周卡', 5, 7, 50);

-- ----------------------------
-- Table structure for privatecoachinfo
-- ----------------------------
DROP TABLE IF EXISTS `privatecoachinfo`;
CREATE TABLE `privatecoachinfo` (
  `pid` int(20) NOT NULL AUTO_INCREMENT,
  `memberid` int(11) DEFAULT NULL,
  `coachid` int(11) DEFAULT NULL,
  `subjectid` int(11) DEFAULT NULL,
  `count` int(20) DEFAULT NULL,
  `countprice` double DEFAULT NULL,
  `realprice` double DEFAULT NULL,
  `date` date DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  `remark` varchar(20) DEFAULT NULL,
  `admin` varchar(20) DEFAULT 'asdf',
  PRIMARY KEY (`pid`),
  KEY `fk_pri_subject` (`subjectid`),
  KEY `fk_pri_coach` (`coachid`),
  KEY `fk_pri_member` (`memberid`),
  CONSTRAINT `fk_pri_coach` FOREIGN KEY (`coachid`) REFERENCES `coach` (`coachId`),
  CONSTRAINT `fk_pri_member` FOREIGN KEY (`memberid`) REFERENCES `member` (`MemberId`),
  CONSTRAINT `fk_pri_subject` FOREIGN KEY (`subjectid`) REFERENCES `subject` (`subId`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of privatecoachinfo
-- ----------------------------
INSERT INTO gym.privatecoachinfo (memberid, coachid, subjectid, count, countprice, realprice, date, state, remark, admin) VALUES (46, 17, 7, 1, 188, 200, '2024-12-30', 1, '', 'asdf');
INSERT INTO gym.privatecoachinfo (memberid, coachid, subjectid, count, countprice, realprice, date, state, remark, admin) VALUES (47, 17, 7, 1, 188, 300, '2025-01-03', 1, '', 'asdf');

-- ----------------------------
-- Table structure for subject
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `subId` int(20) NOT NULL AUTO_INCREMENT,
  `subname` varchar(20) DEFAULT NULL,
  `sellingPrice` double DEFAULT NULL,
  PRIMARY KEY (`subId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO gym.subject (subname, sellingPrice) VALUES ('武装越野', 188);

