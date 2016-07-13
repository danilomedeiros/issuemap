package com.medeiros.modules.issues.service;

import java.util.Collection;
import java.util.Map.Entry;

import com.medeiros.modules.issues.service.mapreduce.MapReduce;

public class TagsTotalMapReduce extends MapReduce<
	Entry<String, Collection<String>>,Integer,  Integer>{

	@Override
	public void mapper(Entry<String, Collection<String>> record) {
		for (String tag : record.getValue()) {
			emitIntermediate(record.getKey() + " "+tag, 1);
		}
	}
	@Override
	public void reduce(String key, Collection<Integer> value) {
		super.emitReducing(key, value.size());
	}

	
}
