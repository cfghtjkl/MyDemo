/**
 * Copyright (c) 2020-2025. op-platform.cn All Rights Reserved.
 * 项目名称：开放开发平台
 * 类名称：UserVo.java
 * 创建人：op.nie-dongjia
 * 联系方式：niedongjiamail@qq.com
 * 开源地址: https://github.com/nie-dongjia
 * 项目官网:
 */
package com.djn.cn.op.abm.base.vo;

import com.djn.cn.op.abm.base.entity.MenuInfo;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

/**
 * <b>类  名：</b>com.djn.cn.op.abm.base.web.vo.UserVo<br/>
 * <b>类描述：</b>登录成功后，用户详细 VO 模型 <br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2020/3/15 23:22<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2020/3/15 23:22<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0 <br/>
 *
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements java.io.Serializable{
    private Long id;
    /** 头像*/
    private String avatar;
    /** 用户名*/
    private String userName;
    /** 邮箱*/
    private String email;
    /**昵称*/
    private String nickName;
    /** 性别*/
    private Integer gender;
    /** 部门名称*/
    private String departmentName;
    /** 角色名称，列表 */
    private Set<String> roles;
    /** 生日*/
    private LocalDate birthday;
    /**菜单*/
    private List<MenuInfo> menuInfos;
    /**按钮菜单*/
    // private List<ButtonVo> buttons;
}
