package com.medeiros.modules.issues.model;

import com.medeiros.modules.issues.model.board.Ordenate;

public enum QualityAspect implements Ordenate {
	
	FUNCTIONAL_REQUIREMENT,
	PERFORMANCE,
	CODE_QUALITY,
	TECHNIC_DEBT
	;
	

	@Override
	public String getKey() {
		return this.name();
	}

}
