/*
 * Copyright (c) 2020-2025. op-platform.cn All Rights Reserved.
 * 项目名称：开放开发平台
 * 类名称：JwtAuthenticationEntryPoint.java
 * 创建人：op.nie-dongjia
 * 联系方式：niedongjiamail@qq.com
 * 开源地址: https://github.com/nie-dongjia
 * 项目官网:
 */
package com.djn.cn.op.abm.base.web.entrypoint;

import com.djn.cn.op.abm.base.web.util.JsonUtils;
import com.djn.cn.op.abm.common.enums.RestResultCodeEnum;
import com.djn.cn.op.abm.common.util.ResponseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * <b>类  名：</b>com.djn.cn.op.abm.base.web.entrypoint.JwtAuthenticationEntryPoint<br/>
 * <b>类描述：</b>认证失败，处理类<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2020/3/15 14:39<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2020/3/15 14:39<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0 <br/>
 *
 */
@Slf4j
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        /**身份认证未通过*/
        response.getWriter().write(
                JsonUtils.objectToJson(
                        ResponseUtil.restResult(null, RestResultCodeEnum.UNAUTHORIZED)
                )
        );
    }
}
