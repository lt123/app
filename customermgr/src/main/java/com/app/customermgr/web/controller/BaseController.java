package com.app.customermgr.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseController {
	
	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public Map<String,Object> handleException(Exception e) {
		e.printStackTrace();
		Map<String,Object> m = new HashMap<>();
		m.put("key", "value");
		return m;
	}
}
