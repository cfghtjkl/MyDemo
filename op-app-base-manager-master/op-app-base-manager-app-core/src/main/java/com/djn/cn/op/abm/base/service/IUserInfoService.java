package com.djn.cn.op.abm.base.service;


import com.djn.cn.op.abm.base.entity.JwtUser;
import com.djn.cn.op.abm.base.entity.UserInfo;
import com.djn.cn.op.abm.base.vo.UserVO;
import org.springframework.security.core.AuthenticationException;

/**
 * 
 * <b>类   名：</b>IUserInfoService<br/>
 * <b>类描述：</b>应用用户接口<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2019年6月18日 下午9:35:52<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2019年6月18日 下午9:35:52<br/>
 * <b>修改备注：</b><br/>
 *
 * @version   1.0<br/>
 *
 */
public interface IUserInfoService extends IBaseService<UserInfo> {
    /**
     * 校验登录的用户中，用户名，是否正确
     *
     * @param userName 用户名
     * @return 操作结果
     * @throws AuthenticationException
     */
    JwtUser validateUserName(String userName) throws AuthenticationException;

    /**
     * 用户登录
     *
     * @param userName
     * @param password
     * @return String token 值
     * @throws AuthenticationException
     */
    String login(String userName, String password) throws AuthenticationException;


    UserInfo findByUserName(String userName);

    /**
     * 用户注册  简单保存，不加入逻辑处理
     *
     * @param userInfo 用户信息
     * @return 操作结果
     */
    Integer register(UserInfo userInfo) ;

    /**
     * 用户退出登录
     * @param loginUser
     */
    void logout(JwtUser loginUser);

    /**
     * 获取用户详细信息
     *
     * @return UserVo
     */
    UserVO findUserInfo();

}
