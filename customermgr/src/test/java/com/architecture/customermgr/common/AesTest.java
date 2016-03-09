package com.architecture.customermgr.common;

import org.junit.Test;

import com.app.common.encryptable.Aes;


/**
 * 测试数据库连接信息加密和解密(根据key)
 * @author lt
 */
public class AesTest {
	String key = "362C1E982014B30D73DFCEAE0A";

	/*
	 * 加密
	 */
	@Test
	public void testEncrypt() {
		// 生成MySQL驱动信息
		System.out.println(Aes.parseByte2HexStr(Aes.encrypt("com.mysql.jdbc.Driver", key)));

		// 生成本地数据库连接信息
		System.out.println(Aes.parseByte2HexStr(
				Aes.encrypt("jdbc:mysql:///architecture?useUnicode=true&characterEncoding=utf-8", key)));
		
		// 生成数据库用户
		System.out.println(Aes.parseByte2HexStr(Aes.encrypt("root", key)));

		// 生成数据库密码
		System.out.println(Aes.parseByte2HexStr(Aes.encrypt("admin", key)));
	}
	
	/*
	 * 解密
	 */
	@Test
	public void testDecrypt() throws Exception {
		System.out.println("driver : " + new String(Aes.decrypt(
				Aes.parseHexStr2Byte("C36A87FA514DF299B8B372F4080CF710342F84277254F8A43D6AA35D80546723"), key)));
		System.out.println("url : " + new String(Aes.decrypt(
				Aes.parseHexStr2Byte("CAD2F1F463A1031274D53098643A3332EF87A94068C40C7494593F38399A10A597E7D5DB868336E7F5A0E3F94EA0754E508E90B628A561AF4DB8613DAF1478BB118C1E2F55081A8CB12B9C0C09EEE679"), key)));
		System.out.println("username : " + new String(Aes.decrypt(
				Aes.parseHexStr2Byte("8A74898D1FBC5828D005C8345912D506"), key)));
		System.out.println("password : " + new String(Aes.decrypt(
				Aes.parseHexStr2Byte("CB17825590354BDE47397E9738FE9D9C"), key)));
	}
	
}
