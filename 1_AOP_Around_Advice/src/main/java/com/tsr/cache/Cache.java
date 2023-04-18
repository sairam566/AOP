package com.tsr.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	
	private static Cache cacheInstance;
	
	private Map<String, Object> dataMap;
	
	private Cache() {
		dataMap = new ConcurrentHashMap<String, Object>();
	}
	
	public static synchronized Cache getInstance() {
		if(cacheInstance == null) {
			cacheInstance = new Cache();
		}
		return cacheInstance;
	}
	
	public void put(String key,Object value) {
		dataMap.put(key, value);
	}
	
	public Object get(String key) {
		return dataMap.get(key);
	}
	
	public boolean containsKey(String key) {
		return dataMap.containsKey(key);
	}
}
