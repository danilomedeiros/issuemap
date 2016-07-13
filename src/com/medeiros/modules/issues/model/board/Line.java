package com.medeiros.modules.issues.model.board;

import java.util.LinkedHashMap;
import java.util.Map;

public class Line {

	String name;
	Map<String, Integer> values;

	public Line(String string, String order, Integer value) {
		this(string);
		this.values.put(order, value);
	}
	
	public Line(String string) {
		this.name = string;
		this.values = new LinkedHashMap<String, Integer>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, Integer> getValues() {
		return values;
	}

	public void setValues(Map<String, Integer> values) {
		this.values = values;
	}
	
	
	
}
