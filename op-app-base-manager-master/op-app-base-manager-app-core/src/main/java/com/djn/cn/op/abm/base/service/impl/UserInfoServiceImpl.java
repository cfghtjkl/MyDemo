package com.djn.cn.op.abm.base.service.impl;

import com.djn.cn.op.abm.base.config.JwtConfigurationProperties;
import com.djn.cn.op.abm.base.entity.JwtUser;
import com.djn.cn.op.abm.base.entity.MenuInfo;
import com.djn.cn.op.abm.base.entity.UserInfo;
import com.djn.cn.op.abm.base.exception.JwtAuthenticationException;
import com.djn.cn.op.abm.base.mapper.UserInfoMapper;
import com.djn.cn.op.abm.base.service.IUserInfoService;
import com.djn.cn.op.abm.base.util.JwtTokenUtil;
import com.djn.cn.op.abm.base.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.redis.core.BoundHashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Slf4j
@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements IUserInfoService {
    @Autowired
    @Lazy
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private JwtConfigurationProperties jwtConfigurationProperties;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserInfoMapper userInfoMapper;



    private BoundHashOperations<String, String, Object> tokenStorage() {
        return redisTemplate.boundHashOps(jwtConfigurationProperties.getTokenHeader());
    }
    @Override
    public JwtUser validateUserName(String userName) throws AuthenticationException {
        JwtUser jwtUser = (JwtUser) tokenStorage().get(userName);
        if (jwtUser == null || StringUtils.isEmpty(jwtUser.getUsername())) {
            throw new JwtAuthenticationException("当前登录用户不存在");
        }
        return jwtUser;
    }

    @Override
    public String login(String userName, String password) throws AuthenticationException {
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(userName, password);
        Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);
        JwtUser userDetails = (JwtUser) userDetailsService.loadUserByUsername(userName);
        String token = jwtTokenUtil.generateToken(userDetails);
        log.debug("userDetails: {}", userDetails);
        tokenStorage().put(userDetails.getUsername(), userDetails);
        return token;
    }

    @Override
    public UserInfo findByUserName(String userName) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName(userName);
        userInfo = userInfoMapper.selectOne(userInfo);
        return userInfo;
    }

    @Override
    public Integer register(UserInfo userInfo) {
        return userInfoMapper.insertSelective(userInfo);
    }

    @Override
    public void logout(JwtUser loginUser) {
        tokenStorage().delete(loginUser.getUsername());
    }

    @Override
    public UserVO findUserInfo() {
        JwtUser userDetails = (JwtUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userDetails.getUid());
        userInfo.setPassword(null);
        UserVO result = new UserVO();
        BeanUtils.copyProperties(userInfo, result);
        // List<ButtonVo> buttonVos = new ArrayList<>();  按钮权限
        List<MenuInfo> menuInfos = new ArrayList<>();
        Set<String> rolesName = new HashSet<>();
        result.setMenuInfos(menuInfos);
        result.setRoles(rolesName);
        return result;
    }

}
