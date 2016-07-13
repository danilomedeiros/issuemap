package com.medeiros.modules.issues.service.mapreduce;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class MapReduce<I,O, R> {

	private Map<String, Collection<O>> intermediate = new HashMap<String, Collection<O>>();
	private Map<String, R> result = new HashMap<String, R>();

	public abstract void mapper(I record);
	public abstract void reduce(String key, Collection<O> value) ;

	public Map<String, R> execute(Collection<I> inputdata) {
		
		for (I issue : inputdata) {
			this.mapper(issue);
		}
		this.getMapResult();

		for (Entry<String, Collection<O>> issue : this.getMapResult().entrySet()) {
			this.reduce(issue.getKey(), issue.getValue());
		}
		return this.result;
	}
	
	protected void emitIntermediate(String key, O value) {
		if (!intermediate.containsKey(key)){
			intermediate.put(key, new ArrayList<O>());
		}

		Collection<O> temp = intermediate.get(key);
		temp.add(value);
		intermediate.put(key, temp);
	}

	public Map<String, Collection<O>> getMapResult(){
		return intermediate;
	}
	
	protected void emitReducing(String key, R value) {
		result.put(key , value);
	}

	
	
}