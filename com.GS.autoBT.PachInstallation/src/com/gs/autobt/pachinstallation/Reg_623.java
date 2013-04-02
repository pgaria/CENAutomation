package com.gs.autobt.pachinstallation;

import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.hamcrest.Matchers.anything;

import java.awt.AWTException;
import java.awt.Robot;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotCTabItem;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.gs.Workflow.StandardFileLoad;
import com.j2fe.ui.base.widgets.standard.RadioPropertyWidget;


import swtbot.Helper.utils.ContextMenuHelper;
import swtbot.Helper.utils.EclipseToolBarMenuItems;

import GS.Prespectives.ConfigureOrchestrator;
import GS.Window.Preferences.Preferences;
import GS.util.SWTbotCommonAction;
@RunWith(SWTBotJunit4ClassRunner.class)
public class Reg_623 {
    public static SWTWorkbenchBot bot = null;
	public static Robot key = null;
	public static SWTbotCommonAction action=null;
	public Reg_623() throws AWTException
	{
		
	}

@BeforeClass
public static void setPreValues() throws Exception
{
	bot = new SWTWorkbenchBot();
	// slow down tests
	SWTBotPreferences.PLAYBACK_DELAY = 100;
	SWTBotPreferences.TIMEOUT = 10000;
	key = new Robot();
	bot.viewByTitle("Welcome").close();
	System.out.println("before class");
	Preferences preference = new Preferences();
	action = new SWTbotCommonAction(bot);
	 
	 preference.addWeblogic(bot,key);
	 preference.addOracle(bot);
	 
}
@Test
public void Workflow_Debugger_Reg_623() throws Exception
{
	ConfigureOrchestrator configureORch= new ConfigureOrchestrator(bot);
	configureORch.openConfigureOrchestratorPrespective();
	configureORch.connectToNewApplicationServer();
	 Thread.sleep(1000);
	// SWTBotTree wizardTree = bot.viewByTitle("Orchestrator Configuration Explorer").bot().tree();
	 //SWTBotTreeItem tItem = wizardTree.getTreeItem("inqa05wl01-(8.4.1.1)").expand();
	 //tItem.getNode("Workflows").expand().select("Standard File Load").contextMenu("Run Latest Released Vesrion").click();
	 //configureORch.RunWorkFlow("Standard","Standard File Load","Released","Run Workflow");
	//EclipseToolBarMenuItems.clickRunLatestReleasedVersionFromMenu(bot);
	//System.out.println("Workflow");
	//StandardFileLoad.RunWorkFlowWindow(bot);
 
	
	/*ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,"User Information");
	 Thread.sleep(4000);
	 SWTBotTreeItem[] tree = OrchestratorConfiTree.expandNode("WEBLOGIC [gsource@t3://inauto02:8004]").expandNode("inaut02wl03 - (8.4.1.1)").expandNode("Workflows").expandNode("Standard").expandNode("Standard File Load").expandNode("Released").getItems();
     for(SWTBotTreeItem item : tree)
     {
    	 System.out.println(item.getText());
    	 item.select();
    	 ContextMenuHelper.clickContextMenu(OrchestratorConfiTree,"Run Workflow");
    	 Thread.sleep(3000);
     }
     */
    //tItem.expandNode("Workflows").expandNode("Standard File Load").expandNode("Released").select().contextMenu("Run Latest Released Vesrion").click();
    
	//configureORch.RunWorkFlow(Feature, workflowName, ContextMenuItem)
}

public void clickNodeinEditor() throws InterruptedException
{
	 SWTBotTree OrchestratorConfiTree = bot.viewByTitle("Orchestrator Configuration Explorer").bot().tree();
	 //System.out.println(OrchestratorConfiTree.expandNode("WEBLOGIC [gsource@t3://inqa05:8003]",true).getText());
	 SWTBotTreeItem[] item = OrchestratorConfiTree.expandNode("WEBLOGIC [gsource@t3://inqa05:8003]").expandNode("inqa05wl02 - (8.4.1.1)").expandNode("Workflows").getItems();
	 for(SWTBotTreeItem ii : item)
	 {   
		 System.out.println(ii.getText());
		 if(ii.getText().equals("TestWorkFlow"))
		 {
			 ii.doubleClick();
		   break;
		 }
	 }
	 Thread.sleep(10000);
	
}

public void EditTPS_1_FormType() throws InterruptedException
{
	 SWTBotTree OrchestratorConfiTree = bot.viewByTitle("Orchestrator Configuration Explorer").bot().tree();
	 //System.out.println(OrchestratorConfiTree.expandNode("WEBLOGIC [gsource@t3://inqa05:8003]",true).getText());
	 SWTBotTreeItem[] item = OrchestratorConfiTree.expandNode("WEBLOGIC [gsource@t3://inqa05:8003]").expandNode("inqa05wl02 - (8.4.1.1)").expandNode("Engines").getItems();
	 for(SWTBotTreeItem ii : item)
	 {   
		 System.out.println(ii.getText());
		 if(ii.getText().equals("TPS-1"))
		 {
			 ii.doubleClick();
		   break;
		 }
	 }
	 
	 bot.cTabItem("Reference Engine Configuration").activate(); 
	bot.radio("Enabled", 5).click();
	bot.radio("Disabled", 6).click();
	Thread.sleep(10000);
}

}
