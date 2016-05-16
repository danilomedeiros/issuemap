package com.medeiros.modules.issues.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.model.DefaultTreeNode;

import com.medeiros.modules.issues.model.Issue;
import com.medeiros.modules.issues.model.board.Board;

@ManagedBean
@SessionScoped
public class BoardMB {

	TreeNode root;
	Board board;
	List<Issue> issues;
		
	
	public BoardMB() {
		root = new TreeNode("Root", null);
		TreeNode documents = new TreeNode("Documents", root);
		TreeNode pictures = new TreeNode("Pictures", root);
		TreeNode music = new TreeNode("Music", root);
		TreeNode work = new TreeNode("Work", documents);
		TreeNode primefaces = new TreeNode("PrimeFaces", documents);
		
		
		//Documents
//		TreeNode expenses = new TreeNode("document", "Expenses.doc", work);
//		TreeNode resume = new TreeNode("document", "Resume.doc", work);
//		TreeNode refdoc = new TreeNode("document", "RefDoc.pages", primefaces);
		//Pictures
//		TreeNode barca = new TreeNode("picture", "barcelona.jpg", pictures);
//		TreeNode primelogo = new TreeNode("picture", "logo.jpg", pictures);
//		TreeNode optimus = new TreeNode("picture", "optimus.png", pictures);
//		//Music
//		TreeNode turkish = new TreeNode("Turkish", music);
//		TreeNode cemKaraca = new TreeNode("Cem Karaca", turkish);
//		TreeNode erkinKoray = new TreeNode("Erkin Koray", turkish);
//		TreeNode mogollar = new TreeNode("Mogollar", turkish);
//		TreeNode nemalacak = new TreeNode("mp3", "Nem Alacak Felek Benim", cemKaraca);
//		TreeNode resimdeki = new TreeNode("mp3", "Resimdeki Goz Yaslari", cemKaraca);
//		TreeNode copculer = new TreeNode("mp3", "Copculer", erkinKoray);
//		TreeNode oylebirgecer = new TreeNode("mp3", "Oyle Bir Gecer", erkinKoray);
//		TreeNode toprakana = new TreeNode("mp3", "Toprak Ana", mogollar);
//		TreeNode bisiyapmali = new TreeNode("mp3", "Bisi Yapmali", mogollar);
	}

	public class TreeNode extends DefaultTreeNode{
		
		public TreeNode(String a, TreeNode parent ) {
			super(a, parent);
		}
		public TreeNode(String a, Object b, TreeNode parent ) {
			super(a, b, parent);
		}
	}
	public TreeNode getRoot() {
		if(this.root == null){
			root = rootFromIssues();
		}
		return root;
	}

	private TreeNode rootFromIssues() {
		return null;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}
	
	public void boardToTreeNode(){
		
	}
	
	

}