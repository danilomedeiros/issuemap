package com.medeiros.modules.issues.mb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.primefaces.model.TreeNode;

import com.medeiros.modules.issues.model.Function;
import com.medeiros.modules.issues.model.Importance;
import com.medeiros.modules.issues.model.Issue;
import com.medeiros.modules.issues.model.Kind;
import com.medeiros.modules.issues.model.Layer;
import com.medeiros.modules.issues.model.Module;

public class TreeIssueBuilderTest {

	TreeIssueBuilder  builder = new TreeIssueBuilder();


	@Test
	public void smokeTest(){
		Issue issue = new Issue();
		issue.setDescription("IssueA");

		ModuleFunctions modA = createModule("MA", "fa1","fa2","fa3");
		ModuleFunctions modB = createModule("MB", "fb1","fb2","fb3");

		List<Issue> createIssueToModules = createIssueToModules(modA, modB);

		TreeIssueBuilder builder = new TreeIssueBuilder();
		TreeNode root = builder.build();
//		Assert.assertEquals(root);
	}

	private List<Issue> createIssueToModules(ModuleFunctions... modules) {
		List<Issue> issues = new ArrayList<Issue>();
		for (ModuleFunctions module : modules) {
			Map<String, Function> functions = module.functions;
			for (Function func : functions.values()) {
				Issue issue = new Issue();

				issue.setDescription("Issue da function:"+func.getName());
				issue.setImportance(Importance.MIDDLE);
				issue.setKind(Kind.DOUBT);
				issue.setLayer(Layer.CONTROLLER);
				issue.setDescription("qwer qwer asfd zxcv rtyu xvcb fghj yuip klçj ,mnb kjh lkajsdf.");
				issues.add(issue);
			}

		}
		return issues;

	}

	public ModuleFunctions createModule(String module, String... functionsName){
		ModuleFunctions mod = new ModuleFunctions();
		mod.setName(module);
		for (String fName : functionsName) {
			Function func = new Function();
			func.setName(fName);
			mod.functions.put(fName, func);
		}
		return mod;
	}


	class ModuleFunctions extends Module{

		Map<String,Function> functions;
		public ModuleFunctions() {
			this.functions = new HashMap<String, Function>();
		}

	}
}
