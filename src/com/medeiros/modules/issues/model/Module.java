package com.medeiros.modules.issues.model;

import com.medeiros.modules.issues.model.board.Ordenate;

public class Module implements Ordenate{

	int id;
	String name;

	public String getKey() {
		return name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
