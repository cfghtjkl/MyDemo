package com.djn.cn.op.abm.common.model;

import java.io.Serializable;


/**
 * 
 * <b>类 名：</b>JsonResult<br/>
 * <b>类描述：</b>WEB封装返回通用Json数据格式<br/>
 * <b>创建人：</b>op.nie-dongjia<br/>
 * <b>创建时间：</b>2019年5月4日 下午7:27:24<br/>
 * <b>修改人：</b>op.nie-dongjia<br/>
 * <b>修改时间：</b>2019年5月4日 下午7:27:24<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0<br/>
 *
 */
public class JsonResult<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 结果集 */
	private T data;
	/** 业务错误码 */
	private Integer code;
	/** 描述 */
	private String msg;

	public JsonResult() {
		super();
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
