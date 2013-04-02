package GS.Window.Preferences;

import java.awt.Robot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;

public class Preferences {
	public void addWeblogic(SWTWorkbenchBot bot,Robot key) throws InterruptedException
	{
		bot.menu("Window").menu("Preferences").click();
		
		bot.shell("Preferences").activate();
		
		bot.tree().expandNode("GoldenSource").expandNode("Application Server Configuration").select("WebLogic Installations");
		
		bot.button("Add").click();
		
		 bot.textWithLabel("Name").setText("WEBLOGIC");
		 bot.textWithLabel("File").setText("C:/Users/pgaria/Documents/weblogic.jar");
		 key.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		 key.keyPress(java.awt.event.KeyEvent.VK_ENTER);
		 
		System.out.println("Open config");
		bot.button("OK").click();
		Thread.sleep(1000);
	}
   
	public void addOracle(SWTWorkbenchBot bot) throws InterruptedException
	{
		bot.menu("Window").menu("Preferences").click(); 
		 Thread.sleep(1000);
		bot.shell("Preferences").activate();
		Thread.sleep(1000);
		bot.tree().unselect();
		bot.tree().collapseNode("GoldenSource");
		bot.tree().expandNode("GoldenSource").select("Database Settings");
		Thread.sleep(1000);
		
		
		System.out.println("AdD clicked");
		Thread.sleep(1000);
		bot.text(1).setText("C:/oracle/product/11.2.0/client_1");
	  // bot.textWithLabel("Client Installation Path").setText("C:/oracle/product/11.2.0/client_1");
		 Thread.sleep(1000);
		 System.out.println("Open config");
		bot.button("OK").click();
		Thread.sleep(1000);
	}
}
