package com.gs.NewActivityWizard;

import java.awt.AWTException;
import java.awt.Robot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import swtbot.Helper.utils.ContextMenuHelper;

import GS.Prespectives.ConfigureOrchestrator;
import GS.Window.Preferences.Preferences;
import GS.util.SWTbotCommonAction;

@RunWith(SWTBotJunit4ClassRunner.class)
public class Reg_158 {
	
	    public static SWTWorkbenchBot bot = null;
		public static Robot key = null;
		public static SWTbotCommonAction action=null;
		public Reg_158() throws AWTException
		{
			
		}

	@BeforeClass
	public static void setPreValues() throws Exception
	{
		bot = new SWTWorkbenchBot();
		// slow down tests
		SWTBotPreferences.PLAYBACK_DELAY =50;
		SWTBotPreferences.TIMEOUT = 10000;
		key = new Robot();
		bot.viewByTitle("Welcome").close();
		System.out.println("before class");
		Preferences preference = new Preferences();
		action = new SWTbotCommonAction(bot);
		 
		 preference.addWeblogic(bot,key);
		 preference.addOracle(bot);
		 ConfigureOrchestrator configureORch= new ConfigureOrchestrator(bot);
		configureORch.openConfigureOrchestratorPrespective();
		configureORch.connectToNewApplicationServer();
	}
	@Test
	public void testReg_158() throws Exception
	{
		 SWTBotTree OrchestratorConfiTree = bot.viewByTitle("Orchestrator Configuration Explorer").bot().tree();
		 //System.out.println(OrchestratorConfiTree.expandNode("WEBLOGIC [gsource@t3://inqa05:8003]",true).getText());
		 SWTBotTreeItem Workflow = OrchestratorConfiTree.expandNode("WEBLOGIC [gsource@t3://inqa05:8003]").expandNode("inqa05wl02 - (8.4.1.1)").expandNode("Workflows");
         Workflow.click().select();
         ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,"New","Workflow Definition");
         Thread.sleep(4000);
         bot.textWithLabel("Name: ").setText("TestWorkFlow");
         bot.button("Finish").click();
        
         SWTBotTreeItem[] Workflows = OrchestratorConfiTree.expandNode("WEBLOGIC [gsource@t3://inqa05:8003]").expandNode("inqa05wl02 - (8.4.1.1)").expandNode("Workflows").getItems();
         for(SWTBotTreeItem ii : Workflows)
    	 {   
    		 System.out.println(ii.getText());
    	
    		 if(ii.getText().equals("TestWorkFlow"))
    		 {
    			 System.out.println("Passed");
    		   break;
    		 }
    	 }
         // Workflow.contextMenu("New").menu("Workflow Definition").click();
	    
		
	}
	

	
}
