/*
 Navicat Premium Data Transfer

 Source Server         : 47.103.10.220_3306
 Source Server Type    : MySQL
 Source Server Version : 50644
 Source Host           : 47.103.10.220:3306
 Source Schema         : db_gardenprotector

 Target Server Type    : MySQL
 Target Server Version : 50644
 File Encoding         : 65001

 Date: 30/06/2019 19:23:46
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
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_adoption
-- ----------------------------
INSERT INTO `t_adoption` VALUES (1, 1, '上海', '花草', '上海财经大学有五十盆珍贵植物，暑假需要请贵公司照料', '假期时间为6月27日至9月10日', '已完成');
INSERT INTO `t_adoption` VALUES (2, 2, '北京', '花草', '我司有三十盆牡丹需要照料', '我们8月1日放假，9月一号开始上班', '已完成');
INSERT INTO `t_adoption` VALUES (6, 4, '西安', '植被', '西北工业大学在暑假期间有十片绿化丛需要被照料', '我们学校的暑假在7月5日至9月13日', '已完成');
INSERT INTO `t_adoption` VALUES (18, 3, '北京市', '杂草', '求助求助，帮帮忙，有急事回家3个月！！多肉很健康，养死了也不用你负责，你尽管养！！', '', '已完成');
INSERT INTO `t_adoption` VALUES (19, 36, '吉林省', '花卉', '食人花哟嘿嘿嘿', '2019-06-08', '已完成');
INSERT INTO `t_adoption` VALUES (20, 36, '四川', '花卉', '11111', '11111', '未完成');

-- ----------------------------
-- Table structure for t_article
-- ----------------------------
DROP TABLE IF EXISTS `t_article`;
CREATE TABLE `t_article`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `content` varchar(20000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `createtime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `liked` int(255) DEFAULT NULL,
  `types` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 25 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_article
-- ----------------------------
INSERT INTO `t_article` VALUES (5, 5, '王武行', '多肉养殖心得', '主要的是浇水了。当你选择了好的土好的盆，浇水没有把握好，一样会有损失的。先就拿准备上盆的裸根植物来说吧，一般要上盆的植株，在修根晾干伤口后才能上盆，尽有可能的用微湿的土上盆，不要给水，什么是微湿的土呢，很多刚刚入门的花友没有尺度来衡量，怎么才微湿呢，用我们的手来感觉，混合好土后，给点水，把土弄到手捏起来成团，松开手土就会散开，这个状态就可以了，如果把握不好，就是用手抓土，手上没有湿漉漉的感觉，而土壤看起来是湿的，这个时候的土给植物上盆是最好的，土里混合点干的多菌灵粉一起搅拌，可以起到发根后抑制细菌侵袭毛细根，如果要添加呋喃丹或土虫丹类的预防用药时，在混合好微湿土后，倒入预防用的药，用东西搅拌匀匀就可以待用了。微湿土上盆后的植物，一般在阴凉通风的地方，大概5到10天基本会干透，这个干透要根据季节和环境来定。', 'Thu May 16 09:31:41 CST 2019', 102, '草木');
INSERT INTO `t_article` VALUES (9, 8, '阿尼呦', '绿化养植心得之栽植', '一、栽植(移植):\r\n1、补植季节\r\n落叶树:在春季土壤解冻以后，发芽以前补植或在秋季落叶以后土壤解冻以前补植。\r\n针叶树，常绿阔叶树:在春季土壤解冻以后、发芽以前补植，或在秋季新梢停止生长后、降霜以前补植。\r\n2、死亡的树木挖除前做好记录，并尽早补植。\r\n3、补植的树木应选用原来树种，规格也相近似。若改变树种或规格，则须与原来的景观相协调，行道树补植必须与同路段树种一致。\r\n一、栽植(移植):\r\n1、补植季节\r\n落叶树:在春季土壤解冻以后，发芽以前补植或在秋季落叶以后土壤解冻以前补植。\r\n针叶树，常绿阔叶树:在春季土壤解冻以后、发芽以前补植，或在秋季新梢停止生长后、降霜以前补植。\r\n2、死亡的树木挖除前做好记录，并尽早补植。\r\n3、补植的树木应选用原来树种，规格也相近似。若改变树种或规格，则须与原来的景观相协调，行道树补植必须与同路段树种一致。\r\n一、栽植(移植):\r\n1、补植季节\r\n落叶树:在春季土壤解冻以后，发芽以前补植或在秋季落叶以后土壤解冻以前补植。\r\n针叶树，常绿阔叶树:在春季土壤解冻以后、发芽以前补植，或在秋季新梢停止生长后、降霜以前补植。\r\n2、死亡的树木挖除前做好记录，并尽早补植。\r\n3、补植的树木应选用原来树种，规格也相近似。若改变树种或规格，则须与原来的景观相协调，行道树补植必须与同路段树种一致。\r\n一、栽植(移植):\r\n1、补植季节\r\n落叶树:在春季土壤解冻以后，发芽以前补植或在秋季落叶以后土壤解冻以前补植。\r\n针叶树，常绿阔叶树:在春季土壤解冻以后、发芽以前补植，或在秋季新梢停止生长后、降霜以前补植。\r\n2、死亡的树木挖除前做好记录，并尽早补植。\r\n3、补植的树木应选用原来树种，规格也相近似。若改变树种或规格，则须与原来的景观相协调，行道树补植必须与同路段树种一致。\r\n栽植(移植):\r\n1、补植季节\r\n落叶树:在春季土壤解冻以后，发芽以前补植或在秋季落叶以后土壤解冻以前补植。\r\n针叶树，常绿阔叶树:在春季土壤解冻以后、发芽以前补植，或在秋季新梢停止生长后、降霜以前补植。\r\n2、死亡的树木挖除前做好记录，并尽早补植。\r\n3、补植的树木应选用原来树种，规格也相近似。若改变树种或规格，则须与原来的景观相协调，行道树补植必须与同路段树种一致。', 'Sat May 25 23:11:28 CST 2019', 44, '盆栽');
INSERT INTO `t_article` VALUES (12, 10, '小恐龙', '养花的心得', '花香宜人，赏花益康。我国民间早就流传许多谚语。如“花中自有健身药”；“赏花乃雅\r\n事，悦目又增寿”；\r\n“养花种草，不急不恼，有动有静，不生杂病”；“种花长福，赏花长寿，爱花养性”；“常在花间走，能活九十九”等等，都说明了以花为伴的人容易获得健康长寿。同时，对如何养花充满兴趣，于是就选修了这门的现代养花技艺与盆景制作！\r\n人们之所以爱花，不仅因为它能美化环境，使人赏心悦目，陶情怡性，还因为它为人类的健康作出了可贵的贡献。老舍在散文《养花》中说：“我总是写了几十个字，就到院中去看看，浇浇这棵，搬搬那盆，然后回到室中再写一点，然后再出去，如此循环，把脑力劳动和体力劳动结合在一起，有益于身心，胜于吃药。”养花是一种愉快的劳动，每天侍弄花木，能活动四肢，灵活关节，使人得到锻炼，顿感浑身轻松。尤其是自己亲手栽培的花木，你差不多每天都要去关照，看孕育了花蕾，继而绽蕾而出，成为盛开的花朵。养花的过程，既有期待的喜悦，又有通过自己辛勤劳动而获得报酬的欢乐。\r\n花的丰姿，花的神韵，花的清丽，花的怡静，洗涤心肺，释解内心的忧郁、烦恼，从而促进身体健康，在花丛之中，看着绽开的朵朵花蕾，望花色，五彩缤纷；观花态，千娇百媚；闻花味，荟萃扑鼻。洁白如玉的，使你顿感素洁高雅；艳红似火的，使你精神焕发；翠绿欲滴的，使你充满遐想；黄灿如金的，则使心中升起光华；枝奇叶茂，使你振奋；枝叶飘逸，你也觉潇洒??这种悠闲、轻快、甜美的享受与喜悦，使人顿感心旷神怡，一切疲劳和烦恼置之度外， 花的香气可以镇静安神，调和血脉。 据观察，经常从事园艺劳动的人较少得癌症，这是由于花草树木生长的地方，空气清新，负离子积累也多，吸进这些负离子，获得了充足的氧气；同时，经常醉心于种植、培土、灌水、收获，易忘却其他不愉快的事，从而调节了机体神经系统功能，为防癌与癌症的自愈，提供了有利的条件。\r\n看着满屋子的花草，心里有一种说不出来的惬意，不是因为喜欢花才养花，而是因为养花给我带来了很多乐趣才爱养花，有的时候真想把这种感觉表达出来，但是到底是一种什么\r\n样的感觉自己也说不清楚，尤其是叫我说说养花的心得，一句话，养花没有心得，只有乐趣。 养花大多为两种人，一种是女人养花，因为爱好；一种是老人养花，可以陶冶情操，消\r\n磨时间；我就是这两种之外的了，因为我不爱花，更不是为了消磨时间，就一个目的，培养爱好，增加乐趣，这也可能就是所谓的陶冶情操吧。既然说了养花心得，那也就班门弄斧一把，说说我的心得，但是不是教我们如何养花，而是养花给我带来了哪些乐趣。\r\n陶冶情操。无论是是在居住的屋子，还是办公的地点，摆几盆花放在窗台上，马上你的\r\n屋子就会显得有生气，充满活力，更主要的是居住人的品味，不仅陶冶了自己情操，而且也会潜移默化的影响别人。\r\n消磨时间。对于我们打发无聊的时间来说，养花不仅是一种好的方式，无论是倒腾盆罐，\r\n还是修理花枝，都需要一定时间，几次来回或是精雕细琢都需要时间，不仅消耗了无聊时间，而且做完每件事你都会有成就感。\r\n培养细心。养花的人很多，但不是每个人都能养好花，因为花的品种不同，生长习性不\r\n同，所需要我们付出的精力就不同，养花必须要有耐心，更有细心，每种花不能一视同仁，一样看待，那样是对花的一种不负责任，严重些可能就是一种摧残\r\n花香宜人，赏花益康。我国民间早就流传许多谚语。如“花中自有健身药”；“赏花乃雅\r\n事，悦目又增寿”；\r\n“养花种草，不急不恼，有动有静，不生杂病”；“种花长福，赏花长寿，爱花养性”；“常在花间走，能活九十九”等等，都说明了以花为伴的人容易获得健康长寿。同时，对如何养花充满兴趣，于是就选修了这门的现代养花技艺与盆景制作！\r\n人们之所以爱花，不仅因为它能美化环境，使人赏心悦目，陶情怡性，还因为它为人类的健康作出了可贵的贡献。老舍在散文《养花》中说：“我总是写了几十个字，就到院中去看看，浇浇这棵，搬搬那盆，然后回到室中再写一点，然后再出去，如此循环，把脑力劳动和体力劳动结合在一起，有益于身心，胜于吃药。”养花是一种愉快的劳动，每天侍弄花木，能活动四肢，灵活关节，使人得到锻炼，顿感浑身轻松。尤其是自己亲手栽培的花木，你差不多每天都要去关照，看孕育了花蕾，继而绽蕾而出，成为盛开的花朵。养花的过程，既有期待的喜悦，又有通过自己辛勤劳动而获得报酬的欢乐。\r\n花的丰姿，花的神韵，花的清丽，花的怡静，洗涤心肺，释解内心的忧郁、烦恼，从而促进身体健康，在花丛之中，看着绽开的朵朵花蕾，望花色，五彩缤纷；观花态，千娇百媚；闻花味，荟萃扑鼻。洁白如玉的，使你顿感素洁高雅；艳红似火的，使你精神焕发；翠绿欲滴的，使你充满遐想；黄灿如金的，则使心中升起光华；枝奇叶茂，使你振奋；枝叶飘逸，你也觉潇洒??这种悠闲、轻快、甜美的享受与喜悦，使人顿感心旷神怡，一切疲劳和烦恼置之度外， 花的香气可以镇静安神，调和血脉。 据观察，经常从事园艺劳动的人较少得癌症，这是由于花草树木生长的地方，空气清新，负离子积累也多，吸进这些负离子，获得了充足的氧气；同时，经常醉心于种植、培土、灌水、收获，易忘却其他不愉快的事，从而调节了机体神经系统功能，为防癌与癌症的自愈，提供了有利的条件。\r\n看着满屋子的花草，心里有一种说不出来的惬意，不是因为喜欢花才养花，而是因为养花给我带来了很多乐趣才爱养花，有的时候真想把这种感觉表达出来，但是到底是一种什么\r\n样的感觉自己也说不清楚，尤其是叫我说说养花的心得，一句话，养花没有心得，只有乐趣。 养花大多为两种人，一种是女人养花，因为爱好；一种是老人养花，可以陶冶情操，消\r\n磨时间；我就是这两种之外的了，因为我不爱花，更不是为了消磨时间，就一个目的，培养爱好，增加乐趣，这也可能就是所谓的陶冶情操吧。既然说了养花心得，那也就班门弄斧一把，说说我的心得，但是不是教我们如何养花，而是养花给我带来了哪些乐趣。\r\n陶冶情操。无论是是在居住的屋子，还是办公的地点，摆几盆花放在窗台上，马上你的\r\n屋子就会显得有生气，充满活力，更主要的是居住人的品味，不仅陶冶了自己情操，而且也会潜移默化的影响别人。\r\n消磨时间。对于我们打发无聊的时间来说，养花不仅是一种好的方式，无论是倒腾盆罐，\r\n还是修理花枝，都需要一定时间，几次来回或是精雕细琢都需要时间，不仅消耗了无聊时间，而且做完每件事你都会有成就感。\r\n培养细心。养花的人很多，但不是每个人都能养好花，因为花的品种不同，生长习性不\r\n同，所需要我们付出的精力就不同，养花必须要有耐心，更有细心，每种花不能一视同仁，一样看待，那样是对花的一种不负责任，严重些可能就是一种摧残\r\n花香宜人，赏花益康。我国民间早就流传许多谚语。如“花中自有健身药”；“赏花乃雅\r\n事，悦目又增寿”；\r\n“养花种草，不急不恼，有动有静，不生杂病”；“种花长福，赏花长寿，爱花养性”；“常在花间走，能活九十九”等等，都说明了以花为伴的人容易获得健康长寿。同时，对如何养花充满兴趣，于是就选修了这门的现代养花技艺与盆景制作！\r\n人们之所以爱花，不仅因为它能美化环境，使人赏心悦目，陶情怡性，还因为它为人类的健康作出了可贵的贡献。老舍在散文《养花》中说：“我总是写了几十个字，就到院中去看看，浇浇这棵，搬搬那盆，然后回到室中再写一点，然后再出去，如此循环，把脑力劳动和体力劳动结合在一起，有益于身心，胜于吃药。”养花是一种愉快的劳动，每天侍弄花木，能活动四肢，灵活关节，使人得到锻炼，顿感浑身轻松。尤其是自己亲手栽培的花木，你差不多每天都要去关照，看孕育了花蕾，继而绽蕾而出，成为盛开的花朵。养花的过程，既有期待的喜悦，又有通过自己辛勤劳动而获得报酬的欢乐。\r\n花的丰姿，花的神韵，花的清丽，花的怡静，洗涤心肺，释解内心的忧郁、烦恼，从而促进身体健康，在花丛之中，看着绽开的朵朵花蕾，望花色，五彩缤纷；观花态，千娇百媚；闻花味，荟萃扑鼻。洁白如玉的，使你顿感素洁高雅；艳红似火的，使你精神焕发；翠绿欲滴的，使你充满遐想；黄灿如金的，则使心中升起光华；枝奇叶茂，使你振奋；枝叶飘逸，你也觉潇洒??这种悠闲、轻快、甜美的享受与喜悦，使人顿感心旷神怡，一切疲劳和烦恼置之度外， 花的香气可以镇静安神，调和血脉。 据观察，经常从事园艺劳动的人较少得癌症，这是由于花草树木生长的地方，空气清新，负离子积累也多，吸进这些负离子，获得了充足的氧气；同时，经常醉心于种植、培土、灌水、收获，易忘却其他不愉快的事，从而调节了机体神经系统功能，为防癌与癌症的自愈，提供了有利的条件。\r\n看着满屋子的花草，心里有一种说不出来的惬意，不是因为喜欢花才养花，而是因为养花给我带来了很多乐趣才爱养花，有的时候真想把这种感觉表达出来，但是到底是一种什么\r\n样的感觉自己也说不清楚，尤其是叫我说说养花的心得，一句话，养花没有心得，只有乐趣。 养花大多为两种人，一种是女人养花，因为爱好；一种是老人养花，可以陶冶情操，消\r\n磨时间；我就是这两种之外的了，因为我不爱花，更不是为了消磨时间，就一个目的，培养爱好，增加乐趣，这也可能就是所谓的陶冶情操吧。既然说了养花心得，那也就班门弄斧一把，说说我的心得，但是不是教我们如何养花，而是养花给我带来了哪些乐趣。\r\n陶冶情操。无论是是在居住的屋子，还是办公的地点，摆几盆花放在窗台上，马上你的\r\n屋子就会显得有生气，充满活力，更主要的是居住人的品味，不仅陶冶了自己情操，而且也会潜移默化的影响别人。\r\n消磨时间。对于我们打发无聊的时间来说，养花不仅是一种好的方式，无论是倒腾盆罐，\r\n还是修理花枝，都需要一定时间，几次来回或是精雕细琢都需要时间，不仅消耗了无聊时间，而且做完每件事你都会有成就感。\r\n培养细心。养花的人很多，但不是每个人都能养好花，因为花的品种不同，生长习性不\r\n同，所需要我们付出的精力就不同，养花必须要有耐心，更有细心，每种花不能一视同仁，一样看待，那样是对花的一种不负责任，严重些可能就是一种摧残\r\n', 'Sat May 25 23:29:48 CST 2019', 13, '园林');
INSERT INTO `t_article` VALUES (14, 9, 'admin2', '养花经验与心得，照着做，养啥花都不难，以后养花不求人', '说起我的养花经历也有二十多年了，刚开始还是跟父亲学的，那是也就养一些草花，有时连草花都养不好，经常会把花给养死。后来随着时间的推移，再加上父亲的指导和自己的摸索，渐渐的就越养越好，从开始养花到现在虽然算不上什么高手，但家里却充满了浓浓的绿意和艳丽的色彩，各种各样的花长得都非常旺盛。今天就把我养花的经验和心得分享给大家，只要照着去做，养啥花都不难，以后养花不求人。\r\n1，养花前先了解花的习性。每一种花都有自己的生长习性，就和每个人都有自己的生活习惯一样，在养殖它之前就要先查一下它需要什么样的温度，是怕热还是怕冷，是喜阳还是耐阴，是耐旱还是怕涝，这些条件是不是适合你，等了解清楚了再去养殖。千万不要去照搬别人的养殖方法，因为每个人的地域、气候、环境不同，每个家庭的光照强度、透风条件、环境温度不同，其所养出来的花长势也不同，养花的经验是靠自己去不断摸索和积累，而不是去生搬硬套。\r\n2，选好土配好土。居家养花选土是关键，花卉长得慢，长得干瘦大多都与土有关。养花用的土除了要透气、疏松，土里还要养分全面。现在市场上都有现成的花土，城市的可以买一点，农村的就不必了。我用土一般都是从市场买的养花腐殖土，但市场上卖的花土有点不太理想，我都是在买土时顺便买一点发酵好的干牛粪或羊粪，买回来后按10份土混合2份肥粪拌匀，然后就可以用来栽花了。栽花时先在盆底放入一层碎砖粒或炉煤渣等一些透气好的颗粒植料，然后根据花盆的大小再填入约三分之一左右的花土，接着就可以把花放到花盆的中间，放完后把剩余的花土填入，填完后用手转圈压一下，使根系能够与土接触紧密，接着浇入水，放到即透风太阳又晒不到的地方，约一星期后就可以进入正常养护。\r\n3，浇水要得法。浇水看似很简单，却不知有多少花友把花给浇死，花的生长离不开水，但是水浇多了会烂根死亡。所以，对于养花新手，最好的浇水方法就是在浇水前先看一下土壤的干湿程度，可以用手指挖一下土层表面，如果土层表面有一指以上的干土，就可以浇水了，如果土层表面还是湿的或有干有湿，那就等个一两天再浇水。但每次浇水时一定要浇透，不要只浇湿表面，里面还是干的。\r\n4，上面已经说过了，养花需要了解它的习性，但对于大多数花卉来说，放置的环境场所也很重要，无论养什么样的花卉高温天气的中午一定要避免阳光暴晒，也不可长时间处于阴暗环境，最好是中午避开阳光，早晚见见阳光。另外，很多花友把施肥看得很重要，认为多施肥花会长得好，但事情并非如此。我养花这么多年除了在换盆时把肥料拌入花土里，平时从来就没施过肥，就浇点淘米水啥的，花年年长得都挺旺。\r\n以上只是我养花中的一些经验和心得以及一些养花的步骤，也是养花的一些最基本知识，照着一步一步的去做，不一定能把花养的枝繁叶茂，但总不至于把花给养死。真正想养好，还需要自己不断地总结经验。\r\n', 'Sat May 25 23:54:05 CST 2019', 97, '花卉');
INSERT INTO `t_article` VALUES (15, 3, 'admin', '第一篇博客', '<p>有点小紧张</p>', 'Tue May 28 17:47:59 CST 2019', 1, '医治');
INSERT INTO `t_article` VALUES (17, 3, 'admin', '长春生存攻略（适宜所有生物）', '<h1>长春：</h1><p><br/></p><h1>存在的问题：<br/></h1><h3>1、风大<br/></h3><h3>2、气候干燥<br/></h3><h3>3、天气变化诡异</h3><h3>4、多有地震</h3><h3>5、冬冷夏热<br/></h3><h1>解决方案：<br/></h1><h3>无。亲，我们这边建议您自闭呢<img src=\"http://img.baidu.com/hi/jx2/j_0002.gif\"/></h3>', 'Tue May 28 18:01:29 CST 2019', 2, '草木');
INSERT INTO `t_article` VALUES (20, 36, 'aha', '水仙花培育', '<p><span style=\"color: rgb(51, 51, 51); font-family: arial; text-align: justify; background-color: rgb(255, 255, 255);\">水仙花名字好听而且好看，一般大家种植是为了观赏。水仙花喜欢太阳光照，喜欢温暖的环境，受不了寒冷的天气，也受不了很炎热的夏天，可以说是很娇气了。跟大部分花花草不同的是水仙是冬天的时候才会开花，春天一般就在储存养料，夏天就在休眠，可能是因为夏天太热，需要的养分会更多，所以夏天休眠就会节省了很多养分水仙的种植有两种方法，就是水种植和土种植。</span></p>', 'Wed May 29 23:13:33 CST 2019', 2, '花卉');
INSERT INTO `t_article` VALUES (22, 36, 'aha', '测试', '<p>1111111111111111111111111111111111111111111111111111111111111111</p>', 'Wed May 29 23:26:24 CST 2019', 2, '盆景');
INSERT INTO `t_article` VALUES (23, 36, 'aha', '测试', '<p>这是一个测试</p>', 'Thu May 30 08:44:49 CST 2019', 0, '草木');
INSERT INTO `t_article` VALUES (24, 36, 'aha', '软件', '<p>11111111</p>', 'Thu May 30 08:52:23 CST 2019', 0, '花卉');

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
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_comment
-- ----------------------------
INSERT INTO `t_comment` VALUES (1, 5, 8, '阿尼呦', '受教了', 21, 'Tue May 14 14:38:51 CST 2019');
INSERT INTO `t_comment` VALUES (2, 10, 35, '飞虎', '需要韩国代购吗，联系我：13354676586', 0, 'Tue May 14 14:41:41 CST 2019');
INSERT INTO `t_comment` VALUES (3, 7, 7, 'aha', '肥料选什么牌子的好呢', 0, 'Wed May 22 15:47:20 CST 2019');
INSERT INTO `t_comment` VALUES (4, 11, 8, '阿尼呦', '太厉害了', 0, 'Sat May 25 23:11:28 CST 2019');
INSERT INTO `t_comment` VALUES (5, 9, 6, '张四', '大神啊，粉！', 0, 'Sat May 25 23:13:31 CST 2019');
INSERT INTO `t_comment` VALUES (6, 14, 5, '王五行', '文笔好好啊', 1, 'Sat May 25 23:16:07 CST 2019');
INSERT INTO `t_comment` VALUES (7, 8, 3, 'admin', 'good', 0, 'Sat May 25 23:29:48 CST 2019');
INSERT INTO `t_comment` VALUES (8, 13, 34, 'xuwq', '北京的小姑娘啊', 0, 'Sat May 25 23:42:18 CST 2019');
INSERT INTO `t_comment` VALUES (9, 12, 34, 'xuwq', '代购是啥', 0, 'Sat May 25 23:54:06 CST 2019');
INSERT INTO `t_comment` VALUES (11, 5, 3, 'admin', '西湖美景，三月天呐', 0, 'Tue May 28 18:11:00 CST 2019');
INSERT INTO `t_comment` VALUES (12, 5, 3, 'admin', '谢谢博主~~', 0, 'Tue May 28 18:16:44 CST 2019');
INSERT INTO `t_comment` VALUES (13, 5, 3, 'admin', '我也这么觉得', 0, 'Tue May 28 20:26:41 CST 2019');
INSERT INTO `t_comment` VALUES (25, 5, 36, 'aha', '测试回复', 0, 'Thu May 30 08:51:21 CST 2019');

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
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_reply
-- ----------------------------
INSERT INTO `t_reply` VALUES (1, 3, 'admin', 1, '我觉得你说的真好', 0, 'Sat May 25 10:04:57 CST 2019');
INSERT INTO `t_reply` VALUES (2, 3, 'admin', 2, '你的评论真棒', 0, 'Sat May 25 14:04:57 CST 2019');
INSERT INTO `t_reply` VALUES (3, 10, '小恐龙', 2, '膜拜大神', 0, 'Sat May 25 23:11:28 CST 2019');
INSERT INTO `t_reply` VALUES (5, 5, '王五行', 2, '太厉害了叭', 0, 'Sat May 25 23:16:07 CST 2019');
INSERT INTO `t_reply` VALUES (6, 6, '张四', 2, '好想认识大神啊', 0, 'Sat May 25 23:29:48 CST 2019');
INSERT INTO `t_reply` VALUES (7, 8, '阿尼呦', 2, '哇！', 0, 'Sat May 25 23:42:18 CST 2019');
INSERT INTO `t_reply` VALUES (8, 6, '张四', 2, '六六六', 0, 'Sat May 25 23:54:06 CST 2019');
INSERT INTO `t_reply` VALUES (9, 3, 'admin', 2, 'aaaaaaa', 0, 'Tue May 28 15:05:46 CST 2019');
INSERT INTO `t_reply` VALUES (28, 7, 'aha', 1, '加一', 0, 'Wed May 29 13:34:31 CST 2019');
INSERT INTO `t_reply` VALUES (29, 7, 'aha', 1, '哈哈哈哈', 0, 'Wed May 29 13:34:51 CST 2019');
INSERT INTO `t_reply` VALUES (30, 3, 'admin', 23, '回复admin', 0, 'Wed May 29 22:10:44 CST 2019');
INSERT INTO `t_reply` VALUES (31, 36, 'aha', 1, '测试回复', 0, 'Thu May 30 08:25:30 CST 2019');

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
) ENGINE = InnoDB AUTO_INCREMENT = 38 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (5, '王五行', 'http://47.103.10.220:8001/img/1.jpg', '123', '男', '2001-07-28', '内蒙古自治区', '极限运动爱好者', '哎呀我的妈呀嘿哟我', '0');
INSERT INTO `t_user` VALUES (6, '张四', 'http://47.103.10.220:8001/img/1.jpg', '123', '女', '20000607', '山东', '摄影师', '略略略', '0');
INSERT INTO `t_user` VALUES (7, 'biubiubiu', 'http://47.103.10.220:8001/img/2.jpg', '123', '男', '1999-12-17', '贵州省', '斜杠青年哈哈哈', '娘子~啊哈', '0');
INSERT INTO `t_user` VALUES (8, '阿尼呦', 'http://47.103.10.220:8001/img/1.jpg', '123', '男', '1992-05-25', '北京市', '好学生', '我是小帅锅一个', '0');
INSERT INTO `t_user` VALUES (9, '夏日清荷', 'http://47.103.10.220:8001/img/2.jpg', '123', '女', '19960402', '北京', '事业单位职员', '许你一株夏日的清荷', '0');
INSERT INTO `t_user` VALUES (10, '小恐龙', 'http://47.103.10.220:8001/img/1.jpg', '123', '男', '1990-11-30', '内蒙古自治区', '韩国正品代购超正', '6月8日飞，请尽情的砸单吧！联系方式：13843947584', '0');
INSERT INTO `t_user` VALUES (35, '飞虎', 'http://47.103.10.220:8001/img/3.jpg', '123', '女', '19750205', '北京', '时尚行业', 'Fashion is fashion', '0');
INSERT INTO `t_user` VALUES (36, 'aha', 'http://47.103.10.220:8001/img/2.jpg', '123', '男', '1992-05-25', '广西壮族自治区', '使者~啊哈！哈哈哈', '', '0');
INSERT INTO `t_user` VALUES (37, 'admin', 'http://47.103.10.220:8001/img/2.jpg', '123', NULL, NULL, NULL, NULL, NULL, '0');

SET FOREIGN_KEY_CHECKS = 1;
