package com.willlee.springbootdemo.util;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSONObject;

public class RequestUtil {

	public static String getParamsFromRequest(HttpServletRequest request) {
		String protocol = request.getProtocol();
		Map<String, String[]> parameterMap = request.getParameterMap();
		return "protocol:" + protocol + " params:" + JSONObject.toJSONString(parameterMap);
	}
}
