package com.medeiros.modules.issues.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import com.medeiros.modules.issues.model.Issue;
import com.medeiros.modules.issues.service.mapreduce.MapReduce;

public class FunctionsTagsMapReduce extends MapReduce<Issue,String[],  Collection<String>>{

	public void mapper(Issue record) {
		
		String[] tagArray = record.tagArray();
		for (String feature : record.featureArray()) {
			super.emitIntermediate(feature, tagArray);
		}

	}
	@Override
	public void reduce(String key, Collection<String[]> value) {
		
		Collection<String> tags = new LinkedList<String>();
		for (String[] strings : value) {
			List<String> asList = Arrays.asList(strings);
			tags.addAll(asList);
		}
		super.emitReducing(key, tags);
	}

	
}
