package com.gs.autobt.pachinstallation;

import java.awt.AWTException;
import java.awt.Robot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.junit.SWTBotJunit4ClassRunner;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import GS.Prespectives.InstallationCenter;
import GS.Window.Preferences.Preferences;
import GS.util.SWTbotCommonAction;

@RunWith(SWTBotJunit4ClassRunner.class)
public class InstallPatch {
    

	    public static SWTWorkbenchBot bot = null;
		public static Robot key = null;
		public static SWTbotCommonAction action=null;
		public InstallPatch() throws AWTException
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
		
	//Main method to install the patch
   @Test
	public void installingPatch() throws Exception
	{
		 System.out.println("Clicked the Installation ");
		 
		 InstallationCenter installationCenter = (InstallationCenter )action.openPrespective("Installation Center");
		 
         action.setFocus("Installation Center Explorer");	
         
         //Clicking Connect to An Existing Repository option
         installationCenter.clickConnectToExistingRepository();	 
         installationCenter.setSchemaName("schema Name");
         installationCenter.clickNextButton();
         installationCenter.sethost("INQA04");
         installationCenter.setportNO("1521");
         installationCenter.setService("INQA04");
         installationCenter.setUser("INQA04_REP_841");
         installationCenter.setPassword("INQA04_REP_841");
         
         installationCenter.clickFinishButton();
         System.out.println("Finish CLicked");
         
        installationCenter.selectContextManuItem("Update selected Repository");
        Thread.sleep(1000);
		 System.out.println("Selected ");
		 bot.shell("Login for GoldenSource Download Site").activate();
		 installationCenter.EnterUserNameToconnectRepository("pgaria");
		 installationCenter.EnterPasswordToconnectRepository("future1");
		 installationCenter.clickOkButton();
		 installationCenter.waitforTextToBePresent("Version Filter ");
		 installationCenter.SelectTheVersionInComboBox("GoldenSource 8.4.1");
		 installationCenter.clickNextButton();	
		 Thread.sleep(30000);
		 installationCenter.waitforTextToBePresent("Available updates");
		 installationCenter.selectPatchVersionInTree("Base Components","Patch - 8.4.1.2 - Base Components Linux Oracle");
		    
	}
}
