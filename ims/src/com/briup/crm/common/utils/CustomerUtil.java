package com.briup.crm.common.utils;

import java.util.HashMap;

public class CustomerUtil {
	private static HashMap<String,Integer> levelMap = 
			new HashMap<>();
	private static HashMap<Integer,String> starMap = 
			new HashMap<>();
	static{
		levelMap.put("普通客户", 1);
		levelMap.put("重点开发客户", 2);
		levelMap.put("大客户", 3);
		levelMap.put("合作伙伴", 4);
		levelMap.put("战略合作伙伴", 5);
		
		
		starMap.put(1, "☆");
		starMap.put(2, "☆☆");
		starMap.put(3, "☆☆☆");
		starMap.put(4, "☆☆☆☆");
		starMap.put(5, "☆☆☆☆☆");
	}
	public static Integer getLevel(String key) {
		return levelMap.get(key);
	}
	
	public static String getStar(Integer key) {
		return starMap.get(key);
	}
	
}
