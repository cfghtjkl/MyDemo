package com.djn.cn.op.abm.common.util;


import com.djn.cn.op.abm.common.enums.RestResultCodeEnum;
import com.djn.cn.op.abm.common.model.JsonResult;

/**
 * 
 * <b>类 名：</b>ResponseUtil<br/>
 * <b>类描述：</b>返回通用工具类-针对WEB端统一调用<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2019年7月24日 下午11:26:16<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2019年7月24日 下午11:26:16<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
public class ResponseUtil {
	public static <T> JsonResult<T> ok(T data) {
		return restResult(data, RestResultCodeEnum.SUCCESS);
	}

	public static <T> JsonResult<T> error(String msg) {
		return restResult(null, RestResultCodeEnum.INTERNAL_SERVER_ERROR.getCode(), msg);
	}
	/**
	 * 
	 * error  返回错误信息 默认信息
	 *
	 * @return   
	 * @since 1.0
	 * @author op.nie-dongjia
	 */
	public static <T> JsonResult<T> error() {
		return restResult(null, RestResultCodeEnum.INTERNAL_SERVER_ERROR.getCode(), RestResultCodeEnum.INTERNAL_SERVER_ERROR.getMsg());
	}

	/**
	 * 
	 * failed 通用业务异常
	 *
	 * @return
	 * @since 1.0
	 * @author op.nie-dongjia
	 */
	public static <T> JsonResult<T> failed() {
		return restResult(null, RestResultCodeEnum.FAIL.getCode(), RestResultCodeEnum.FAIL.getMsg());
	}

	/**
	 * 
	 * failed 通用业务异常
	 *
	 * @param msg
	 * @return
	 * @since 1.0
	 * @author op.nie-dongjia
	 */
	public static <T> JsonResult<T> failed(String msg) {
		return restResult(null, RestResultCodeEnum.FAIL.getCode(), msg);
	}
	
	public static <T> JsonResult<T> restResult(T data, RestResultCodeEnum restResultCodeEnum) {
		return restResult(data, restResultCodeEnum.getCode(), restResultCodeEnum.getMsg());
	}
	/**
	 * 
	 * restResult  组装
	 *
	 * @param data
	 * @param code
	 * @param msg
	 * @return   
	 * @since 1.0
	 * @author op.nie-dongjia
	 */
	private static <T> JsonResult<T> restResult(T data, Integer code, String msg) {
		JsonResult<T> jsonResult = new JsonResult<>();
		jsonResult.setCode(code);
		jsonResult.setData(data);
		jsonResult.setMsg(msg);
		return jsonResult;
	}

}
