/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50619
 Source Host           : localhost:3306
 Source Schema         : db_gardenprotector

 Target Server Type    : MySQL
 Target Server Version : 50619
 File Encoding         : 65001

 Date: 26/05/2019 11:58:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_adoption
-- ----------------------------
DROP TABLE IF EXISTS `t_adoption`;
CREATE TABLE `t_adoption`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `city` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '城市',
  `types` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '类型',
  `detail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '详情',
  `note` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_adoption
-- ----------------------------
INSERT INTO `t_adoption` VALUES (1, 3, '上海', '植被', 'bbbbb', 'aaaaaaaa');
INSERT INTO `t_adoption` VALUES (2, 3, '北京', '植被', 'aaaaa', 'aaaaaaaa');
INSERT INTO `t_adoption` VALUES (3, 3, '北京', '植被', 'aaaaa', 'aaaaaaaa');
INSERT INTO `t_adoption` VALUES (5, 3, '北京', '植被', 'aaaaa', 'aaaaaaaa');
INSERT INTO `t_adoption` VALUES (7, 1, 'beijing', 'jiyang', NULL, 'asdas');
INSERT INTO `t_adoption` VALUES (8, 1, 'beijing', 'jiyang', 'wqeqw', 'asdas');
INSERT INTO `t_adoption` VALUES (9, 1, 'beijing', 'jiyang', 'wqeqw', 'asdas');
INSERT INTO `t_adoption` VALUES (10, 3, '北京', '植被', 'aaaaa', 'aaaaaaaa');
INSERT INTO `t_adoption` VALUES (11, 3, '北京', '植被', 'aaaaa', 'aaaaaaaa');
INSERT INTO `t_adoption` VALUES (12, 3, '北京', '植被', 'aaaaa', 'aaaaaaaa');
INSERT INTO `t_adoption` VALUES (13, 3, '北京', '植被', 'aaaaa', 'aaaaaaaa');
INSERT INTO `t_adoption` VALUES (14, 3, '北京', '植被', 'aaaaa', 'aaaaaaaa');
INSERT INTO `t_adoption` VALUES (15, 3, '北京', '植被', 'aaaaa', 'aaaaaaaa');

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `liked` int(255) DEFAULT NULL,
  `types` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES (5, 3, '孔一言', 'heheda', '哦吼', 'Thu May 16 09:31:41 CST 2019', 89, '医治');
INSERT INTO `t_article` VALUES (6, 3, '孔一言', 'aaa', '孔一言小仙女', 'Thu May 16 22:00:17 CST 2019', 0, '植被');
INSERT INTO `t_article` VALUES (7, 3, '孔一言', 'aaa', '孔一言小仙女', 'Thu May 16 22:00:36 CST 2019', 0, '植被啊');
INSERT INTO `t_article` VALUES (8, 3, '孔一言', 'aaa', '孔一言小仙女', 'Sat May 25 14:02:12 CST 2019', 0, NULL);
INSERT INTO `t_article` VALUES (9, 3, '孔一言', 'aaa', '孔一言小仙女', 'Sat May 25 23:11:28 CST 2019', 0, NULL);
INSERT INTO `t_article` VALUES (11, 3, '孔一言', 'aaa', '孔一言小仙女', 'Sat May 25 23:16:06 CST 2019', 0, NULL);
INSERT INTO `t_article` VALUES (12, 3, '孔一言', 'aaa', '孔一言小仙女', 'Sat May 25 23:29:48 CST 2019', 0, NULL);
INSERT INTO `t_article` VALUES (13, 3, '孔一言', 'aaa', '孔一言小仙女', 'Sat May 25 23:42:18 CST 2019', 0, NULL);
INSERT INTO `t_article` VALUES (14, 3, '孔一言', 'aaa', '孔一言小仙女', 'Sat May 25 23:54:05 CST 2019', 0, NULL);

-- ----------------------------
-- Table structure for t_comment
-- ----------------------------
DROP TABLE IF EXISTS `t_comment`;
CREATE TABLE `t_comment`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `article_id` int(11) DEFAULT NULL COMMENT '文章id',
  `user_id` int(11) DEFAULT NULL COMMENT '评论作者id',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论作者',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论内容',
  `liked` int(11) DEFAULT NULL COMMENT '点赞数',
  `createtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评论日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (1, 5, 3, 'kongyiyan', '真棒', 21, 'Tue May 14 14:38:51 CST 2019');
