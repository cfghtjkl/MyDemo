/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 50714
 Source Host           : 127.0.0.1
 Source Database       : DB_TK

 Target Server Type    : MySQL
 Target Server Version : 50714
 File Encoding         : utf-8
 Date: 03/09/2018 21:58:16 PM
*/
-- 生成DB_MobileAPI数据库  
DROP DATABASE IF EXISTS DB_Base_Manager ;
CREATE DATABASE DB_Base_Manager CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE DB_Base_Manager;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `T_SYS_MenuInfo`;
CREATE TABLE `T_SYS_MenuInfo` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` VARCHAR(80) DEFAULT "" COMMENT '名称',
  `createTime` DATETIME NOT NULL COMMENT '生成时间',
  `lastUpdateTime` TIMESTAMP COMMENT '最后修改时间',
  `description` VARCHAR(200) DEFAULT "" COMMENT '描述',
  `creatorId` BIGINT(20) DEFAULT 0 COMMENT ' 创建者Id',
  `lastUpdateUserId` BIGINT(20) DEFAULT 0 COMMENT '最后修改者',
  `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除 ',
  `version` BIGINT(20) DEFAULT 0 COMMENT '当前版本号',
  `dedupKey` VARCHAR(80) DEFAULT "" COMMENT 'key to pretend order duplication',  
  
  `url` VARCHAR(80) DEFAULT "" COMMENT '菜单地址',
  `parentId` BIGINT(20) DEFAULT 0  COMMENT '父节点',
  `status` INT(3) DEFAULT 0   COMMENT '' ,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='T_SYS_MenuInfo 应用菜单表';

DROP TABLE IF EXISTS `T_SYS_RoleInfo`;
CREATE TABLE `T_SYS_RoleInfo` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` VARCHAR(80) DEFAULT "" COMMENT '名称',
  `createTime` DATETIME NOT NULL COMMENT '生成时间',
  `lastUpdateTime` TIMESTAMP COMMENT '最后修改时间',
  `description` VARCHAR(200) DEFAULT "" COMMENT '描述',
  `creatorId` BIGINT(20) DEFAULT 0 COMMENT ' 创建者Id',
  `lastUpdateUserId` BIGINT(20) DEFAULT 0 COMMENT '最后修改者',
  `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除 ',
  `version` BIGINT(20) DEFAULT 0 COMMENT '当前版本号',
  `dedupKey` VARCHAR(80) DEFAULT "" COMMENT 'key to pretend order duplication',
  
  `status` INT(3) DEFAULT 0   COMMENT '' ,
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='T_SYS_RoleInfo 应用角色表';

