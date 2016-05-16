package com.medeiros.modules.issues.mb;

import java.util.HashMap;
import java.util.Map;

public class DataBase {

	private static DataBase instance = new DataBase();
	public Map<String, Map<String, Object>> tables;
	
	public DataBase() {
		this.tables = new HashMap<String, Map<String,Object>>();
	}

	public static DataBase getInstance(){
		return instance;
	}
	
	public <T extends Object> Map<String, T> getTable(Class<T> klass){
		String table = klass.getSimpleName();
		if(!tables.containsKey(table)){
			tables.put(table, new HashMap<String, Object>());
		}
		return (Map<String, T>) tables.get(table);
	}

	public  <T extends Object> void save(String key, T value) {
		Map<String, T> table = (Map<String, T>) getTable(value.getClass());
		table.put(key, value);
	}

	public <T extends Object> void delete(String key, T issue) {
		getTable(issue.getClass()).remove(key);
	}
}
