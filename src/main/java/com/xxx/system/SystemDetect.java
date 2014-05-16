package com.xxx.system;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public class SystemDetect {
	public static void displayMap(Map<String, String> map){
		for(Entry<String, String> e : map.entrySet()){
			System.out.println(e.getKey()+"="+e.getValue());
		}
	}
	public static void displayProperties(Properties pros){
		for(Entry<Object, Object> e : pros.entrySet()){
			System.out.println(e.getKey()+"="+e.getValue());
		}
	}
	public static void main(String[] args) {
		System.out.println("=========system env list=========");
		displayMap(System.getenv());
		System.out.println("=========properties env list=========");
		Properties pros = System.getProperties();
		displayProperties(pros);
	}
}
