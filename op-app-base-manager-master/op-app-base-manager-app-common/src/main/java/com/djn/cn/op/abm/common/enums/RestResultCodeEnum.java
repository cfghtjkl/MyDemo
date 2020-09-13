package com.djn.cn.op.abm.common.enums;

/**
 * 
 * <b>类 名：</b>ResultEnum<br/>
 * <b>类描述：</b> 枚举定义异常类型以及相对于的错误信息 有助于返回码的唯一性,便于前端统一处理，针对不同类型的错误通用处理
 * 	按照HTTP HttpStatus.INTERNAL_SERVER_ERROR
 * <br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2019年7月25日 下午9:23:00<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2019年7月25日 下午9:23:00<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
public enum RestResultCodeEnum {
	INTERNAL_SERVER_ERROR(500, "服务器内部错误"),
	SUCCESS(200, "操作成功"),
	UNAUTHORIZED(401, "你还没有经过授权认证"),
	VALIDATE_FAILED(304, "参数检验失败"),
	NOT_FOUND(404, "Not Found"),
	UNSUPPORTED_MEDIA_TYPE(415, "不支持此请求类型！"),
	FAIL(402, "操作失败");
	/**前端业务通用处理code */
	private final Integer code;
	private final String  msg;

	private RestResultCodeEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
}
