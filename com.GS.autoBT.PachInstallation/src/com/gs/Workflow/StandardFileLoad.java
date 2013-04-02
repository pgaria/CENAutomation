package com.gs.Workflow;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

public class StandardFileLoad {
     
	public static void RunWorkFlowWindow(SWTWorkbenchBot bot)
	{   
		System.out.println("Run WorkFlow ............");
		System.out.println("Active Shell "+bot.activeShell().getText());
		bot.shell("Run Workflow").bot().tree().setFocus();
		SWTBotTreeItem[] items = bot.tree(1).getAllItems();
		
		for (SWTBotTreeItem item : items) {
			String itemText = item.getText();	
			System.out.println("Item "+itemText);
	}
	}
	
}
