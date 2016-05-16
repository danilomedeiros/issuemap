package com.medeiros.modules.issues.model;

import com.medeiros.modules.issues.model.board.Ordenate;

public enum Layer implements Ordenate{

	MODEL,
	VIEW,
	CONTROLLER,
	PERSISTENCE,
	SYSTEM
	;

	@Override
	public String getKey() {
		return this.name();
	}
}
