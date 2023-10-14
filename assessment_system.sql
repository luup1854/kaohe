/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 80013 (8.0.13)
 Source Host           : localhost:3306
 Source Schema         : assessment_system

 Target Server Type    : MySQL
 Target Server Version : 80013 (8.0.13)
 File Encoding         : 65001

 Date: 13/10/2023 20:57:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for assessment_system
-- ----------------------------
DROP TABLE IF EXISTS `assessment_system`;
CREATE TABLE `assessment_system`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '号码',
  `information` text CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL COMMENT '信息',
  `state` int(11) NULL DEFAULT NULL COMMENT '状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of assessment_system
-- ----------------------------
INSERT INTO `assessment_system` VALUES (1, '1.	大二女生王霞来自农村，最近父亲去世给原本贫困的家庭雪上加霜，母亲身体患病，无力承担学习和生活费用，劝其退学，该生找到辅导员求助，帮助家庭经济困难学生度过难关继续学业，作为辅导员的你该如何与他交谈', 0);
INSERT INTO `assessment_system` VALUES (2, '世界上最受欢迎的人从来不是那种不停地往后看着昨天的困苦、悲伤、失败和惨痛挫折的人，而是那种怀着信心、期望、勇气和愉快的求知欲而放眼未来的人。', 0);
INSERT INTO `assessment_system` VALUES (3, '3.	小林以较高的成绩被我校录取，入校时招生老师告诉她，只要她保持良好的学习状态，很容易获得一等奖学金。第一学年末，她成绩虽然不错，但因为与同学关系不好，也不热心班级事务，未能评上一等奖学金，从此她的情绪一落千丈，变得郁郁寡欢，无心学习，也不能处理好与同学的人际关系，还整夜失眠，甚至有退学的想法。帮助学生摆脱没有评上奖学金的困扰，作为辅导员的你该如何与他交谈', 1);
INSERT INTO `assessment_system` VALUES (4, '5.	如果一位同学不断与周围同学抱怨学校评奖学金、助学金的制度不合理，还在院长信箱里写了不少意见，他的举动引起了不少老师和同学的关注，当你得知这一情况后，作为辅导员的你该如何与他交谈', 0);
INSERT INTO `assessment_system` VALUES (5, '去年米贵阙军食，今年米贱大伤农。', 0);
INSERT INTO `assessment_system` VALUES (6, '荷叶碧绿碧绿的，有的像个大盘子，有的像小伞，还有的像一只大蝴蝶。', 0);
INSERT INTO `assessment_system` VALUES (7, '不要轻易把自己的伤疤揭开，看热闹是别人，痛的却是自己。', 0);
INSERT INTO `assessment_system` VALUES (8, '本人性格开朗，对待工作认真负责，待人真诚，善于沟通协调，有较强的组织潜力与团队精神；上进心强勤于学习能不断进步自身的潜力与综合素质。在未来的实习工作中，我将以充沛的精力，刻苦钻研的精神来努力工作。', 0);
INSERT INTO `assessment_system` VALUES (9, '本人热情随和，活波开朗，具有进取精神和团队精神，有较强的动手潜力。良好协调沟通潜力，适应力强，反应快用心细心灵活，具有必须的社会交往潜力。所以我需要找一份与自身知识结构相关的工作来展示自己的潜力，在学习中，我注重理论与实践的结合，己具备了相当的实践操作潜力。很强的事业心和职责感使我能够应对任何困难和挑战。', 0);

SET FOREIGN_KEY_CHECKS = 1;
