/*
 * Copyright (c) 2020-2025. op-platform.cn All Rights Reserved.
 * 项目名称：开放开发平台
 * 类名称：UserInfoController.java
 * 创建人：op.nie-dongjia
 * 联系方式：niedongjiamail@qq.com
 * 开源地址: https://github.com/nie-dongjia
 * 项目官网:
 */
package com.djn.cn.op.abm.base.web.controller;

import com.djn.cn.op.abm.base.service.IUserInfoService;
import com.djn.cn.op.abm.common.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>类  名：</b>com.djn.cn.op.abm.base.web.controller.UserInfoController<br/>
 * <b>类描述：</b>TODO<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2020/3/12 10:57<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2020/3/12 10:57<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0 <br/>
 *
 */
@Slf4j
@Api(tags = "[ 权限管理 ] 用户管理")
@RestController
@RequestMapping("/sys/user")
public class UserInfoController {
    @Autowired
    private IUserInfoService iUserInfoService;
    @ApiOperation(value = "获取用户详细信息", notes = "获取用户详细信息")
    @GetMapping("/info")
    public Object findUserInfo() {
        return ResponseUtil.ok(iUserInfoService.findUserInfo());
    }

}
