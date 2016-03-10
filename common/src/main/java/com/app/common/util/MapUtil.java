package com.app.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * 操作map相关的工具类
 * 
 * @author lt
 * 
 */
public class MapUtil {
	
	
	/**
	 * 把传入的参数封装进map并返回
	 * 
	 * @param args
	 * @return
	 */
	public Map<String, Object> createMap(Object... args) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", args[0]);
		map.put("name", args[1]);
		return map;
	}
	
	public static void test(String s){
		Map<String, Object> map = new HashMap<>();
		map.put("name", s);
	}
	
	public static void main(String[] args) {
		String name = "hehe";
		test(name);
	}
}
