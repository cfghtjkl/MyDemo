/*
 * Copyright (c) 2020-2025. op-platform.cn All Rights Reserved.
 * 项目名称：开放开发平台
 * 类名称：TokenValue.java
 * 创建人：op.nie-dongjia
 * 联系方式：niedongjiamail@qq.com
 * 开源地址: https://github.com/nie-dongjia
 * 项目官网:
 */
package com.djn.cn.op.abm.base.web.vo;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * <b>类  名：</b>com.djn.cn.op.abm.base.web.vo.TokenValue<br/>
 * <b>类描述：</b>token 返回值<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2020/3/15 14:14<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2020/3/15 14:14<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0 <br/>
 *
 */
@Getter
@Setter
@Builder
public class TokenValue implements java.io.Serializable {
    /**
     * @description: 请求头的值
     */
    private String header;

    /**
     * @description: token 值
     */
    private String value;

    /**
     * @description: token 前缀
     */
    private String prefix;

    /**
     * @description: 过期时间（毫秒，这里默认20分钟）
     */
    private Long expiration;
}
