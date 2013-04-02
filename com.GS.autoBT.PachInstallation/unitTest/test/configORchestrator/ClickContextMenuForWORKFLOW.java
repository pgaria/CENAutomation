package test.configORchestrator;

import java.awt.AWTException;
import java.awt.Robot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.swt.finder.utils.SWTBotPreferences;
import org.junit.BeforeClass;
import org.junit.Test;

import GS.Prespectives.ConfigureOrchestrator;
import GS.Window.Preferences.Preferences;
import GS.util.SWTbotCommonAction;

public class ClickContextMenuForWORKFLOW {
	
	 public static SWTWorkbenchBot bot = null;
		public static Robot key = null;
		public static SWTbotCommonAction action=null;
		public static  ConfigureOrchestrator configureORch;
		public ClickContextMenuForWORKFLOW() throws AWTException
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
		 configureORch= new ConfigureOrchestrator(bot);
			configureORch.openConfigureOrchestratorPrespective();
			configureORch.connectToNewApplicationServer();
	}
	
	@Test
	public void RunStandardWorkFlowReleasedVersion() throws Exception
	{
		
		 Thread.sleep(3000);
		 configureORch.RunWorkFlow("Standard","Standard File Load","Released","View");
	    
	}
	@Test
	public void RunStandardWorkFlowDevelopmentVersion() throws Exception
	{
		
		 Thread.sleep(3000);
		 configureORch.RunWorkFlow("Standard","Standard File Load","In Development","View");
	    
	}


}
