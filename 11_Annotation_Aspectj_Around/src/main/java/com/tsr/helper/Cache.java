package com.tsr.helper;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {

	private static Cache cache;
	private Map<String, Object> map;

	private Cache() {
		map = new ConcurrentHashMap<String, Object>();
	}

	public synchronized static Cache getInstance() {
		if (cache == null) {
			cache = new Cache();
		}
		return cache;
	}

	public void add(String key, Object object) {
		map.put(key, object);
	}

	public Object get(String key) {
		return map.get(key);
	}

	public boolean containsKey(String key) {
		return map.containsKey(key);
	}
}
