package com.medeiros.modules.issues.service;

import java.util.Collection;
import java.util.Map;

import com.medeiros.modules.issues.model.Issue;

public class IssuesSet {

	private Collection<Issue> source;
	private Map<String, Integer> heatMap;
	
	public void calculate(){
		FunctionsTagsMapReduce engine = new FunctionsTagsMapReduce();
		Map<String, Collection<String>> firstMap = engine.execute(this.source);
		TagsTotalMapReduce tagsTotalMapReduce = new TagsTotalMapReduce();
		this.heatMap = tagsTotalMapReduce.execute(firstMap.entrySet());
	}
	
	public Map<String, Integer> getHeatMap() {
		return heatMap;
	}

	public Collection<Issue> getSource() {
		return source;
	}

	public void setSource(Collection<Issue> source) {
		this.source = source;
	}
	
}
