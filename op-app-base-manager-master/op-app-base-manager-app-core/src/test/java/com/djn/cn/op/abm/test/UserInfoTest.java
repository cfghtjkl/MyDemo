package com.djn.cn.op.abm.test;


import com.djn.cn.op.abm.base.entity.UserInfo;
import com.djn.cn.op.abm.base.service.IUserInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class UserInfoTest extends AbstractTestCase {
    @Autowired
    private IUserInfoService iUserInfoService;

    @Test
    public void selectAllTest() {
        System.out.println("AAA"+iUserInfoService.selectAll().size());
    }

    @Test
    public void iUserInfoServiceAddTest() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("327803131@qq1.com");
        userInfo.setPassword("123456");
        userInfo.setCreateTime(new Date());
        System.out.println(iUserInfoService.insertSelective(userInfo));
        System.out.println(userInfo);
    }
}
