package swtbot.Helper.utils;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

public class CustomWait {
       
	public static void waitForTextInNewShellWindow(SWTWorkbenchBot bot,String ExpectedText) throws Exception
	{
		System.out.println("In waitfor Method");
		boolean visible = bot.shell(ExpectedText).isVisible();
		System.out.println(visible);
		while(!visible)
		{
			System.out.println("Waiting for the Shell");
			Thread.sleep(1000);
		}
	}
}
