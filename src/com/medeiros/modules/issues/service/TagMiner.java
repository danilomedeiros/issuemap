package com.medeiros.modules.issues.service;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TagMiner {
	
	static final Pattern tags = Pattern.compile("#(\\w+)");
	static final Pattern features = Pattern.compile("\\@(\\w+)");
	private static final TagMiner INSTANCE = new TagMiner();
	
	public static TagMiner getInstance(){
		return INSTANCE;
	}
	public Map<String, Integer> tagsFrom(String texto) {
		return find(texto, tags);
	}
	
	public Map<String, Integer> featuresFrom(String texto) {
		return find(texto, features);
	}

	private Map<String, Integer> find(String texto, Pattern pattern) {
		Matcher m = pattern.matcher(texto);
		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		while (m.find()) {
			String tag = m.group(1);
			int total = 1;
			if(hashMap.containsKey(tag)){
				total += hashMap.get(tag);
			}
			hashMap.put(tag, total);
		}
		return hashMap;
	}
}
