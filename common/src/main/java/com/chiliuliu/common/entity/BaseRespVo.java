package com.kangqiao.core.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @author liouwb
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ApiModel(value = " 返回基础类")
public class BaseRespVo<T> {
	@ApiModelProperty(value = "结果")
	private boolean result;

	@ApiModelProperty(value = "返回信息")
	private String message;

	@ApiModelProperty(value = "状态码")
	private int code;

	@ApiModelProperty(value = "返回数据")
	private T data;

	public static <T> BaseRespVo<T> success() {
		BaseRespVo<T> r = new BaseRespVo<T>();
		r.setResult(true);
		r.setCode(200);
		r.setMessage("");
		return r;
	}

	public static <T> BaseRespVo<T> success(T data) {
		BaseRespVo<T> r = new BaseRespVo<T>();
		r.setResult(true);
		r.setCode(200);
		r.setMessage("");
		r.setData(data);
		return r;
	}

	public static <T> BaseRespVo<T> success(String msg, T data) {
		BaseRespVo<T> r = new BaseRespVo<T>();
		r.setResult(true);
		r.setCode(200);
		r.setMessage(msg);
		r.setData(data);
		return r;
	}

	public static BaseRespVo<Object> error(String msg) {
		return error(500, msg);
	}

	public static BaseRespVo<Object> error(int code, String msg) {
		BaseRespVo<Object> r = new BaseRespVo<Object>();
		r.setCode(code);
		r.setMessage(msg);
		r.setResult(false);
		return r;
	}
}
