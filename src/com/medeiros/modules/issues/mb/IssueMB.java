package com.medeiros.modules.issues.mb;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.medeiros.modules.issues.model.Function;
import com.medeiros.modules.issues.model.Importance;
import com.medeiros.modules.issues.model.Issue;
import com.medeiros.modules.issues.model.Kind;
import com.medeiros.modules.issues.model.Layer;

@ManagedBean
@RequestScoped
public class IssueMB {

	static int nextId = 0;
	private Issue issue;

	public IssueMB() {
		System.out.println("IssueMB.IssueMB()");
		init();
	}
	
	public Issue getIssue() {
		if(this.issue == null){
			this.issue = new Issue();
		}
		return issue;
	}

	private void init() {
		Map<String, ? extends IssueMB> table = DataBase.getInstance().getTable(this.getClass());
		for (int i = 100; i < 102; i++) {
			Issue issue123 = buildIssue(i);
			DataBase.getInstance().save(issue123.getId()+"", issue123);
		}
		
	}
	
	public Importance[] getImportances(){
		return Importance.values();
	}

	private Issue buildIssue(int id) {
		Issue issue = new Issue();
		issue.setId(id);
		issue.setLayer(Layer.VIEW);
		issue.setImportance(Importance.HIGH);;
		issue.setDescription("sourceId=j_idt6:j_idt11[severity=(ERROR 2), summary=(j_idt6:j_idt11: Erro de validação: o valor não é válido), detail=(j_idt6:j_idt11: Erro de validação: o valor não é válido)]Abr 28, 2016 1:03:40 AM com.sun.faces.renderkit.");
//		issue.setFunction(new Function(3));
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	public Layer[] getLayers(){
		return Layer.values();
//		return new String[]{"Visão", "Regras/Modelo", "Persistência", "Requisitos"};
	}

	public Kind[] getKinds(){
		return Kind.values();
	}
	public Importance[] getHastes(){
		return Importance.values();
	}

	public String salvar(){
		System.out.println("IssueMB.salvar() "+DataBase.getInstance().getTable(Issue.class).size());
		if(this.issue.getId() ==0){
			nextId = nextId + 1;
			this.issue.setId(nextId);
		}
		DataBase.getInstance().save(String.valueOf(this.issue.getId()),this.issue);
		System.out.println("IssueMB.salvar()");
		
		FacesContext context = FacesContext.getCurrentInstance();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Issue Salva.", null);
		context.addMessage(null, message);
	
		
		return null;
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
