package com.medeiros.modules.issues.model;

import java.io.Serializable;


public class Issue implements Serializable{
	
	private int id;
	private String description;
	
	private Function function;
	private Layer layer;
	private Importance importance;
	private Kind kind;
	
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
	public Function getFunction() {
		return function;
	}
	public void setFunction(Function function) {
		this.function = function;
	}
	public Layer getLayer() {
		return layer;
	}
	public void setLayer(Layer layer) {
		this.layer = layer;
	}

	public Importance getImportance() {
		return importance;
	}
	public void setImportance(Importance importance) {
		this.importance = importance;
	}
	public Kind getKind() {
		return kind;
	}
	public void setKind(Kind kind) {
		this.kind = kind;
	}
	@Override
	public String toString() {
		return "Issue [id=" + id + ", description=" + description
				+ ", function=" + function + ", layer=" + layer + ", importance="
				+ importance + ", kind=" + kind + "]";
	}

	
	
}
