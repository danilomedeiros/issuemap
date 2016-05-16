package com.medeiros.modules.issues.listeners;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public class LOGINActionListener implements ActionListener {

	@Override
	public void processAction(ActionEvent arg0) throws AbortProcessingException {
		System.out.println("LOGINActionListener.processAction()");
	}
	
}