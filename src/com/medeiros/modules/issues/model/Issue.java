package com.medeiros.modules.issues.model;

import java.io.Serializable;

public class Issue implements Serializable{
	
	private int id;
	private String description;
	private String features;
	private String tags;
	private IssueStatus status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getFeatures() {
		return features;
	}
	public void setFeatures(String features) {
		this.features = features;
	}
	public String[] tagArray(){
		if(this.tags == null){
			this.tags = "";
		}
		return this.tags.split(",");
	}
	
	public String[] featureArray(){
		if(this.features == null){
			this.features = "";
		}
		return this.features.split(",");
	}
}
