package com.medeiros.modules.issues.mb;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.medeiros.modules.issues.model.Issue;

public class DataBase {

	static int nextId = 0;
	private static DataBase instance = new DataBase();
	public Map<String, Map<String, Object>> tables;
	
	public DataBase() {
		this.tables = new HashMap<String, Map<String,Object>>();
		init();
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

	public  <T extends Object> void save(T value) {
		Map<String, T> table = (Map<String, T>) getTable(value.getClass());
		table.put(String.valueOf(nextId++), value);
	}
	
	public <T extends Object> void delete(String key, T issue) {
		getTable(issue.getClass()).remove(key);
	}
	
	private void init() {
		for (int i = 0; i < 100; i++) {
			List<Issue> createIssues = createIssues();
			for (Issue issue : createIssues) {
				this.save(issue);
			}
		}
	}
	private Issue createIssue(String tags) {
		Issue i = new Issue();
		i.setTags(tags);
		i.setDescription(createDescription());
		i.setFeatures("F"+i.tagArray().length);
		return i;
	}

	private Issue buildIssue(int id) {
		Issue issue = new Issue();
		issue.setId(id);
		String desc = createDescription();
		issue.setDescription(desc);
		issue.setTags("T1,T2,T3,T4,T5,T6");
		issue.setFeatures("F1,F2,F3");
		return issue;
	}

	private String createDescription() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			sb.append(System.currentTimeMillis() + " asdf qwer ytyui asdf qer xasd asdf qwer askljf açsfiuq welkjr açsodifkl");
		}
		String desc = sb.toString();
		return desc;
	}
	
	
	private List<Issue> createIssues() {
		LinkedList<Issue> issues = new LinkedList<Issue>();
		issues.add(createIssue("A,B,C,D,E"));
		issues.add(createIssue("A,B,C"));
		issues.add(createIssue("A,B"));
		issues.add(createIssue("A"));
		issues.add(createIssue("A,B,C,D"));
		issues.add(createIssue("A,B,C"));
		issues.add(createIssue("A,B"));
		issues.add(createIssue("A"));
		return issues;
	}

}
