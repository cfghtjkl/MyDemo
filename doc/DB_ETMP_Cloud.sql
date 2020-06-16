/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : 127.0.0.1
 Source Database       : DB_EIDC_Cloud

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : utf-8

 Date: 05/24/2020 21:58:16 PM
*/

-- 生成DB_ETMP_Cloud数据库
DROP DATABASE IF EXISTS DB_ETMP_Cloud;
CREATE DATABASE `DB_ETMP_Cloud` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE DB_ETMP_Cloud;
/******************************************************
命名规范：T_应用模块_业务模块_实体
模块划分：
  环流检测：T_ECM_业务模块_实体

业务模块:	
   BD： 基础数据
   SYS：系统模块
 ******************************************************/

USE DB_ETMP_Cloud;
-- 实体基础信息
-- 一般实体构建
CREATE TABLE `T_BD_BaseInfo` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` VARCHAR(80) DEFAULT "" COMMENT '名称',
  `createTime` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '生成时间',
  `lastUpdateTime` TIMESTAMP COMMENT '最后修改时间',
  `description` VARCHAR(200) DEFAULT "" COMMENT '描述',
  `creatorId` BIGINT(20) DEFAULT 0 COMMENT ' 创建者Id',
  `lastUpdateUserId` BIGINT(20) DEFAULT 0 COMMENT '最后修改者',
  `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除 ',
  `version` BIGINT(20) DEFAULT 0 COMMENT '当前版本号',
  `dedupKey` VARCHAR(80) DEFAULT "" COMMENT 'key to pretend order duplication',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='实体基础信息';















