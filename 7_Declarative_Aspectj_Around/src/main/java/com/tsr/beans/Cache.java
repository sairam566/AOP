package com.tsr.beans;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
	
	private Map<String, Object> cacheMap = null;
	private static Cache cache = null;
	
	private Cache() {
		cacheMap = new ConcurrentHashMap<String, Object>();
	}
	
	public static synchronized Cache getInstance() {
		if(cache == null) {
			cache = new Cache(); 
		}
		return cache;
	}
	
	public void put(String key, Object object) {
		cacheMap.put(key, object);
	}
	
	public Object get(String key) {
		return cacheMap.get(key);
	}
	
	public boolean conatins(String key) {
		return cacheMap.containsKey(key);
	}
}
