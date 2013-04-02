package GS.Prespectives;

import java.awt.AWTException;
import java.awt.Robot;

import org.eclipse.swtbot.eclipse.finder.SWTWorkbenchBot;
import org.eclipse.swtbot.eclipse.finder.widgets.SWTBotView;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTree;
import org.eclipse.swtbot.swt.finder.widgets.SWTBotTreeItem;

import GS.util.SWTbotCommonAction;

public class InstallationCenter {
	 public SWTWorkbenchBot bot = null;
	 public SWTbotCommonAction action =null;
     
	 public InstallationCenter(SWTWorkbenchBot bot) throws AWTException
		{
			this.bot = bot;
			if(action==null)
			{
			this.action= new SWTbotCommonAction(bot);
			}
		}
	 
	
	 
	//Methods related to installation Center
	public void openInstallationCenterPrespective()
	{
		bot.perspectiveByLabel("Installation Center").activate();
		
	}
	
	public void clickConnectToExistingRepository()
	{
	 
	 SWTBotTree wizardTree = bot.viewByTitle("Installation Center Explorer").bot().tree();
	 wizardTree.contextMenu("Connect to an Existing Installation Repository").click();
		 
	}
	public void clickCreateNewConnectionRepository()
	{
	 
	 SWTBotTree wizardTree = bot.viewByTitle("Installation Center Explorer").bot().tree();
	 wizardTree.contextMenu("Connect to an Existing Installation Repository").click();
		 
	}
     
	public void setSchemaName(String schemaName)
	{
		 bot.text().setText(schemaName);
	
		
	}
	public void clickNextButton()
	{
		action.clickNextButton();
	}
	public void selectContextManuItem(String itemOption)
	{     SWTBotTree wizardTree = bot.viewByTitle("Installation Center Explorer").bot().tree();
	      System.out.println("NOde items "+ wizardTree.getAllItems().toString());
	      SWTBotTreeItem[] app = wizardTree.getAllItems();
		  for(SWTBotTreeItem pp : app)
		  {
		    pp.contextMenu(itemOption).click();
		  }
	}
	//Enter UserName when connecting to the Installation Repository
	public void EnterUserNameToconnectRepository(String MachineUserName)
	{
		 bot.shell("Login for GoldenSource Download Site").activate();
		 action.setTextByLabel("Username: ",MachineUserName);
	}
		
	//Enter the password when Connecting to the Repository
	public void EnterPasswordToconnectRepository(String MachinePassword)
	{
		 action.setTextByLabel("Password: ",MachinePassword);
	}
    
	//Click Finish Button
	public void clickFinishButton()
	{
		action.clickFinishButton();
	}
	
	//Click Ok Button
	public void clickOkButton()
	{
	action.clickOKButton();
	}
	
	public void setDataBaseDetails()
	{
	}
	
	//Set Host Name
	public void sethost(String hostName)
	{
	 bot.text(1).setText(hostName);
	}
	//Set Port No.
	public void setportNO(String portNO)
	{
	 bot.text(2).setText(portNO);
	}
	//Set Service Name
	public void setService(String service)
	{
	 bot.text(3).setText(service);	
	}
	//Set DB UserName
	public void setUser(String UserName)
	{
	bot.text(4).setText(UserName);
	}
	//Set DB Password
	public void setPassword(String Password)
	{
	bot.text(5).setText(Password);
	}
	
	//Wait for the Text To be present in the Widget,  
	public boolean waitforTextToBePresent(String TextToWaitFor) throws Exception
	{
		 do{ 
			  System.out.println("Waiting for Available Updates");
			 Thread.sleep(1000);
		 }while((bot.textWithLabel(TextToWaitFor).isVisible())==false);
	  
		 return true;
	}
	
	//Version section from the Combobox for the Repository
	public void SelectTheVersionInComboBox(String VersionToselect)
		{
		action.SelectItemInComboBoxList("Version Filter ",VersionToselect);
	}
	
	/**
	 * Select the FeatureName From the Tree and Expand the Tree and click the Version User have Provided.
	 * Method will Select the One Feature and one Path Version for the Feature 
	 * @param FeatureName
	 * @param PatchVersionName
	 */
	public void selectPatchVersionInTree(String FeatureName,String PatchVersionName)
	{
		 SWTBotTree updateTree = bot.tree();
		 SWTBotTreeItem[] allitems = updateTree.getAllItems();
		 for(SWTBotTreeItem pp : allitems)
		 { 
			boolean FoundItem=false; 
			 if(pp.getText().equalsIgnoreCase(FeatureName))
			  {
				pp.expand();
			    SWTBotTreeItem[] innerTree =  pp.getItems();
			 
				for(SWTBotTreeItem InnerItem : innerTree)
				 {  
				   if(InnerItem.getText().equalsIgnoreCase(PatchVersionName))
					{
					   InnerItem.check();
					   FoundItem=true;
					break;
				 }
			        
		          }
			  }
		    if(FoundItem)
		    {
		    break;	
		 }
		 }
	}
	/**
	 * Select the Context MEnu Item for the Patch List Inside Components->
	 * ContextMenuItem is the options available after Right click on the Patch Name
	 * @param FeatureName
	 * @param PatchVersionName
	 * @param ContextMenuItem
	 * @throws InterruptedException
	 */
	public void ComponentsMenuOperations(String FeatureName,String PatchVersionName,String ContextMenuItem) throws InterruptedException
	{    boolean ItemFound=false;
		 SWTBotTree wizardMainTree = bot.tree();
		 SWTBotTreeItem[] outerTree = wizardMainTree.getAllItems();
		 
		 for(SWTBotTreeItem innerTree : outerTree)
		 {
			SWTBotTreeItem[] itemTree = innerTree.expandNode("Components").expandNode(FeatureName).getItems();
			Thread.sleep(3000);
			for(SWTBotTreeItem patch : itemTree)
			 {  
				
			  if(patch.getText().equalsIgnoreCase(PatchVersionName))
				{
				patch.contextMenu(ContextMenuItem).click();
				Thread.sleep(3000);
				if(bot.shell(ContextMenuItem).isVisible())
				{   
					ItemFound=true;
					break;
				}
				}
				Thread.sleep(3000);
			 }	
		
		 }
	}
	
	/**
	 * Get the Text value of the Job Name: Text Field
	 * @return
	 */
	public String getJobNameTextFieldText()
	{
		return bot.textWithLabel("Job Name:").getText();
	}
	
	/**
	 * Get the value of the Environment: Selected at the Install Patch Window
	 * @return
	 */
	public String EnvironmentText()
	{
		return bot.ccomboBoxWithLabel("Environment:").getText();
	}
	
	//Create a Tree For the All avaiable packages
	/*public void createANdPRontTRee(){
	  SWTBotTree updateTree = bot.tree();
	 SWTBotTreeItem[] allitems = updateTree.getAllItems();
	 System.out.println(allitems.length);
	 for(SWTBotTreeItem pp : allitems)
	 {
		 System.out.println(pp.getText());
		 System.out.println(pp.expand());
		 SWTBotTreeItem[] innerTRee =  pp.getItems();
		 	System.out.println("Size"+innerTRee.length);
			for(SWTBotTreeItem InnerItem : innerTRee)
			 {  
				System.out.println("Inner Item "+pp.getText());
				System.out.println("the Package value"+InnerItem.getText());
				InnerItem.select().click();
		        
	 }}*/
	
}
