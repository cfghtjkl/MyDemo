/*
 * Copyright (c) 2020-2025. op-platform.cn All Rights Reserved.
 * 项目名称：开放开发平台
 * 类名称：JwtConfigurationProperties.java
 * 创建人：op.nie-dongjia
 * 联系方式：niedongjiamail@qq.com
 * 开源地址: https://github.com/nie-dongjia
 * 项目官网:
 */
package com.djn.cn.op.abm.base.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.time.Duration;

/**
 * <b>类  名：</b>com.djn.cn.op.abm.base.web.config.JwtConfigurationProperties<br/>
 * <b>类描述：</b>JwtConfigurationProperties<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2020/3/15 0:19<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2020/3/15 0:19<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0 <br/>
 *
 */
@Data
@Component
@ConfigurationProperties(prefix = "jwt")
public class JwtConfigurationProperties {
    /** claim authorities key */
    private String secret;
    /** 管理后台过期时间 */
    private Long expiration;
    /**请求头或请求参数*/
    private String tokenHeader;
    /**token 头 */
    private String tokenHead;
    /** 小程序前台过期时间 */
    private Duration wechatExpireTime;

}
