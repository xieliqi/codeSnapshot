package com.xxx.kaolafm.test;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

	public final static String BASE_URL_PHONE = "http://localhost:8080/KAOLA_PHONE";
	
	public static Map<String,String> androidHeaders(){
		Map<String,String> headers = new HashMap<String, String>();
		headers.put("uid", "9979997F6244B82B263D47506B9A1D93");
		headers.put("userType", "0");
		headers.put("agent", "");
		headers.put("channel", "");
		headers.put("deviceType", "0");
		headers.put("udid", "");
		headers.put("version", "2.3.2");
		headers.put("protocol_version", "");
		headers.put("imei", "");
		headers.put("platform", "");
		headers.put("network", "");
		return headers;
	}
}