INSERT INTO `t_comment` VALUES (2, 5, 3, 'kongyiyan', 'ayouyouyou', 0, 'Tue May 14 14:41:41 CST 2019');
INSERT INTO `t_comment` VALUES (3, 1, 3, 'kongyiyan', '真棒', 0, 'Wed May 22 15:47:20 CST 2019');
INSERT INTO `t_comment` VALUES (4, 1, 3, 'kongyiyan', '真棒', 0, 'Sat May 25 23:11:28 CST 2019');
INSERT INTO `t_comment` VALUES (5, 1, 3, 'kongyiyan', '真棒', 0, 'Sat May 25 23:13:31 CST 2019');
INSERT INTO `t_comment` VALUES (6, 1, 3, 'kongyiyan', '真棒', 0, 'Sat May 25 23:16:07 CST 2019');
INSERT INTO `t_comment` VALUES (7, 1, 3, 'kongyiyan', '真棒', 0, 'Sat May 25 23:29:48 CST 2019');
INSERT INTO `t_comment` VALUES (8, 1, 3, 'kongyiyan', '真棒', 0, 'Sat May 25 23:42:18 CST 2019');
INSERT INTO `t_comment` VALUES (9, 1, 3, 'kongyiyan', '真棒', 0, 'Sat May 25 23:54:06 CST 2019');

-- ----------------------------
-- Table structure for t_reply
-- ----------------------------
DROP TABLE IF EXISTS `t_reply`;
CREATE TABLE `t_reply`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '作者',
  `replycomment_id` int(11) DEFAULT NULL COMMENT '被回复人id',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复内容',
  `liked` int(255) DEFAULT NULL COMMENT '点赞数',
  `createtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '回复时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_reply
-- ----------------------------
INSERT INTO `t_reply` VALUES (1, 3, '孔一言', 1, '回复内容测试', 0, '时间测试');
INSERT INTO `t_reply` VALUES (2, 1, '孔一言', 2, '你的评论真棒', 0, 'Sat May 25 14:04:57 CST 2019');
INSERT INTO `t_reply` VALUES (3, 1, '孔一言', 2, '你的评论真棒', 0, 'Sat May 25 23:11:28 CST 2019');
INSERT INTO `t_reply` VALUES (5, 1, '孔一言', 2, '你的评论真棒', 0, 'Sat May 25 23:16:07 CST 2019');
INSERT INTO `t_reply` VALUES (6, 1, '孔一言', 2, '你的评论真棒', 0, 'Sat May 25 23:29:48 CST 2019');
INSERT INTO `t_reply` VALUES (7, 1, '孔一言', 2, '你的评论真棒', 0, 'Sat May 25 23:42:18 CST 2019');
INSERT INTO `t_reply` VALUES (8, 1, '孔一言', 2, '你的评论真棒', 0, 'Sat May 25 23:54:06 CST 2019');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `image` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '头像',
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `sex` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '性别',
  `birth` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '生日',
  `locate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在地区',
  `job` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所在行业',
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '简介',
  `power` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL DEFAULT '0' COMMENT '超管',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'admin', 'aaaaaaa', '123', '女', '19991021', 'henan', '软件狗', '我是小仙女', '1');
INSERT INTO `t_user` VALUES (5, 'lucy', 'aaaaaaa', '123', '女', '19991021', 'henan', '软件狗', '我是小仙女', '0');
INSERT INTO `t_user` VALUES (6, 'lucy', 'aaaaaaa', '123', '女', '19991021', 'henan', '软件狗', '我是小仙女', '0');
INSERT INTO `t_user` VALUES (7, 'lucy', 'aaaaaaa', '123', '女', '19991021', 'henan', '软件狗', '我是小仙女', '0');
INSERT INTO `t_user` VALUES (8, 'lucy', 'aaaaaaa', '123', '女', '19991021', 'henan', '软件狗', '我是小仙女', '0');
INSERT INTO `t_user` VALUES (9, 'admin2', NULL, '123', NULL, NULL, NULL, NULL, NULL, '0');
INSERT INTO `t_user` VALUES (10, 'lucy', 'aaaaaaa', '123', '女', '19991021', 'henan', '软件狗', '我是小仙女', '0');

SET FOREIGN_KEY_CHECKS = 1;
