/*
 * Copyright (c) 2020-2025. op-platform.cn All Rights Reserved.
 * 项目名称：开放开发平台
 * 类名称：AuthController.java
 * 创建人：op.nie-dongjia
 * 联系方式：niedongjiamail@qq.com
 * 开源地址: https://github.com/nie-dongjia
 * 项目官网:
 */
package com.djn.cn.op.abm.base.web.controller;

import com.djn.cn.op.abm.base.config.JwtConfigurationProperties;
import com.djn.cn.op.abm.base.entity.JwtUser;
import com.djn.cn.op.abm.base.entity.UserInfo;
import com.djn.cn.op.abm.base.service.IUserInfoService;
import com.djn.cn.op.abm.base.util.JwtTokenUtil;
import com.djn.cn.op.abm.base.web.dto.UserLoginRequestDTO;
import com.djn.cn.op.abm.base.web.dto.UserRegisterRequestDTO;
import com.djn.cn.op.abm.base.web.vo.TokenValue;
import com.djn.cn.op.abm.common.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * <b>类  名：</b>com.djn.cn.op.abm.base.web.controller.AuthController<br/>
 * <b>类描述：</b>用户认证controller<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2020/3/15 12:46<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2020/3/15 12:46<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0 <br/>
 *
 */
@Slf4j
@Api(tags = "[ 权限管理 ] 用户认证")
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private IUserInfoService iUserInfoService;
    @Autowired
    private JwtConfigurationProperties jwtConfigurationProperties;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @ApiOperation(value = "用户登录认证", notes = "用户名，密码登录格式 {\"username\":\"admin\",\"password\":\"admin\"}")
    @PostMapping("/login")
    public Object login(@RequestBody @Validated UserLoginRequestDTO user, BindingResult br) {
        try {
            String jwtToken = iUserInfoService.login(user.getUserName(), user.getPassword());
            TokenValue tokenValue = TokenValue.builder()
                    .header(jwtConfigurationProperties.getTokenHeader())
                    .value(jwtToken)
                    .prefix(jwtConfigurationProperties.getTokenHead())
                    .expiration(jwtConfigurationProperties.getExpiration())
                    .build();
            return ResponseUtil.ok(tokenValue);
        } catch (AuthenticationException ex) {
            log.error(ex.getMessage());
            return ResponseUtil.failed("用户名或密码错误");
        }
    }
    @ApiOperation(value = "用户注册", notes = "用户名，密码登录格式 {\"userName\":\"admin\",\"password\":\"admin\"}")
    @PostMapping("/register")
    public Object register(@RequestBody @Validated UserRegisterRequestDTO userRegisterRequestDTO, BindingResult br) {
        try {
            System.out.println(userRegisterRequestDTO.toString());
            UserInfo userInfo = new UserInfo();
            BeanUtils.copyProperties(userRegisterRequestDTO,userInfo);
            userInfo.setCreateTime(new Date());
            userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
            return ResponseUtil.ok(iUserInfoService.register(userInfo));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseUtil.failed("用户名或密码错误");
        }
    }

    @ApiOperation(value = "用户退出登录", notes = "用户退出登录")
    @GetMapping("/logout")
    public Object logout() {
        JwtUser loginUser = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (loginUser != null && !StringUtils.isEmpty(loginUser.getUsername())) {
            iUserInfoService.logout(loginUser);
            return ResponseUtil.ok(null);
        }
        return ResponseUtil.failed("请重试");
    }
    @ApiOperation(value = "刷新Token值", notes = "只需要在请求头中附带token即可")
    @GetMapping("/refresh")
    public Object refresh(@RequestHeader(value = "${jwt.tokenHeader}") String completeToken) {
        // 从完整的token中截取出token值
        String oldToken = jwtTokenUtil.interceptCompleteToken(completeToken);
        // 根据token值，获取登录的用户名
        String username = jwtTokenUtil.getUsernameFromToken(oldToken);
        if (!StringUtils.isEmpty(username)) {
            // 校验数据中的，用户是否存在
            JwtUser details = iUserInfoService.validateUserName(username);
            if (details != null && !StringUtils.isEmpty(details.getUsername())) {
                // 刷新 token 的值
                String jwtToken = jwtTokenUtil.refreshToken(oldToken);
                // 封装新的 token 值
                TokenValue tokenValue = TokenValue.builder()
                        .header(jwtConfigurationProperties.getTokenHeader())
                        .value(jwtToken)
                        .prefix(jwtConfigurationProperties.getTokenHead())
                        .expiration(jwtConfigurationProperties.getExpiration())
                        .build();
                return ResponseUtil.ok(tokenValue);
            }
        }
        return ResponseUtil.failed("token格式错误!");
    }
}