DROP TABLE IF EXISTS `T_SYS_UserInfo`;
CREATE TABLE `T_SYS_UserInfo` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` VARCHAR(80) DEFAULT "" COMMENT '名称',
  `createTime` DATETIME NOT NULL COMMENT '生成时间',
  `lastUpdateTime` TIMESTAMP COMMENT '最后修改时间',
  `description` VARCHAR(200) DEFAULT "" COMMENT '描述',
  `creatorId` BIGINT(20) DEFAULT 0 COMMENT ' 创建者Id',
  `lastUpdateUserId` BIGINT(20) DEFAULT 0 COMMENT '最后修改者',
  `deleted` TINYINT(1) DEFAULT 0 COMMENT '是否删除 ',
  `version` BIGINT(20) DEFAULT 0 COMMENT '当前版本号',
  `dedupKey` VARCHAR(80) DEFAULT "" COMMENT 'key to pretend order duplication',
  
  `userName` VARCHAR(80) DEFAULT ""  COMMENT '用户名',
  `password` VARCHAR(80) DEFAULT ""  COMMENT '密码',
  `salt` VARCHAR(80) DEFAULT ""  COMMENT '密码盐 UUID',
  `email` VARCHAR(80) DEFAULT ""  COMMENT '邮箱地址',
  `age` INT(3) DEFAULT 0  COMMENT '年龄',	
  `qq` VARCHAR(40) DEFAULT ""  COMMENT 'QQ号码',
  `telphone` VARCHAR(80) DEFAULT ""  COMMENT '电话号码',
  `address` VARCHAR(80) DEFAULT ""  COMMENT '地址',
  `sex` VARCHAR(10) DEFAULT ""  COMMENT '性别',
  `locked`TINYINT(1)  DEFAULT 1  COMMENT '是否锁定',
  `activated` TINYINT(1) DEFAULT 1  COMMENT '是否激活',
  PRIMARY KEY (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8 COMMENT='系统用户表';


DROP TABLE IF EXISTS `T_UserInfo_RoleInfo`;
CREATE TABLE `T_UserInfo_RoleInfo` (
  `userInfoId` BIGINT(20)  NOT NULL   COMMENT '用户Id',
  `roleInfoId` BIGINT(20)  NOT NULL   COMMENT '角色Id',
   PRIMARY KEY (`userInfoId`,`roleInfoId`)
)  ENGINE=INNODB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='用户角色关系表 ' ; 


DROP TABLE IF EXISTS `T_RoleInfo_MenuInfo`;
CREATE TABLE `T_RoleInfo_MenuInfo` (
  `roleInfoId` BIGINT(20)  NOT NULL   COMMENT '角色Id',
  `menuInfoId` BIGINT(20)  NOT NULL   COMMENT '菜单Id',
   PRIMARY KEY (`roleInfoId`,`menuInfoId`)
)  ENGINE=INNODB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT COMMENT='角色Menu关系表 ' ; 

-- 初始化应用数据
-- 初始化管理员角色
INSERT INTO T_SYS_RoleInfo (NAME,description,createTime,creatorId) VALUES  ('admin','超级管理员',NOW(),1);
-- 初始化菜单数据 初始化第一版 Menu 
INSERT INTO T_SYS_MenuInfo (NAME,description,createTime,creatorId,dedupKey,url,parentId) VALUES  ('系统管理','系统管理',NOW(),1,UUID(),'',0);
INSERT INTO T_SYS_MenuInfo (NAME,description,createTime,creatorId,dedupKey,url,parentId) VALUES  ('菜单管理','菜单管理',NOW(),1,UUID(),'sys/manage-menu',1);
INSERT INTO T_SYS_MenuInfo (NAME,description,createTime,creatorId,dedupKey,url,parentId) VALUES  ('角色管理','角色管理',NOW(),1,UUID(),'sys/manage-role',1);
INSERT INTO T_SYS_MenuInfo (NAME,description,createTime,creatorId,dedupKey,url,parentId) VALUES  ('权限管理','权限管理',NOW(),1,UUID(),'sys/manage-auth',1);
INSERT INTO T_SYS_MenuInfo (NAME,description,createTime,creatorId,dedupKey,url,parentId) VALUES  ('用户管理','用户管理',NOW(),1,UUID(),'sys/manage-user',1);
-- 初始化用户 
INSERT INTO T_SYS_UserInfo (NAME,description,createTime,creatorId,dedupKey,userName,PASSWORD,email)
VALUES  ('系统管理员','系统管理员用户',NOW(),1,UUID(),'admin','E10ADC3949BA59ABBE56E057F20F883E','327803131@qq.com');

-- 初始化Role Menu 关系
INSERT INTO T_RoleInfo_MenuInfo VALUES  
 (1,1),
 (1,2),
 (1,3),
 (1,4),
 (1,5)
;
-- 初始化人物角色
INSERT INTO T_UserInfo_RoleInfo VALUES  
 (1,1)
;

SELECT * FROM T_SYS_UserInfo ;
SELECT * FROM T_SYS_RoleInfo ;
SELECT * FROM T_SYS_UserInfo ;
SELECT * FROM T_RoleInfo_MenuInfo ;
SELECT * FROM T_UserInfo_RoleInfo ;



