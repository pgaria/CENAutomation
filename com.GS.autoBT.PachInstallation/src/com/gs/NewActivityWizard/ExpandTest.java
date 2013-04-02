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
import GS.Prespectives.ConfigureOrchestratorBot;
import GS.Prespectives.GSsutdioBot;
import GS.Window.Preferences.Preferences;
import GS.util.SWTbotCommonAction;

@RunWith(SWTBotJunit4ClassRunner.class)
public class ExpandTest {
	
	    public static SWTWorkbenchBot bot = null;
		public static Robot key = null;
		public static SWTbotCommonAction action=null;
		 private GSsutdioBot GSsutdioBot;
		 private ConfigureOrchestratorBot configurerochestratorBot;

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
	@SuppressWarnings("deprecation")
	@Test
	public void testReg_158() throws Exception
	{    
		GSsutdioBot = new GSsutdioBot();
		configurerochestratorBot = GSsutdioBot.getConfigureOrchestrator();
		configurerochestratorBot.selectEntry( "WEBLOGIC [gsource@t3://inauto04:8003]","inaut04wl01 - (8.4.1.1)", "Workflows","Standard");
		
		Thread.sleep(6000);
		
	    
		
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
		

	