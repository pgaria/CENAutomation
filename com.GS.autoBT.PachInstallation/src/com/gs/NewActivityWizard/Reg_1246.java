package com.gs.NewActivityWizard;

import static org.eclipse.swtbot.swt.finder.finders.UIThreadRunnable.syncExec;
import static org.eclipse.swtbot.swt.finder.matchers.WidgetMatcherFactory.widgetOfType;
import static org.eclipse.swtbot.swt.finder.waits.Conditions.shellCloses;
import static org.eclipse.swtbot.swt.finder.waits.Conditions.waitForShell;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.swt.widgets.Widget;
import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.waits.Conditions;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotEditor;

import org.eclipse.swtbot.swt.finder.SWTBot;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.keyboard.Keyboard;
import org.eclipse.swtbot.swt.finder.keyboard.KeyboardFactory;
import org.eclipse.swtbot.swt.finder.keyboard.Keystrokes;

import org.eclipse.swtbot.swt.finder.results.Result;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.waits.ICondition;
import org.eclipse.swtbot.swt.finder.widgets.AbstractSWTBot;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotShell;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotText;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;
import org.eclipse.swtbot.swt.finder.widgets.TimeoutException;


import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import swtbot.Helper.utils.ContextMenuHelper;
import GS.Prespectives.ConfigureOrchestrator;
import GS.Window.Preferences.Preferences;
import GS.util.SWTbotCommonAction;

@RunWith(SWTBotJunit4ClassRunner.class)
public class Reg_1246 {
	
	    public static SWTWorkbenchBot bot = null;
		public static Robot key = null;
		public static SWTbotCommonAction action=null;
		

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
		 ConfigureOrchestrator configureORch= new ConfigureOrchestrator(bot);  
		configureORch.openConfigureOrchestratorPrespective();
		 preference.addWeblogic(bot,key);
		 preference.addOracle(bot);
		
		
		configureORch.connectToNewApplicationServer();
	}
	@SuppressWarnings("deprecation")
	@Test
	public void testReg_158() throws Exception
	{
		 SWTBotTree OrchestratorConfiTree = bot.viewByTitle("Orchestrator Configuration Explorer").bot().tree();
		 //System.out.println(OrchestratorConfiTree.expandNode("WEBLOGIC [gsource@t3://inqa05:8003]",true).getText());
		
        
         SWTBotTreeItem[] Workflows = OrchestratorConfiTree.expandNode("WEBLOGIC [gsource@t3://inauto04:8003]").expandNode("inaut04wl01 - (8.4.1.1)").expandNode("Workflows").expandNode("Standard").getItems();
         for(SWTBotTreeItem ii : Workflows)
    	 {   
    		// System.out.println(ii.getText());
    	
    		 if(ii.getText().equals("Standard File Load"))
    		 {
    			ii.select();
    			 System.out.println("Passed");
    		   break;
    		 }
    	 }
         bot.toolbarButtonWithTooltip("Runs The Latest Released Workflow Version").click();
         bot.sleep(8000);
        bot.tree().getTreeItem("").select().click(3);
       // bot.tree(0).getTreeItem("File").click(5).cell(1);
        System.out.println("Waittttttttttttttt");
        bot.sleep(8000);
        SWTBotTreeItem[] items =  bot.tree().getAllItems();
        for(SWTBotTreeItem ii : items )
        {  
        	 if(ii.select().cell(1).toString().equals("File"))
        	{
        		 
        	ii.click(5);
        	
        	Text widget = bot.widget(widgetOfType(Text.class));
        	SWTBotText text = new SWTBotText(widget, null);
        	text.setText("db://resource/QA/StandardMessageFile.txt"); // set the text
        	text.pressShortcut(KeyStroke.getInstance(SWT.LF));
          
        }
        	 if(ii.select().cell(1).toString().equals("MessageType"))
         	{
         		 
         	ii.click(5);
         	
         	Text widget = bot.widget(widgetOfType(Text.class));
         	SWTBotText text = new SWTBotText(widget, null);
         	text.setText("BBGlobalEquity"); // set the text
         	text.pressShortcut(KeyStroke.getInstance(SWT.LF));
           
         } 
        }
        
        
        //key.keyPress(java.awt.event.KeyEvent.VK_DOWN);
      
        /*  bot.tree().cell(3,"Value");
         SWTBotTreeItem[] items =  bot.tree().getAllItems();
         for(SWTBotTreeItem ii : items )
         {  Thread.sleep(2000);
         // System.out.println(ii.select().cell(1).toString());    Print the Name of the Parameter
         if(ii.select().cell(1).toString().equals("File"))
         {
          ii.select().click(5);
          SWTBotText text = bot.text();
          text.setText("db://resource/QA/StandardMessageFile.txt"); // set the text
         
          //bot.text().setText("File Path");
          //key.keyPress(java.awt.event.KeyEvent.VK_ENTER);
          bot.sleep(5000);
         }
         if(ii.select().cell(1).toString().equals("MessageType"))
         {
          ii.select().click(5);
          SWTBotText text = bot.text();
          text.setText("BBGlobalEquity"); // set the text
        
          //bot.text().setText("File Path");
          //key.keyPress(java.awt.event.KeyEvent.VK_ENTER);
          bot.sleep(5000);
         }
         }*/
       // bot.tree().pressShortcut(Keystrokes.LF ); //SWT.CR, SWT.LF
         bot.sleep(3000);
         bot.button("OK").click();
         bot.sleep(10000);
         // Workflow.contextMenu("New").menu("Workflow Definition").click();
	    
		
	}
	
	


	
	
	private void waitUntil(ICondition condition, long timeout, long interval) throws InterruptedException
	{ 
		long limit = System.currentTimeMillis() + timeout; condition.init(bot);
		while (true) 
		{ 
			try {
				if (condition.test())
					return; 
				} catch (Throwable e) 
				{ // do nothing 
					
				} 
				Thread.sleep(8000);
				if (System.currentTimeMillis() > limit) 
					throw new TimeoutException("Timeout after: " + timeout); 
				
		}
			}
		
	}
		

	