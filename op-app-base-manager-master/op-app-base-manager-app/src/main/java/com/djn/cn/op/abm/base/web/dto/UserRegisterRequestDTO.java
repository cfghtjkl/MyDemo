package com.djn.cn.op.abm.base.web.dto;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 
 * <b>类   名：</b>UserLoginRequestDTO<br/>
 * <b>类描述：</b>用户登录RequestDTO<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2019年7月20日 下午1:14:45<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2019年7月20日 下午1:14:45<br/>
 * <b>修改备注：</b><br/>
 *
 * @version   1.0<br/>
 *
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterRequestDTO {
	@NotNull(message = "用户名不能为空")
	@Length(min = 5, message = "用户名长度不能少于五位")
	private String userName;
	@NotNull(message = "密码不能为空")
	@Length(min = 5, message = "密码长度不能少于五位")
	private String password;
}
