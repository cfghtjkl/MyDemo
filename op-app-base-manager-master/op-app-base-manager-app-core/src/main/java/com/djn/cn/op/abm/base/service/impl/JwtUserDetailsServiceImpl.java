/**
 * Copyright (c) 2020-2025. op-platform.cn All Rights Reserved.
 * 项目名称：开放开发平台
 * 类名称：JwtUserDetailsServiceImpl.java
 * 创建人：op.nie-dongjia
 * 联系方式：niedongjiamail@qq.com
 * 开源地址: https://github.com/nie-dongjia
 * 项目官网:
 */
package com.djn.cn.op.abm.base.service.impl;

import com.djn.cn.op.abm.base.entity.JwtUser;
import com.djn.cn.op.abm.base.entity.UserInfo;
import com.djn.cn.op.abm.base.service.IUserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <b>类  名：</b>com.djn.cn.op.abm.base.service.impl.JwtUserDetailsServiceImpl<br/>
 * <b>类描述：</b>spring security 认证 UserDetailsService 实现类<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2020/3/15 16:12<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2020/3/15 16:12<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0 <br/>
 *
 */
@Slf4j
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private IUserInfoService iUserInfoService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = iUserInfoService.findByUserName(username);
        if (userInfo == null || StringUtils.isEmpty(userInfo.getId())) {
            throw new UsernameNotFoundException(String.format("'%s'.这个用户不存在", username));
        } else {
            return new JwtUser(userInfo.getId(), userInfo.getUserName(), userInfo.getPassword(), 1, null);
        }
    }
}
