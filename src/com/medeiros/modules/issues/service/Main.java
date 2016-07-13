package com.medeiros.modules.issues.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.medeiros.modules.issues.model.Issue;


public class Main {

	public static void main(String[] argh) {
		IssuesSet issuesSet = new IssuesSet();
		issuesSet.setSource(createIssues());
		issuesSet.calculate();
		Map<String, Integer> result = issuesSet.getHeatMap();
		for (String key : result.keySet()) {
			Object value = result.get(key);
			System.out.println(key + " - "+value);
		}		
	}

	private static List<Issue> createIssues() {
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

	private static Issue createIssue(String tags) {
		Issue i = new Issue();
		i.setTags(tags);
		i.setFeatures("F"+i.tagArray().length);
		return i;
	}

}
