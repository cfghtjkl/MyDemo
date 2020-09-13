/*
 * Copyright (c) 2020-2025. op-platform.cn All Rights Reserved.
 * 项目名称：开放开发平台
 * 类名称：JwtAuthenticationTokenFilter.java
 * 创建人：op.nie-dongjia
 * 联系方式：niedongjiamail@qq.com
 * 开源地址: https://github.com/nie-dongjia
 * 项目官网:
 */
package com.djn.cn.op.abm.base.web.filter;

import com.djn.cn.op.abm.base.config.JwtConfigurationProperties;
import com.djn.cn.op.abm.base.entity.JwtUser;
import com.djn.cn.op.abm.base.service.IUserInfoService;
import com.djn.cn.op.abm.base.util.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <b>类  名：</b>com.djn.cn.op.abm.base.web.jwt.JwtAuthenticationTokenFilter<br/>
 * <b>类描述：</b>JwtAuthenticationTokenFilter <br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2020/3/15 13:27<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2020/3/15 13:27<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0 <br/>
 *
 */
@Slf4j
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    private IUserInfoService iUserInfoService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtConfigurationProperties jwtProperties;

    @Autowired
    private AuthenticationEntryPoint authenticationEntryPoint;

    /**
     * 获取当前登录用户的信息
     * JwtUserDetails userDetails = (JwtUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     *
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        // 获取 Request 中的请求头为 “ Authorization ” 的 token 值
        String completeToken = request.getHeader(jwtProperties.getTokenHeader());
        // 验证 值是否以"Bearer "开头
        if (completeToken != null && completeToken.startsWith(jwtProperties.getTokenHead())) {
            // 截取token中"Bearer "后面的值，
            final String tokenValue = jwtTokenUtil.interceptCompleteToken(completeToken);
            // 根据 token值，获取 用户的 username
            String username = jwtTokenUtil.getUsernameFromToken(tokenValue);
            log.debug("当前登录的用户是 : {} ", username);
            // 验证用户账号是否合法
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
                // 根据 username 去 redis 中查询 user 数据，足够信任token的情况下，可以省略这一步
                JwtUser userDetails = null;
                try {
                    userDetails = iUserInfoService.validateUserName(username);
                } catch (AuthenticationException ex) {
                    log.debug(ex.getMessage());
                    SecurityContextHolder.clearContext();
                    this.authenticationEntryPoint.commence(request, response, ex);
                    return;
                }
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                // 将用户信息，设置到 SecurityContext 中，可以在任何地方 使用 下面语句获取 获取 当前用户登录信息
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        chain.doFilter(request, response);
    }


}