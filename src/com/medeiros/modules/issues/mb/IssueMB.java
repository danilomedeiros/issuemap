package com.medeiros.modules.issues.mb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.medeiros.modules.issues.model.Issue;
import com.medeiros.modules.issues.service.TagMiner;

@ManagedBean
@SessionScoped
public class IssueMB {

	private Issue issue;
	DataBase database; 

	public IssueMB() {
		database = DataBase.getInstance();
	}
	
	public Issue getIssue() {
		if(this.issue == null){
			this.issue = new Issue();
		}
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public void calcularIssue(Issue issue){
		Map<String, Integer> tags = TagMiner.getInstance().tagsFrom(issue.getDescription());
		Map<String, Integer> features = TagMiner.getInstance().featuresFrom(issue.getDescription());
		issue.setFeatures(features.keySet().toString());
		issue.setTags(tags.keySet().toString());
	}
	public void atualizar(Issue issue){
		calcularIssue(issue);
		DataBase.getInstance().save(String.valueOf(issue.getId()),issue);
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Issue Salva.", null);
		context.addMessage(null, message);
	}
	
	public void salvar(){
		calcularIssue(issue);
		DataBase.getInstance().save(issue);
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Issue Salva.", null);
		context.addMessage(null, message);
		this.issue = null;
	}

	public String excluir(Issue issue){
		DataBase.getInstance().delete(issue.getId()+"",issue);
		return null;
	}
	
	public List<Issue> getLista(){
		ArrayList<Issue> lista = new ArrayList<Issue>();
		Collection<Issue> values = DataBase.getInstance().getTable(Issue.class).values();
		lista.addAll(values);
		Collections.sort(lista, new Comparator<Issue>() {
			@Override
			public int compare(Issue o1, Issue o2) {
				return ((Integer)o1.getId()).compareTo(o2.getId());
			}
		});
		return lista;
	}


}
